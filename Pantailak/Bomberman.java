package Pantailak;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Bomberman {
	
	////////////ATRIBUTUAK////////////
	protected int X;
	protected int Y;
	protected int aurreX;
	protected int aurreY;
	protected boolean bizirik;
	private int bizitzak = 3;
	private int bonbaKop = 10;
	private boolean timerAktibatu = false; 
	private boolean bonbaPrest = false;
	private int iristera;
	private int kont;
	private int PERIODO = 3;
	private Timer timer = null;
	private Bonba bonbaMota;
	private Queue<Bonba> bonLista = new LinkedList<>();
	
	////////////ERAIKITZAILEA////////////
	protected Bomberman(int pX, int pY, int pIritsi, Bonba pBonba) {
		this.X = pX;
		this.Y = pY;
		this.aurreX = pX;
		this.aurreY = pY;
		this.iristera = pIritsi;
		this.bonbaMota = pBonba;
		this.bizirik = true;
	}
	
	////////////GETTER eta SETTER////////////
	public int getX() {
		return this.X;
	}
	
	public int getY() {
		return this.Y;
	}

	public void setX(int i) {
		this.X = i;		
	}

	public void setY(int i) {
		this.Y = i;
	}
	
	public int getAurrekoX() {
		return this.aurreX;
	}
	
	public int getAurrekoY() {
		return this.aurreY;
	}

	public void setAurrekoX(int pAurX) {
		this.aurreX = pAurX;
	}

	public void setAurrekoY(int pAurY) {
		this.aurreY = pAurY;
	}

	public void setBizirik(boolean b) {
		bizirik = b;
	}
	
	public void setBonbaKop(int kop) {
		bonbaKop = kop;
	}
	
	public boolean getBizitza() {
		return this.bizirik;
	}
	
	public int getIritsi() {
		return this.iristera;
	}
	
	public void setIritsi(int pIritsi) {
		this.iristera = pIritsi;
	}

	public boolean bonbaNahiko() {
		return bonbaKop != 0;
	}

	public void bonbaGutxitu() {
		this.bonbaKop--;
		if (bonbaKop == 0)
			timerAktibatu();
	}

	public void timerAktibatu() {
		if (!timerAktibatu) {
			kont = PERIODO;
			TimerTask timerTask = new TimerTask() {
				@Override
				public void run() {
					updateKont();
				}		
			};
			timer = new Timer();
			timer.scheduleAtFixedRate(timerTask, 0, 1000);
		}
	}
	
	public boolean denboraPasa() {
		return bonbaPrest;
	}
	
	private void updateKont() {
		kont--;
		if (kont == 0) {
			kont = PERIODO;
			bonbaPrest = true;
			System.out.print("\nBonba prest dago");
			timer.cancel();
		}	
	}

	public void bonbaJarrita() {
		bonbaPrest = false;
		timerAktibatu = false;
	}	
	
	public boolean bombaJarri() {
		boolean jarrita = false;
		Bonba bomba;
		if(bonbaMota != null && bonbaNahiko()) {
			if (bonbaMota instanceof BonbaNormala) {
				bomba = new BonbaNormala();
			}
			else {
				bomba = new BonbaUltra();
			}
			bomba.setX(X);
			bomba.setY(Y);
			bomba.setRadioa(iristera);
			bomba.timerHasi();
			bonLista.add(bomba);
			bonbaGutxitu();
			jarrita = true;
		}
		else if (bonbaMota != null && bonbaPrest) {
			if (bonbaMota instanceof BonbaNormala) {
				bomba = new BonbaNormala();
			}
			else {
				bomba = new BonbaUltra();
			}
			bomba.setX(X);
			bomba.setY(Y);
			bomba.timerHasi();
			bomba.setRadioa(iristera);
			bonLista.add(bomba);
			bonbaJarrita();
			timerAktibatu();
			jarrita = true;
		}
		return jarrita;
		
	}
	
	public void aldatuBombaMota(Bonba b) {
		bonbaMota = b;
	}

	public boolean bombarikDago(int i, int j) {
		for (Bonba bon : getBombaGuztiak()) {
			if (bon.getX() == (getX()+i) && bon.getY() == (getY()+j)) {
				return true;
			}
		}
		return false;
	}

	public boolean bombarikEtsai(int x, int y) {
		for (Bonba bon : getBombaGuztiak()) {
			if (bon != null) {
				if (bon.getX() == x && bon.getY() == y) {
					return true;
				}
			}
		}
		return false;
	}

	public void bonbaKendu() {
		bonLista.remove();	
	}
	
	private LinkedList<Bonba> getBombaGuztiak(){
		return new LinkedList<Bonba>(bonLista);
	}
	
	protected void biziTimer() {}
	
	protected void updateDenb() {}
	
	protected void timerAmatatu() {}

	public boolean bizitzakDitu() {
		return bizitzak>=0;
	}

	public void kenduBizitzak() {
		bizitzak--;
		
	}

	public int getBizitzak() {
		return this.bizitzak;
	}
	
}