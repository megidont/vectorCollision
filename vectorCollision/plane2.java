/*

plane2 - a 1d plane in 2d space

	fields:
		p1 -- the first point that defines the plane
		p2 -- the second point that defines the plane
		m -- the slope of the equation of the plane in slope-intercept form
		b -- the y-intercept of the equation of the plane in slope-intercept form

	methods:
		public plane2 translate(point2 p2) -- returns a plane translated such that p2 is its origin.
		public string equation() -- returns a human readable string of the equation of the plane.
		public static boolean doesIntersectSegment(point2 vector, plane2 plane) -- returns whether the given vector in 2d space crosses the segment defining the plane
		public static boolean fallsOn(point2 point, plane2 plane) -- returns whether or not the point in 2d space is on that plane

*/

class plane2{

	//A class to define a plane in 2d space. Since it is in 2 dimensions, even though it's a 1 dimensional plane
	//we call it a plane2 (because it consists of 2d points.)

	point2 p1, p2;
	float m, b;

	plane2(point2 given1, point2 given2){

		p1 = given1;
		p2 = given2;

		//find coefficients to put in slope intercept form
		m = (p2.y - p1.y)/(p2.x - p1.x);
		b = p2.y - (m*p2.x);

	}

	public plane2 translate(point2 p2){

		return new plane2(

			point2.add(this.p1, p2),
			point2.add(this.p2, p2)

		);

	}

	public String equation(){

		return "y = " + m + "*x + " + b;

	}

	public static boolean doesIntersectSegment(point2 vector, plane2 plane){

		//Step 1: check if vector is between the vertices of the plane! (If the vector goes towards the plane)
		if(
			(point2.crossProductZ(plane.p1, vector) * point2.crossProductZ(plane.p1, plane.p2) <= 0) ||
			(point2.crossProductZ(plane.p2, vector) * point2.crossProductZ(plane.p2, plane.p1) <= 0)){
			return false;

		}

		//Step 2: check if the point is outside of the triangle formed by the plane and the origin
		point2 temp1, temp2, tempp;

		temp1 = new point2(0 - plane.p1.x, 0 - plane.p1.y);
		temp2 = new point2(plane.p2.x - plane.p1.x, plane.p2.y - plane.p1.y);
		tempp = new point2(vector.x - plane.p1.x, vector.y - plane.p1.y);

		if(
			(point2.crossProductZ(temp1, tempp) * point2.crossProductZ(temp1, temp2) > 0) &&
			(point2.crossProductZ(temp2, tempp) * point2.crossProductZ(temp2, temp1) > 0)){

			return false;

		}

		return true;

	}

	public static boolean doesIntersectPlane(point2 p1, plane2 p){

		float unb = p.b * -1;
		float testb = ((p.m * p1.x) - p1.y);
		return (((testb >= 0? testb : -1*testb) >= (unb >= 0? unb : p.b))&& (testb * unb) >= 0);

	}

	public static boolean fallsOn(point2 point, plane2 plane){

		return (point.y == (plane.m * point.x) + plane.b);

	}

}