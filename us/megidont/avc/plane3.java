package us.megidont.avc;
/*

Plane3 - a 2d plane in 3d space

	fields:
		p1 -- the first point that defines the plane
		p2 -- the second point that defines the plane
		p3 -- the third point that defines the plane
		a -- the a-component of the planar equation
		b -- the b-component of the planar equation
		c -- the c-component of the planar equation
		d -- the d-component of the planar equation

	methods:
		public Plane3 translate(Point3 p2) -- returns a plane translated such that p2 is its origin.
		public string equation() -- returns a human readable string of the equation of the plane.
		public static boolean doesIntersectTriangle(Point3 vector, Plane3 plane) -- returns whether the given vector in 3d space crosses the triangle defining the plane.
		public static boolean doesIntersectPlane(Point3 p1, Plane3 p) -- returns whether the given vector in 3d space crosses the plane.
		public static boolean fallsOn(Point3 point, Plane3 plane) -- returns whether or not the point in 3d space is on that plane.

*/

public class Plane3{

	public Point3 p1, p2, p3;
	public float a, b, c, d;

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

	public Plane3 translate(Point3 p2){

		return new Plane3(

			Point3.subtract(this.p1, p2),
			Point3.subtract(this.p2, p2),
			Point3.subtract(this.p3, p2)

		);

	}

	public String equation(){

		return a + "*x + " + b + "*y + " + c + "*z = " + d;

	}

	public String toString(){

		return "[" + p1.toString() + ", " + p2.toString() + ", " + p3.toString() + "]";

	}

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

	public static boolean doesIntersectPlane(Point3 p1, Plane3 p){

		float testd = (p.a * p1.x + p.b * p1.y + p.c * p1.z);
		return (((testd > 0? testd : testd*-1) >= (p.d > 0? p.d : p.d*-1)) && ((testd * p.d) >= 0));

	}

	public static boolean fallsOn(Point3 point, Plane3 plane){

		return (((plane.a * point.x) + (plane.b * point.y) + (plane.c * point.z)) == plane.d);

	}


}