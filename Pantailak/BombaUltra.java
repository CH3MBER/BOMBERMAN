package Pantailak;

public class BombaUltra extends BombaStrategy {
	private int radioa;

	public BombaUltra() {
		super();
		
	}
	private int getRadioa() {
		return this.radioa;
	}
	
	private void setRadioa(int pRadioa) {
		radioa = pRadioa;
	}
	
	
	@Override
	protected void apurtu() {
		LaberintoEredua lE = LaberintoEredua.getLabEredua();
		boolean hil = false;
		lE.getBomberman().bonbaKendu();
		lE.getSuLista().add(new Sua(getX(),getY()));
		LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(getY()*17+getX()).setMota(4);
		if (!((LaberintoEredua.getLabEredua().getLabMota().getbZerr().getBloke(getX()+1, getY())) instanceof Gogorra)) {
			for (int i=getX(); i<LaberintoEredua.getLabEredua().getLabMota().getZutabe(); i++) {
				if(lE.getBomberman().getX() == i && lE.getBomberman().getY() == getY()) {
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(getY()*17+i).setMota(40);
					lE.getBomberman().setBizitza(false);
					hil = true;
				}
				else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(i, getY()) != null) {
					LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(i, getY()).setBizitza(false);
					LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(i, getY()));
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(getY()*17+i).setMota(4);
					lE.getSuLista().add(new Sua(i,getY()));
				}
				else  if (!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(getY()*17+i).getMota() == 45)) {
					lE.getSuLista().add(new Sua(i,getY()));
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(getY()*17+i).setMota(4);
				}
				LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(i, getY());
			}
		}
		if (!((LaberintoEredua.getLabEredua().getLabMota().getbZerr().getBloke(getX()-1, getY()) instanceof Gogorra))) {
			for (int i=0; i<=getX(); i++) {
				if (lE.getBomberman().getX() == i && lE.getBomberman().getY() == getY()) {
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(getY()*17+i).setMota(40);
					lE.getBomberman().setBizitza(false);
					hil = true;
				}
				else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(i, getY()) != null) {
					LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(i, getY()).setBizitza(false);
					LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(i, getY()));
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(getY()*17+i).setMota(4);
					lE.getSuLista().add(new Sua(i,getY()));
				}
				else if (!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(getY()*17+i).getMota() == 45)) {
					lE.getSuLista().add(new Sua(i,getY()));
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(getY()*17+i).setMota(4);
				}
				LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(i, getY());
			}
		}
		if (!((LaberintoEredua.getLabEredua().getLabMota().getbZerr().getBloke(getX(), getY()-1)) instanceof Gogorra)) {
			for (int i=0; i<=getY(); i++) {
				if (lE.getBomberman().getX() == getX() && lE.getBomberman().getY() == i) {
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(i*17+getX()).setMota(40);
					lE.getBomberman().setBizitza(false);
					hil = true;
				}
				else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(getX(), i) != null) {
					LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(getX(), i).setBizitza(false);
					LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(getX(), i));
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(i*17+getX()).setMota(4);
					lE.getSuLista().add(new Sua(getX(),i));
				}
				else if (!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(i*17+getX()).getMota() == 45)) {
					lE.getSuLista().add(new Sua(getX(),i));
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(i*17+getX()).setMota(4);
				}
				LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(getX(), i);
			}
		}	
		if (!((LaberintoEredua.getLabEredua().getLabMota().getbZerr().getBloke(getX(), getY()+1)) instanceof Gogorra)) {
			for (int i=getY(); i<LaberintoEredua.getLabEredua().getLabMota().getErrenkada(); i++) {
				if (lE.getBomberman().getX() == getX() && lE.getBomberman().getY() == i) {
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(i*17+getX()).setMota(40);
					lE.getBomberman().setBizitza(false);
					hil = true;
				}
				else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(getX(), i) != null) {
					LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(getX(), i).setBizitza(false);
					LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(getX(), i));
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(i*17+getX()).setMota(4);
					lE.getSuLista().add(new Sua(getX(),i));
				}
				else if(!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(i*17+getX()).getMota() == 45)) {
					lE.getSuLista().add(new Sua(getX(),i));
					LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().aurkituGelaxka(i*17+getX()).setMota(4);
				}
				LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(getX(), i);
			}
		}
			
		if (LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().zerrendaHutsik()) {
			System.out.print("\nZorionak Bonberman jokoan irabazi duzu.");
			lE.partidaBukatu();
		}
			
		if (hil) {
			System.out.print("\nPartida galdu duzu.");
			lE.getBomberman().setBizitza(false);
			lE.partidaBukatu();
		}
	}
	
	/*@Override
	protected void updateKont() {
		kont--;
		if (kont == 0) {
			kont = PERIODO;
			eztanda = true;
			apurtu();
			timer.cancel();
		}
	}*/

}