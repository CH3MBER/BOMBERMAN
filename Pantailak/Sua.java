package Pantailak;

import java.util.Timer;
import java.util.TimerTask;

public class Sua {
	private int X;
	private int Y;
	private int kont;
	private int PERIODO = 2;
	private Timer timer = null;
	private boolean piztuta = false;
	
	public Sua(int pX, int pY){
	this.X = pX;
	this.Y = pY;
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
			ezkonduSua();
			timer.cancel();
		}
	}
	
	public void ezkonduSua() {
		LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(Y * 17 + X).setMota(0);
		LaberintoEredua.getLabEredua().amatatuSua(this);
	}
	
	public int getX() {
		return this.X;
	}
	
	public int getY() {
		return this.Y;
	}

}
