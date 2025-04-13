package bomberman;

public class JokalariFactory {
	private static JokalariFactory nireJokalariFactory;
	
	
	private JokalariFactory() {
		
	}
	
	public JokalariFactory getNireJokalariFactory() {
		if (nireJokalariFactory == null) {
			nireJokalariFactory = new JokalariFactory();
		}
		return nireJokalariFactory;
	}
	
	public JokalariEredu sortuJokalari(int i, int pX, int pY) {
		JokalariEredu bomberman = null;
		if(i == 1) {         //bomberman txuria sortu
			bomberman = new BombermanTxuria(pX,pY);
		}
		else if (i == 2) {   //bomberman beltza sortu
			bomberman = new BombermanBeltza(pX, pY);
		}
		return bomberman;
	}

}
