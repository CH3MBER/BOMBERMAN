package bomberman;


import java.util.ArrayList;
import java.util.Iterator;


public class EtsaiZerrenda {
	private ArrayList<Etsai> etsaiZerrenda;
	
	public EtsaiZerrenda() {
		etsaiZerrenda = new ArrayList<Etsai>();
	}
	
	private Iterator<Etsai> getIterator(){
		return this.etsaiZerrenda.iterator();
		
	}
	
	public void gehituEtsaia(Etsai pEtsai) {
		this.etsaiZerrenda.add(pEtsai);
		
	}
	
	public void ezabatuEtsai (int x, int y) {
		this.etsaiZerrenda.remove(aurkituEtsai(x,y));
	}
	
	public Etsai aurkituEtsai(int x, int y) {
		boolean aurk = false;
		Iterator<Etsai> itr = getIterator();
		Etsai etsaia = null;
		while (itr.hasNext() && aurk == false) {
			etsaia = itr.next();
			if (etsaia.getX() == x && etsaia.getY() == y) {
				aurk = true;
			}
		}
		if (aurk == false) {
			etsaia = null;
		}
		return etsaia;
	}
	
	public ArrayList<Etsai> erakutsiEtsaiGuztiak(){
		return new ArrayList<Etsai>(this.etsaiZerrenda);
	}
	
	public int zerrendaTamaina() {
		return this.etsaiZerrenda.size();
	}
	
	public boolean zerrendaHutsik() {
		boolean hutsik = false;
		if (this.etsaiZerrenda.size()==0) {
			hutsik = true;
		}
		return hutsik;
	}


}


}
