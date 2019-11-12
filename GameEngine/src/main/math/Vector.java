package main.math;

public class Vector {

	// Variables
	private float[] tuple; // (x, y, z)

	// Constructors
	public Vector(float x, float y, float z) {
		tuple = new float[3];

		tuple[0] = x;
		tuple[1] = y;
		tuple[2] = z;
	}

	public Vector() {
		tuple = new float[3];
		tuple[0] = tuple[1] = tuple[2] = 0;
	}

	// Operators
	public Vector AddVectorToVector(final Vector v) {
		Vector ve = new Vector(this.tuple[0], this.tuple[1], this.tuple[2]);

		ve.tuple[0] += v.tuple[0];
		ve.tuple[1] += v.tuple[1];
		ve.tuple[2] += v.tuple[2];

		return ve;
	}

	public Vector SubstractVectorFromVector(final Vector v) {
		Vector ve = new Vector(this.tuple[0], this.tuple[1], this.tuple[2]);

		ve.tuple[0] -= v.tuple[0];
		ve.tuple[1] -= v.tuple[1];
		ve.tuple[2] -= v.tuple[2];

		return ve;
	}

	// Getters and Setters
	public float[] getTuples() {
		return this.tuple;
	}

	public float getX() {
		return this.tuple[0];
	}

	public float getY() {
		return this.tuple[1];
	}

	public float getZ() {
		return this.tuple[2];
	}

	public void setTuples(final int pos, final float tuple) {
		this.tuple[pos] = tuple;
	}

	public void setTuples(final Vector v) {
		this.tuple = v.tuple;
	}

}
