package Pantailak;

public class EztandaX implements BonbaStrategy{
	
	public void apurtu(Bonba pBonba) {
		LaberintoEredua le=LaberintoEredua.getLabEredua();
		boolean hil=false;
		int x;
		int y;
		le.getBomberman().bonbaKendu();
		// Extanda zentroan
		if(le.getBomberman().getY()*17+le.getBomberman().getX()==pBonba.getY()*17+pBonba.getX()) {
			LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+pBonba.getX()).setMota(14);
			le.getBomberman().setBizirik(false);
			hil=true;
		}else {
			LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(pBonba.getY()*17+pBonba.getX()).setMota(4);
			le.getSuLista().add(new Sua(pBonba.getX(), pBonba.getY()));
		}
		//Extanda ezkerreko diagonalean gorantza
		x=pBonba.getX()-1;
		y=pBonba.getY()-1;
		while(x>= 0 && y>= 0 && x<= 16 && y<= 10 && Math.abs(pBonba.getX()-x)<= pBonba.getRadioa() && Math.abs(pBonba.getY()-y)<=pBonba.getRadioa()) {
			if(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).getMota()==1) {
				break;
			}
			le.getSuLista().add(new Sua(x,y));
			if(le.getBomberman().getY()*17+le.getBomberman().getX()==y*17+x) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).setMota(14);
				le.getBomberman().setBizirik(false);
				hil=true;
			}else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x,y)!=null){
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, y).setBizitza(false);
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, y));
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).setMota(4);
			// Laberintoa eguneratu horma lehertezina baldin ez bada
			}else if(!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).getMota()==3)) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).setMota(4);
			}
			
			LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(x, y);
			x--;
			y--;
		}
		
		//Eztanda eskuineko daigonalean gorantza
		x=pBonba.getX()+1;
		y=pBonba.getY()-1;
		while (x>=0 && x<=16 && y>=0  && y<=10 && Math.abs(pBonba.getX()-x)<=pBonba.getRadioa() && Math.abs(pBonba.getY()-y)<=pBonba.getRadioa()) {
			if(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).getMota()==1) {
				break;
			}
			le.getSuLista().add(new Sua(x,y));
			if(le.getBomberman().getY()*17+le.getBomberman().getX()==y*17+x) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).setMota(14);
				le.getBomberman().setBizirik(false);
				hil=true;
			}else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, y)!=null) {
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, y).setBizitza(false);
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, y));
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).setMota(4);
			}else if(!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).getMota()==3)) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).setMota(4);
			}
			LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(x, y);
			x++;
			y--;
		}
		//Eztanda ezkerreko diagonalean beherantz
		x=pBonba.getX()-1;
		y=pBonba.getY()+1;
		while(x>=0 && y>= 0 && x<=16 && y<=10 &&Math.abs(pBonba.getX()-x)<=pBonba.getRadioa() && Math.abs(pBonba.getY()-y)<=pBonba.getRadioa()) {
			if(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).getMota()==1) {
				break;
			}
			le.getSuLista().add(new Sua(x,y));
			if(le.getBomberman().getY()*17+le.getBomberman().getX()==y*17+x) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).setMota(14);
				le.getBomberman().setBizirik(false);
				hil=true;
			}else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, y)!=null) {
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, y).setBizitza(false);
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, y));
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).setMota(4);
			}else if(!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).getMota()==3)) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).setMota(4);
			}
			LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(x, y);
			x--;
			y++;
		}
			
		//Eztanda eskuineko diagonalean beherantz
			
		x=pBonba.getX()+1;
		y=pBonba.getY()+1;
		while(x>= 0 && y>= 0 && x<=16 && y<=10 && Math.abs(pBonba.getX()-x)<=pBonba.getRadioa() && Math.abs(pBonba.getY()-y)<=pBonba.getRadioa()) {
			if(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).getMota()==1) {
				break;
			}
			le.getSuLista().add(new Sua(x,y));
			if(le.getBomberman().getY()*17+le.getBomberman().getX()==y*17+x) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).setMota(14);
				le.getBomberman().setBizirik(false);
				hil=true;
			}else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x,y)!=null) {
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, y).setBizitza(false);
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, y));
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).setMota(4);
			}else if(!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).getMota()==3)) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).setMota(4);
			}
			LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(x, y);
			x++;
			y++;
		}
		
		if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().zerrendaHutsik()) {
			//System.out.println("Zorional Bomberman jokoa irabazi duzu.");
			le.partidaBukatu();
		}
			
		if(hil) {
			//System.out.println("Partida galdu duzu.");
			le.getBomberman().setBizirik(false);
			le.partidaBukatu();
		}
	}
}
