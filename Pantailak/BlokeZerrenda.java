package bomberman;

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
	
	public void deleteBloke(Bloke pBloke) {
		blokeZerrenda.remove(pBloke);
	}
	
	public Bloke getBloke(int index) {
		if(index >= 0 && index< blokeZerrenda.size()) {
			return blokeZerrenda.get(index);
		}
		return null;
	}
	
	public Bloke getBloke(int X, int Y) {
		Iterator<Bloke> iter=getIter();
		Bloke pBloke = null;
		boolean aurkitua = false;
		while(iter.hasNext() && !aurkitua) {
			pBloke=iter.next();
			if (pBloke.getPosizioa()[0]== X && pBloke.getPosizioa()[1]== Y && pBloke != null) {
				aurkitua = true;
			}
		}
		return pBloke;
	}
	
	public ArrayList<Bloke> getBlokeGuztiak(){
		return new ArrayList<>(blokeZerrenda);
	}
	
	public void eztandaEginPosizioan(int x, int y) {
		Iterator<Bloke> iter=getIter();
		while(iter.hasNext()) {
			Bloke pBloke=iter.next();
			if (pBloke != null) {
				if (pBloke.getPosizioa()[0] == x && pBloke.getPosizioa()[1] == y && (pBloke instanceof Biguna)) {
					((Biguna)pBloke).eztandaEgin();
					break;
				}
			}
		}
	}
	
	public void blokeakInprimatu() {
		Iterator<Bloke> iter=getIter();
		while(iter.hasNext()) {
			Bloke bloke=iter.next();
			System.out.println("Posizioa: ("+bloke.getPosizioa()[0]+ ", "+bloke.getPosizioa()[1]+") Dago"+bloke.badago());
		}
	}

	public boolean blokeBigunaDu() {
		Iterator<Bloke> iter=getIter();
		boolean dauka = false;
		while(iter.hasNext() && !dauka) {
			Bloke pBloke=iter.next();
			if (pBloke instanceof Biguna) {
				dauka = true;	
			}
		}
		return dauka;
	}
	
	public void sortuBlokea (int pMota,int pX, int pY) {
		Bloke blokeBerria = BlokeFactory.getNireBlokeFactory().sortuBlokea(pMota, pX, pY);
		gehituBloke(blokeBerria);
	}

}
