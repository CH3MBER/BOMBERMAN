package Pantailak;

public class LaberintoFactory {
	private static LaberintoFactory nLF = null;
	
	private LaberintoFactory(){}

	public static LaberintoFactory getLF() {
		if(nLF == null)
			nLF = new LaberintoFactory();
		return nLF;
	}
	
	public Laberinto sortuLaberinto(int pMota) {
		Laberinto nLE = null;
		switch(pMota) {
			case 1: nLE = new LaberintoClassic(); break;
			case 2: nLE = new LaberintoSoft(); break;
			case 3: nLE = new LaberintoEmpty(); break;
		}
		return nLE;
		
	}
	
}
