package Pantailak;

import java.util.Timer;
import java.util.TimerTask;

public class Bonba {
	private int radioa;
	private int X;
	private int Y;
	private boolean eztanda;
	private int kont;
	private int PERIODO = 3;
	private Timer timer = null;
	
	public Bonba(int pRadioa, int pX, int pY){
		this.radioa = pRadioa;
		this.X = pX;
		this.Y = pY;
		eztanda = true;
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
		
	private void updateKont() {
		kont--;
		if (kont == 0) {
			kont = PERIODO;
			eztanda = true;
			apurtu();
			timer.cancel();
		}
	}
	
	private int getRadioa() {
		return this.radioa;
	}

	private void apurtu() {
	    LaberintoEredua.getLabEredua().apurtuBlokeak(X, Y);
	}
	
	public int getX() {
		return this.X;
	}
	
	public int getY() {
		return this.Y;
	}
}
