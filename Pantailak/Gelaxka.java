package Pantailak;

import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("deprecation")
public class Gelaxka extends JLabel implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GelaxkaEredu gelEredu;
	private Image argazki; 
	
	public Gelaxka(GelaxkaEredu pGelEredu) {
		this.gelEredu = pGelEredu;
		this.gelEredu.addObserver(this);
	    addComponentListener(new ComponentAdapter() {
	    	@Override
	    	public void componentResized(ComponentEvent e) {
	        	dimentsionatu();
	            }
	        });
	}
	
	private void actualizar() {
		switch (gelEredu.getTipo()) {
			case 1:
				argazki = (new ImageIcon(getClass().getResource("BlokeGogorra.png")).getImage());
				break;
			case 2:
				argazki = (new ImageIcon(getClass().getResource("BlokeBiguna.png")).getImage());
				break;	
			case 5:
				argazki = (new ImageIcon(getClass().getResource("Bonberman.png")).getImage());
				break;
			case 6:
				argazki = (new ImageIcon(getClass().getResource("whiteleft1.png")).getImage());
				break;
			case 7:
				argazki = (new ImageIcon(getClass().getResource("whiteright2.png")).getImage());
				break;
			case 8:
				argazki = (new ImageIcon(getClass().getResource("whiteup4.png")).getImage());
				break;
			case 9:
				argazki = (new ImageIcon(getClass().getResource("whitedown1.png")).getImage());
				break;
			case 10:
				argazki = (new ImageIcon(getClass().getResource("whiteup3.png")).getImage());
				break;
			default:
				argazki = null;
				setIcon(null);
				break;
			}
			dimentsionatu();
	}
	
	private void dimentsionatu() {
		if (!(argazki == null) && !((getWidth() <= 0 || getHeight() <= 0))) {
			Image imagenEscalada = argazki.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);
			setIcon(new ImageIcon(imagenEscalada));
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		actualizar();
	}

}
