package Pantailak;

import java.util.Timer;
import java.util.TimerTask;

public class Etsai {

	private int X;
	private int Y;
	private int PERIODO = 2;
	private int kont;
	private Timer timer = null;
	
	public Etsai(int pX, int pY) {
		this.X = pX;
		this.Y = pY;
//		kont = PERIODO;
//		TimerTask timerTask = new TimerTask() {
//			@Override
//			public void run() {
//			updateKont();
//			}		
//		};
//		timer = new Timer();
//		timer.scheduleAtFixedRate(timerTask, 0, 500);
//	}
//	
//	private void updateKont() {
//		kont--;
//		if (kont == 0) {
//			kont = PERIODO;
//			LaberintoEredua.getLabEredua().etsaiMugitu(this, this.X, this.Y);
//		}
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}
}
