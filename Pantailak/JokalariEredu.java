package Pantailak;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public abstract class JokalariEredu {
	protected int X;
	protected int Y;
	protected int aurreX;
	protected int aurreY;
	protected boolean bizitza;
	private int bonbaKop = 10;
	private boolean timerAktibatu = false; 
	private boolean bonbaPrest = false;
	private int kont;
	private int PERIODO = 3;
	private Timer timer = null;
	private BombaStrategy bombaMota;
	private Queue<BombaStrategy> bonLista = new LinkedList<>();
	
	protected JokalariEredu(int pX, int pY, BombaStrategy pBombaStrategy) {
		this.X = pX;
		this.Y = pY;
		this.aurreX = pX;
		this.aurreY = pY;
		this.bombaMota = pBombaStrategy;
		this.bizitza = true;
	}
	
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

	public void setAurrekoX(int i) {
		// TODO Auto-generated method stub
		this.aurreX = i;		
	}

	public void setAurrekoY(int i) {
		// TODO Auto-generated method stub
		this.aurreY = i;
	}

	public void setBizitza(boolean b) {
		bizitza = b;
	}
	
	public void setBonbaKop(int kop) {
		bonbaKop = kop;
	}
	
	public boolean getBizitza() {
		return this.bizitza;
	}

	public boolean bonbaNahiko() {
		return bonbaKop!=0;
	}

	public void bonbaGutxitu() {
		this.bonbaKop--;
		if (bonbaKop==0)
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
		BombaStrategy bomba;
		if(bombaMota != null && bonbaNahiko()) {
			if (bombaMota instanceof BombaNormala) {
				bomba = new BombaNormala();
			}
			else {
				bomba = new BombaUltra();
				
			}
			bomba.setX(X);
			bomba.setY(Y);
			bomba.timerHasi();
			bonLista.add(bomba);
			bonbaGutxitu();
			jarrita = true;
		}
		else if (bombaMota != null && bonbaPrest) {
			if (bombaMota instanceof BombaNormala) {
				bomba = new BombaNormala();
			}
			else {
				bomba = new BombaUltra();
				
			}
			bomba.setX(X);
			bomba.setY(Y);
			bomba.timerHasi();
			bonLista.add(bomba);
			bonbaJarrita();
			timerAktibatu();
			jarrita = true;
		}
		return jarrita;
		
	}
	
	public void aldatuBombaMota(BombaStrategy b) {
		bombaMota = b;
	}

	public boolean bombarikDago(int i, int j) {
		for (BombaStrategy bon : bonLista) {
			if (bon.getX() == (getX()+i) && bon.getY() == (getY()+j)) {
				return true;
			}
		}
		return false;
	}

	public boolean bombarikEtsai(int x, int y) {
		for (BombaStrategy bon : bonLista) {
			if (bon.getX() == x && bon.getY() == y) {
				return true;
			}
		}
		return false;
	}

	public void bonbaKendu() {
		bonLista.remove();
		
	}
}