/*

point2 - a point in 2d space or a vector in 2d space

	fields:
		x -- x component
		y -- y component
		static ZEROV -- the Zero vector

	methods:
		public boolean isEqualTo(point2 p2) -- returns if the points are identical.
		public point2 translate(point2 p2) -- returns a vector translated such that p2 is its origin.
		public String toString() -- returns data represented as string.
		public static point2 add(point2 p1, point2 p2) -- returns the sum of the two vectors.
		public static point2 subtract(point2 p1, point2 p2) -- returns the difference of vector p1 - vector p2. almost didn't implement it but it can be cleaner.
		public static point2 scalarMultiply(point2 p1, float s) -- returns the vector multiplied by a scalar.
		public static float dotProduct(point2 p1, point2 p2) -- returns the dot product of the two vectors.
		public static float crossProductZ(point2 vector1, point2 vector2) -- Finds the cross product direction in a 3d space with z of each assumed to be 0.
		public static int compare(point2 p1, point2 p2) -- returns 0 for equal or the number of the larger vector.

*/

class point2{

	public static point2 ZEROV = new point2(0, 0);

	public float x, y;

	point2(float givenX, float givenY){

		x = givenX;
		y = givenY;

	}

	public boolean isEqualTo(point2 p2){

		return (x == p2.x) && (y == p2.y);

	}

	public point2 translate(point2 p2){


		return point2.add(this, p2);

	}

	public String toString(){

		return "(" + x + ", " + y + ")";

	}

	public static point2 add(point2 p1, point2 p2){

		return new point2(p1.x + p2.x, p1.y + p2.y);

	}

	public static point2 subtract(point2 p1, point2 p2){

		return point2.add(p1, point2.scalarMultiply(p2, -1));

	}

	public static point2 scalarMultiply(point2 p1, float s){

		return new point2(p1.x * s, p1.y * s);

	}

	public static float dotProduct(point2 p1, point2 p2){

		return (p1.x * p2.x) + (p1.y * p2.y);

	}

	public static float crossProductZ(point2 vector1, point2 vector2){

		return((vector1.y * vector2.x) - (vector1.x * vector2.y));

	}

	public static int compare(point2 p1, point2 p2){

		//belive it or not this actually works
		//if a > x, a*a > x*x in all cases, therefore we don't need to waste a few cycles to multiply.
		float l1 = p1.x + p1.y, l2 = p2.x + p2.y;
		return (l1 == l2? 0 : (l1 > l2? 1 : 2));

	}

}