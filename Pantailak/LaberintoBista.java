package Sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.BorderLayout;
import Pantailak.LaberintoEredua;
import Pantailak.GelaxkaEredu;

@SuppressWarnings({ "deprecation"})
public class LaberintoBista extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel matrizea;
	private Kontroladore kontroladore = null;

	/**
	 * Create the frame.
	 */
	public LaberintoBista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LaberintoEredua.getLabEredua().addObserver(this);
	}
	
	private void inizializatu() {
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel() {
	        private Image background = new ImageIcon(getClass().getResource("Basamortua.png")).getImage();
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(sortuLaberintoa(), BorderLayout.CENTER);
		setContentPane(contentPane);
		addKeyListener(getKontroladore());
		setLocationRelativeTo(null);	//Lehioa pantaila erdian egoteko
		setVisible(true);
		setResizable(false);
		setFocusable(true);
	}
		
	private JPanel sortuLaberintoa() {								//Matrizea hartzen du
		if(matrizea==null) {
			matrizea = new JPanel();
			matrizea.setLayout(new GridLayout(11, 17, 0, 0)); 	//Matrizearen dimentsioak zeintzuk izango diren zehazten ditu
			hasieratuGelaxkak();	//Matrizea sortzen du
			matrizea.setOpaque(false);
		}
		return matrizea;
	}

	private void hasieratuGelaxkak() {
		ArrayList<GelaxkaEredu> lEz = LaberintoEredua.getLabEredua().getLabMota().getGelaZerr().erakutsiGelaxkaGuztiak();
		for (int i=0; i<lEz.size();i++) {
			Gelaxka label = new Gelaxka(lEz.get(i));
			matrizea.add(label);
		}
	}

	private Kontroladore getKontroladore() {
		if (kontroladore == null) {
			kontroladore = new Kontroladore();
		}
		return kontroladore;
	}
	
	private class Kontroladore implements KeyListener{
		public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == (KeyEvent.VK_RIGHT)) {
					LaberintoEredua.getLabEredua().mugitu(1,0);
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					LaberintoEredua.getLabEredua().mugitu(0,-1);
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					LaberintoEredua.getLabEredua().mugitu(0,1);
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					LaberintoEredua.getLabEredua().mugitu(-1,0);
				}
				if (e.getKeyCode() == KeyEvent.VK_A) {
					LaberintoEredua.getLabEredua().bonbaJarri();
				}
		}
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}
	
}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (arg instanceof int[]) {
			if(((int[])arg)[0]==1) {
				inizializatu();
			}
		}
	}
}