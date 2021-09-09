import us.megidont.avc.*;
import java.util.Random;
import java.time.Instant;
import java.time.Duration;

public class vectorCollisionTester{

	public static void main(String[] args){

		/*
		Point3 p = new Point3(7, 7, 7);
		Tetrahedron t = new Tetrahedron(new Point3(0, 0, 0), new Point3(0, 2, 2), new Point3(4, 5, 6), new Point3(5, 8, 13));

		System.out.println(
			"Is P(" + p + "\n" +
			"within T[\n\t(" + t.p1 + ")\n\t("  + t.p2 + ")\n\t("  + t.p3 + ")\n\t("  + t.p4 + ")\n]?\n" +
			Tetrahedron.isInside(p, t)
		);*/

		/*
		Point2 v = new Point2(1, 4);
		Plane2 p = new Plane2(new Point2(1, 3), new Point2(3, 1));

		System.out.println(
			"Does V(" + v + "\n" +
			"cross over P[\n\t(" + p.p1 + ")\n\t(" + p.p2 +")\n]?\n" +
			Plane2.doesIntersect(v, p)
		);
		*/

		/*
		Point3 v1 = new Point3( (float)0.1, (float)0.1, 3);
		Point3 v2 = new Point3( 0, 0, 3);
		Point3 v3 = new Point3( 0, -1, 2);
		Point3 v4 = new Point3( 0, 0, -3);
		Plane3 p = new Plane3(new Point3(0, 0, 2), new Point3(0, 1, 2), new Point3(1, 0, 2));

		System.out.println(
			"Does V(" + v1 + "\n" +
			"cross over Triangle[\n\t(" + p.p1 + ")\n\t(" + p.p2 + ")\n\t(" + p.p3 + ")\n] -- " + p.equation() + "?\n" +
			Plane3.doesIntersectTriangle(v1, p) +"\n\n"
		);
		System.out.println(
			"Does V(" + v2 + "\n" +
			"cross over Triangle[\n\t(" + p.p1 + ")\n\t(" + p.p2 + ")\n\t(" + p.p3 + ")\n] -- " + p.equation() + "?\n" +
			Plane3.doesIntersectTriangle(v2, p) +"\n\n"
		);
		System.out.println(
			"Does V(" + v3 + "\n" +
			"cross over Triangle[\n\t(" + p.p1 + ")\n\t(" + p.p2 + ")\n\t(" + p.p3 + ")\n] -- " + p.equation() + "?\n" +
			Plane3.doesIntersectTriangle(v3, p) +"\n\n"
		);
		System.out.println(
			"Does V(" + v4 + "\n" +
			"cross over Triangle[\n\t(" + p.p1 + ")\n\t(" + p.p2 + ")\n\t(" + p.p3 + ")\n] -- " + p.equation() + "?\n" +
			Plane3.doesIntersectTriangle(v3, p) +"\n\n"
		);

		System.out.println(
			"Does V(" + v1 + "\n" +
			"cross over plane[\n\t(" + p.p1 + ")\n\t(" + p.p2 + ")\n\t(" + p.p3 + ")\n] -- " + p.equation() + "?\n" +
			Plane3.doesIntersectPlane(v1, p) +"\n\n"
		);
		System.out.println(
			"Does V(" + v2 + "\n" +
			"cross over plane[\n\t(" + p.p1 + ")\n\t(" + p.p2 + ")\n\t(" + p.p3 + ")\n] -- " + p.equation() + "?\n" +
			Plane3.doesIntersectPlane(v2, p) +"\n\n"
		);
		System.out.println(
			"Does V(" + v3 + "\n" +
			"cross over plane[\n\t(" + p.p1 + ")\n\t(" + p.p2 + ")\n\t(" + p.p3 + ")\n] -- " + p.equation() + "?\n" +
			Plane3.doesIntersectPlane(v3, p) +"\n\n"
		);
		System.out.println(
			"Does V(" + v4 + "\n" +
			"cross over Triangle[\n\t(" + p.p1 + ")\n\t(" + p.p2 + ")\n\t(" + p.p3 + ")\n] -- " + p.equation() + "?\n" +
			Plane3.doesIntersectPlane(v4, p) +"\n\n"
		);*/

		/*
		Plane2 L = new Plane2(new Point2(0, 0), new Point2(1, 1));
		System.out.println(
			"Is the equation of the line between A(" + L.p2 + ") and B(" + L.p1 + ")\n" +
			L.a + " * x + " + L.b + " * y = " + L.c + "?"
		);

		Plane2 s = new Plane2(new Point2(1, 3), new Point2(3, 1));
		System.out.println(
			"Do points " + s.p1 + " and " + s.p2 + " fall on plane " + s.a + " * x + " + s.b +
			" * y = " + s.c + "? 1. " + Plane2.fallsOn(s.p1, s) + ", 2. " +
			Plane2.fallsOn(s.p2, s) + ".\n"
		);*/

		/*
		Plane3 p = new Plane3(new Point3(0, 1, 3), new Point3(4, 6, 2), new Point3(8, 0, 0));
		System.out.println(
			"Do points " + p.p1 + ", " + p.p2 + ", and " + p.p3 + "fall on plane " +
			p.a + "x + " + p.b + "y + " + p.c + "z = " + p.d + "? 1. " + Plane3.fallsOn(p.p1, p) +
			", 2. " + Plane3.fallsOn(p.p2, p) + ", 3. " + Plane3.fallsOn(p.p3, p) + ".\n"
		);*/

		/*
		Point2 a = new Point2(0, 1), b = new Point2(1, 0);
		Point3 j = new Point3(0, 1, 2), k = new Point3(1, 2, 3);

		System.out.println(
			"Vector a = " + a + ", Vector b = " + b + "\n" +
			"2a = " + Point2.scalarMultiply(a, 2) + "\n" +
			"a == b? " + a.isEqualTo(b) + "\n" +
			"a + b = " + Point2.add(a, b) + "\n" +
			"a - b = " + Point2.subtract(a, b) + "\n" +
			"a . b = " + Point2.dotProduct(a, b) + "\n" +
			"a >< b = " + Point2.compare(a, b) + "\n"
		);

		System.out.println(
			"Vector j = " + j + ", Vector k = " + k + "\n" +
			"2k = " + Point3.scalarMultiply(j, 2) + "\n" +
			"j == k? " + j.isEqualTo(k) + "\n" +
			"j + k = " + Point3.add(j, k) + "\n" +
			"j - k = " + Point3.subtract(j, k) + "\n" +
			"j . k = " + Point3.dotProduct(j, k) + "\n" +
			"j >< k = " + Point3.compare(j, k) + "\n"
		);*/

		/*
		Point2 p1 = new Point2(2,0);
		Plane2 p = new Plane2(new Point2(1,0), new Point2(1, 1));
		System.out.println(
			"Does vector p" + p1 + "cross over plane P" + p.toString() +
			" -- " + p.equation() + "?\n\n\t" +
			Plane2.doesIntersectPlane(p1, p)
		);

		Point3 p2 = new Point3(2,0,0);
		Plane3 q = new Plane3(new Point3(1,0,0), new Point3(1, 1,0), Point3.ZEROV);
		System.out.println(
			"Does vector p" + p2 + "cross over plane Q" + q.toString() +
			" -- " + q.equation() + "?\n\n\t" +
			Plane3.doesIntersectPlane(p2, q)
		);
		*/

		/* */
		Point2 p;
		Triangle t;
		Random rng = new Random();

		int i = 0;
		do{

			p = new Point2(rng.nextInt(20), rng.nextInt(20));
			try{
				t = new Triangle(
						new Point2(rng.nextInt(20), rng.nextInt(20)),
						new Point2(rng.nextInt(20), rng.nextInt(20)),
						new Point2(rng.nextInt(20), rng.nextInt(20))
				);
			}catch(InvalidDataException e){
				System.out.println(e.getMessage());
				t = new Triangle(new Point2(0,0), new Point2(0,1), new Point2(1,0));
			}

			boolean oldWay, newWay, error;
			long startOld, endOld;
			long startNew, endNew;
			long startBase, endBase;
			long oldTime, newTime, baseTime;

			startOld = System.nanoTime();
			oldWay = Triangle.isInsideOld(p, t);
			endOld = System.nanoTime();
			oldTime = endOld - startOld;

			startNew = System.nanoTime();
			newWay = Triangle.isInside(p, t);
			endNew = System.nanoTime();
			newTime = endNew - startNew;

			startBase = System.nanoTime();
			endBase = System.nanoTime();
			baseTime = endBase - startBase;

			error = !(newWay == oldWay);
			String tabStorage = t.toString().length() > 39? "\t" : "\t\t";

			if(error == true){ i = 0xB0DAC105; }

			System.out.println(
				p + "\twithin " + t + "?" + tabStorage + "old: " +
				oldWay + " new: " + newWay +
				(error ? " FAIL!!!!!!!!!!!!!!" : " pass" + (newWay? "!" : ""))
			);
			System.out.println(
				"\n\t\t\t\t\t\t" + oldTime + " -> " + newTime + " : " + baseTime + "\n"
			);


		}while(--i > 0xB0DAC105);
	/* */

	/*
		Point3 p;
		Tetrahedron t;
		Random rng = new Random();

		int i = 0;
		do{

			p = new Point3(rng.nextInt(20), rng.nextInt(20), rng.nextInt(20));
			try{
				t = new Tetrahedron(
						new Point3(rng.nextInt(20), rng.nextInt(20), rng.nextInt(20)),
						new Point3(rng.nextInt(20), rng.nextInt(20), rng.nextInt(20)),
						new Point3(rng.nextInt(20), rng.nextInt(20), rng.nextInt(20)),
						new Point3(rng.nextInt(20), rng.nextInt(20), rng.nextInt(20))
				);
			}catch(InvalidDataException e){
				System.out.println(e.getMessage());
				t = new Tetrahedron(
					new Point3(0,0,0), new Point3(1,0,0),
					new Point3(0,1,0), new Point3(0,0,1)
				);
			}

			boolean oldWay, newWay, error;
			long startOld, endOld;
			long startNew, endNew;
			long startBase, endBase;
			long oldTime, newTime, baseTime;

			startOld = System.nanoTime();
			oldWay = Tetrahedron.isInsideOld(p, t);
			endOld = System.nanoTime();
			oldTime = endOld - startOld;

			startNew = System.nanoTime();
			newWay = Tetrahedron.isInside(p, t);
			endNew = System.nanoTime();
			newTime = endNew - startNew;

			startBase = System.nanoTime();
			endBase = System.nanoTime();
			baseTime = endBase - startBase;

			error = !(newWay == oldWay);
			String tabStorage1 = p.toString().length() > 15? "\t" : "\t\t";
			String tabStorage2 = t.toString().length() > 71? "\t" : "\t\t";

			if(error == true){ i = 0xB0DAC105; }

			System.out.println(
				p + tabStorage1 + "within " + t + "?" + tabStorage2 + "old: " +
				oldWay + " new: " + newWay +
				(error ? " FAIL!!!!!!!!!!!!!!" : " pass" + (newWay? "!" : ""))
			);
			System.out.println(
				"\n\t\t\t\t\t\t" + oldTime + " -> " + newTime + " : " + baseTime + "\n"
			);

		}while(--i > 0xB0DAC105);
	*/

	}

}