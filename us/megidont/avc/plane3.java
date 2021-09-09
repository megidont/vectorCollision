package us.megidont.avc;

/**
* Plane3 is the basic class for a 2d plane in 3d space.
* A <code>Plane3</code> consists of 3 <code>Point3</code>s that define the plane. Even though this plane
* is technically 2 dimensional, this package uses numeric suffixes to specify the dimensionality of points.
*
* @author	Megidon't
* @version	3.0
*/
public class Plane3{

	/**
	* The 3 points that define the plane.
	*/
	public Point3 p1, p2, p3;

	/**
	* The a, b, c, and d components of the plane's equation in standard form.
	*/
	public float a, b, c, d;

	/**
	* Constructs a <code>Plane3</code> from three <code>Point3</code>s that define the plane.
	*
	* @param given1		the first point
	* @param given2		the second point
	* @param given3		the third point
	*/
	public Plane3(Point3 given1, Point3 given2, Point3 given3){

		p1 = given1;
		p2 = given2;
		p3 = given3;

		Point3 v1 = new Point3(p2.x - p1.x, p2.y - p1.y, p2.z - p1.z);
		Point3 v2 = new Point3(p3.x - p1.x, p3.y - p1.y, p3.z - p1.z);

		a = (v1.y * v2.z) - (v1.z * v2.y);
		b = (v1.z * v2.x) - (v1.x * v2.z);
		c = (v1.x * v2.y) - (v1.y * v2.x);
		d = (a * p1.x) + (b * p1.y) + (c * p1.z);

	}

	/**
	* Translates the <code>Plane3</code> to use <code>newOrigin</code> as its new origin.
	*
	* @param newOrigin	the new origin for the translated <code>Plane3</code>
	* @return		the <code>Plane3</code>, translated
	*/
	public Plane3 translate(Point3 newOrigin){

		return new Plane3(

			Point3.subtract(this.p1, newOrigin),
			Point3.subtract(this.p2, newOrigin),
			Point3.subtract(this.p3, newOrigin)

		);

	}

	/**
	* Creates a human readable string representation of the plane's equation in standard form.
	*
	* @return		a string of the equation in standard form
	*/
	public String equation(){

		return a + "*x + " + b + "*y + " + c + "*z = " + d;

	}

	/**
	* Creates a human readable string representation of the plane as a trio of ordered triples.
	*
	* @return		a string of the plane represented as a trio of ordered triples
	*/
	public String toString(){

		return "[" + p1.toString() + ", " + p2.toString() + ", " + p3.toString() + "]";

	}

	/**
	* Checks whether the vector of a point from the origin crosses over the given <code>Plane3</code>
	*
	* @param vector		the <code>Point3</code> representation of the vector from the origin
	* @param plane		the <code>Plane3</code> to check intersection against
	* @return		<code>true</code> if the line intersects the triangle between the
	*			<code>Point3</code>s that define the <code>Plane3</code>,
	*			<code>false</code> otherwise
	*/
	public static boolean doesIntersectTriangle(Point3 vector, Plane3 plane){

		//Step 1: check if vector is between the vertices of the plane! (If the vector goes towards the plane)
		if(
			(Point3.crossProductW(plane.p1, plane.p2, vector) * Point3.crossProductW(plane.p1, plane.p2, plane.p3) < 0 )||
			(Point3.crossProductW(plane.p2, plane.p3, vector) * Point3.crossProductW(plane.p2, plane.p3, plane.p1) < 0 )||
			(Point3.crossProductW(plane.p3, plane.p1, vector) * Point3.crossProductW(plane.p3, plane.p1, plane.p2) < 0 )){

			return false;

		}

		//Step 2: check if the point is outside of the tetrahedron formed by the plane and the origin
		Point3 temp1, temp2, temp3, tempp;

		temp1 = new Point3(0 - plane.p1.x, 0 - plane.p1.y, 0 - plane.p1.z);
		temp2 = new Point3(plane.p2.x - plane.p1.x, plane.p2.y - plane.p1.y, plane.p2.z - plane.p1.z);
		temp3 = new Point3(plane.p3.x - plane.p1.x, plane.p3.y - plane.p1.y, plane.p3.z - plane.p1.z);
		tempp = new Point3(vector.x - plane.p1.x, vector.y - plane.p1.y,vector.z - plane.p1.z);

		if(
			(Point3.crossProductW(temp1, temp2, tempp) * Point3.crossProductW(temp1, temp2, temp3) > 0 )&&
			(Point3.crossProductW(temp2, temp3, tempp) * Point3.crossProductW(temp2, temp3, temp1) > 0 )&&
			(Point3.crossProductW(temp3, temp1, tempp) * Point3.crossProductW(temp3, temp1, temp2) > 0 )){

			return false;

		}

		return true;

	}

	/**
	* Checks whether the vector of a point from the origin crosses over the plane defined by
	* the given <code>Plane3</code>.
	* Used for easy preliminary tests of overlap.
	*
	* @param vector		the <code>Point3</code> representation of the vector from the origin
	* @param plane		the <code>Plane3</code> that defines the line
	* @return		<code>true</code> if the line intersects line defined by the
	*			<code>Point3</code>s that define <code>Plane3</code>,
	*			<code>false</code> otherwise
	*/
	public static boolean doesIntersectPlane(Point3 vector, Plane3 plane){

		float testd = (plane.a * vector.x + plane.b * vector.y + plane.c * vector.z);
		return (((testd > 0? testd : testd*-1) >= (plane.d > 0? plane.d : plane.d*-1)) && ((testd * plane.d) >= 0));

	}

	/**
	* Checks if the given <code>Point3</code> falls on the line defined by the <code>Plane3</code>.
	*
	* @param point		the <code>Point3</code> to check
	* @param plane		the <code>Plane3</code> that defines the line
	* @return		<code>true</code> if the <code>Point3</code> falls on the plane defined by the
	*			<code>Point3</code>s that define <code>Plane3</code>,
	*			<code>false</code> otherwise
	*/
	public static boolean fallsOn(Point3 point, Plane3 plane){

		return (((plane.a * point.x) + (plane.b * point.y) + (plane.c * point.z)) == plane.d);

	}


}