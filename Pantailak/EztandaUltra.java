package Pantailak;

public class EztandaUltra implements BonbaStrategy{

	public void apurtu(Bonba pBonba) {
		LaberintoEredua lE = LaberintoEredua.getLabEredua();
		boolean hil = false;
		lE.getBomberman().bonbaKendu();
		lE.getSuLista().add(new Sua(pBonba.getX(),pBonba.getY()));
		LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+pBonba.getX()).setMota(4);
		if (!((LaberintoEredua.getLabEredua().getLabMota().getbZerr().getBloke(pBonba.getX()+1, pBonba.getY())) instanceof Gogorra)) {
			for (int i=pBonba.getX(); i<LaberintoEredua.getLabEredua().getLabMota().getZutabe(); i++) {
				if(lE.getBomberman().getX() == i && lE.getBomberman().getY() == pBonba.getY()) {
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+i).setMota(40);
					lE.getBomberman().setBizirik(false);
					hil = true;
				}
				else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(i, pBonba.getY()) != null) {
					LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(i, pBonba.getY()).setBizitza(false);
					LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(i, pBonba.getY()));
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+i).setMota(4);
					lE.getSuLista().add(new Sua(i,pBonba.getY()));
				}
				else  if (!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+i).getMota() == 45)) {
					lE.getSuLista().add(new Sua(i,pBonba.getY()));
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+i).setMota(4);
				}
				LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(i, pBonba.getY());
			}
		}
		if (!((LaberintoEredua.getLabEredua().getLabMota().getbZerr().getBloke(pBonba.getX()-1, pBonba.getY()) instanceof Gogorra))) {
			for (int i=0; i<=pBonba.getX(); i++) {
				if (lE.getBomberman().getX() == i && lE.getBomberman().getY() == pBonba.getY()) {
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+i).setMota(40);
					lE.getBomberman().setBizirik(false);
					hil = true;
				}
				else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(i, pBonba.getY()) != null) {
					LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(i, pBonba.getY()).setBizitza(false);
					LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(i, pBonba.getY()));
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+i).setMota(4);
					lE.getSuLista().add(new Sua(i,pBonba.getY()));
				}
				else if (!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+i).getMota() == 45)) {
					lE.getSuLista().add(new Sua(i,pBonba.getY()));
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+i).setMota(4);
				}
				LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(i, pBonba.getY());
			}
		}
		if (!((LaberintoEredua.getLabEredua().getLabMota().getbZerr().getBloke(pBonba.getX(), pBonba.getY()-1)) instanceof Gogorra)) {
			for (int i=0; i<=pBonba.getY(); i++) {
				if (lE.getBomberman().getX() == pBonba.getX() && lE.getBomberman().getY() == i) {
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(i*17+pBonba.getX()).setMota(40);
					lE.getBomberman().setBizirik(false);
					hil = true;
				}
				else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(pBonba.getX(), i) != null) {
					LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(pBonba.getX(), i).setBizitza(false);
					LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(pBonba.getX(), i));
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(i*17+pBonba.getX()).setMota(4);
					lE.getSuLista().add(new Sua(pBonba.getX(),i));
				}
				else if (!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(i*17+pBonba.getX()).getMota() == 45)) {
					lE.getSuLista().add(new Sua(pBonba.getX(),i));
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(i*17+pBonba.getX()).setMota(4);
				}
				LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(pBonba.getX(), i);
			}
		}	
		if (!((LaberintoEredua.getLabEredua().getLabMota().getbZerr().getBloke(pBonba.getX(), pBonba.getY()+1)) instanceof Gogorra)) {
			for (int i=pBonba.getY(); i<LaberintoEredua.getLabEredua().getLabMota().getErrenkada(); i++) {
				if (lE.getBomberman().getX() == pBonba.getX() && lE.getBomberman().getY() == i) {
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(i*17+pBonba.getX()).setMota(40);
					lE.getBomberman().setBizirik(false);
					hil = true;
				}
				else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(pBonba.getX(), i) != null) {
					LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(pBonba.getX(), i).setBizitza(false);
					LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(pBonba.getX(), i));
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(i*17+pBonba.getX()).setMota(4);
					lE.getSuLista().add(new Sua(pBonba.getX(),i));
				}
				else if(!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(i*17+pBonba.getX()).getMota() == 45)) {
					lE.getSuLista().add(new Sua(pBonba.getX(),i));
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(i*17+pBonba.getX()).setMota(4);
				}
				LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(pBonba.getX(), i);
			}
		}
			
		if (LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().zerrendaHutsik()) {
			System.out.print("\nZorionak Bonberman jokoan irabazi duzu.");
			lE.partidaBukatu();
		}
			
		if (hil) {
			System.out.print("\nPartida galdu duzu.");
			lE.getBomberman().setBizirik(false);
			lE.partidaBukatu();
		}
	}

}
