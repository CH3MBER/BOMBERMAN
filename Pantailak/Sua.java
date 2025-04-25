package Pantailak;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

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
		
		LaberintoEredua.getLabEredua().getExecutor().schedule(()->{
			ezkonduSua();
		}, PERIODO, TimeUnit.SECONDS);
		
//		TimerTask timerTask = new TimerTask() {
//			@Override
//			public void run() {
//				updateKont();
//			}		
//		};
//		timer = new Timer();
//		timer.scheduleAtFixedRate(timerTask, 0, 1000);
	}
	
	private void updateKont() {
		kont--;
		if (kont == 0) {
			timer.cancel();
			ezkonduSua();
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
