package Pantailak;

import java.util.ArrayList;
import java.util.Iterator;

public class GelaxkaZerrenda {

	private ArrayList<GelaxkaEredu> gelaxkaZerr;
	
	public GelaxkaZerrenda() {
		gelaxkaZerr = new ArrayList<>();
	}
	
	private Iterator<GelaxkaEredu> getIterator(){
		return this.gelaxkaZerr.iterator();
	}
	
	public void gehituGelaxka(GelaxkaEredu pGelaxka) {
		this.gelaxkaZerr.add(pGelaxka);
	}

	public void ezabatuEtsai(GelaxkaEredu pGelaxka) {
		this.gelaxkaZerr.remove(pGelaxka);
	}
	
	public void ezabatuEtsaiKoord(int x, int y) {
		this.gelaxkaZerr.remove(aurkituGelaxka(y*17+x));
	}
	
	public GelaxkaEredu aurkituGelaxka(int gelaxka) {
		return gelaxkaZerr.get(gelaxka);
	}
	
	public ArrayList<GelaxkaEredu> erakutsiGelaxkaGuztiak(){
		return new ArrayList<GelaxkaEredu>(this.gelaxkaZerr);
	}
	
	public int zerrendaTamaina() {
		return this.gelaxkaZerr.size();
	}
	
}
