package bomberman;

public class BihotzaEfektua implements PowerUpEfektua {

	public void efektuaEman(Bomberman pb) {
		int biziKop = pb.getBizitzak();
		pb.setBizitzak(biziKop +1);  //Bombermanak dituen bizitzei, bat gehitzen die.
		
		}
}
	
