package us.megidont.avc;
/*

point3 - a point in 3d space or a vector in 3d space

	fields:
		x -- x component
		y -- y component
		z -- z component
		static ZEROV -- the Zero vector

	methods:
		public boolean isEqualTo(point3 p2) -- returns if the points are identical.
		public point3 translate(point3 p2) -- returns a vector translated such that p2 is its origin.
		public String toString() -- returns data represented as string.
		public static point3 add(point3 p1, point3 p2) -- returns the sum of the two vectors.
		public static point3 subtract(point3 p1, point3 p2) -- returns the difference of vector p1 - vector p2. almost didn't implement it but it can be cleaner.
		public static point3 scalarMultiply(point3 p1, float s) -- returns the vector multiplied by a scalar.
		public static float dotProduct(point3 p1, point3 p2) -- returns the dot product of the two vectors.
		public static float crossProductW(point3 vector1, point3 vector2) -- Finds the cross product direction in a 4d space with w of each assumed to be 0.
		public static int compare(point3 p1, point3 p2) -- returns 0 for equal or the number of the larger vector.

*/

/**
* Point3 is the basic 3 dimensional point class for avc.
* A <code>point3</code> class is treated as a vector and can be considered as such, with all applicable
* vector operations implemented.
*
* @author 	Megidon't
* @version 	3.0
*/
public class point3{

	/**
	* Stores the zero vector.
	*/
	public static point3 ZEROV = new point3(0, 0, 0);

	/**
	* The x/y/z coordinates of the <code>point3</code>.
	*/
	public float x, y, z;

	/**
	* Constructs a <code>point3</code> from x, y, and z coordinates.
	*
	* @param givenX		the x coordinate
	* @param givenY		the y coordinate
	* @param givenZ		the z coordinate
	*/
	public point3(float givenX, float givenY, float givenZ){

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
	public boolean isEqualTo(point3 p2){

		return (x == p2.x) && (y == p2.y) && (z == p2.z);

	}

	/**
	* Translates the point to use <code>p2</code> as its new origin.
	* Functionally the same as subtracting <code>p2</code> from <code>this</code>, but more readable.
	*
	* @param p2		the second point
	* @return		The translated point
	*/
	public point3 translate(point3 p2){

		return point3.subtract(this, p2);

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
	public static point3 add(point3 p1, point3 p2){

		return new point3(p1.x + p2.x, p1.y + p2.y, p1.z + p2.z);

	}

	/**
	* Subtracts the second point from the first.
	*
	* @param p1		the first point
	* @param p2		the second point
	* @return		the difference between two points
	*/
	public static point3 subtract(point3 p1, point3 p2){

		return new point3(p1.x - p2.x, p1.y - p2.y, p1.z - p2.z);

	}

	/**
	* Multiplies a scalar by a vector
	*
	* @param p1		the vector to multiply by a scalar
	* @param s		the scalar to multiply the vector by
	* @return		the scaled vector
	*/
	public static point3 scalarMultiply(point3 p1, float s){

		return new point3(p1.x * s, p1.y * s, p1.z * s);

	}

	/**
	* Multiplies a vector by another vector to yield a scalar
	*
	* @param p1		the first vector to multiply
	* @param p2		the second vector to multiply
	* @return		the scalar dot product
	*/
	public static float dotProduct(point3 p1, point3 p2){

		return (p1.x * p2.x) + (p1.y * p2.y) + (p1.z * p2.z);

	}

	/**
	* Multiplies a 3d vector by another 3d vector in 4d space assuming they have no w component
	* and returns the W component of the result.
	*
	* @param vector1	the premultiplicand
	* @param vector2	the postmultiplicand
	* @return		the W component of the resultant vector
	*/
	public static float crossProductW(point3 vector1, point3 vector2, point3 vector3){

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
	public static int compare(point3 p1, point3 p2){

		float l1 = p1.x + p1.y + p1.z, l2 = p2.x + p2.y + p2.z;
		return (l1 == l2? 0 : (l1 > l2? 1 : 2));

	}

}