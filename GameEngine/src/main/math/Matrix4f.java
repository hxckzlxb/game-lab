package main.math;

public class Matrix4f {

	// Variables
	private float[][] elements;

	// Constructors
	public Matrix4f() {
		elements = new float[4][4];
	}

	// Functions
	public Matrix4f Zero() {
		elements[0][0] = 0;
		elements[0][1] = 0;
		elements[0][2] = 0;
		elements[0][3] = 0;

		elements[1][0] = 0;
		elements[1][1] = 0;
		elements[1][2] = 0;
		elements[1][3] = 0;

		elements[2][0] = 0;
		elements[2][1] = 0;
		elements[2][2] = 0;
		elements[2][3] = 0;

		elements[3][0] = 0;
		elements[3][1] = 0;
		elements[3][2] = 0;
		elements[3][3] = 0;

		return this;
	}

	public Matrix4f Identity() {
		elements[0][0] = 1;
		elements[0][1] = 0;
		elements[0][2] = 0;
		elements[0][3] = 0;

		elements[1][0] = 0;
		elements[1][1] = 1;
		elements[1][2] = 0;
		elements[1][3] = 0;

		elements[2][0] = 0;
		elements[2][1] = 0;
		elements[2][2] = 1;
		elements[2][3] = 0;

		elements[3][0] = 0;
		elements[3][1] = 0;
		elements[3][2] = 0;
		elements[3][3] = 1;

		return this;
	}

	public Matrix4f Orthographic2D(final int width, final int height) {
		elements[0][0] = 2f / (float) width;
		elements[0][1] = 0;
		elements[0][2] = 0;
		elements[0][3] = -1;

		elements[1][0] = 0;
		elements[1][1] = 2f / (float) height;
		elements[1][2] = 0;
		elements[1][3] = -1;

		elements[2][0] = 0;
		elements[2][1] = 0;
		elements[2][2] = 1;
		elements[2][3] = 0;

		elements[3][0] = 0;
		elements[3][1] = 0;
		elements[3][2] = 0;
		elements[3][3] = 1;

		return this;
	}

	public Matrix4f Translation(final Vector translation) {
		elements[0][0] = 1;
		elements[0][1] = 0;
		elements[0][2] = 0;
		elements[0][3] = translation.getX();

		elements[1][0] = 0;
		elements[1][1] = 1;
		elements[1][2] = 0;
		elements[1][3] = translation.getY();

		elements[2][0] = 0;
		elements[2][1] = 0;
		elements[2][2] = 1;
		elements[2][3] = translation.getZ();

		elements[3][0] = 0;
		elements[3][1] = 0;
		elements[3][2] = 0;
		elements[3][3] = 1;

		return this;
	}

	public Matrix4f Rotation(final Vector rotation) {
		Matrix4f rx = new Matrix4f();
		Matrix4f ry = new Matrix4f();
		Matrix4f rz = new Matrix4f();

		float x = (float) Math.toRadians(rotation.getX());
		float y = (float) Math.toRadians(rotation.getY());
		float z = (float) Math.toRadians(rotation.getZ());

		// RZ
		rz = Zero();
		rz.elements[0][0] = (float) Math.cos(z);
		rz.elements[0][1] = -(float) Math.sin(z);
		rz.elements[1][0] = (float) Math.sin(z);
		rz.elements[1][1] = (float) Math.cos(z);

		// RX
		rx = Zero();
		rx.elements[0][0] = 1;
		rx.elements[1][1] = (float) Math.cos(x);
		rx.elements[1][2] = -(float) Math.sin(x);
		rx.elements[2][1] = (float) Math.sin(x);
		rx.elements[2][2] = (float) Math.cos(x);

		// RY
		ry = Zero();
		ry.elements[0][0] = (float) Math.cos(y);
		ry.elements[0][2] = (float) Math.sin(y);
		ry.elements[1][1] = 1;
		ry.elements[2][0] = -(float) Math.sin(y);
		ry.elements[2][2] = (float) Math.cos(y);

		elements = rz.mul(ry.mul(rx)).getElements();

		return this;
	}

	// Operators
	public Matrix4f mul(final Matrix4f m) {
		Matrix4f result = new Matrix4f();

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				result.setElement(i, j, elements[i][0] * m.getElement(0, j) + elements[i][1] * m.getElement(1, j)
						+ elements[i][2] * m.getElement(2, j) + elements[i][3] * m.getElement(3, j));
			}
		}

		return result;
	}

	// Getters and Setters
	public float[][] getElements() {
		return this.elements;
	}

	public float getElement(final int r, final int c) {
		return this.elements[r][c];
	}

	public void setElement(final int r, final int c, final float e) {
		this.elements[r][c] = e;
	}

	public void setElements(final float[][] el) {
		this.elements = el;
	}

}
