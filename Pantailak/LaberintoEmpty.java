package Pantailak;

public class LaberintoEmpty extends Laberinto{
	
	public LaberintoEmpty() {
		super();
	}
	
	protected void matrizeaSortu() {
		int lerro, zut;
		for(lerro=0;lerro<errenkada;lerro++) {
			for(zut=0;zut<zutabe;zut++) {
				if (!((lerro==0 && zut==0)||(lerro==0 && zut==1)||(lerro==1 && zut==0))){
					if (super.ausazZenbakia()>0.95 && super.etsaiLista.zerrendaTamaina()<10) {
						super.gelaxkaZerrenda.gehituGelaxka(new GelaxkaEredu(20));
						super.etsaiLista.gehituEtsaia(new Etsai(zut, lerro));
					}
					else {
						super.gelaxkaZerrenda.gehituGelaxka(new GelaxkaEredu(0));	//Hutsik
					}
				}
				else {
					super.gelaxkaZerrenda.gehituGelaxka(new GelaxkaEredu(0));	//Hutsik
				}
			}
	
		}
	}

	
}
