package Pantailak;


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

	public void ezabatuEtsai (Etsai pEtsai) {
		this.etsaiZerrenda.remove(pEtsai);
	}
	
	public void ezabatuEtsaiKoord (int x, int y) {
		this.etsaiZerrenda.remove(aurkituEtsai(x,y));
	}
	
	public Etsai aurkituEtsai(int x, int y) {
		return erakutsiEtsaiGuztiak().stream().filter(e -> e.getX() == x && e.getY() == y).findFirst().orElse(null);
	}
	
	public ArrayList<Etsai> erakutsiEtsaiGuztiak(){
		return new ArrayList<Etsai>(this.etsaiZerrenda);
	}
	
	public int zerrendaTamaina() {
		return this.etsaiZerrenda.size();
	}
	
	public boolean zerrendaHutsik() {
		return etsaiZerrenda.isEmpty();
	}
	
}