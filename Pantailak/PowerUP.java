package Pantailak;

public abstract class PowerUP {

	private int X;
	private int Y;
	
	protected PowerUP(int pX, int pY) {
		this.X = pX;
		this.Y = pY;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

}
