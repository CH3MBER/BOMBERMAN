package Pantailak;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class GelaxkaEredu extends Observable{

    private int mota;

    public GelaxkaEredu(int pMota) {
        this.mota = pMota;
    }

    public int getMota() {
        return mota;
    }

    public void setMota(int motaBerria) {
        this.mota = motaBerria;
        setChanged();
        notifyObservers(new int[] {motaBerria});
    }
    
    public void eguneratu(int i)
    {
		setChanged();
		notifyObservers(new int[] {i});
	}
}
