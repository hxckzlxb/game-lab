package main.math;

public class Point {

	// Variables
	private float[] tuple; // (x, y, z)

	// Constructors
	public Point(float x, float y, float z) {
		tuple = new float[3];

		tuple[0] = x;
		tuple[1] = y;
		tuple[2] = z;
	}

	public Point() {
		tuple = new float[3];
		tuple[0] = tuple[1] = tuple[2] = 0;
	}

	// Operators
	public void AddVectorToPoint(final Vector v) {
		tuple[0] += v.getTuples()[0];
		tuple[1] += v.getTuples()[1];
		tuple[2] += v.getTuples()[2];
	}

	public void SubstractVectorFromPoint(final Vector v) {
		tuple[0] -= v.getTuples()[0];
		tuple[1] -= v.getTuples()[1];
		tuple[2] -= v.getTuples()[2];
	}

	public Vector SubstractPointFromPoint(final Point p) {
		Vector v = new Vector();

		v.setTuples(0, this.tuple[0] - p.tuple[0]);
		v.setTuples(1, this.tuple[1] - p.tuple[1]);
		v.setTuples(2, this.tuple[2] - p.tuple[2]);

		return v;
	}

	// Functions
	public void drawPoint() {
		System.out.println("(" + this.tuple[0] + ", " + this.tuple[1] + ", " + this.tuple[2] + ")");
	}

	// Getters and Setters
	public float[] getTuples() {
		return this.tuple;
	}

	public void setTuple(final int pos, final float tuple) {
		this.tuple[pos] = tuple;
	}

	public void setTuple(final Point p) {
		this.tuple = p.tuple;
	}

}
