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
	private Queue<Bonba> bonbaLista = new LinkedList<>();
	private Queue<Sua> suLista = new LinkedList<>();
	
	
	////////////ERAIKITZAILEA////////////
	private LaberintoEredua() {
		this.bZerr = new BlokeZerrenda();
		matrizeaSortu();
		this.bonberman = new JokalariEredu(0,0);
	}
	
	public static LaberintoEredua getLabEredua() {
		if (nLE == null) {
			nLE = new LaberintoEredua();
		}
		return nLE;
	}
	
	////////////EGUNERAKETA HASIERAN////////////
	public void eguneratu() {
		// TODO Auto-generated method stub
		setChanged();
		notifyObservers(new int[] {1});
	}
	
	
	////////////MATRIZEA ERAIKI////////////
	private void matrizeaSortu() { //Hurrengo aukerak: 0 Gelaxka Hutsa, 1 Bloke Gogorra, 2 Bloke Biguna 5 Bonberman-a
		int lerro, zut;
		for(lerro=0;lerro<errenkada;lerro++) {
			for(zut=0;zut<zutabe;zut++) {
				GelaxkaEredu gel = null;
				int i = zut%17;
				if (i%2!=0 && lerro%2!=0) {
					bZerr.gehituBloke(new Gogorra(zut, lerro));
					gel = new GelaxkaEredu(1);
					getGelaZerr().add(gel); //Bloke Gogorra
				}
				else if (ausazZenbakia()>0.4 && !((lerro==0 && zut==0)||(lerro==0 && zut==1)||(lerro==1 && zut==0))){
					bZerr.gehituBloke(new Biguna(zut, lerro));
					gel = new GelaxkaEredu(2);
					getGelaZerr().add(gel);	//Bloke Biguna
				}
				else if (lerro==0 && zut==0) {
					gel = new GelaxkaEredu(5);
					getGelaZerr().add(gel);	//Bonberman
					bZerr.gehituBloke(null);
				}
				else {
					gel = new GelaxkaEredu(0);
					getGelaZerr().add(gel);	//Hutsik
					bZerr.gehituBloke(null);
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
		boolean bonba = false;
		if (!((this.bonberman.getX()+i<0) || (this.bonberman.getY()+j<0) || (this.bonberman.getX()+i>16) || (this.bonberman.getY()+j>10))){	//Bonberman-a tarteetan dagoela konprobatzen du
			if(!((getGelaZerr().get((this.bonberman.getY()+j)*17+this.bonberman.getX()+i).getMota() == 1) || (getGelaZerr().get((this.bonberman.getY()+j)*17+this.bonberman.getX()+i).getMota() == 2) || (getGelaZerr().get((this.bonberman.getY()+j)*17+this.bonberman.getX()+i).getMota() == 3) || (getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).getMota() == 14))){	//Bonberman-a blokeekin ez dela joko konprobatzen du
				this.bonberman.setAurrekoX(this.bonberman.getX());	//Lehengo, aurreko posizioak eguneratzen ditu eta gero helduko den posizioa
				this.bonberman.setAurrekoY(this.bonberman.getY());
				if (getGelaZerr().get((this.bonberman.getY()+j)*17+this.bonberman.getX()+i).getMota() == 4) {
					for(Sua su : suLista) {
						if (su.getX() == (this.bonberman.getX()+i) && su.getY() == (this.bonberman.getY()+j)) {
							su.ezkonduSua();
						}
					}
					getGelaZerr().get((this.bonberman.getY()+j)*17+this.bonberman.getX()+i).setMota(14);
					erre = true;
				}
				if (getGelaZerr().get((this.bonberman.getAurrekoY())*17+this.bonberman.getAurrekoX()).getMota() == 15) {
					getGelaZerr().get((this.bonberman.getAurrekoY())*17+this.bonberman.getAurrekoX()).setMota(3);
					bonba = true;
				}
				this.bonberman.setX(this.bonberman.getX()+i);
				this.bonberman.setY(this.bonberman.getY()+j);
				mugitu = true;
			}	
		}
		
		if(!erre && !(getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).getMota() == 15) && !(getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).getMota() == 14)) {
			switch (i){	//Mugimenduaren arabera "sprite" bat edo beste bat erakutsiko du
			case -1:
				if(getGelaZerr().get((this.bonberman.getAurrekoY())*17+this.bonberman.getAurrekoX()).getMota() == 6 || getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).getMota() == 6){
					getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setMota(7);
				}
				else {
					getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setMota(6);
				}
				break;
			case 1:
				if(getGelaZerr().get((this.bonberman.getAurrekoY())*17+this.bonberman.getAurrekoX()).getMota() == 8 || getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).getMota() == 8){
					getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setMota(9);
				}
				else {
					getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setMota(8);
				}
				break;
			}
			
			switch (j){
			case -1:
				if(getGelaZerr().get((this.bonberman.getAurrekoY())*17+this.bonberman.getAurrekoX()).getMota() == 12 || getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).getMota() == 12){
					getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setMota(13);
				}
				else {
					getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setMota(12);
				}
				break;
			case 1:
				if(getGelaZerr().get((this.bonberman.getAurrekoY())*17+this.bonberman.getAurrekoX()).getMota() == 10 || getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).getMota() == 10){
					getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setMota(11);
				}
				else {
					getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setMota(10);
				}
				break;
			}
		}
		if (mugitu && !bonba) //Gelaxka hutsik dagoela adierazteko balio du, alegia, Bonberman-a mugitu da, baldin eta bonbarik jarri ez badu.
			getGelaZerr().get((this.bonberman.getAurrekoY())*17+this.bonberman.getAurrekoX()).setMota(0);
		
		if(erre) {
		    System.out.print("\nPartida galdu duzu.");
			javax.swing.Timer timer = new javax.swing.Timer(5, e -> partidaBukatu());
		    timer.setRepeats(false);
		    timer.start();
		}
	}

	public void bonbaJarri() {
		Bonba bonba;
		if (bonberman.bonbaNahiko()) {
			bonberman.bonbaGutxitu();	
			bonba = new Bonba(3, this.bonberman.getX(), this.bonberman.getY());
			getGelaZerr().get(this.bonberman.getY()*17+this.bonberman.getX()).setMota(15);
			bonbaLista.add(bonba);
		}
		else if (bonberman.denboraPasa()){
			bonba = new Bonba(3, this.bonberman.getX(), this.bonberman.getY());
			getGelaZerr().get(this.bonberman.getY()*17+this.bonberman.getX()).setMota(15);
			bonberman.bonbaJarrita();
			bonberman.timerAktibatu();
			bonbaLista.add(bonba);
		}
	}
	
	public void apurtuBlokeak(int zut, int lerr) {
		boolean hil = false;
		bonbaLista.remove();
		if (this.bonberman.getY()*17+this.bonberman.getX() == lerr*17+zut) {
			getGelaZerr().get(lerr*17+zut).setMota(14);
			this.bonberman.setBizitza(false);
			hil = true;
		}
		else {
			getGelaZerr().get(lerr*17+zut).setMota(4);
			suLista.add(new Sua(zut,lerr));
		}
		
		if(zut-1>=0 && !(getGelaZerr().get(lerr*17+(zut-1)).getMota() == 1)) {
			suLista.add(new Sua(zut-1,lerr));
			if (this.bonberman.getY()*17+this.bonberman.getX() == lerr*17+(zut-1)) {
				getGelaZerr().get(lerr*17+(zut-1)).setMota(14);
				this.bonberman.setBizitza(false);
				hil = true;
			}
			else if (!(getGelaZerr().get(lerr*17+(zut-1)).getMota() == 3))
				getGelaZerr().get(lerr*17+(zut-1)).setMota(4);
			bZerr.eztandaEginPosizioan(zut-1, lerr);
		}
		if(zut+1<=16 && !(getGelaZerr().get(lerr*17+(zut+1)).getMota() == 1)) {
			suLista.add(new Sua(zut+1,lerr));
			if (this.bonberman.getY()*17+this.bonberman.getX() == lerr*17+(zut+1)) {
				getGelaZerr().get(lerr*17+(zut+1)).setMota(14);
				this.bonberman.setBizitza(false);
				hil = true;
			}
			else if (!(getGelaZerr().get(lerr*17+(zut+1)).getMota() == 3))
				getGelaZerr().get(lerr*17+(zut+1)).setMota(4);
			bZerr.eztandaEginPosizioan(zut+1, lerr);
		}	
		if(lerr-1>=0 && !(getGelaZerr().get((lerr-1)*17+zut).getMota() == 1)) { 
			suLista.add(new Sua(zut,lerr-1));
			if (this.bonberman.getY()*17+this.bonberman.getX() == (lerr-1)*17+zut){
				getGelaZerr().get((lerr-1)*17+zut).setMota(14);
				this.bonberman.setBizitza(false);
				hil = true;
			}
			else if (!(getGelaZerr().get((lerr-1)*17+zut).getMota() == 3))
				getGelaZerr().get((lerr-1)*17+zut).setMota(4);
			bZerr.eztandaEginPosizioan(zut, lerr-1);
		}
		if(lerr+1<=10 && !(getGelaZerr().get((lerr+1)*17+zut).getMota() == 1)) {
			suLista.add(new Sua(zut,lerr+1));
			if (this.bonberman.getY()*17+this.bonberman.getX() == (lerr+1)*17+zut) {
				getGelaZerr().get((lerr+1)*17+zut).setMota(14);
				this.bonberman.setBizitza(false);
				hil = true;
			}
			else if (!(getGelaZerr().get((lerr+1)*17+zut).getMota() == 3))
				getGelaZerr().get((lerr+1)*17+zut).setMota(4);
			bZerr.eztandaEginPosizioan(zut, lerr+1);
		}
		
		if (!(bZerr.blokeBigunaDu())) {
			System.out.print("\nZorionak Bonberman jokoan irabazi duzu.");
			partidaBukatu();
		}
		
		if (hil) {
			System.out.print("\nPartida galdu duzu.");
			partidaBukatu();
	
		}
	}
	
	private void partidaBukatu() {
		denboraItxaron(100);
		System.exit(0);
	}
	
	private static void denboraItxaron(int pMillis) { 
		try { Thread.sleep(pMillis); 
		} 
		catch (Exception e) {} 
		}
}