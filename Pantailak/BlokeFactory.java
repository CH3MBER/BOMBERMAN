package Pantailak;

public class BlokeFactory {
	
	////////////ATRIBUTUAK////////////
	private static BlokeFactory nireBlokeFactory;
	
	////////////ERAIKITZAILEA////////////
	private BlokeFactory() {}
	
	public static BlokeFactory getNireBlokeFactory() {
		if (nireBlokeFactory == null) {
			nireBlokeFactory = new BlokeFactory();
		}
		return nireBlokeFactory;
	}
	
	////////////BLOKEA SORTU////////////
	public Bloke sortuBlokea(int pMota, int pX, int pY) {
		Bloke nireBloke = null;
		if (pMota == 1) {
			nireBloke = new Gogorra(pX,pY);	//Bloke gogorra sortu
		}
		else if (pMota == 2){
			nireBloke = new Biguna(pX, pY);	//Bloke biguna sortu
		}
		else {
			nireBloke = new Hutsa(pX, pY);	//Bloke hutsa sortu
		}
		return nireBloke;
	}

}