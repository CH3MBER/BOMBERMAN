package Pantailak;

public class EztandaNormal implements BonbaStrategy{

	public void apurtu(Bonba pBonba) {
		LaberintoEredua lE = LaberintoEredua.getLabEredua();
		boolean hil = false;
		int x,y;
		lE.getBomberman().bonbaKendu();
		if (lE.getBomberman().getY()*17+lE.getBomberman().getX() == pBonba.getY()*17+pBonba.getX()) {
			LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+pBonba.getX()).setMota(14);
			lE.getBomberman().setBizirik(false);
			hil = true;
		}
		else {
			LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+pBonba.getX()).setMota(4);
			lE.getSuLista().add(new Sua(pBonba.getX(),pBonba.getY()));
		}
		
		x=pBonba.getX()-1;
		while(x>=0 && x<=16 &&Math.abs(pBonba.getX()-x)<=pBonba.getRadioa()) {
			if(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+x).getMota()==1) {
				break;
			}
			lE.getSuLista().add(new Sua(x,pBonba.getY()));
			if(lE.getBomberman().getY()*17+lE.getBomberman().getX()==pBonba.getY()*17+x) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+x).setMota(14);
				lE.getBomberman().setBizirik(false);
				hil=true;
			}else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, pBonba.getY())!=null) {
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, pBonba.getY()).setBizitza(false);
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, pBonba.getY()));
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+x).setMota(4);
			}else if(!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+x).getMota()==3)) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+x).setMota(4);
			}
			LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(x, pBonba.getY());
			x--;
		}

		x=pBonba.getX()+1;
		while(x>=0 && x<=16 &&Math.abs(pBonba.getX()-x)<=pBonba.getRadioa()) {
			if(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+x).getMota()==1) {
				break;
			}
			lE.getSuLista().add(new Sua(x,pBonba.getY()));
			if(lE.getBomberman().getY()*17+lE.getBomberman().getX()==pBonba.getY()*17+x) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+x).setMota(14);
				lE.getBomberman().setBizirik(false);
				hil=true;
			}else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, pBonba.getY())!=null) {
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, pBonba.getY()).setBizitza(false);
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, pBonba.getY()));
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+x).setMota(4);
			}else if(!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+x).getMota()==3)) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+x).setMota(4);
			}
			LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(x, pBonba.getY());
			x++;
		}
		
		y=pBonba.getY()-1;
		while(y>=0 && y<=10 && Math.abs(pBonba.getY()-y)<=pBonba.getRadioa()) {
			if(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+pBonba.getX()).getMota()==1) {
				break;
			}
			lE.getSuLista().add(new Sua(pBonba.getX(),y));
			if(lE.getBomberman().getY()*17+lE.getBomberman().getX()==y*17+pBonba.getX()) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+pBonba.getX()).setMota(14);
				lE.getBomberman().setBizirik(false);
				hil=true;
			}else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(pBonba.getX(), y)!=null) {
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(pBonba.getX(), x).setBizitza(false);
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(pBonba.getX(), y));
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+pBonba.getX()).setMota(4);
			}else if(!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+pBonba.getX()).getMota()==3)) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+pBonba.getX()).setMota(4);
			}
			LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(pBonba.getX(), y);
			y--;
		}
		
		y=pBonba.getY()+1;
		while(y>=0 && y<=10 && Math.abs(pBonba.getY()-y)<=pBonba.getRadioa()) {
			if(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+pBonba.getX()).getMota()==1) {
				break;
			}
			lE.getSuLista().add(new Sua(pBonba.getX(),y));
			if(lE.getBomberman().getY()*17+lE.getBomberman().getX()==y*17+pBonba.getX()) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+pBonba.getX()).setMota(14);
				lE.getBomberman().setBizirik(false);
				hil=true;
			}else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(pBonba.getX(), y)!=null) {
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(pBonba.getX(), x).setBizitza(false);
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(pBonba.getX(), y));
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+pBonba.getX()).setMota(4);
			}else if(!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+pBonba.getX()).getMota()==3)) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+pBonba.getX()).setMota(4);
			}
			LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(pBonba.getX(), y);
			y++;
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
