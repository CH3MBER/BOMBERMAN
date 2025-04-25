package Pantailak;

public class BonbaNormala extends Bonba {
	
	public BonbaNormala() {
		super(new EztandaNormal());
		
	}
	
	public void apurtu() {
		super.bonbaStrategy.apurtu(this);
	}
}