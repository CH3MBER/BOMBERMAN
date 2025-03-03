package Pantailak;

public class JokalariEredu {
	private int X;
	private int Y;
	private int aurreX;
	private int aurreY;
	
	public JokalariEredu(int pX, int pY) {
		this.X = pX;
		this.Y = pY;
		this.aurreX = pX;
		this.aurreY = pY;
	}
	
	public int getX() {
		return this.X;
	}
	
	public int getY() {
		return this.Y;
	}

	public void setX(int i) {
		// TODO Auto-generated method stub
		this.X = i;		
	}

	public void setY(int i) {
		// TODO Auto-generated method stub
		this.Y = i;
	}
	
	public int getAurrekoX() {
		return this.aurreX;
	}
	
	public int getAurrekoY() {
		return this.aurreY;
	}

	public void setAurrekoX(int i) {
		// TODO Auto-generated method stub
		this.aurreX = i;		
	}

	public void setAurrekoY(int i) {
		// TODO Auto-generated method stub
		this.aurreY = i;
	}
}
