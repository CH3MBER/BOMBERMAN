package Pantailak;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class GelaxkaEredu extends Observable{

    private int mota;

    public GelaxkaEredu(int pMota) {
        this.mota = pMota;
    }

    public int getTipo() {
        return mota;
    }

    public void setTipo(int nuevoTipo) {
        this.mota = nuevoTipo;
        setChanged();
        notifyObservers();
    }
}
