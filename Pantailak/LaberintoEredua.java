package Pantailak;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import javax.swing.JLabel;

@SuppressWarnings("deprecation")
public class LaberintoEredua extends Observable{
	
	private static LaberintoEredua nLE = new LaberintoEredua();
	private ArrayList<JLabel> gelaxkaZerrenda = null;//Gelaxkak bilduko dituen kolekzioa
	private final int zutabe = 17;
	private final int errenkada = 11;
	private JokalariEredu bonberman;
	
	public LaberintoEredua() {
		matrizeaSortu();
		this.bonberman = new JokalariEredu(0,0);
		setChanged();
		notifyObservers();
	}
	
	private void matrizeaSortu() { 								//Matrizea sortzen du
		int lerro, zut;
		for(lerro=0;lerro<errenkada;lerro++) {
			for(zut=0;zut<zutabe;zut++) {
				getGelaZerr().add(new JLabel());					//Gelaxkak kolekzioan sartzen ditu
			}
		}
	}
	
	public double ausazZenbakia() {								//Ausaz zenbaki bat aukeratzen du, bloke biguna edo etsai bat sortzeko
		Random ram = new Random();
		double aukera = ram.nextDouble();
		//System.out.print("\n"+aukera);
		return aukera;
	}
	
	public static LaberintoEredua getLabEredua() {
		return nLE;
	}
	
	public ArrayList<JLabel> getGelaZerr() {
		if (gelaxkaZerrenda == null) {
			gelaxkaZerrenda = new ArrayList<>();
		}
		return gelaxkaZerrenda;
	}

	public JokalariEredu getBomberman() {
		return this.bonberman;
	}
	
	public void mugitu(int i, int j) {
		this.bonberman.setAurrekoX(this.bonberman.getX());
		this.bonberman.setAurrekoY(this.bonberman.getY());
		this.bonberman.setX(this.bonberman.getX()+i);
		this.bonberman.setY(this.bonberman.getY()+j);
		
		setChanged();
		notifyObservers();
	}
	
}
