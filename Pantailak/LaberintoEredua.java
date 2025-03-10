package Pantailak;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import javax.swing.JLabel;

@SuppressWarnings("deprecation")
public class LaberintoEredua extends Observable{
	
	////////////ATRIBUTUAK////////////
	private static LaberintoEredua nLE = null;
	private ArrayList<GelaxkaEredu> gelaxkaZerrenda = null;//Gelaxkak bilduko dituen kolekzioa
	private BlokeZerrenda bZerr;
	private final int zutabe = 17;
	private final int errenkada = 11;
	private JokalariEredu bonberman;
	private boolean borratu = false;
	
	
	////////////ERAIKITZAILEA////////////
	private LaberintoEredua() {
		this.bZerr = new BlokeZerrenda();
		matrizeaSortu();
		this.bonberman = new JokalariEredu(0,0);
		setChanged();
		notifyObservers();
	}
	
	public static LaberintoEredua getLabEredua() {
		if (nLE == null) {
			nLE = new LaberintoEredua();
		}
		return nLE;
	}
	
	
	////////////MATRIZEA ERAIKI////////////
	private void matrizeaSortu() { //Hurrengo aukerak: 0 Gelaxka Hutsa, 1 Bloke Gogorra, 2 Bloke Biguna 5 Bonberman-a
		int lerro, zut;
		for(lerro=0;lerro<errenkada;lerro++) {
			for(zut=0;zut<zutabe;zut++) {
				GelaxkaEredu gel = null;
				int i = zut%17;
				if (i%2!=0 && lerro%2!=0) {
					bZerr.gehituBloke(new Bloke("Gogorra", zut, lerro));
					gel = new GelaxkaEredu(1);
					getGelaZerr().add(gel); //Bloke Gogorra
				}
				else if (ausazZenbakia()>0.4 && !((lerro==0 && zut==0)||(lerro==0 && zut==1)||(lerro==1 && zut==0))){
					bZerr.gehituBloke(new Bloke("Biguna", zut, lerro));
					gel = new GelaxkaEredu(2);
					getGelaZerr().add(gel);	//Bloke Biguna
				}
				else if (lerro==0 && zut==0) {
					gel = new GelaxkaEredu(5);
					getGelaZerr().add(gel);	//Bonberman
				}
				else {
					gel = new GelaxkaEredu(0);
					getGelaZerr().add(gel);	//Hutsik
				}
			}
		}
	}
	
	////////////AUSAZKO ZENBAKIA////////////
	private double ausazZenbakia() {
		Random ram = new Random();
		double aukera = ram.nextDouble();	//Ausaz zenbaki bat aukeratzen du, bloke biguna edo etsai bat sortzeko
		//System.out.print("\n"+aukera);
		return aukera;
	}


	public ArrayList<GelaxkaEredu> getGelaZerr() {
		if(gelaxkaZerrenda == null) {
			gelaxkaZerrenda = new ArrayList<>();
		}
		return gelaxkaZerrenda;
	}
	
	public JokalariEredu getBomberman() {
		return this.bonberman;
	}
	
	////////////JOKALARIA MUGITU////////////
	public void mugitu(int i, int j) {
		boolean mugitu = false;
		if (!((this.bonberman.getX()+i<0) || (this.bonberman.getY()+j<0) || (this.bonberman.getX()+i>16) || (this.bonberman.getY()+j>10))){	//Bonberman-a tarteetan dagoela konprobatzen du
			if(!((getGelaZerr().get((this.bonberman.getY()+j)*17+this.bonberman.getX()+i).getTipo() == 1) || (getGelaZerr().get((this.bonberman.getY()+j)*17+this.bonberman.getX()+i).getTipo() == 2))){	//Bonberman-a blokeekin ez dela joko konprobatzen du
				this.bonberman.setAurrekoY(this.bonberman.getY());	//Lehengo aurreko posizioak eguneratzen ditu eta gero helduko den posizioa
				this.bonberman.setY(this.bonberman.getY()+j);
				this.bonberman.setAurrekoX(this.bonberman.getX());
				this.bonberman.setX(this.bonberman.getX()+i);
				getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setTipo(5);
				mugitu = true;
			}	
		}
		
		switch (i){	//Mugimenduaren arabera "sprite" bat edo beste bat erakutsiko du
		case 0:
			getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setTipo(getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).getTipo());
			break;
		case -1:
			getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setTipo(6);
			break;
		case 1:
			getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setTipo(7);
			break;
		}
		switch (j){
		case 0:
			getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setTipo(getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).getTipo());
			break;
		case -1:
			if(getGelaZerr().get((this.bonberman.getAurrekoY())*17+this.bonberman.getAurrekoX()).getTipo() == 8){
				getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setTipo(10);
			}
			else {
				getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setTipo(8);
			}
			break;
		case 1:
			getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setTipo(9);
			break;
		}
		
		if (mugitu) //Gelaxka hutsik dagoela adierazteko balio du, alegia, Bonberman-a mugitu da.
			getGelaZerr().get((this.bonberman.getAurrekoY())*17+this.bonberman.getAurrekoX()).setTipo(0);
		
		setChanged();
		notifyObservers();
	}
	
	public boolean getBorratu() {
		return this.borratu;
	}
	
	public boolean kenduBorratu() {
		return this.borratu = false;
	}
	
	
	//KENDU HEMENDIK BONBA METODOA
	public void ingurunea() {
		this.borratu = false;
		int pos = (this.bonberman.getY())*17+this.bonberman.getX();	
		if(this.bonberman.getX()-1>=0 && !(getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()-1).getTipo() == 1)) {
			//pos = (this.bonberman.getY())*17+this.bonberman.getX()+1*(-1);
			pos = pos-1;
			getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()-1).setTipo(0);
			bZerr.deleteBloke(bZerr.getBloke((this.bonberman.getY())*17+this.bonberman.getX()-1));
			System.out.print("\n"+pos);
			borratu = true;
		}
		if(this.bonberman.getX()+1<=16 && !(getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()+1).getTipo() == 1)) {
			//pos = this.bonberman.getY()*17+this.bonberman.getX()+1;
			pos = pos+1;
			getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()+1).setTipo(0);
			bZerr.deleteBloke(bZerr.getBloke((this.bonberman.getY())*17+this.bonberman.getX()+1));
			System.out.print("\n"+pos);
			borratu = true;
		}	
		if(this.bonberman.getY()-1>=0 && !(getGelaZerr().get((this.bonberman.getY()-1)*17+this.bonberman.getX()).getTipo() == 1)) { 
			//pos = (this.bonberman.getY()-1)*17+this.bonberman.getX();
			pos = pos-17;
			getGelaZerr().get((this.bonberman.getY()-1)*17+this.bonberman.getX()).setTipo(0);
			bZerr.deleteBloke(bZerr.getBloke((this.bonberman.getY()-1)*17+this.bonberman.getX()));
			System.out.print("\n"+pos);
			borratu = true;
		}
		if(this.bonberman.getY()+1<=10 && !(getGelaZerr().get((this.bonberman.getY()+1)*17+this.bonberman.getX()).getTipo() == 1)) {
			//pos = (this.bonberman.getY()+1)*17+this.bonberman.getX();
			pos = pos+17;
			getGelaZerr().get((this.bonberman.getY()+1)*17+this.bonberman.getX()).setTipo(0);
			bZerr.deleteBloke(bZerr.getBloke((this.bonberman.getY()+1)*17+this.bonberman.getX()));
			System.out.print("\n"+pos);
			borratu = true;
		}
		setChanged();
		notifyObservers();
	}
	
}
