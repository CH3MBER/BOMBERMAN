package Pantailak;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;
import java.util.Random;

public class LaberintoEredua extends Observable{
	
	////////////ATRIBUTUAK////////////
	private static LaberintoEredua nLE = null;
	private ArrayList<GelaxkaEredu> gelaxkaZerrenda = null;	//Gelaxkak bilduko dituen kolekzioa
	private BlokeZerrenda blokeZerr;
	private final int zutabe = 17;
	private final int errenkada = 11;
	private JokalariEredu bonberman;
	private boolean borratu = false;
	private Queue<Bonba> bonbaLista = new LinkedList<>();
	private Queue<Sua> suLista = new LinkedList<>();
	private ArrayList<Etsai> etsaiLista = new ArrayList<>();
	private int mota = 1;
	
	
	////////////ERAIKITZAILEA////////////
	private LaberintoEredua() {
		this.blokeZerr = new BlokeZerrenda();
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
	@SuppressWarnings("deprecation")
	public void eguneratu() {
		// TODO Auto-generated method stub
		setChanged();
		notifyObservers(new int[] {1});
		for (GelaxkaEredu gelaxka : gelaxkaZerrenda)
			gelaxka.eguneratu();
	}
	
	
	////////////MATRIZEA ERAIKI////////////
	private void matrizeaSortu() { //Hurrengo aukerak: 0 Gelaxka Hutsa, 1 Bloke Gogorra, 2 Bloke Biguna 5 Bonberman-a
		int lerro, zut;
		for(lerro=0;lerro<errenkada;lerro++) {
			for(zut=0;zut<zutabe;zut++) {
				switch (mota) {
				case 1:
					if (zut%2!=0 && lerro%2!=0) {
						blokeZerr.sortuBlokea(1, zut, lerro);
						getGelaZerr().add(new GelaxkaEredu(1)); //Bloke Gogorra
					}
					else if (!((lerro==0 && zut==0)||(lerro==0 && zut==1)||(lerro==1 && zut==0))){
						if (ausazZenbakia()>0.4) {
							blokeZerr.sortuBlokea(2, zut, lerro);
							getGelaZerr().add(new GelaxkaEredu(2));	//Bloke Biguna
						}
						else if (ausazZenbakia()>0.9 && etsaiLista.size()<6) {
							getGelaZerr().add(new GelaxkaEredu(20));	//Etsaia
							etsaiLista.add(new Etsai(zut, lerro));
						}
						else {
							getGelaZerr().add(new GelaxkaEredu(0));	//Hutsik
							//blokeZerr.sortuBlokea(0, zut, lerro);
						}
					}
					else if (lerro==0 && zut==0) {
						getGelaZerr().add(new GelaxkaEredu(5));	//Bonberman
						//blokeZerr.sortuBlokea(0, zut, lerro);
					}
					else {
						getGelaZerr().add(new GelaxkaEredu(0));	//Hutsik
						//blokeZerr.sortuBlokea(0, zut, lerro);
					}
					break;
			case 2:
					if (!((lerro==0 && zut==0)||(lerro==0 && zut==1)||(lerro==1 && zut==0))){
						if (ausazZenbakia()>0.4) {
							blokeZerr.sortuBlokea(2, zut, lerro);
							getGelaZerr().add(new GelaxkaEredu(2));	//Bloke Biguna
						}
						else if (ausazZenbakia()>0.9 && etsaiLista.size()<8) {
							getGelaZerr().add(new GelaxkaEredu(20));	//Bloke Biguna
							etsaiLista.add(new Etsai(zut, lerro));
						}
						else {
							getGelaZerr().add(new GelaxkaEredu(0));	//Hutsik
							blokeZerr.sortuBlokea(0, zut, lerro);
						}
					}
					else if (lerro==0 && zut==0) {
						getGelaZerr().add(new GelaxkaEredu(5));	//Bonberman
						blokeZerr.sortuBlokea(0, zut, lerro);
					}
					else {
						getGelaZerr().add(new GelaxkaEredu(0));	//Hutsik
						blokeZerr.sortuBlokea(0, zut, lerro);
					}
					break;
			case 3:
					if (!((lerro==0 && zut==0)||(lerro==0 && zut==1)||(lerro==1 && zut==0))){
						if (ausazZenbakia()>0.95 && etsaiLista.size()<10) {
							getGelaZerr().add(new GelaxkaEredu(20));
							etsaiLista.add(new Etsai(zut, lerro));
						}
						else {
							getGelaZerr().add(new GelaxkaEredu(0));	//Hutsik
							blokeZerr.sortuBlokea(0, zut, lerro);
						}
					}
					else if (lerro==0 && zut==0) {
						getGelaZerr().add(new GelaxkaEredu(5));	//Bonberman
						blokeZerr.sortuBlokea(0, zut, lerro);
					}
					else {
						getGelaZerr().add(new GelaxkaEredu(0));	//Hutsik
						blokeZerr.sortuBlokea(0, zut, lerro);
					}
					break;
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
		return blokeZerr;
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
			if((!((blokeZerr.getBloke((this.bonberman.getX()+i),(this.bonberman.getY()+j)) instanceof Biguna) || (blokeZerr.getBloke((this.bonberman.getX()+i),(this.bonberman.getY()+j)) instanceof Gogorra))) || (blokeZerr.getBloke((this.bonberman.getX()+i),(this.bonberman.getY()+j)) == null)) {
				if(!((bonbarikDago(i, j)) || !(this.bonberman.getBizitza()))){	//Bonberman-a blokeekin ez dela joko konprobatzen du
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
						this.bonberman.setBizitza(false);
					}
					
					for (Etsai es : etsaiLista) {
						if(es.getX()==this.bonberman.getX()+i && es.getY()==this.bonberman.getY()+j) {
							getGelaZerr().get((this.bonberman.getY()+j)*17+this.bonberman.getX()+i).setMota(14);
							erre = true;
							this.bonberman.setBizitza(false);
						}
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
		}
		
		if(!erre && !(getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).getMota() == 15) && (this.bonberman.getBizitza())) {
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

	private boolean bonbarikDago(int i, int j) {
		for (Bonba bon : bonbaLista) {
			if (bon.getX() == (this.bonberman.getX()+i) && bon.getY() == (this.bonberman.getY()+j)) {
				return true;
			}
		}
		return false;
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
			blokeZerr.eztandaEginPosizioan(zut-1, lerr);
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
			blokeZerr.eztandaEginPosizioan(zut+1, lerr);
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
			blokeZerr.eztandaEginPosizioan(zut, lerr-1);
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
			blokeZerr.eztandaEginPosizioan(zut, lerr+1);
		}
		
		if (etsaiLista.isEmpty()) {
			System.out.print("\nZorionak Bonberman jokoan irabazi duzu.");
			partidaBukatu();
		}
		
		if (hil) {
			System.out.print("\nPartida galdu duzu.");
			this.bonberman.setBizitza(false);
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

	public void etsaiMugitu(Etsai etsai, int x, int y) { //Poner boolean en etsaiak
		// TODO Auto-generated method stub
		Random rand = new Random();
		boolean mugitu = false;
		while (!mugitu) {
			int ausaz = rand.nextInt(4);
			switch (ausaz) {
			case 0:
				if (!(y-1<0)){	//Bonberman-a tarteetan dagoela konprobatzen du		
					if(!(((blokeZerr.getBloke(x,y-1)) instanceof Gogorra) || ((blokeZerr.getBloke(x,y-1)) instanceof Biguna)) || (blokeZerr.getBloke(x,y-1)) == null) {
						if(!((etsaiBonba(x, y-1)) || !(this.bonberman.getBizitza()))){
							gelaxkaZerrenda.get(y*17+x).setMota(0);
							gelaxkaZerrenda.get((y-1)*17+x).setMota(20);
							etsai.setY(y-1);
							mugitu = true;
						}
					}
				}
				break;
			case 1:
				if (!(x-1<0)){	//Bonberman-a tarteetan dagoela konprobatzen du			
					if(!(((blokeZerr.getBloke(x-1,y)) instanceof Gogorra) || ((blokeZerr.getBloke(x-1,y)) instanceof Biguna)) || (blokeZerr.getBloke(x-1,y)) == null) {
						if(!((etsaiBonba(x-1, y)) || !(this.bonberman.getBizitza()))){
							gelaxkaZerrenda.get(y*17+x).setMota(0);
							gelaxkaZerrenda.get(y*17+x-1).setMota(20);
							etsai.setX(x-1);
							mugitu = true;
						}
					}
				}
				break;
			case 2:
				if (x+1<=16){	//Bonberman-a tarteetan dagoela konprobatzen du	
					if(!(((blokeZerr.getBloke(x+1,y)) instanceof Gogorra) || ((blokeZerr.getBloke(x+1,y)) instanceof Biguna)) || (blokeZerr.getBloke(x+1,y)) == null) {
						if(!((etsaiBonba(x+1, y)) || !(this.bonberman.getBizitza()))){
							gelaxkaZerrenda.get(y*17+x).setMota(0);
							gelaxkaZerrenda.get(y*17+x+1).setMota(20);
							etsai.setX(x+1);
							mugitu = true;
						}
					}
				}
				break;
			case 3:
				if (y+1<=10){
					if(!(((blokeZerr.getBloke(x,y+1)) instanceof Gogorra) || ((blokeZerr.getBloke(x,y+1)) instanceof Biguna)) || (blokeZerr.getBloke(y+1)) == null) {
						if(!((etsaiBonba(x, y+1)) || !(this.bonberman.getBizitza()))){
							gelaxkaZerrenda.get((y)*17+x).setMota(0);
							gelaxkaZerrenda.get((y+1)*17+x).setMota(20);
							etsai.setY(y+1);
							mugitu = true;
						}
					}
				}
				break;
			}
			if (this.bonberman.getX() == etsai.getX() && this.bonberman.getY() == etsai.getY()) {
				partidaBukatu();
			}
		}
	}

	private boolean etsaiBonba(int x, int y) {
		for (Bonba bon : bonbaLista) {
			if (bon.getX() == x && bon.getY() == y) {
				return true;
			}
		}
		return false;
	}
	
	public void apurtuBlokeak2(int zut, int lerr) {
		bonbaLista.remove();
		if (!((blokeZerr.getBloke(zut+1, lerr)) instanceof Gogorra)) {
			for (int i=zut; i<zutabe; i++) {
				suLista.add(new Sua(i,lerr));
				gelaxkaZerrenda.get(lerr*17+i).setMota(4);
				blokeZerr.eztandaEginPosizioan(i, lerr);
			}
		}
		if (!((blokeZerr.getBloke(zut-1, lerr)) instanceof Gogorra)) {
			for (int i=0; i<=zut; i++) {
				suLista.add(new Sua(i,lerr));
				gelaxkaZerrenda.get(lerr*17+i).setMota(4);
				blokeZerr.eztandaEginPosizioan(i, lerr);
			}
		}

		if (!((blokeZerr.getBloke(zut, lerr-1)) instanceof Gogorra)) {
			for (int i=0; i<=lerr; i++) {
				suLista.add(new Sua(zut,i));
				gelaxkaZerrenda.get(i*17+zut).setMota(4);
				blokeZerr.eztandaEginPosizioan(zut, i);
			}
		}
		
		if (!((blokeZerr.getBloke(zut, lerr+1)) instanceof Gogorra)) {
			for (int i=lerr; i<errenkada; i++) {
				suLista.add(new Sua(zut,i));
				gelaxkaZerrenda.get(i*17+zut).setMota(4);
				blokeZerr.eztandaEginPosizioan(zut, i);
			}
		}
		
	}
	
}