package Pantailak;

public class BonbaXnova extends Bonba{
	
	public BonbaXnova(int radioa) {
		super(new EztandaX());
		this.radioa = radioa;
	}
	
	public void apurtu() {
		super.bonbaStrategy.apurtu(this);
	}
}