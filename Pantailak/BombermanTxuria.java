package Pantailak;

public class BombermanTxuria extends Bomberman {
	
	//private int bonbaKop = 10;
	public BombermanTxuria(int pX,int pY) {
		super(pX, pY, 2, new BonbaNormala());
		setBonbaKop(10);
	}
	
}