package Pantailak;

public class GelaxkaFactory {
	
	private static GelaxkaFactory nireGelaxkaFactory;
	
	private GelaxkaFactory() {
		
	}
	
	public static GelaxkaFactory getNireGelaxkaFactory() {	
		if(nireGelaxkaFactory == null) {
			nireGelaxkaFactory = new GelaxkaFactory();
		}
		return nireGelaxkaFactory;
	}
	
	public GelaxkaEredu sortuGelaxka(int pMota) {
		GelaxkaEredu nireGelaxka = null;
		if (pMota == 1) {
			
		}
		return null;
	}
	
}