package Pantailak;

import java.util.Timer;
import java.util.TimerTask;

public class BombermanGorria extends Bomberman {

	private int denbora;
	private int SUA = 2;
	private Timer eztandaTimer = null;
	
	//private int bonbaKop = 10;
	public BombermanGorria(int pX,int pY) { //Meter aqui lo del timer de bomberman
		super(pX, pY, 3, new BonbaNormala());
		setBonbaKop(10);
	}

	public void biziTimer() {
		denbora = SUA;
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				updateDenb();
			}		
		};
		eztandaTimer = new Timer();
		eztandaTimer.scheduleAtFixedRate(timerTask, 0, 1000);
	}
	
	protected void updateDenb() {
		denbora--;
		if (denbora == 0) {
			denbora = SUA;
			System.out.print("Hil zara");
			LaberintoEredua.getLabEredua().partidaBukatu();
			eztandaTimer.cancel();
		}	
	}
	
	public void timerAmatatu() {
		eztandaTimer.cancel();
	}
}