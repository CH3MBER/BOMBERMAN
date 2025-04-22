package Pantailak;

import java.util.Timer;
import java.util.TimerTask;

public class BombermanTxuria extends Bomberman {
	
	//private int bonbaKop = 10;
	public BombermanTxuria(int pX,int pY) {
		super(pX, pY, new BombaNormala());
		setBonbaKop(10);
	}
	
}