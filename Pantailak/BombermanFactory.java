package Pantailak;

public class BombermanFactory {
	private static BombermanFactory nireBomebermanFactory;
	
	
	private BombermanFactory() {
		
	}
	
	public static BombermanFactory getNireJokalariFactory() {
		if (nireBomebermanFactory == null) {
			nireBomebermanFactory = new BombermanFactory();
		}
		return nireBomebermanFactory;
	}
	
	public Bomberman sortuJokalari(int i, int pX, int pY) {
		Bomberman bomberman = null;
		if(i == 1) {         //Bomberman Txuria sortu
			bomberman = new BombermanTxuria(pX,pY);
		}
		else if(i == 2) {   //Bomberman Urdina sortu
			bomberman = new BombermanBeltza(pX, pY);
		}
		else if(i == 3) {	//Bomberman Gorria sortu
			bomberman = new BombermanGorria(pX,pY);
		}
		else if(i == 4) {  	//Bomberman Beltza sortu
			bomberman = new BombermanBeltza(pX, pY);
		}
		return bomberman;
	}

}