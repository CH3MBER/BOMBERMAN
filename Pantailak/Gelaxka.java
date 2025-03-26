package Sprites;

import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Pantailak.GelaxkaEredu;

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
	        	egokitu();
	            }
	        });
	}
	
	private void eguneratu(int arg) {
		switch (arg) {
			case 1:
				argazki = (new ImageIcon(getClass().getResource("BlokeGogorra.png")).getImage());
				break;
			case 2:
				argazki = (new ImageIcon(getClass().getResource("BlokeBiguna.png")).getImage());
				break;	
			case 3:
				argazki = (new ImageIcon(getClass().getResource("Bonba.png")).getImage());
				break;
			case 4:
				argazki = (new ImageIcon(getClass().getResource("Eztanda.png")).getImage());
				break;
			case 5:
				argazki = (new ImageIcon(getClass().getResource("Bonberman.png")).getImage());
				break;
			case 6:
				argazki = (new ImageIcon(getClass().getResource("Ezker1.png")).getImage());
				break;
			case 7:
				argazki = (new ImageIcon(getClass().getResource("Ezker2.png")).getImage());
				break;
			case 8:
				argazki = (new ImageIcon(getClass().getResource("Eskuin1.png")).getImage());
				break;
			case 9:
				argazki = (new ImageIcon(getClass().getResource("Eskuin2.png")).getImage());
				break;
			case 10:
				argazki = (new ImageIcon(getClass().getResource("Behera1.png")).getImage());
				break;
			case 11:
				argazki = (new ImageIcon(getClass().getResource("Behera2.png")).getImage());
				break;
			case 12:
				argazki = (new ImageIcon(getClass().getResource("Gora1.png")).getImage());
				break;
			case 13:
				argazki = (new ImageIcon(getClass().getResource("Gora2.png")).getImage());
				break;
			case 14:
				argazki = (new ImageIcon(getClass().getResource("JokSutan.png")).getImage());
				break;
			case 15:
				argazki = (new ImageIcon(getClass().getResource("BonbaEskuan.png")).getImage());
				break;
			default:
				argazki = null;
				setIcon(null);
				break;
			}
			egokitu();
	}
	
	private void egokitu() {
		if (!(argazki == null) && !((getWidth() <= 0 || getHeight() <= 0))) {
			Image imagenEscalada = argazki.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);
			setIcon(new ImageIcon(imagenEscalada));
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (arg instanceof int[]) {
				eguneratu(((int[])arg)[0]);
		}
	}

}