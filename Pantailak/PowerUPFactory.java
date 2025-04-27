package Pantailak;

public class PowerUPFactory {
	
	////////////ATRIBUTUAK////////////
	private static PowerUPFactory nirePowerUPFactory;
	
	////////////ERAIKITZAILEA////////////
	private PowerUPFactory() {}
	
	public static PowerUPFactory getNireBlokeFactory() {
		if (nirePowerUPFactory == null) {
			nirePowerUPFactory = new PowerUPFactory();
		}
		return nirePowerUPFactory;
	}
	
	////////////BLOKEA SORTU////////////
	public PowerUP sortuPowerUP(int pMota, int pX, int pY) {
		PowerUP nirePUP = null;
		if (pMota == 1) {
			nirePUP = new Izarra(pX,pY);	//Bloke gogorra sortu
		}
//		else if (pMota == 2){
//			nirePUP = null	//Bloke biguna sortu
//		}
//		else {
//			nirePUP = null	//Bloke hutsa sortu
//		}
		return nirePUP;
	}

}
