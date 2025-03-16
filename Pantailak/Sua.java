package Pantailak;

import java.util.Timer;
import java.util.TimerTask;

public class Sua {
	private int X;
	private int Y;
	private int kont;
	private int PERIODO = 2;
	private Timer timer = null;
	
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
			erakutsiSua();
			timer.cancel();
		}
		//setChanged();
		//notifyObservers();	
	}
	
	private void erakutsiSua() {
		LaberintoEredua.getLabEredua().getGelaZerr().get(Y * 17 + X).setTipo(0);
	}
	
}
