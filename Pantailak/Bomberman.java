package bomberman;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Bomberman {
	
	private static final Object IzarraEfektua = null;
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
	private PowerUpEfektua efektua;
	private boolean efektuaAktibatuta = false;
	
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
	
	public void setBizitzak(int i) {
		bizitzak = i;
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

	public int getBonbaKop() {
		return this.bonbaKop;
	}
	
	public void setBonbaKop(int pBonbaKop) {
		this.bonbaKop = pBonbaKop;
	}
	
	public int getBizitzak() {
		return this.bizitzak;
	}
	
	public boolean getEfektuaAkt() {
		return efektuaAktibatuta;
	}
	
	public void setEfektuaAkt(boolean pAktibo) {
		efektuaAktibatuta = pAktibo;
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
	
	public boolean denboraPasa() {
		return bonbaPrest;
	}
	
	private void updateKont() {
		kont--;
		if (kont == 0) {
			System.out.print("\nBonba prest dago");
			bonbaKop++;
			bonbaJarrita();
			timer.cancel();
		}	
	}

	public void bonbaJarrita() {
		LaberintoEredua.getLabEredua().layoutEguneratu();
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
		return jarrita;
		
	}
	
	public void aldatuBombaMota(Bonba b) {
		bonbaMota = b;
	}

	public boolean bombarikDago(int i, int j) {
		return getBonbaGuztiak().stream().anyMatch(b -> b.getX() == (getX()+i) && b.getY() == (getY()+j));
	}

	public boolean bombarikEtsai(int x, int y) {
		return getBonbaGuztiak().stream().anyMatch(b -> b != null && b.getX() == x && b.getY() == y);
	}

	public void bonbaKendu() {
		bonLista.remove();	
	}
	
	private LinkedList<Bonba> getBonbaGuztiak(){
		return new LinkedList<Bonba>(bonLista);
	}
	
	public void aldatuEfektua(PowerUpEfektua pEfektua) {

			efektua = pEfektua;
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
	
	public void powerUpEfektua() {
		PowerUpEfektua efekt = efektua;
		int bizitzaKop = bizitzak;
		if (efektuaAktibatuta == true) {
			if(efekt.equals(IzarraEfektua)) {
				bizitzak = bizitzaKop;
			}
		}
		else {
			bizitzak --;
		}
			
	}

	
}