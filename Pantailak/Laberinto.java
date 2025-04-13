package Pantailak;

import java.util.ArrayList;
import java.util.Random;

public abstract class Laberinto {

	protected GelaxkaZerrenda gelaxkaZerrenda = new GelaxkaZerrenda();	//Gelaxkak bilduko dituen kolekzioa
	protected BlokeZerrenda blokeZerr = new BlokeZerrenda();
	protected final int zutabe = 17;
	protected final int errenkada = 11;
	protected EtsaiZerrenda etsaiLista = new EtsaiZerrenda();
	
	public Laberinto() {
		matrizeaSortu();
	}
	
	protected double ausazZenbakia() {
		Random ram = new Random();
		double aukera = ram.nextDouble();	//Ausaz zenbaki bat aukeratzen du, bloke biguna edo etsai bat sortzeko
		//System.out.print("\n"+aukera);
		return aukera;
	}

	protected abstract void matrizeaSortu();
	
	public GelaxkaZerrenda getGelaZerr(){
		return this.gelaxkaZerrenda;
	}
	
	public BlokeZerrenda getbZerr() {
		return blokeZerr;
	}

	public int getZutabe() {
		return zutabe;
	}

	public int getErrenkada() {
		return errenkada;
	}
	
	public EtsaiZerrenda getEtsaiLista() {
		return etsaiLista;
	}
}
