package bomberman;

import java.util.Timer;
import java.util.TimerTask;

public class IzarraEfektua implements PowerUpEfektua {
	
	private Timer timer;
	
	public void efektuaEman(Bomberman pb) {
		
		timer = new Timer();
		int bizitzaKop = pb.getBizitzak();
		
		pb.setEfektuaAkt(true);
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				pb.setEfektuaAkt(false);
				timer.cancel();
			}
		}, 5000);
		
		
		
	}
	

}
