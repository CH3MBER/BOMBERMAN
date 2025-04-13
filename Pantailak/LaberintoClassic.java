package Pantailak;

public class LaberintoClassic extends Laberinto{

	public LaberintoClassic() {
		super();
	}
	
	protected void matrizeaSortu() {
		int lerro, zut;
		for(lerro=0;lerro<super.errenkada;lerro++) {
			for(zut=0;zut<super.zutabe;zut++) {
				if (zut%2!=0 && lerro%2!=0) {
					super.blokeZerr.sortuBlokea(1, zut, lerro);
					super.gelaxkaZerrenda.gehituGelaxka(new GelaxkaEredu(1)); //Bloke Gogorra
				}
				else if (!((lerro==0 && zut==0)||(lerro==0 && zut==1)||(lerro==1 && zut==0))){
					if (super.ausazZenbakia()>0.4) {
						super.blokeZerr.sortuBlokea(2, zut, lerro);
						super.gelaxkaZerrenda.gehituGelaxka(new GelaxkaEredu(2));	//Bloke Biguna
					}
					else if (super.ausazZenbakia()>0.9 && super.etsaiLista.zerrendaTamaina()<6) {
						super.gelaxkaZerrenda.gehituGelaxka(new GelaxkaEredu(20));	//Etsaia
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