package us.megidont.avc;
/*

tetrahedron - a 3d polygon in 3d space

	fields:
		p1 -- the first point of the tetrahedron
		p2 -- the second point of the tetrahedron
		p3 -- the third point of the tetrahedron
		p4 -- the fourth point of the tetrahedron

	methods:
		public tetrahedron translate(point3 p2) -- returns a tetrahedron translated such that p2 is its origin.
		public static boolean isInside(point3 p, tetrahedron t) -- returns whether point p is within tetrahedron t with vector precision

*/

public class tetrahedron{

	public point3 p1, p2, p3, p4;

	public tetrahedron(point3 given1, point3 given2, point3 given3, point3 given4){

		p1 = given1;
		p2 = given2;
		p3 = given3;
		p4 = given4;

	}

	public tetrahedron translate(point3 p2){

		return new tetrahedron(

			point3.subtract(this.p1, p2),
			point3.subtract(this.p2, p2),
			point3.subtract(this.p3, p2),
			point3.subtract(this.p4, p2)

		);

	}

	public static boolean isInside(point3 p, tetrahedron t){

		point3 temp1, temp2, temp3, tempp;

		//Step 1: translate
		temp1 = new point3(t.p1.x - t.p4.x, t.p1.y - t.p4.y, t.p1.z - t.p4.z);
		temp2 = new point3(t.p2.x - t.p4.x, t.p2.y - t.p4.y, t.p2.z - t.p4.z);
		temp3 = new point3(t.p3.x - t.p4.x, t.p3.y - t.p4.y, t.p3.z - t.p4.z);
		tempp = new point3(p.x - t.p4.x, p.y - t.p4.y, p.z - t.p4.z);

		//Step 2: check if between vectors
		if(
			(point3.crossProductW(temp1, temp2, tempp) * point3.crossProductW(temp1, temp2, temp3) <= 0 )||
			(point3.crossProductW(temp2, temp3, tempp) * point3.crossProductW(temp2, temp3, temp1) <= 0 )||
			(point3.crossProductW(temp3, temp1, tempp) * point3.crossProductW(temp3, temp1, temp2) <= 0 )){

			return false;

		}

		//Step 3, 4, 5, & 6: Do it again twice

		temp1 = new point3(t.p1.x - t.p2.x, t.p1.y - t.p2.y, t.p1.z - t.p2.z);
		temp2 = new point3(t.p3.x - t.p2.x, t.p3.y - t.p2.y, t.p3.z - t.p2.z);
		temp3 = new point3(t.p4.x - t.p2.x, t.p4.y - t.p2.y, t.p4.z - t.p2.z);
		tempp = new point3(p.x - t.p2.x, p.y - t.p2.y, p.z - t.p2.z);

		if(
			(point3.crossProductW(temp1, temp2, tempp) * point3.crossProductW(temp1, temp2, temp3) <= 0 )||
			(point3.crossProductW(temp2, temp3, tempp) * point3.crossProductW(temp2, temp3, temp1) <= 0 )||
			(point3.crossProductW(temp3, temp1, tempp) * point3.crossProductW(temp3, temp1, temp2) <= 0 )){

			return false;

		}

		return true;

	}

}