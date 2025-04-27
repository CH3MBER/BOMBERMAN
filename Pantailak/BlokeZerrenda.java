package Pantailak;
import java.util.ArrayList;
import java.util.Iterator;


public class BlokeZerrenda {
	private ArrayList<Bloke> blokeZerrenda;
	
	public BlokeZerrenda() {
		this.blokeZerrenda= new ArrayList<>();
	}
	
	private Iterator<Bloke> getIter(){
		return this.blokeZerrenda.iterator();
	}
	public void gehituBloke(Bloke pBloke) {
		blokeZerrenda.add(pBloke);
	}
	
	public void deleteBloke(int x, int y) {
		blokeZerrenda.remove(getBloke(x,y));
	}
	
	public Bloke getBloke(int index) {
		if(index >= 0 && index< blokeZerrenda.size()) {
			return blokeZerrenda.get(index);
		}
		return null;
	}
	
	public Bloke getBloke(int X, int Y) {
		return this.getBlokeGuztiak().stream().filter(b -> b != null && b.getPosizioa()[0] == X && b.getPosizioa()[1]== Y).findFirst().orElse(null);
	}
	
	public ArrayList<Bloke> getBlokeGuztiak(){
		return new ArrayList<>(blokeZerrenda);
	}
	
	public void eztandaEginPosizioan(int x, int y) {
		blokeZerrenda.stream().filter(b -> b != null && b.getPosizioa()[0] == x && b.getPosizioa()[1] == y && (b instanceof Biguna)).findFirst().ifPresent(b -> {((Biguna)b).eztandaEgin(); deleteBloke(b.getPosizioa()[0], b.getPosizioa()[1]);});
	}
	
	public void blokeakInprimatu() {
		blokeZerrenda.stream().forEach(bloke -> System.out.println("Posizioa: ("+bloke.getPosizioa()[0]+ ", "+bloke.getPosizioa()[1]+") Dago"+bloke.badago()));
	}

	public boolean blokeBigunaDu() {
		Iterator<Bloke> iter=getIter();
		boolean dauka = false;
		while(iter.hasNext() && !dauka) {
			Bloke pBloke=iter.next();
			if (pBloke instanceof Biguna) {
				System.out.print("Dago");
				dauka = true;	
			}
		}
		return dauka;
	}

	public void sortuBlokea (int pMota, int pX, int pY) {
		Bloke blokeBerria = BlokeFactory.getNireBlokeFactory().sortuBlokea(pMota, pX, pY);
		gehituBloke(blokeBerria);
	}
	
}