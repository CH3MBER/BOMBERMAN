package Pantailak;

public class BlokeFactory {
	private static BlokeFactory nireBlokeFactory;
	
	
	private BlokeFactory() {
		
	}
	public static BlokeFactory getNireBlokeFactory() {
		if (nireBlokeFactory == null) {
			nireBlokeFactory = new BlokeFactory();
		}
		return nireBlokeFactory;
	}
	
	public Bloke sortuBlokea(int pMota, int pX, int pY) {
		Bloke nireBloke = null;
		if (pMota == 1) {
			nireBloke = new Gogorra(pX,pY);
		}
		else if (pMota == 2){
			nireBloke = new Biguna(pX, pY);
		}
		else {
			nireBloke = new Hutsa(pX, pY);
		}
		return nireBloke;
	}

}