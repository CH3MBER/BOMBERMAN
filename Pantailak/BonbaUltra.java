package Pantailak;

public class BonbaUltra extends Bonba {
	private int radioa;

	public BonbaUltra() {
		super(new EztandaUltra());
		
	}
	
	public void apurtu() {
		super.bonbaStrategy.apurtu(this);
	}
}