package us.megidont.avc;

/**
* Point3 is the basic 3 dimensional point class for avc.
* A <code>Point3</code> is treated as a vector and can be considered as such, with all applicable
* vector operations implemented.
*
* @author 	Megidon't
* @version 	3.0
*/
public class Point3{

	/**
	* Stores the zero vector.
	*/
	public static Point3 ZEROV = new Point3(0, 0, 0);

	/**
	* The x/y/z coordinates of the <code>Point3</code>.
	*/
	public float x, y, z;

	/**
	* Constructs a <code>Point3</code> from x, y, and z coordinates.
	*
	* @param givenX		the x coordinate
	* @param givenY		the y coordinate
	* @param givenZ		the z coordinate
	*/
	public Point3(float givenX, float givenY, float givenZ){

		x = givenX;
		y = givenY;
		z = givenZ;

	}

	/**
	* Checks equality against a second point.
	*
	* @param p2		the second point
	* @return		<code>true</code> if the points are equal, <code>false</code> otherwise
	*/
	public boolean isEqualTo(Point3 p2){

		return (x == p2.x) && (y == p2.y) && (z == p2.z);

	}

	/**
	* Translates the point to use <code>p2</code> as its new origin.
	* Functionally the same as subtracting <code>p2</code> from <code>this</code>, but more readable.
	*
	* @param p2		the second point
	* @return		The translated point
	*/
	public Point3 translate(Point3 p2){

		return Point3.subtract(this, p2);

	}

	/**
	* Creates a human readable string representation of the point as an ordered triple.
	*
	* @return		the human readable string representation of the point as an ordered pair.
	*/
	public String toString(){

		return "(" + x + ", " + y + ", " + z + ")";

	}

	/**
	* Adds the two points together.
	*
	* @param p1		the first point
	* @param p2		the second point
	* @return		the sum of the two points
	*/
	public static Point3 add(Point3 p1, Point3 p2){

		return new Point3(p1.x + p2.x, p1.y + p2.y, p1.z + p2.z);

	}

	/**
	* Subtracts the second point from the first.
	*
	* @param p1		the first point
	* @param p2		the second point
	* @return		the difference between two points
	*/
	public static Point3 subtract(Point3 p1, Point3 p2){

		return new Point3(p1.x - p2.x, p1.y - p2.y, p1.z - p2.z);

	}

	/**
	* Multiplies a scalar by a vector
	*
	* @param p1		the vector to multiply by a scalar
	* @param s		the scalar to multiply the vector by
	* @return		the scaled vector
	*/
	public static Point3 scalarMultiply(Point3 p1, float s){

		return new Point3(p1.x * s, p1.y * s, p1.z * s);

	}

	/**
	* Multiplies a vector by another vector to yield a scalar
	*
	* @param p1		the first vector to multiply
	* @param p2		the second vector to multiply
	* @return		the scalar dot product
	*/
	public static float dotProduct(Point3 p1, Point3 p2){

		return (p1.x * p2.x) + (p1.y * p2.y) + (p1.z * p2.z);

	}

	/**
	* Multiplies a 3d vector by another two 3d vector in 4d space assuming they have no w component
	* and returns the W component of the result.
	*
	* @param vector1	the premultiplicand
	* @param vector2	the postmultiplicand
	* @param vector3	the ...postpostmultiplicand
	* @return		the W component of the resultant vector
	*/
	public static float crossProductW(Point3 vector1, Point3 vector2, Point3 vector3){

		return(	(vector1.x * vector2.y * vector3.z) -
			(vector1.x * vector2.z * vector3.y) -
			(vector1.y * vector2.x * vector3.z) +
			(vector1.y * vector2.z * vector3.x) +
			(vector1.z * vector2.x * vector3.y) -
			(vector1.z * vector2.y * vector3.x)	);

	}

	/**
	* Compares one vectors length to another.
	*
	* @param p1		the first vector
	* @param p2		the second vector
	* @return		<code>0</code> if they are equal, <code>1</code> if
	* 			<code>p1</code> > <code>p2</code>, or <code>2</code> if
	*			<code>p2</code> > <code>p1</code>
	*/
	public static int compare(Point3 p1, Point3 p2){

		float l1 = p1.x + p1.y + p1.z, l2 = p2.x + p2.y + p2.z;
		return (l1 == l2? 0 : (l1 > l2? 1 : 2));

	}

}