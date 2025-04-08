package bomberman;

public class BombaNormala extends BombaStrategy {
	private int radioa;
	
	public BombaNormala(int pRadioa) {
		super();
		radioa = pRadioa;
		super.timerHasi();
		
	}
	private int getRadioa() {
		return this.radioa;
	}
	
	private void setRadioa(int pRadioa) {
		radioa = pRadioa;
	}
	
	@Override
	protected void apurtu() {
	    LaberintoEredua.getLabEredua().apurtuBlokeak(X, Y);
	}
	
	/*@Override
	protected void updateKont() {
		kont--;
		if (kont == 0) {
			kont = PERIODO;
			eztanda = true;
			apurtu();
			timer.cancel();
		}
	}*/
}
