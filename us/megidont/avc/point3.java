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

public class point3{

	public static point3 ZEROV = new point3(0, 0, 0);

	public float x, y, z;

	public point3(float givenX, float givenY, float givenZ){

		x = givenX;
		y = givenY;
		z = givenZ;

	}

	public boolean isEqualTo(point3 p2){

		return (x == p2.x) && (y == p2.y) && (z == p2.z);

	}

	public point3 translate(point3 p2){

		return point3.subtract(this, p2);

	}

	public String toString(){

		return "(" + x + ", " + y + ", " + z + ")";

	}

	public static point3 add(point3 p1, point3 p2){

		return new point3(p1.x + p2.x, p1.y + p2.y, p1.z + p2.z);

	}

	public static point3 subtract(point3 p1, point3 p2){

		return new point3(p1.x - p2.x, p1.y - p2.y, p1.z - p2.z);

	}

	public static point3 scalarMultiply(point3 p1, float s){

		return new point3(p1.x * s, p1.y * s, p1.z * s);

	}

	public static float dotProduct(point3 p1, point3 p2){

		return (p1.x * p2.x) + (p1.y * p2.y) + (p1.z * p2.z);

	}

	public static float crossProductW(point3 vector1, point3 vector2, point3 vector3){

		return(	(vector1.x * vector2.y * vector3.z) -
			(vector1.x * vector2.z * vector3.y) -
			(vector1.y * vector2.x * vector3.z) +
			(vector1.y * vector2.z * vector3.x) +
			(vector1.z * vector2.x * vector3.y) -
			(vector1.z * vector2.y * vector3.x)	);

	}

	public static int compare(point3 p1, point3 p2){

		float l1 = p1.x + p1.y + p1.z, l2 = p2.x + p2.y + p2.z;
		return (l1 == l2? 0 : (l1 > l2? 1 : 2));

	}

}