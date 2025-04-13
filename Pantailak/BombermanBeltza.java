package Pantailak;

public class BombermanBeltza extends JokalariEredu {

	private int bonbaKop = 1;
	
	public BombermanBeltza(int pX,int pY) {
		super(pX, pY, new BombaUltra());
		setBonbaKop(1);
	}

}