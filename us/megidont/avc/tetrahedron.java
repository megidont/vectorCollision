package us.megidont.avc;

/**
* Tetrahedron is the basic 3d polygon for avc.
* A <code>Tetrahedron</code> consists of four <code>Point3</code>s and includes relevant functions.
* Halts program with runtime expression InvalidDataException in the event of any collinear sides..
*
* @author	Megidon't
* @version	3.0
*/
public class Tetrahedron{

	/**
	* The 4 points that define the <code>Tetrahedron</code>.
	*/
	public Point3 p1, p2, p3, p4;

	/**
	* Constructs a <code>Tetrahedron</code> from three <code>Point3</code>s.
	*
	* @param given1		the first point
	* @param given2		the second point
	* @param given3		the third point
	*/
	public Tetrahedron(Point3 given1, Point3 given2, Point3 given3, Point3 given4){

		p1 = given1;
		p2 = given2;
		p3 = given3;
		p4 = given4;

		if( Plane3.fallsOn(given4, new Plane3(given1, given2, given3)) ) {

			throw new InvalidDataException("COPLANAR TETRAHEDRON CONSTRUCTED " + this.toString());

		}


	}

	/**
	* Translates the <code>Tetrahedron</code> to use <code>newOrigin</code> as its new origin.
	*
	* @param newOrigin	the new origin for the translated <code>Triangle</code>
	* @return		the <code>Tetrahedron</code>, translated
	*/
	public Tetrahedron translate(Point3 newOrigin){

		return new Tetrahedron(

			Point3.subtract(this.p1, newOrigin),
			Point3.subtract(this.p2, newOrigin),
			Point3.subtract(this.p3, newOrigin),
			Point3.subtract(this.p4, newOrigin)

		);

	}

	/**
	* Creates a human readable string representation of the <code>Tetrahedron</code> as four ordered triples.
	*
	* @return		a string of the <code>Tetrahedron</code> represented as four ordered triples
	*/
	public String toString(){

		return "<" + p1 + ", " + p2 + ", " + p3 + "," + p4 + ">";

	}

	/**
	* Determines if a <code>Point3</code> is within a <code>Tetrahedron</code>.
	* It does it quicky and efficiently by using only addition and multiplication.
	* Now with more quickly and efficiently and fewer false negatives (I found none).
	*
	* @param p		The <code>Point3</code> to check collision of
	* @param t		The <code>Tetrahedron</code> to check collision against
	* @return		<code>true</code> if the point is within the <code>Tetrahedron</code>,
	*			<code>false</code> otherwise
	*/
	public static boolean isInside(Point3 p, Tetrahedron t){

		Point3 temp1, temp2, temp3, tempp;
		Plane3 farPlane;

		//Step 1: translate
		temp1 = new Point3(t.p1.x - t.p4.x, t.p1.y - t.p4.y, t.p1.z - t.p4.z);
		temp2 = new Point3(t.p2.x - t.p4.x, t.p2.y - t.p4.y, t.p2.z - t.p4.z);
		temp3 = new Point3(t.p3.x - t.p4.x, t.p3.y - t.p4.y, t.p3.z - t.p4.z);
		tempp = new Point3(p.x - t.p4.x, p.y - t.p4.y, p.z - t.p4.z);

		//Step 2: check if between vectors
		if(
			(Point3.crossProductW(temp1, temp2, tempp) * Point3.crossProductW(temp1, temp2, temp3) <= 0 )||
			(Point3.crossProductW(temp2, temp3, tempp) * Point3.crossProductW(temp2, temp3, temp1) <= 0 )||
			(Point3.crossProductW(temp3, temp1, tempp) * Point3.crossProductW(temp3, temp1, temp2) <= 0 )){

			return false;

		}

		//Step 3 it can't be that easy they can't keep getting away with it!!!

		farPlane = new Plane3(temp1, temp2, temp3);
		if( Plane3.doesIntersectPlane(tempp, farPlane) ){ return false; }

		return true;

	}

	/**
	* Deprecated.
	* Determines if a <code>Point3</code> is within a <code>Tetrahedron</code>.
	* It does it quicky and efficiently by using only addition and multiplication.
	*
	* @param p		The <code>Point3</code> to check collision of
	* @param t		The <code>Tetrahedron</code> to check collision against
	* @return		<code>true</code> if the point is within the <code>Tetrahedron</code>,
	*			<code>false</code> otherwise
	*/
	public static boolean isInsideOld(Point3 p, Tetrahedron t){

		Point3 temp1, temp2, temp3, tempp;

		//Step 1: translate
		temp1 = new Point3(t.p1.x - t.p4.x, t.p1.y - t.p4.y, t.p1.z - t.p4.z);
		temp2 = new Point3(t.p2.x - t.p4.x, t.p2.y - t.p4.y, t.p2.z - t.p4.z);
		temp3 = new Point3(t.p3.x - t.p4.x, t.p3.y - t.p4.y, t.p3.z - t.p4.z);
		tempp = new Point3(p.x - t.p4.x, p.y - t.p4.y, p.z - t.p4.z);

		//Step 2: check if between vectors
		if(
			(Point3.crossProductW(temp1, temp2, tempp) * Point3.crossProductW(temp1, temp2, temp3) <= 0 )||
			(Point3.crossProductW(temp2, temp3, tempp) * Point3.crossProductW(temp2, temp3, temp1) <= 0 )||
			(Point3.crossProductW(temp3, temp1, tempp) * Point3.crossProductW(temp3, temp1, temp2) <= 0 )){

			return false;

		}

		//Step 3, 4, 5, & 6: Do it again twice

		temp1 = new Point3(t.p1.x - t.p2.x, t.p1.y - t.p2.y, t.p1.z - t.p2.z);
		temp2 = new Point3(t.p3.x - t.p2.x, t.p3.y - t.p2.y, t.p3.z - t.p2.z);
		temp3 = new Point3(t.p4.x - t.p2.x, t.p4.y - t.p2.y, t.p4.z - t.p2.z);
		tempp = new Point3(p.x - t.p2.x, p.y - t.p2.y, p.z - t.p2.z);

		if(
			(Point3.crossProductW(temp1, temp2, tempp) * Point3.crossProductW(temp1, temp2, temp3) <= 0 )||
			(Point3.crossProductW(temp2, temp3, tempp) * Point3.crossProductW(temp2, temp3, temp1) <= 0 )||
			(Point3.crossProductW(temp3, temp1, tempp) * Point3.crossProductW(temp3, temp1, temp2) <= 0 )){

			return false;

		}

		return true;

	}

}