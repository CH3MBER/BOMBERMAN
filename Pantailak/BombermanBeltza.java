package Pantailak;

public class BombermanBeltza extends Bomberman {

	private int bonbaKop = 1;
	
	public BombermanBeltza(int pX,int pY) {
		super(pX, pY, 20, new BonbaUltra());
		setBonbaKop(1);
	}

}