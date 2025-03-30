package Pantailak;

public class Biguna extends Bloke{

	private boolean eztanda = true;
	
	public Biguna(int pPosX, int pPosY) {
		super(pPosX, pPosY, new EztandaNormal());
		// TODO Auto-generated constructor stub
	}
	public void eztandaEgin() { //Blokea eztanda egiteko
		System.out.println("Blokea eztanda egin du.");
		setDago(false);
		
	}

}
