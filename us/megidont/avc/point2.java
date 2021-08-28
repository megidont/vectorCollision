package us.megidont.avc;
/**
* Point2 is the basic 2 dimensional point class for avc.
* A <code>point2</code> class is treated as a vector and can be considered as such, with all applicable
* vector operations implemented.
*
* @author 	Megidon't
* @version 	3.0
*/
public class point2{

	/**
	* Stores the zero vector.
	*/
	public static point2 ZEROV = new point2(0, 0);

	/**
	* The x/y coordinates of the <code>point2</code>.
	*/
	public float x, y;

	/**
	* Constructs a <code>point2</code> from x and y coordinates.
	*
	* @param givenX		the x coordinate
	* @param givenY		the y coordinate
	*/
	public point2(float givenX, float givenY){

		x = givenX;
		y = givenY;

	}

	/**
	* Checks equality against a second point.
	*
	* @param p2		the second point
	* @return		<code>true</code> if the points are equal, <code>false</code> otherwise
	*/
	public boolean isEqualTo(point2 p2){

		return (x == p2.x) && (y == p2.y);

	}

	/**
	* Translates the point to use <code>p2</code> as its new origin.
	* Functionally the same as subtracting <code>p2</code> from <code>this</code>, but more readable.
	*
	* @param p2		the second point
	* @return		The translated point
	*/
	public point2 translate(point2 p2){


		return point2.subtract(this, p2);

	}

	/**
	* Creates a human readable string representation of the point as an ordered pair.
	*
	* @return		the human readable string representation of the point as an ordered pair.
	*/
	public String toString(){

		return "(" + x + ", " + y + ")";

	}

	/**
	* Adds the two points together.
	*
	* @param p1		the first point
	* @param p2		the second point
	* @return		the sum of the two points
	*/
	public static point2 add(point2 p1, point2 p2){

		return new point2(p1.x + p2.x, p1.y + p2.y);

	}

	/**
	* Subtracts the second point from the first.
	*
	* @param p1		the first point
	* @param p2		the second point
	* @return		the difference between two points
	*/
	public static point2 subtract(point2 p1, point2 p2){

		return new point2(p1.x - p2.x, p1.y - p2.y);

	}

	/**
	* Multiplies a scalar by a vector
	*
	* @param p1		the vector to multiply by a scalar
	* @param s		the scalar to multiply the vector by
	* @return		the scaled vector
	*/
	public static point2 scalarMultiply(point2 p1, float s){

		return new point2(p1.x * s, p1.y * s);

	}

	/**
	* Multiplies a vector by another vector to yield a scalar
	*
	* @param p1		the first vector to multiply
	* @param p2		the second vector to multiply
	* @return		the scalar dot product
	*/
	public static float dotProduct(point2 p1, point2 p2){

		return (p1.x * p2.x) + (p1.y * p2.y);

	}

	/**
	* Multiplies a 2d vector by another 2d vector in 3d space assuming they have no z component
	* and returns the Z component of the result.
	*
	* @param vector1	the premultiplicand
	* @param vector2	the postmultiplicand
	* @return		the Z component of the resultant vector
	*/
	public static float crossProductZ(point2 vector1, point2 vector2){

		return((vector1.y * vector2.x) - (vector1.x * vector2.y));

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
	public static int compare(point2 p1, point2 p2){

		//belive it or not this actually works
		//if a > x, a*a > x*x in all cases, therefore we don't need to waste a few cycles to multiply.
		float l1 = p1.x + p1.y, l2 = p2.x + p2.y;
		return (l1 == l2? 0 : (l1 > l2? 1 : 2));

	}

}