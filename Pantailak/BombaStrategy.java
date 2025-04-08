package bomberman;

import java.util.Timer;
import java.util.TimerTask;

public abstract class BombaStrategy {
	//private int radioa;
	protected int X;
	protected int Y;
	protected boolean eztanda;
	protected int kont;
	protected int PERIODO = 3;
	protected Timer timer = null;
	
	/*protected BonbaStrategy(/*int pRadioa, int pX, int pY){
		//this.radioa = pRadioa;
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
	} */
	public void timerHasi() {
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				updateKont();
			}		
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
	}
		

	
	public int getX() {
		return this.X;
	}
	
	public int getY() {
		return this.Y;
	}
	
	public void setX(int pX) {
		X =pX;
	}
	
	public void setY(int pY) {
		Y = pY;
	}
	
	protected void updateKont() {
		kont--;
		if (kont == 0) {
			kont = PERIODO;
			eztanda = true;
			apurtu();
			timer.cancel();
		}
	}
	
	protected void apurtu() {
	}

}
