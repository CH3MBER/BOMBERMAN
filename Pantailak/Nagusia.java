package Pantailak;

import Sprites.HasieraPantailaBista;
import Sprites.LaberintoBista;

public class Nagusia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//EREDUA//
		HasieraPantailaEredu hpE = HasieraPantailaEredu.getHPE();
		
		//BISTA//
		HasieraPantailaBista hp = new HasieraPantailaBista();
		
		//Eguneraketa
		hpE.eguneratu();
		
		//LaberintoEredua lE = LaberintoEredua.getLabEredua();
		//lE.setLaberintoMota(LaberintoFactory.getLF().sortuLaberinto(2));
		
		//EREDUA//
		/*LaberintoEredua lE = LaberintoEredua.getLabEredua();*/
		//BISTA//
		//LaberintoBista lb = new LaberintoBista();
		
		//Eguneratu
		//lE.eguneratu();
	}

}