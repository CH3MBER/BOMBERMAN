package Pantailak;

import java.util.Observable;

import Sprites.LaberintoBista;

public class HasieraPantailaEredu extends Observable{

	////////////ATRIBUTUAK////////////
	private static HasieraPantailaEredu nHPE = null;
	private int laberinto = 0;	//Jokatuko den laberinto mota aukeratu.
	private int bomberman = 0;	//Erabiliko den bomberman mota aukeratu.
	
	
	////////////ERAIKITZAILEA////////////	
	private HasieraPantailaEredu() {}
	
	public static HasieraPantailaEredu getHPE() {
		if (nHPE == null) {
			nHPE = new HasieraPantailaEredu();
		}
		return nHPE;
	}
	
	////////////HASIERAKO EGUNERAKETA////////////
	@SuppressWarnings("deprecation")
	public void eguneratu() {
		setChanged();
		notifyObservers(new int[] {bomberman, laberinto});	//Erakutsi behar duenaren mezua
	}
	
	////////////BOMBERMAN AUKERATU////////////
	@SuppressWarnings("deprecation")
	public void bombermanAukera(int aukera) {
		if (!(bomberman == 0 && aukera == -1 || bomberman == 3 && aukera == 1)) {
			bomberman+=aukera;
		}
//			if (aukera == 1)
//				bomberman = 0;	//Bomberman Txuria
//			else if(aukera == 2)
//				bomberman = 1;	//Bomberman Beltza
//			/*
//				bomberman = 2;  //Bomberman Gorria
//			 */
			setChanged();
			notifyObservers(new int[] {bomberman, laberinto});	//Aukera berriak bistaratzeko mezua
	}
	
	////////////LABERINTOA AUKERATU////////////
	@SuppressWarnings("deprecation")
	public void laberintoAukera(int aukera) {
		if (!(laberinto == 0 && aukera == -1 || laberinto == 2 && aukera == 1)) {	//Ertzetatik ez ateratzea konprobatzen da
			if (laberinto == 1 && aukera == -1)
				laberinto = 0;	//Classic laberintoa
			else if (laberinto == 2 && aukera == -1)
				laberinto = 1;	//Soft laberintoa
			else if (laberinto == 0 && aukera == 1)
				laberinto = 1;	//Soft laberintoa
			else if (laberinto == 1 && aukera == 1)
				laberinto = 2;	//Empty laberintoa
			setChanged();
			notifyObservers(new int[] {bomberman, laberinto});	//Aukera berriak bistaratzeko mezua
		}
	}
	
	////////////PARTIDA HASI////////////
	@SuppressWarnings("deprecation")
	public void aurreraEgin() {
		LaberintoEredua lE = LaberintoEredua.getLabEredua();	//Laberintoaren Singletona sortu
		lE.setLaberintoMota(LaberintoFactory.getLF().sortuLaberinto(laberinto+1));	//Laberintoaren mota zehaztu
		lE.setBomberman(BombermanFactory.getNireJokalariFactory().sortuJokalari(bomberman+1, 0, 0));	//Bomberman mota zehaztu
		LaberintoBista lBis = new LaberintoBista();	//Bista sortu
		lE.eguneratu();	//Ereduaren lehenengo eguneraketa
		setChanged();
		notifyObservers(new int[] {-1});	//Hasiera pantaila ixteko mezua bidaltzen du
	}
	
	
	
}