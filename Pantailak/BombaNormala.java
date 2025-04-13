package Pantailak;

public class BombaNormala extends BombaStrategy {
	private int radioa;
	
	public BombaNormala() {
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
		if (lE.getBomberman().getY()*17+lE.getBomberman().getX() == getY()*17+getX()) {
			LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get(getY()*17+getX()).setMota(14);
			lE.getBomberman().setBizitza(false);
			hil = true;
		}
		else {
			LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get(getY()*17+getX()).setMota(4);
			lE.getSuLista().add(new Sua(getX(),getY()));
		}
		
		if(getX()-1>=0 && !(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get(getY()*17+(getX()-1)).getMota() == 1)) {
			lE.getSuLista().add(new Sua(getX()-1,getY()));
			if (lE.getBomberman().getY()*17+lE.getBomberman().getX() == getY()*17+(getX()-1)) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get(getY()*17+(getX()-1)).setMota(14);
				lE.getBomberman().setBizitza(false);
				hil = true;
			}
			else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(getX()-1, getY()) != null) {
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(getX()-1, getY()).setBizitza(false);
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(getX()-1, getY()));
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get(getY()*17+(getX()-1)).setMota(4);
			}
			else if (!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get(getY()*17+(getX()-1)).getMota() == 3))
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get(getY()*17+(getX()-1)).setMota(4);
			LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(getX()-1, getY());
		}
		if(getX()+1<=16 && !(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get(getY()*17+(getX()+1)).getMota() == 1)) {
			lE.getSuLista().add(new Sua(getX()+1,getY()));
			if (lE.getBomberman().getY()*17+lE.getBomberman().getX() == getY()*17+(getX()+1)) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get(getY()*17+(getX()+1)).setMota(14);
				lE.getBomberman().setBizitza(false);
				hil = true;
			}
			else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(getX()+1, getY()) != null) {
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(getX()+1, getY()).setBizitza(false);
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(getX()+1, getY()));
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get(getY()*17+(getX()+1)).setMota(4);
			}
			else if (!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get(getY()*17+(getX()+1)).getMota() == 3))
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get(getY()*17+(getX()+1)).setMota(4);
			LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(getX()+1, getY());
		}	
		if(getY()-1>=0 && !(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get((getY()-1)*17+getX()).getMota() == 1)) { 
			lE.getSuLista().add(new Sua(getX(),getY()-1));
			if (lE.getBomberman().getY()*17+lE.getBomberman().getX() == (getY()-1)*17+getX()){
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get((getY()-1)*17+getX()).setMota(14);
				lE.getBomberman().setBizitza(false);
				hil = true;
			}
			else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(getX(), getY()-1) != null) {
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(getX(), getY()-1).setBizitza(false);
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(getX(), getY()-1));
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get((getY()-1)*17+getX()).setMota(4);
			}
			else if (!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get((getY()-1)*17+getX()).getMota() == 3))
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get((getY()-1)*17+getX()).setMota(4);
			LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(getX(), getY()-1);
		}
		if(getY()+1<=10 && !(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get((getY()+1)*17+getX()).getMota() == 1)) {
			lE.getSuLista().add(new Sua(getX(),getY()+1));
			if (lE.getBomberman().getY()*17+lE.getBomberman().getX() == (getY()+1)*17+getX()) {
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get((getY()+1)*17+getX()).setMota(14);
				lE.getBomberman().setBizitza(false);
				hil = true;
			}
			else if(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(getX(), getY()+1) != null) {
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(getX(), getY()+1).setBizitza(false);
				LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().ezabatuEtsai(LaberintoEredua.getLabEredua().getLabMota().getEtsaiLista().aurkituEtsai(getX(), getY()+1));
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get((getY()+1)*17+(getX())).setMota(4);
			}
			else if (!(LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get((getY()+1)*17+getX()).getMota() == 3))
				LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().get((getY()+1)*17+getX()).setMota(4);
			LaberintoEredua.getLabEredua().getLabMota().getbZerr().eztandaEginPosizioan(getX(), getY()+1);
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