package Pantailak;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;
import java.util.Random;

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
	private Queue<Integer> proba = new LinkedList<Integer>();
	private int lehenLibre = 1;
	
	
	////////////ERAIKITZAILEA////////////
	private LaberintoEredua() {
		this.bZerr = new BlokeZerrenda();
		matrizeaSortu();
		this.bonberman = new JokalariEredu(0,0);
		setChanged();
		notifyObservers(new int[] {1});
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
					bZerr.gehituBloke(new Bloke(null,zut,lerro));
				}
				else {
					gel = new GelaxkaEredu(0);
					getGelaZerr().add(gel);	//Hutsik
					bZerr.gehituBloke(new Bloke(null,zut,lerro));
				}
			}
		}
	}

	////////////GETTER eta SETTER////////////
	public ArrayList<GelaxkaEredu> getGelaZerr() {
		if(gelaxkaZerrenda == null) {
			gelaxkaZerrenda = new ArrayList<>();
		}
		return gelaxkaZerrenda;
	}
	
	public BlokeZerrenda getbZerr() {
		return bZerr;
	}

	public JokalariEredu getBomberman() {
		return this.bonberman;
	}

	public int getZutabe() {
		return zutabe;
	}

	public int getErrenkada() {
		return errenkada;
	}

	public boolean getBorratu() {
		return this.borratu;
	}
	
	public void setBorratu(boolean borratu) {
		this.borratu = borratu;
	}

	////////////AUSAZKO ZENBAKIA////////////
	private double ausazZenbakia() {
		Random ram = new Random();
		double aukera = ram.nextDouble();	//Ausaz zenbaki bat aukeratzen du, bloke biguna edo etsai bat sortzeko
		//System.out.print("\n"+aukera);
		return aukera;
	}

	////////////JOKALARIA MUGITU////////////
	public void mugitu(int i, int j) {
		boolean mugitu = false;
		boolean erre = false;
		if (!((this.bonberman.getX()+i<0) || (this.bonberman.getY()+j<0) || (this.bonberman.getX()+i>16) || (this.bonberman.getY()+j>10))){	//Bonberman-a tarteetan dagoela konprobatzen du
			if(!((getGelaZerr().get((this.bonberman.getY()+j)*17+this.bonberman.getX()+i).getTipo() == 1) || (getGelaZerr().get((this.bonberman.getY()+j)*17+this.bonberman.getX()+i).getTipo() == 2) || (getGelaZerr().get((this.bonberman.getY()+j)*17+this.bonberman.getX()+i).getTipo() == 3))){	//Bonberman-a blokeekin ez dela joko konprobatzen du
				this.bonberman.setAurrekoY(this.bonberman.getY());	//Lehengo aurreko posizioak eguneratzen ditu eta gero helduko den posizioa
				this.bonberman.setY(this.bonberman.getY()+j);
				this.bonberman.setAurrekoX(this.bonberman.getX());
				this.bonberman.setX(this.bonberman.getX()+i);
				mugitu = true;
				if (getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).getTipo() == 4) {
					getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setTipo(12);
					erre = true;
				}
				else {
					getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setTipo(5);
				}
			}	
		}
		
		if(!erre) {
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
		}
		
		if (mugitu) //Gelaxka hutsik dagoela adierazteko balio du, alegia, Bonberman-a mugitu da.
			getGelaZerr().get((this.bonberman.getAurrekoY())*17+this.bonberman.getAurrekoX()).setTipo(0);
	}
	
	//KENDU HEMENDIK BONBA METODOA
	public void bonbaJarri() {
		if (bonberman.bonbaNahiko()) {
			bonberman.bonbaGutxitu();	
			Bonba bonba = new Bonba(3, this.bonberman.getX(), this.bonberman.getY());
			proba.add(lehenLibre);
			System.out.print(proba.peek());
			getGelaZerr().get(this.bonberman.getY()*17+this.bonberman.getX()).setTipo(3);
			this.bonberman.setY(this.bonberman.getAurrekoY());
			this.bonberman.setX(this.bonberman.getAurrekoX());
			getGelaZerr().get(this.bonberman.getY()*17+this.bonberman.getX()).setTipo(5);
			lehenLibre++;
		}
		else if (bonberman.denboraPasa()){
			Bonba bonba = new Bonba(3, this.bonberman.getX(), this.bonberman.getY());
			proba.add(lehenLibre);
			System.out.print(proba.peek());
			getGelaZerr().get(this.bonberman.getY()*17+this.bonberman.getX()).setTipo(3);
			this.bonberman.setY(this.bonberman.getAurrekoY());
			this.bonberman.setX(this.bonberman.getAurrekoX());
			getGelaZerr().get(this.bonberman.getY()*17+this.bonberman.getX()).setTipo(5);
			lehenLibre++;
			bonberman.bonbaJarrita();
			bonberman.timerAktibatu();
		}
	}
	
	public void apurtuBlokeak(int zut, int lerr) {
		int pos = lerr*17+zut;
		//bZerr.blokeakInprimatu();
		if(zut-1>=0 && !(getGelaZerr().get(lerr*17+(zut-1)).getTipo() == 1)) {
			pos = pos-1;
			Sua sua = new Sua(zut-1,lerr);
			if (this.bonberman.getY()*17+this.bonberman.getX() == lerr*17+(zut-1)) {
				getGelaZerr().get(lerr*17+(zut-1)).setTipo(12);
				this.bonberman.setBizitza(false);
				System.exit(0);
			}
			else
				getGelaZerr().get(lerr*17+(zut-1)).setTipo(4);
			bZerr.eztandaEginPosizioan(zut-1, lerr);
			System.out.print("\n"+pos);
		}
		if(zut+1<=16 && !(getGelaZerr().get(lerr*17+(zut+1)).getTipo() == 1)) {
			pos = pos+1;
			Sua sua = new Sua(zut+1,lerr);
			if (this.bonberman.getY()*17+this.bonberman.getX() == lerr*17+(zut+1)) {
				getGelaZerr().get(lerr*17+(zut+1)).setTipo(12);
				this.bonberman.setBizitza(false);
				System.exit(0);
			}
			else
				getGelaZerr().get(lerr*17+(zut+1)).setTipo(4);
			bZerr.eztandaEginPosizioan(zut+1, lerr);
			System.out.print("\n"+pos);
		}	
		if(lerr-1>=0 && !(getGelaZerr().get((lerr-1)*17+zut).getTipo() == 1)) { 
			pos = pos-17;
			Sua sua = new Sua(zut,lerr-1);
			if (this.bonberman.getY()*17+this.bonberman.getX() == (lerr-1)*17+zut){
				getGelaZerr().get((lerr-1)*17+zut).setTipo(12);
				this.bonberman.setBizitza(false);
				System.exit(0);
			}
			else
				getGelaZerr().get((lerr-1)*17+zut).setTipo(4);
			bZerr.eztandaEginPosizioan(zut, lerr-1);
			System.out.print("\n"+pos);
		}
		if(lerr+1<=10 && !(getGelaZerr().get((lerr+1)*17+zut).getTipo() == 1)) {
			pos = pos+17;
			Sua sua = new Sua(zut,lerr+1);
			if (this.bonberman.getY()*17+this.bonberman.getX() == (lerr+1)*17+zut) {
				getGelaZerr().get((lerr+1)*17+zut).setTipo(12);
				this.bonberman.setBizitza(false);
				System.exit(0);
			}
			else
				getGelaZerr().get((lerr+1)*17+zut).setTipo(4);
			bZerr.eztandaEginPosizioan(zut, lerr+1);
			System.out.print("\n"+pos);
		}
		
		if (!(bZerr.blokeBigunaDu())) {
			System.out.print("\nIrabazi duzu");
			System.exit(0);
		}
	}
	
	
}