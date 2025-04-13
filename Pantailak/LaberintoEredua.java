package Pantailak;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;
import java.util.Random;

public class LaberintoEredua extends Observable{
	
	////////////ATRIBUTUAK////////////
	private static LaberintoEredua nLE = null;
	private JokalariEredu bonberman;
	private Queue<BombaStrategy> bonbaLista = new LinkedList<>();
	private Queue<Sua> suLista = new LinkedList<>();
	private Laberinto labMota;
	
	
	////////////ERAIKITZAILEA////////////
	private LaberintoEredua() {
		//labMota.matrizeaSortu();
		this.bonberman = new BombermanTxuria(0,0);
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
		for (GelaxkaEredu gelaxka : labMota.getGelaZerr())
			gelaxka.eguneratu();
	}
	
	////////////GETTER eta SETTER////////////
	/*public ArrayList<GelaxkaEredu> getGelaZerr() {
		if(gelaxkaZerrenda == null) {
			gelaxkaZerrenda = new ArrayList<>();
		}
		return gelaxkaZerrenda;
	}
	
	public BlokeZerrenda getbZerr() {
		return blokeZerr;
	}
*/
	public JokalariEredu getBomberman() {
		return this.bonberman;
	}
/*
	public int getZutabe() {
		return zutabe;
	}

	public int getErrenkada() {
		return errenkada;
	}
	
	public ArrayList<Etsai> getEtsaiLista() {
		return etsaiLista;
	}*/
	
	public Queue<Sua> getSuLista() {
		return suLista;
	}
	
    public Laberinto getLabMota() {
        return labMota;
    }
	
    public void setLaberintoMota(Laberinto pLabMota) {
        labMota = pLabMota;
    }
	
	////////////AUSAZKO ZENBAKIA////////////
	public double ausazZenbakia() {
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
			if((!((labMota.getbZerr().getBloke((this.bonberman.getX()+i),(this.bonberman.getY()+j)) instanceof Biguna) || (labMota.getbZerr().getBloke((this.bonberman.getX()+i),(this.bonberman.getY()+j)) instanceof Gogorra))) || (labMota.getbZerr().getBloke((this.bonberman.getX()+i),(this.bonberman.getY()+j)) == null)) {
				if(!((bonbarikDago(i, j)) || !(this.bonberman.getBizitza()))){	//Bonberman-a blokeekin ez dela joko konprobatzen du
					this.bonberman.setAurrekoX(this.bonberman.getX());	//Lehengo, aurreko posizioak eguneratzen ditu eta gero helduko den posizioa
					this.bonberman.setAurrekoY(this.bonberman.getY());
					System.out.print("zeozer");
					if (labMota.getGelaZerr().get((this.bonberman.getY()+j)*17+this.bonberman.getX()+i).getMota() == 4) {
						for(Sua su : suLista) {
							if (su.getX() == (this.bonberman.getX()+i) && su.getY() == (this.bonberman.getY()+j)) {
								su.ezkonduSua();
							}
						}
						labMota.getGelaZerr().get((this.bonberman.getY()+j)*17+this.bonberman.getX()+i).setMota(14);
						erre = true;
						this.bonberman.setBizitza(false);
					}
					
					if (labMota.getEtsaiLista().aurkituEtsai(bonberman.getX()+i, bonberman.getY()+j) != null) {
						if(labMota.getEtsaiLista().aurkituEtsai(bonberman.getX()+i, bonberman.getY()+j).getBizitza()) {
							labMota.getGelaZerr().get((this.bonberman.getY()+j)*17+this.bonberman.getX()+i).setMota(14);
							erre = true;
							this.bonberman.setBizitza(false);
						}
					}
					
					if (labMota.getGelaZerr().get((this.bonberman.getAurrekoY())*17+this.bonberman.getAurrekoX()).getMota() == 15) {
						labMota.getGelaZerr().get((this.bonberman.getAurrekoY())*17+this.bonberman.getAurrekoX()).setMota(3);
						bonba = true;
					}
					this.bonberman.setX(this.bonberman.getX()+i);
					this.bonberman.setY(this.bonberman.getY()+j);
					mugitu = true;
				}	
			}
		}
		
		if(!erre && !(labMota.getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).getMota() == 15) && (this.bonberman.getBizitza())) {
			switch (i){	//Mugimenduaren arabera "sprite" bat edo beste bat erakutsiko du
			case -1:
				if(labMota.getGelaZerr().get((this.bonberman.getAurrekoY())*17+this.bonberman.getAurrekoX()).getMota() == 6 || labMota.getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).getMota() == 6){
					labMota.getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setMota(7);
				}
				else {
					labMota.getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setMota(6);
				}
				break;
			case 1:
				if(labMota.getGelaZerr().get((this.bonberman.getAurrekoY())*17+this.bonberman.getAurrekoX()).getMota() == 8 || labMota.getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).getMota() == 8){
					labMota.getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setMota(9);
				}
				else {
					labMota.getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setMota(8);
				}
				break;
			}
			
			switch (j){
			case -1:
				if(labMota.getGelaZerr().get((this.bonberman.getAurrekoY())*17+this.bonberman.getAurrekoX()).getMota() == 12 || labMota.getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).getMota() == 12){
					labMota.getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setMota(13);
				}
				else {
					labMota.getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setMota(12);
				}
				break;
			case 1:
				if(labMota.getGelaZerr().get((this.bonberman.getAurrekoY())*17+this.bonberman.getAurrekoX()).getMota() == 10 || labMota.getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).getMota() == 10){
					labMota.getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setMota(11);
				}
				else {
					labMota.getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setMota(10);
				}
				break;
			}
		}
		if (mugitu && !bonba) //Gelaxka hutsik dagoela adierazteko balio du, alegia, Bonberman-a mugitu da, baldin eta bonbarik jarri ez badu.
			labMota.getGelaZerr().get((this.bonberman.getAurrekoY())*17+this.bonberman.getAurrekoX()).setMota(0);
		
		if(erre) {
		    System.out.print("\nPartida galdu duzu.");
			javax.swing.Timer timer = new javax.swing.Timer(5, e -> partidaBukatu());
		    timer.setRepeats(false);
		    timer.start();
		}
	}

	private boolean bonbarikDago(int i, int j) {
		return bonberman.bombarikDago(i,j);
	}

	public void bonbaJarri() {
		if (this.bonberman.bombaJarri())
			labMota.getGelaZerr().get(this.bonberman.getY()*17+this.bonberman.getX()).setMota(15);
	}

	public void partidaBukatu() {
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
			System.out.println("mugitu");
			int ausaz = rand.nextInt(4);
			switch (ausaz) {
			case 0:
				if (!(y-1<0)){	//Bonberman-a tarteetan dagoela konprobatzen du		
					if((!(((labMota.getbZerr().getBloke(x,y-1)) instanceof Gogorra) || ((labMota.getbZerr().getBloke(x,y-1)) instanceof Biguna))) || (labMota.getbZerr().getBloke(x,y-1)) == null) {
						if(!((etsaiBonba(x, y-1)) || !(etsai.getBizitza()) || etsaiaSuaDu(x,y-1) || etsaiaDago(x,y-1))){
							labMota.getGelaZerr().get(y*17+x).setMota(0);
							labMota.getGelaZerr().get((y-1)*17+x).setMota(20);
							etsai.setY(y-1);
							mugitu = true;
						}
					}
				}
				break;
			case 1:
				if (!(x-1<0)){	//Bonberman-a tarteetan dagoela konprobatzen du			
					if((!(((labMota.getbZerr().getBloke(x-1,y)) instanceof Gogorra) || ((labMota.getbZerr().getBloke(x-1,y)) instanceof Biguna))) || (labMota.getbZerr().getBloke(x-1,y)) == null) {
						if(!((etsaiBonba(x-1, y)) || !(etsai.getBizitza()) || etsaiaSuaDu(x-1,y) || etsaiaDago(x-1,y))){
							labMota.getGelaZerr().get(y*17+x).setMota(0);
							labMota.getGelaZerr().get(y*17+x-1).setMota(20);
							etsai.setX(x-1);
							mugitu = true;
						}
					}
				}
				break;
			case 2:
				if (x+1<=16){	//Bonberman-a tarteetan dagoela konprobatzen du	
					if((!(((labMota.getbZerr().getBloke(x+1,y)) instanceof Gogorra) || ((labMota.getbZerr().getBloke(x+1,y)) instanceof Biguna))) || (labMota.getbZerr().getBloke(x+1,y)) == null) {
						if(!((etsaiBonba(x+1, y)) || !(etsai.getBizitza()) || etsaiaSuaDu(x+1,y) || etsaiaDago(x+1,y))){
							labMota.getGelaZerr().get(y*17+x).setMota(0);
							labMota.getGelaZerr().get(y*17+x+1).setMota(20);
							etsai.setX(x+1);
							mugitu = true;
						}
					}
				}
				break;
			case 3:
				if (y+1<=10){
					if((!(((labMota.getbZerr().getBloke(x,y+1)) instanceof Gogorra) || ((labMota.getbZerr().getBloke(x,y+1)) instanceof Biguna))) || (labMota.getbZerr().getBloke(y+1)) == null) {
						if(!((etsaiBonba(x, y+1)) || !(etsai.getBizitza()) || etsaiaSuaDu(x,y+1) || etsaiaDago(x,y+1))){
							labMota.getGelaZerr().get((y)*17+x).setMota(0);
							labMota.getGelaZerr().get((y+1)*17+x).setMota(20);
							etsai.setY(y+1);
							mugitu = true;
						}
					}
				}
				break;
			}
			if (this.bonberman.getX() == etsai.getX() && this.bonberman.getY() == etsai.getY() && etsai.getBizitza()) {
				partidaBukatu();
			}
		}
	}

	private boolean etsaiaDago(int x, int y) {
		if (labMota.getEtsaiLista().aurkituEtsai(x, y) != null) {
			return true;
		}
		return false;
	}

	private boolean etsaiBonba(int x, int y) {
		return bonberman.bombarikEtsai(x,y);
	}
	
	public void amatatuSua(Sua sua) {
		for(Sua su : suLista) {
			if(sua.getX() == su.getX() && sua.getY() == su.getY()) {
				suLista.remove(su);
			}
		}
	}
	
	private boolean etsaiaSuaDu(int x, int y) {
		for (Sua su :suLista) {
			if(su.getX() == x && su.getY() == y) {
				return true;
			}
		}
		return false;
	}
	
	
	

}