package Pantailak;

import java.util.Observable;

public class HasieraPantailaEredu extends Observable{

	private static HasieraPantailaEredu nHPE = null;
	private int laberinto = 0;
	private int bomberman = 0;
	
	private HasieraPantailaEredu() {
		
	}
	
	public static HasieraPantailaEredu getHPE() {
		if (nHPE == null) {
			nHPE = new HasieraPantailaEredu();
		}
		return nHPE;
	}
	
	public void eguneratu() {
		setChanged();
		notifyObservers(new int[] {bomberman, laberinto});
	}
	
	public void bombermanAukera(int aukera) {
		if (!(bomberman == 0 && aukera == 1 || bomberman == 1 && aukera == -1)) {
			if (aukera == 1)
				bomberman = 0;
			else
				bomberman = 1;
			setChanged();
			notifyObservers(new int[] {bomberman, laberinto});
		}
	}
	
	public void laberintoAukera(int aukera) {
		if (!(laberinto == 0 && aukera == -1 || laberinto == 2 && aukera == 1)) {
			if (laberinto == 1 && aukera == -1)
				laberinto = 0;
			else if (laberinto == 2 && aukera == -1)
				laberinto = 1;
			else if (laberinto == 0 && aukera == 1)
				laberinto = 1;
			else if (laberinto == 1 && aukera == 1)
				laberinto = 2;
			setChanged();
			notifyObservers(new int[] {bomberman, laberinto});
		}
	}
	
	
}
