package Pantailak;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class LaberintoEredua extends Observable{
	
	////////////ATRIBUTUAK////////////
	private static LaberintoEredua nLE = null;
	private Bomberman bomberman;
	private ArrayList<Sua> suLista = new ArrayList<>();
	private Laberinto labMota;
	private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
	private boolean birsortzen = false;
	
	////////////ERAIKITZAILEA////////////
	private LaberintoEredua() {
		//labMota.matrizeaSortu();
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
		notifyObservers(new int[] {-1, bomberman.getBizitzak(), bomberman.getBonbaKop()});
		labMota.getGelaZerr().erakutsiGelaxkaGuztiak().stream().forEach(GelaxkaEredu::eguneratu);
	}
	
	////////////GETTER eta SETTER////////////
	public Bomberman getBomberman() {
		return this.bomberman;
	}
	
	public void setBomberman(Bomberman pBomberman) {
		bomberman = pBomberman;
		if(bomberman instanceof BombermanTxuria) {
			labMota.getGelaZerr().aurkituGelaxka(0).setMota(5);
		}
		else {
			labMota.getGelaZerr().aurkituGelaxka(0).setMota(30);
		}
		bomberman.biziTimer();
	}

	public ArrayList<Sua> getSuLista() {
		return suLista;
	}
	
    public Laberinto getLabMota() {
        return labMota;
    }
	
    public void setLaberintoMota(Laberinto pLabMota) {
        labMota = pLabMota;
    }
    
    public ScheduledExecutorService getExecutor() {
    	return LaberintoEredua.executor;
    }
    
	////////////AUSAZKO ZENBAKIA////////////
	public double ausazZenbakia() {
		Random ram = new Random();
		double aukera = ram.nextDouble();	//Ausaz zenbaki bat aukeratzen du, bloke biguna edo etsai bat sortzeko
		//System.out.print("\n"+aukera);
		return aukera;
	}

	
	////////////BOMBERMAN////////////
	
	
	////////////MUGITU////////////
	public void mugitu(int i, int j) {
		boolean mugitu = false;
		boolean erre = false;
		boolean bonba = false;
		if(!birsortzen) {
			if (!((this.bomberman.getX()+i<0) || (this.bomberman.getY()+j<0) || (this.bomberman.getX()+i>16) || (this.bomberman.getY()+j>10))){	//Bonberman-a tarteetan dagoela konprobatzen du
				if((!((labMota.getbZerr().getBloke((this.bomberman.getX()+i),(this.bomberman.getY()+j)) instanceof Biguna) || (labMota.getbZerr().getBloke((this.bomberman.getX()+i),(this.bomberman.getY()+j)) instanceof Gogorra))) || (labMota.getbZerr().getBloke((this.bomberman.getX()+i),(this.bomberman.getY()+j)) == null)) {
					if(!((bonbarikDago(i, j)) || !(this.bomberman.getBizitza()))){	//Bonberman-a blokeekin ez dela joko konprobatzen du
						this.bomberman.setAurrekoX(this.bomberman.getX());	//Lehengo, aurreko posizioak eguneratzen ditu eta gero helduko den posizioa
						this.bomberman.setAurrekoY(this.bomberman.getY());
						bomberman.timerAmatatu();
						if (labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY()+j)*17+this.bomberman.getX()+i).getMota() == 4) {
							suLista.removeIf(su -> su != null && this.bomberman.getX()+i == su.getX() && this.bomberman.getY()+j == su.getY());
							if (bomberman instanceof BombermanTxuria)
								labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY()+j)*17+this.bomberman.getX()+i).setMota(14);
							else
								labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY()+j)*17+this.bomberman.getX()+i).setMota(40);
							erre = true;
						}
						
						if (labMota.getEtsaiLista().aurkituEtsai(bomberman.getX()+i, bomberman.getY()+j) != null) {
							if(labMota.getEtsaiLista().aurkituEtsai(bomberman.getX()+i, bomberman.getY()+j).getBizitza()) {
								if (bomberman instanceof BombermanTxuria)
									labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY()+j)*17+this.bomberman.getX()+i).setMota(14);
								else
									labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY()+j)*17+this.bomberman.getX()+i).setMota(40);
								erre = true;
							}
						}
						
						if (labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getAurrekoY())*17+this.bomberman.getAurrekoX()).getMota() == 15 || labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getAurrekoY())*17+this.bomberman.getAurrekoX()).getMota() == 39) {
							if (bomberman instanceof BombermanTxuria)
								labMota.getGelaZerr().aurkituGelaxka(this.bomberman.getY()*17+this.bomberman.getX()).setMota(3);
							else
								labMota.getGelaZerr().aurkituGelaxka(this.bomberman.getY()*17+this.bomberman.getX()).setMota(45);
							bonba = true;
						}
						this.bomberman.setX(this.bomberman.getX()+i);
						this.bomberman.setY(this.bomberman.getY()+j);
						mugitu = true;
						
						bomberman.biziTimer();	//Bomberman gorria mugitu ostean Timer-a aktibatzen da berriz
					}	
				}
			}
		}
		
		spriteAldatu(erre, i , j);	//Mugimenduaren arabera, sprite bat aukeratuko da
		
		if (mugitu && !bonba) //Gelaxka hutsik dagoela adierazteko balio du, alegia, Bonberman-a mugitu da, baldin eta bonbarik jarri ez badu.
			labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getAurrekoY())*17+this.bomberman.getAurrekoX()).setMota(0);
		
		if(erre) {	//Erre bada Bomberman-a, orduan partida amaituko da
			bomberman.kenduBizitzak();
			bomberman.setBizirik(false);
			if (!bomberman.bizitzakDitu()) {
				this.bomberman.setBizirik(false);
			    System.out.print("\nPartida galdu duzu.");
				javax.swing.Timer timer = new javax.swing.Timer(5, e -> partidaBukatu());
			    timer.setRepeats(false);
			    timer.start();
			}
			else {
				labMota.getGelaZerr().aurkituGelaxka(0).setMota(0);
				birsortzen = true;
				javax.swing.Timer timer = new javax.swing.Timer(2000, e-> birsortuDa());
			    timer.setRepeats(false);
			    timer.start();
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	private void birsortuDa() {
		bomberman.setX(0);
		bomberman.setY(0);
		labMota.getGelaZerr().aurkituGelaxka(0).setMota(5);
		birsortzen = false;
		bomberman.setBizirik(true);
		setChanged();
		notifyObservers(new int[] {bomberman.getBizitzak(), bomberman.getBonbaKop()});
	}
	
	////////////NORABIDEA ZEHAZTU////////////
	private void spriteAldatu(boolean erre, int pI, int pJ) {
		if(!erre && !((labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).getMota() == 15) || (labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).getMota() == 39)) && (this.bomberman.getBizitza())) {
			switch (pI){	//Mugimenduaren arabera "sprite" bat edo beste bat erakutsiko du
			case -1:
				if (bomberman instanceof BombermanTxuria) {
					if(labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getAurrekoY())*17+this.bomberman.getAurrekoX()).getMota() == 6 || labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).getMota() == 6){
						labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).setMota(7);
					}
					else {
						labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).setMota(6);
					}
				}
				else {
					if(labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getAurrekoY())*17+this.bomberman.getAurrekoX()).getMota() == 31 || labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).getMota() == 31){
						labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).setMota(32);
					}
					else {
						labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).setMota(31);
					}
				}
				break;
			case 1:
				if (bomberman instanceof BombermanTxuria) {
					if(labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getAurrekoY())*17+this.bomberman.getAurrekoX()).getMota() == 8 || labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).getMota() == 8){
						labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).setMota(9);
					}
					else {
						labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).setMota(8);
					}
				}
				else {
					if(labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getAurrekoY())*17+this.bomberman.getAurrekoX()).getMota() == 33 || labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).getMota() == 33){
						labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).setMota(34);
					}
					else {
						labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).setMota(33);
					}
				}
				break;
			}
			
			switch (pJ){
			case -1:
				if (bomberman instanceof BombermanTxuria) {
					if(labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getAurrekoY())*17+this.bomberman.getAurrekoX()).getMota() == 12 || labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).getMota() == 12){
						labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).setMota(13);
					}
					else {
						labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).setMota(12);
					}
				}
				else {
					if(labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getAurrekoY())*17+this.bomberman.getAurrekoX()).getMota() == 37 || labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).getMota() == 37){
						labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).setMota(38);
					}
					else {
						labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).setMota(37);
					}
				}
				break;
			case 1:
				if (bomberman instanceof BombermanTxuria) {
					if(labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getAurrekoY())*17+this.bomberman.getAurrekoX()).getMota() == 10 || labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).getMota() == 10){
						labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).setMota(11);
					}
					else {
						labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).setMota(10);
					}
				}
				else {
					if(labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getAurrekoY())*17+this.bomberman.getAurrekoX()).getMota() == 35 || labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).getMota() == 36){
						labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).setMota(36);
					}
					else {
						labMota.getGelaZerr().aurkituGelaxka((this.bomberman.getY())*17+this.bomberman.getX()).setMota(35);
					}
				}
				break;
			}
		}
	}
	
	////////////BONBA BIDEAN////////////
	private boolean bonbarikDago(int i, int j) {
		return bomberman.bombarikDago(i,j);	//Bidean bonbarik dagoen konprobatzen du
	}

	////////////BONBA JARRI////////////
	@SuppressWarnings("deprecation")
	public void bonbaJarri() {
		if (this.bomberman.bombaJarri()) {
			if (bomberman instanceof BombermanTxuria)	//Bomberman-aren arabera bonbaren sprite bat edo beste bat jarriko ad
				labMota.getGelaZerr().aurkituGelaxka(this.bomberman.getY()*17+this.bomberman.getX()).setMota(15);
			else
				labMota.getGelaZerr().aurkituGelaxka(this.bomberman.getY()*17+this.bomberman.getX()).setMota(39);
		}
		setChanged();
		notifyObservers(new int[] {bomberman.getBizitzak(), bomberman.getBonbaKop()});
	}

	////////////PARTIDA BUKATU////////////
	public void partidaBukatu() {
		denboraItxaron(100);
		System.exit(0);
	}
	
	////////////SLEEP////////////
	private static void denboraItxaron(int pMillis) { 
		try { Thread.sleep(pMillis); 	//Partida bukatu baino lehen programak sleep egingo du, erakusteko partida bukatzearen zergatia
		} 
		catch (Exception e) {} 
		}

	////////////ETSAIAK////////////
	
	////////////MUGITU////////////
	public void etsaiMugitu(Etsai etsai, int x, int y) {
		Random rand = new Random();
		boolean mugitu = false;
		while (!mugitu) {
			int ausaz = rand.nextInt(4);
			switch (ausaz) {
			case 0:
				if (!(y-1<0)){	//Bonberman-a tarteetan dagoela konprobatzen du		
					if((!(((labMota.getbZerr().getBloke(x,y-1)) instanceof Gogorra) || ((labMota.getbZerr().getBloke(x,y-1)) instanceof Biguna))) || (labMota.getbZerr().getBloke(x,y-1)) == null) {
						if(!((etsaiBonba(x, y-1)) || !(etsai.getBizitza()) || etsaiaSuaDu(x,y-1) || etsaiaDago(x,y-1, etsai))){
							labMota.getGelaZerr().aurkituGelaxka(y*17+x).setMota(0);
							labMota.getGelaZerr().aurkituGelaxka((y-1)*17+x).setMota(20);
							etsai.setY(y-1);
							mugitu = true;
						}
					}
				}
				break;
			case 1:
				if (!(x-1<0)){	//Bonberman-a tarteetan dagoela konprobatzen du			
					if((!(((labMota.getbZerr().getBloke(x-1,y)) instanceof Gogorra) || ((labMota.getbZerr().getBloke(x-1,y)) instanceof Biguna))) || (labMota.getbZerr().getBloke(x-1,y)) == null) {
						if(!((etsaiBonba(x-1, y)) || !(etsai.getBizitza()) || etsaiaSuaDu(x-1,y) || etsaiaDago(x-1,y, etsai))){
							labMota.getGelaZerr().aurkituGelaxka(y*17+x).setMota(0);
							labMota.getGelaZerr().aurkituGelaxka(y*17+x-1).setMota(20);
							etsai.setX(x-1);
							mugitu = true;
						}
					}
				}
				break;
			case 2:
				if (x+1<=16){	//Bonberman-a tarteetan dagoela konprobatzen du	
					if((!(((labMota.getbZerr().getBloke(x+1,y)) instanceof Gogorra) || ((labMota.getbZerr().getBloke(x+1,y)) instanceof Biguna))) || (labMota.getbZerr().getBloke(x+1,y)) == null) {
						if(!((etsaiBonba(x+1, y)) || !(etsai.getBizitza()) || etsaiaSuaDu(x+1,y) || etsaiaDago(x+1,y, etsai))){
							labMota.getGelaZerr().aurkituGelaxka(y*17+x).setMota(0);
							labMota.getGelaZerr().aurkituGelaxka(y*17+x+1).setMota(20);
							etsai.setX(x+1);
							mugitu = true;
						}
					}
				}
				break;
			case 3:
				if (y+1<=10){
					if((!(((labMota.getbZerr().getBloke(x,y+1)) instanceof Gogorra) || ((labMota.getbZerr().getBloke(x,y+1)) instanceof Biguna))) || (labMota.getbZerr().getBloke(x,y+1)) == null) {
						if(!((etsaiBonba(x, y+1)) || !(etsai.getBizitza()) || etsaiaSuaDu(x,y+1) || etsaiaDago(x,y+1, etsai))){
							labMota.getGelaZerr().aurkituGelaxka((y)*17+x).setMota(0);
							labMota.getGelaZerr().aurkituGelaxka((y+1)*17+x).setMota(20);
							etsai.setY(y+1);
							mugitu = true;
						}
					}
				}
				break;
			}
			if (this.bomberman.getX() == etsai.getX() && this.bomberman.getY() == etsai.getY() && etsai.getBizitza()) {
				partidaBukatu();
			}
		}
	}

	
	////////////ETSAIA BIDEAN////////////
	private boolean etsaiaDago(int x, int y, Etsai etsai) {
		
		Etsai erdian = labMota.getEtsaiLista().aurkituEtsai(x, y);
	    Etsai ezker = labMota.getEtsaiLista().aurkituEtsai(x-1, y);
	    Etsai eskuin = labMota.getEtsaiLista().aurkituEtsai(x+1, y);
	    Etsai gora = labMota.getEtsaiLista().aurkituEtsai(x, y-1);
	    Etsai behera = labMota.getEtsaiLista().aurkituEtsai(x, y+1);

	    return (erdian != null) || (ezker != null && ezker != etsai) || (eskuin != null && eskuin != etsai) || (gora != null && gora != etsai) ||(behera != null && behera != etsai);
	}

	////////////BONBA ETSAI BIDEAN////////////
	private boolean etsaiBonba(int x, int y) {
		return bomberman.bombarikEtsai(x,y);
	}

	public void amatatuSua(Sua sua) {
		getSuGuztiak().removeIf(su -> su != null && sua.getX() == su.getX() && sua.getY() == su.getY());
	}
	
	private boolean etsaiaSuaDu(int x, int y) {
		for (Sua su : getSuGuztiak()) {
			if(su.getX() == x && su.getY() == y) {
				return true;
			}
		}
		return false;
	}

	public void layoutEguneratu() {
		setChanged();
		notifyObservers(new int[] {bomberman.getBizitzak(), bomberman.getBonbaKop()});	
	}
	
	private Queue<Sua> getSuGuztiak() {
		return new LinkedList<Sua>(suLista);
	}
	
	

}