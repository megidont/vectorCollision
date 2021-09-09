package us.megidont.avc;

/**
* Triangle is the basic 2d polygon for avc.
* A <code>Triangle</code> consists of three <code>Point2</code>s and includes relevant functions.
* Halts program with runtime expression InvalidDataException in the event of a collinear <code>Triangle</code>.
*
* @author	Megidon't
* @version	3.0
*/
public class Triangle{

	/**
	* The 3 points that define the <code>Triangle</code>.
	*/
	public Point2 p1, p2, p3;

	/**
	* Constructs a <code>Triangle</code> from three <code>Point2</code>s.
	*
	* @param given1		the first point
	* @param given2		the second point
	* @param given3		the third point
	*/
	public Triangle(Point2 given1, Point2 given2, Point2 given3){

		p1 = given1;
		p2 = given2;
		p3 = given3;

		if( Plane2.fallsOn(given3, new Plane2(given1, given2)) ) {

			throw new InvalidDataException("COLLINEAR TRIANGLE CONSTRUCTED " + this.toString());

		}

	}

	/**
	* Translates the <code>Triangle</code> to use <code>newOrigin</code> as its new origin.
	*
	* @param newOrigin	the new origin for the translated <code>Triangle</code>
	* @return		the <code>Triangle</code>, translated
	*/
	public Triangle translate(Point2 newOrigin){

		return new Triangle(

			Point2.subtract(this.p1, newOrigin),
			Point2.subtract(this.p2, newOrigin),
			Point2.subtract(this.p3, newOrigin)

		);

	}

	/**
	* Creates a human readable string representation of the <code>Triangle</code> as a trio of ordered pairs.
	*
	* @return		a string of the <code>Triangle</code> represented as a trio of ordered pairs
	*/
	public String toString(){

		return "<" + p1.toString() + ", " + p2.toString() + ", " + p3.toString() + ">";

	}

	/**
	* Determines if a <code>Point2</code> is within a <code>Triangle</code>.
	* It does it quicky and efficiently by using only addition and multiplication.
	* Now with more quickly and efficiently and fewer false negatives (none I've found).
	*
	* @param p		The <code>Point2</code> to check collision of
	* @param t		The <code>Triangle</code> to check collision against
	* @return		<code>true</code> if the point is within the Triangle,
	*			<code>false</code> otherwise
	*/
	public static boolean isInside(Point2 p, Triangle t){

		Point2 temp1, temp2, tempp;
		Plane2 farPlane;

		//step 1: translate Triangle & test point such that p1 is origin

		temp1 = new Point2(t.p2.x - t.p1.x, t.p2.y - t.p1.y);
		temp2 = new Point2(t.p3.x - t.p1.x, t.p3.y - t.p1.y);
		tempp = new Point2(p.x - t.p1.x, p.y - t.p1.y);

		//step 2: check if angle of vector tempp is between vectors temp1 and temp2

		//we can do this by checking if the signs of the cross products between temp1 & tempp have the same sign as between temp1 & temp2, and again for temp2 & tempp and temp2 & temp1!
		if(
			(Point2.crossProductZ(temp1, tempp) * Point2.crossProductZ(temp1, temp2) <= 0) ||
			(Point2.crossProductZ(temp2, tempp) * Point2.crossProductZ(temp2, temp1) <= 0)){

			return false;

		}

		//step 3 is new: check if tempp vector crosses far side of the Triangle. This is hella faster.

		farPlane = new Plane2(temp1, temp2);
		if( Plane2.doesIntersectPlane(tempp, farPlane) ){ return false; }

		return true;

	}

	/**
	* Deprecated.
	* Determines if a <code>Point2</code> is within a <code>Triangle</code>.
	* It does it quicky and efficiently by using only addition and multiplication.
	*
	* @param p		The <code>Point2</code> to check collision of
	* @param t		The <code>Triangle</code> to check collision against
	* @return		<code>true</code> if the point is within the Triangle,
	*			<code>false</code> otherwise
	*/
	public static boolean isInsideOld(Point2 p, Triangle t){

		Point2 temp1, temp2, tempp;

		//step 1: translate Triangle & test point such that p1 is origin

		temp1 = new Point2(t.p2.x - t.p1.x, t.p2.y - t.p1.y);
		temp2 = new Point2(t.p3.x - t.p1.x, t.p3.y - t.p1.y);
		tempp = new Point2(p.x - t.p1.x, p.y - t.p1.y);

		//step 2: check if angle of vector tempp is between vectors temp1 and temp2

		//we can do this by checking if the signs of the cross products between temp1 & tempp have the same sign as between temp1 & temp2, and again for temp2 & tempp and temp2 & temp1!
		if(
			(Point2.crossProductZ(temp1, tempp) * Point2.crossProductZ(temp1, temp2) <= 0) ||
			(Point2.crossProductZ(temp2, tempp) * Point2.crossProductZ(temp2, temp1) <= 0)){

			return false;

		}

		//finally, we do it again using another point as the origin.

		temp1 = new Point2(t.p1.x - t.p2.x, t.p1.y - t.p2.y);
		temp2 = new Point2(t.p3.x - t.p2.x, t.p3.y - t.p2.y);
		tempp = new Point2(p.x - t.p2.x, p.y - t.p2.y);

		if(
			(Point2.crossProductZ(temp1, tempp) * Point2.crossProductZ(temp1, temp2) <= 0) ||
			(Point2.crossProductZ(temp2, tempp) * Point2.crossProductZ(temp2, temp1) <= 0)){

			return false;

		}

		return true;

	}

}