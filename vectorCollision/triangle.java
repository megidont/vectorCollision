/*

triangle - a 2d polygon in 2d space

	fields:
		p1 -- the first point of the triangle
		p2 -- the second point of the triangle
		p3 -- the third point of the triangle

	methods:
		public triangle translate(point2 p2) -- returns a triangle translated such that p2 is its origin.
		public static boolean isInside(point2 p, triangle t) -- returns whether point p is within triangle t with vector precision

*/

class triangle{

	public point2 p1, p2, p3;

	triangle(point2 given1, point2 given2, point2 given3){

		p1 = given1;
		p2 = given2;
		p3 = given3;

	}

	public triangle translate(point2 p2){

		return new triangle(

			point2.add(this.p1, p2),
			point2.add(this.p2, p2),
			point2.add(this.p3, p2)

		);

	}

	public static boolean isInside(point2 p, triangle t){

		point2 temp1, temp2, tempp;

		//step 1: translate triangle & test point such that p1 is origin

		temp1 = new point2(t.p2.x - t.p1.x, t.p2.y - t.p1.y);
		temp2 = new point2(t.p3.x - t.p1.x, t.p3.y - t.p1.y);
		tempp = new point2(p.x - t.p1.x, p.y - t.p1.y);

		//step 2: check if angle of vector tempp is between vectors temp1 and temp2

		//we can do this by checking if the signs of the cross products between temp1 & tempp have the same sign as between temp1 & temp2, and again for temp2 & tempp and temp2 & temp1!
		if(
			(point2.crossProductZ(temp1, tempp) * point2.crossProductZ(temp1, temp2) <= 0) ||
			(point2.crossProductZ(temp2, tempp) * point2.crossProductZ(temp2, temp1) <= 0)){

			return false;

		}

		//finally, we do it again using another point as the origin.

		temp1 = new point2(t.p1.x - t.p2.x, t.p1.y - t.p2.y);
		temp2 = new point2(t.p3.x - t.p2.x, t.p3.y - t.p2.y);
		tempp = new point2(p.x - t.p2.x, p.y - t.p2.y);

		if(
			(point2.crossProductZ(temp1, tempp) * point2.crossProductZ(temp1, temp2) <= 0) ||
			(point2.crossProductZ(temp2, tempp) * point2.crossProductZ(temp2, temp1) <= 0)){

			return false;

		}

		return true;

	}

}