package bomberman;

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
			nirePUP = new Izarra(pX,pY);	//Izar berria sortu
		}
		else if (pMota == 2){
			nirePUP = new Bihotza(pX,pY);	//Bihotz berria sortu
//		}
//		else {
//			nirePUP = null	//Bloke hutsa sortu
//		}
		return nirePUP;
	}

}