package Pantailak;

public class LaberintoSoft extends Laberinto{

	public LaberintoSoft() {
		super();
	}
	
	protected void matrizeaSortu() {
		int lerro, zut;
		for(lerro=0;lerro<errenkada;lerro++) {
			for(zut=0;zut<zutabe;zut++) {
				if (!((lerro==0 && zut==0)||(lerro==0 && zut==1)||(lerro==1 && zut==0))){
					if (super.ausazZenbakia()>0.4) {
						super.blokeZerr.sortuBlokea(2, zut, lerro);
						super.gelaxkaZerrenda.gehituGelaxka(new GelaxkaEredu(2));	//Bloke Biguna
					}
					else if (super.ausazZenbakia()>0.9 && super.etsaiLista.zerrendaTamaina()<8) {
						super.gelaxkaZerrenda.gehituGelaxka(new GelaxkaEredu(20));	//Bloke Biguna
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
