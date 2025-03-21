package Pantailak;

public class Bloke {
	private boolean eztanda; //Blokea eztanda egin al duen ala ez jakiteko
	private String mota; //Biguna edo ez bereizteko
	private int posX; //X koordenatuak matrizean jakiteko
	private int posY; // Y koordenatuak matrizean jakiteko 
	private boolean dago; //Blokea jokuan jarraitzen duen ala eztanda egin duela jakiteko
	
	
	public Bloke(String pMota, int pPosX, int pPosY ){
		this.mota = pMota;
		this.posX = pPosX;
		this.posY = pPosY;
		this.dago = true;
		
		if(!(mota == null)) {
			if (mota.equalsIgnoreCase("Biguna")) { //Blokea biguna denean, eztanda egin ahal duen ala ez jakiteko
				this.eztanda=true;
				
			}else {
				this.eztanda=false;
			}
		}
	}
	
	public void eztandaEgin() { //Blokea eztanda egiteko
		if(eztanda) {
			this.dago=false;
			System.out.println("Blokea eztanda egin du.");
			this.mota = null;
			
		}else {
			System.out.println("Blokea ez du eztanda egin.");
		}
		
	}
	
	
	public boolean eztandaEginAlDu() {
		return eztanda;
	}
	public int[] getPosizioa() { //Jakiteko zein posizioan dagoen
		return new int[] {posX,posY};
	}
	
	public String getMota() {
		return mota;
	}
	
	public boolean badago() { //Jakiteko jokuan jarraitzen duen ala ez
		return dago;
	}

	public void setMota(String pMota) {
		this.mota = pMota;
		
	}

}
