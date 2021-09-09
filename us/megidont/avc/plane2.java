package us.megidont.avc;

/**
* Plane2 is the basic class for a 1d plane (line) in 2d space.
* A <code>Plane2</code> consists of 2 <code>Point2</code>s that define the plane. Even though this plane
* is technically 1 dimensional, this package uses numeric suffixes to specify the dimensionality of points.
*
* @author	Megidon't
* @version	3.0
*/
public class Plane2{

	/**
	* The 2 points that define the plane.
	*/
	public Point2 p1, p2;

	/**
	* The a, b, and c components of the plane's equation in standard form.
	*/
	public static float a, b, c;

	/**
	* Constructs a <code>Plane2</code> from two <code>Point2</code>s that define the plane.
	*
	* @param given1		the first point
	* @param given2		the second point
	*/
	public Plane2(Point2 given1, Point2 given2){

		p1 = given1;
		p2 = given2;

		/*Used to be slope intercept, may come back to that
		//find coefficients to put in slope intercept form
		m = (p2.y - p1.y)/(p2.x - p1.x);
		b = p2.y - (m*p2.x);
		*/

		a = p2.y - p1.y;
		b = p1.x - p2.x;
		c = a*p1.x + b*p1.y;

	}

	/**
	* Translates the <code>Plane2</code> to use <code>newOrigin</code> as its new origin.
	*
	* @param newOrigin	the new origin for the translated <code>Plane2</code>
	* @return		the <code>Plane2</code>, translated
	*/
	public Plane2 translate(Point2 newOrigin){

		return new Plane2(

			Point2.subtract(this.p1, newOrigin),
			Point2.subtract(this.p2, newOrigin)

		);

	}

	/**
	* Creates a human readable string representation of the plane's equation in standard form.
	*
	* @return		a string of the equation in standard form
	*/
	public String equation(){

		return a + " * x + " + b + " * y = " + c;

	}

	/**
	* Creates a human readable string representation of the plane as a pair of ordered pairs.
	*
	* @return		a string of the plane represented as a pair of ordered pairs
	*/
	public String toString(){

		return "[" + p1.toString() + ", " + p2.toString() + "]";

	}

	/**
	* Checks whether the vector of a point from the origin crosses over the given <code>Plane2</code>
	*
	* @param vector		the <code>Point2</code> representation of the vector from the origin
	* @param plane		the <code>Plane2</code> to check intersection against
	* @return		<code>true</code> if the line intersects the segment between the
	*			<code>Point2</code>s that define <code>plane</code>,
	*			<code>false</code> otherwise
	*/
	public static boolean doesIntersectSegment(Point2 vector, Plane2 plane){

		//Step 1: check if vector is between the vertices of the plane! (If the vector goes towards the plane)
		if(
			(Point2.crossProductZ(plane.p1, vector) * Point2.crossProductZ(plane.p1, plane.p2) <= 0) ||
			(Point2.crossProductZ(plane.p2, vector) * Point2.crossProductZ(plane.p2, plane.p1) <= 0)){
			return false;

		}

		//Step 2: check if the point is outside of the triangle formed by the plane and the origin
		Point2 temp1, temp2, tempp;

		temp1 = new Point2(0 - plane.p1.x, 0 - plane.p1.y);
		temp2 = new Point2(plane.p2.x - plane.p1.x, plane.p2.y - plane.p1.y);
		tempp = new Point2(vector.x - plane.p1.x, vector.y - plane.p1.y);

		if(
			(Point2.crossProductZ(temp1, tempp) * Point2.crossProductZ(temp1, temp2) > 0) &&
			(Point2.crossProductZ(temp2, tempp) * Point2.crossProductZ(temp2, temp1) > 0)){

			return false;

		}

		return true;

	}

	/**
	* Checks whether the vector of a point from the origin crosses over the line defined by
	* the given <code>Plane2</code>.
	* Used for easy preliminary tests of overlap.
	*
	* @param vector		the <code>Point2</code> representation of the vector from the origin
	* @param plane		the <code>Plane2</code> that defines the line
	* @return		<code>true</code> if the line intersects line defined by the
	*			<code>Point2</code>s that define <code>plane</code>,
	*			<code>false</code> otherwise
	*/
	public static boolean doesIntersectPlane(Point2 vector, Plane2 plane){

		/* Legacy code from slope-intercept!
		float unb = plane.b * -1;
		float testb = ((plane.m * vector.x) - vector.y);
		return (((testb >= 0? testb : -1*testb) >= (unb >= 0? unb : plane.b))&& (testb * unb) >= 0);
		*/

		float testc = (plane.a * vector.x + plane.b * vector.y);
		return(((testc > 0? testc : testc*-1) > (plane.c > 0? plane.c : plane.c*-1)) && ((testc * plane.c) >= 0));

	}

	/**
	* Checks if the given <code>Point2</code> falls on the line defined by the <code>Plane2</code>.
	*
	* @param point		the <code>Point2</code> to check
	* @param plane		the <code>Plane2</code> that defines the line
	* @return		<code>true</code> if the <code>Point2</code> falls on the line defined by the
	*			<code>Point2</code>s that define <code>plane</code>,
	*			<code>false</code> otherwise
	*/
	public static boolean fallsOn(Point2 point, Plane2 plane){

		return (plane.c == (plane.a * point.x) + (plane.b * point.y));

	}

}