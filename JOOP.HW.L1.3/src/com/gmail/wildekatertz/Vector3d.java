package com.gmail.wildekatertz;

public class Vector3d {

	private double x;
	private double y;
	private double z;

	public Vector3d() {
	}

	public Vector3d(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return "Vector3d [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	public static Vector3d sumVector3d(Vector3d a, Vector3d b) {
		Vector3d c = new Vector3d((a.getX() + b.getX()), (a.getY() + b.getY()), (a.getZ() + b.getZ()));
		return c;
	}

	public static double scalarProductVector3d(Vector3d a, Vector3d b) {
		double scalarProduct = (a.getX() * b.getX()) + (a.getY() * b.getY()) + (a.getZ() * b.getZ());
		return scalarProduct;
	}

	public static Vector3d vectorProductVector3d(Vector3d a, Vector3d b) {
		Vector3d c = new Vector3d((a.getY() * b.getZ() - a.getZ() * b.getX()),
				(a.getZ() * b.getX() - a.getX() * b.getZ()), (a.getZ() * b.getX() - a.getX() * b.getZ()));
		return c;
	}

}
