package Pantailak;

import java.util.Timer;
import java.util.TimerTask;

public class JokalariEredu {
	private int X;
	private int Y;
	private int aurreX;
	private int aurreY;
	private boolean bizitza;
	private int bonbaKop = 10;
	private boolean timerAktibatu = false; 
	private boolean bonbaPrest = false;
	private int kont;
	private int PERIODO = 3;
	private Timer timer = null;
	
	public JokalariEredu(int pX, int pY) {
		this.X = pX;
		this.Y = pY;
		this.aurreX = pX;
		this.aurreY = pY;
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
}