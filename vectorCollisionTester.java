import us.megidont.avc.*;

public class vectorCollisionTester{

	public static void main(String[] args){

		/*
		point3 p = new point3(7, 7, 7);
		tetrahedron t = new tetrahedron(new point3(0, 0, 0), new point3(0, 2, 2), new point3(4, 5, 6), new point3(5, 8, 13));

		System.out.println(
			"Is P(" + p + "\n" +
			"within T[\n\t(" + t.p1 + ")\n\t("  + t.p2 + ")\n\t("  + t.p3 + ")\n\t("  + t.p4 + ")\n]?\n" +
			tetrahedron.isInside(p, t)
		);*/

		/*
		point2 v = new point2(1, 4);
		plane2 p = new plane2(new point2(1, 3), new point2(3, 1));

		System.out.println(
			"Does V(" + v + "\n" +
			"cross over P[\n\t(" + p.p1 + ")\n\t(" + p.p2 +")\n]?\n" +
			plane2.doesIntersect(v, p)
		);
		*/

		/*
		point3 v1 = new point3( (float)0.1, (float)0.1, 3);
		point3 v2 = new point3( 0, 0, 3);
		point3 v3 = new point3( 0, -1, 2);
		point3 v4 = new point3( 0, 0, -3);
		plane3 p = new plane3(new point3(0, 0, 2), new point3(0, 1, 2), new point3(1, 0, 2));

		System.out.println(
			"Does V(" + v1 + "\n" +
			"cross over triangle[\n\t(" + p.p1 + ")\n\t(" + p.p2 + ")\n\t(" + p.p3 + ")\n] -- " + p.equation() + "?\n" +
			plane3.doesIntersectTriangle(v1, p) +"\n\n"
		);
		System.out.println(
			"Does V(" + v2 + "\n" +
			"cross over triangle[\n\t(" + p.p1 + ")\n\t(" + p.p2 + ")\n\t(" + p.p3 + ")\n] -- " + p.equation() + "?\n" +
			plane3.doesIntersectTriangle(v2, p) +"\n\n"
		);
		System.out.println(
			"Does V(" + v3 + "\n" +
			"cross over triangle[\n\t(" + p.p1 + ")\n\t(" + p.p2 + ")\n\t(" + p.p3 + ")\n] -- " + p.equation() + "?\n" +
			plane3.doesIntersectTriangle(v3, p) +"\n\n"
		);
		System.out.println(
			"Does V(" + v4 + "\n" +
			"cross over triangle[\n\t(" + p.p1 + ")\n\t(" + p.p2 + ")\n\t(" + p.p3 + ")\n] -- " + p.equation() + "?\n" +
			plane3.doesIntersectTriangle(v3, p) +"\n\n"
		);

		System.out.println(
			"Does V(" + v1 + "\n" +
			"cross over plane[\n\t(" + p.p1 + ")\n\t(" + p.p2 + ")\n\t(" + p.p3 + ")\n] -- " + p.equation() + "?\n" +
			plane3.doesIntersectPlane(v1, p) +"\n\n"
		);
		System.out.println(
			"Does V(" + v2 + "\n" +
			"cross over plane[\n\t(" + p.p1 + ")\n\t(" + p.p2 + ")\n\t(" + p.p3 + ")\n] -- " + p.equation() + "?\n" +
			plane3.doesIntersectPlane(v2, p) +"\n\n"
		);
		System.out.println(
			"Does V(" + v3 + "\n" +
			"cross over plane[\n\t(" + p.p1 + ")\n\t(" + p.p2 + ")\n\t(" + p.p3 + ")\n] -- " + p.equation() + "?\n" +
			plane3.doesIntersectPlane(v3, p) +"\n\n"
		);
		System.out.println(
			"Does V(" + v4 + "\n" +
			"cross over triangle[\n\t(" + p.p1 + ")\n\t(" + p.p2 + ")\n\t(" + p.p3 + ")\n] -- " + p.equation() + "?\n" +
			plane3.doesIntersectPlane(v4, p) +"\n\n"
		);*/

		/*
		plane2 L = new plane2(new point2(0, 0), new point2(1, 1));
		System.out.println(
			"Is the equation of the line between A(" + L.p2 + ") and B(" + L.p1 + ")\n" +
			L.a + " * x + " + L.b + " * y = " + L.c + "?"
		);

		plane2 s = new plane2(new point2(1, 3), new point2(3, 1));
		System.out.println(
			"Do points " + s.p1 + " and " + s.p2 + " fall on plane " + s.a + " * x + " + s.b +
			" * y = " + s.c + "? 1. " + plane2.fallsOn(s.p1, s) + ", 2. " +
			plane2.fallsOn(s.p2, s) + ".\n"
		);*/

		/*
		plane3 p = new plane3(new point3(0, 1, 3), new point3(4, 6, 2), new point3(8, 0, 0));
		System.out.println(
			"Do points " + p.p1 + ", " + p.p2 + ", and " + p.p3 + "fall on plane " +
			p.a + "x + " + p.b + "y + " + p.c + "z = " + p.d + "? 1. " + plane3.fallsOn(p.p1, p) +
			", 2. " + plane3.fallsOn(p.p2, p) + ", 3. " + plane3.fallsOn(p.p3, p) + ".\n"
		);*/

		/*
		point2 a = new point2(0, 1), b = new point2(1, 0);
		point3 j = new point3(0, 1, 2), k = new point3(1, 2, 3);

		System.out.println(
			"Vector a = " + a + ", Vector b = " + b + "\n" +
			"2a = " + point2.scalarMultiply(a, 2) + "\n" +
			"a == b? " + a.isEqualTo(b) + "\n" +
			"a + b = " + point2.add(a, b) + "\n" +
			"a - b = " + point2.subtract(a, b) + "\n" +
			"a . b = " + point2.dotProduct(a, b) + "\n" +
			"a >< b = " + point2.compare(a, b) + "\n"
		);

		System.out.println(
			"Vector j = " + j + ", Vector k = " + k + "\n" +
			"2k = " + point3.scalarMultiply(j, 2) + "\n" +
			"j == k? " + j.isEqualTo(k) + "\n" +
			"j + k = " + point3.add(j, k) + "\n" +
			"j - k = " + point3.subtract(j, k) + "\n" +
			"j . k = " + point3.dotProduct(j, k) + "\n" +
			"j >< k = " + point3.compare(j, k) + "\n"
		);*/


		point2 p1 = new point2(2,0);
		plane2 p = new plane2(new point2(1,0), new point2(1, 1));
		System.out.println(
			"Does vector p" + p1 + "cross over plane P" + p.toString() +
			" -- " + p.equation() + "?\n\n\t" +
			plane2.doesIntersectPlane(p1, p)
		);

		point3 p2 = new point3(2,0,0);
		plane3 q = new plane3(new point3(1,0,0), new point3(1, 1,0), point3.ZEROV);
		System.out.println(
			"Does vector p" + p2 + "cross over plane Q" + q.toString() +
			" -- " + q.equation() + "?\n\n\t" +
			plane3.doesIntersectPlane(p2, q)
		);

	}

}