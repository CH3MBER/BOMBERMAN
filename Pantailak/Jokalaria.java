package Pantailak;

public class Jokalaria {
  private boolean bizitza;
	private boolean bonbaPrest; 
	private int bonbaKop; 

  //Eraikitzailea
  public Jokalaria (boolean pBizitza, boolean pBonbaPrest, int pBonbaKop) {
		this.bizitza = true;
		this.bonbaPrest = true;
		this.bonbaKop = 10;
  }

  public void HilEgin () {
    //TODO
  }

  public void SpriteAldatu () {
    //TODO
  }

  //Posiblea
  public void BonbaJarri () {
    if (bonbaPrest && bonbaKop > 0) {
      //Bonba bota
      bonbaKop -= 1;

      if (bonbaKop == 0) {
        bonbaPrest = false;
      }
    } 
  }

  public void BonbaBerria () {
    if (/*DenboraPasa*/) {
      bonbaKop += 1;
      
      if (!bonbaPrest) {
        bonbaPrest = true;
      }
    }
  }
  
}
