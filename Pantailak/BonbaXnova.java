package proiektua;

public class BonbaXnova extends BonbaStrategy{
	
	private int radioa;
	
	public BonbaXnova() {
		super();
	}
	
	public int getRadioa() {
		return radioa;
	}
	
	public void setRadioa(int pRadioa) {
		radioa=pRadioa;
	}
	
	protected void apurtu() {
		LaberintoEredua le=LaberintoEredua.getLabEredua();
		boolean hil=false;
		le.getBomberman().bonbaKendu();
		// Extanda zentroan
		if(le.getBomberman().getY()*17+le.getBomberman().getX()==getY()*17+getX()) {
			LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(getY()*17+getX()).setMota(14);
			le.getBomberman().setBizitza(false);
			hil=true;
		}else {
			LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(getY()*17+getX()).setMota(14);
			le.getSuLista().add(new Sua(getX(), getY()));
		}
		
		//Extanda ezkerreko diagonalean gorantza
		int x=getX()-1;
		int y=getY()-1;
		while(x>= 0 && y>=0 && Math.abs(getX()-x)<= getRadioa()&&Math.abs(getY()-y)<=getRadioa()) {
			if(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).getMota()==1) {
				break;
			}
			le.getSuLista().add(new Sua(x,y));
			
			if(le.getBomberman().getY()*17+le.getBomberman().getX()==y*17+x) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).setMota(14);
				le.getBomberman().setBizitza(false);
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
		 x=getX()+1;
		 y=getY()-1;
		while (x<=16&&y>=0&&Math.abs(getX()-x)<=getRadioa()&&Math.abs(getY()-y)<=getRadioa()) {
			if(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).getMota()==1) {
				break;
			}
			le.getSuLista().add(new Sua(x,y));
			if(le.getBomberman().getY()*17+le.getBomberman().getX()==y*17+x) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).setMota(14);
				le.getBomberman().setBizitza(false);
				hil=true;
			}else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, y)!=null) {
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, y).setBizitza(false);
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, y));
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(Y*17+x).setMota(4);
			}else if(!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).getMota()==3)) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).setMota(4);
			}
			LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(x, y);
			x++;
			y--;
		}
		//Eztanda ezkerreko diagonalean beherantz
		x=getX()-1;
		y=getY()+1;
		while(x>=0&&y<=10&&Math.abs(getX()-x)<=getRadioa()&&Math.abs(getY()-y)<=getRadioa()) {
			if(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).getMota()==1) {
				break;
			}
			le.getSuLista().add(new Sua(x,y));
			if(le.getBomberman().getY()*17+le.getBomberman().getX()==y*17+x) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).setMota(14);
				le.getBomberman().setBizitza(false);
				hil=true;
			}else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, y)!=null) {
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, y).setBizitza(false);
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(x, y));
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).setMota(4);
			}else if(!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).getMota()==3)) {
				LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(x, y);
				x--;
				y++;
			}
			
			//Eztanda eskuineko diagonalean beherantz
			
			x=getX()+1;
			y=getY()-1;
			while(x<=16 && y<=10 && Math.abs(getX()-x)<=getRadioa() && Math.abs(getY()-y)<=getRadioa()) {
				if(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).getMota()==1) {
					break;
				}
				le.getSuLista().add(new Sua(x,y));
				if(le.getBomberman().getY()*17+le.getBomberman().getX()==y*17+x) {
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(y*17+x).setMota(14);
					le.getBomberman().setBizitza(false);
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
				le.getBomberman().setBizitza(false);
				le.partidaBukatu();
			}
		}
	}

}
