package Pantailak;

import java.util.Timer;
import java.util.TimerTask;

public class Bonba {
	private int radioa;
	private int X;
	private int Y;
	private boolean eztanda;
	private int kont;
	private int PERIODO = 2;
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
			detonar();
			timer.cancel();
		}
		//setChanged();
		//notifyObservers();	
	}
	
	public void eztandaEgin() {
		if (/*tenp>=3*/true){
			int eztanda = this.radioa;
			deleteBonba();
		}
		
	}
	
	private void deleteBonba() {
		
		
	}
	
	private int getRadioa() {
		return this.radioa;
	}

	private void detonar() {
	    System.out.println("💥 La bomba ha explotado en (" + X + "," + Y + ")!");
	    
	    // Cambiar el tipo de la celda donde estaba la bomba a 0 (vacío)
	    LaberintoEredua.getLabEredua().getGelaZerr().get(Y * 17 + X).setTipo(0);
	    
	    // Explosión: Elimina los bloques blandos en la cruz
	    LaberintoEredua.getLabEredua().apurtuBlokeak(X, Y);

	    // Notificar a los observadores (para que la UI cambie la imagen)
	   // LaberintoEredua.getLabEredua().setChanged();
	   // LaberintoEredua.getLabEredua().notifyObservers();
	}
	
	public int getX() {
		return this.X;
	}
	
	public int getY() {
		return this.Y;
	}
}
