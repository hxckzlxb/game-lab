package main;

import main.math.Point;
import main.math.Vector;

public class MainManager {

	public static void main(String[] args) {
		Point point1 = new Point(1, 2, 1);
		Point point2 = new Point(0, 4, 4);
		Vector vector1 = new Vector(2, 0, 0);
		Vector vector2;

		point1.drawPoint(); // should display (1,2,1)
		point2.drawPoint(); // should display (0,4,4)

		vector2 = point1.SubstractPointFromPoint(point2);

		vector1 = vector1.AddVectorToVector(vector2);

		point1.AddVectorToPoint(vector1);
		point1.drawPoint(); // should display (4,0,-2)

		point2.SubstractVectorFromPoint(vector2);
		point2.drawPoint(); // should display (-1,6,7)
	}

}
