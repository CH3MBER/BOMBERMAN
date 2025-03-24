package Pantailak;

public class Bloke {
	private int posX; //X koordenatuak matrizean jakiteko
	private int posY; // Y koordenatuak matrizean jakiteko 
	private boolean dago; //Blokea jokuan jarraitzen duen ala eztanda egin duela jakiteko
	
	
	public Bloke(int pPosX, int pPosY ){
		this.posX = pPosX;
		this.posY = pPosY;
		this.setDago(true);
	}
		
	public int[] getPosizioa() { //Jakiteko zein posizioan dagoen
		return new int[] {posX,posY};
	}
	
	public boolean badago() { //Jakiteko jokuan jarraitzen duen ala ez
		return getDago();
	}

	public boolean getDago() {
		return dago;
	}

	public void setDago(boolean dago) {
		this.dago = dago;
	}

}