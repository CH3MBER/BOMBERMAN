package Pantailak;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.BorderLayout;
import java.awt.Color;

@SuppressWarnings("deprecation")
public class LaberintoBista extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private static LaberintoBista nLB = null;
	private JPanel contentPane;
	private JPanel matrizea;
	//private int X;
	//private int Y;
	private Kontroladore kontroladore = null;
	//private int kont = 10;
	//private LaberintoEredua eredua;
	//private BlokeZerrenda blokeak;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaberintoBista frame = new LaberintoBista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public LaberintoBista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setFocusable(true);
		matrizea.setOpaque(false);
		LaberintoEredua.getLabEredua().addObserver(this);//Lehioa pantaila erdian egoteko
	}
	
	public static LaberintoBista getLabBista() {
		if(nLB == null) {
			nLB = new LaberintoBista();
		}
		return nLB;
	}
	
	private JPanel sortuLaberintoa() {								//Matrizea hartzen du
		if(matrizea==null) {
			matrizea = new JPanel();
			matrizea.setLayout(new GridLayout(11, 17, 0, 0)); 	//Matrizearen dimentsioak zeintzuk izango diren zehazten ditu
			hasieratuGelaxkak();	//Matrizea sortzen du
		}
		return matrizea;
	}

	private void hasieratuGelaxkak() {
		ArrayList<GelaxkaEredu> lEz = LaberintoEredua.getLabEredua().getGelaZerr();
		for (int i=0; i<lEz.size();i++) {
			//koordenatuakLortu(i);
			GelaxkaEredu eredu = lEz.get(i);
			JLabel label = new Gelaxka(eredu);
			if (lEz.get(i).getTipo()==5) { //LaberintoEredua.getLabEredua().getBomberman().getX()==X && LaberintoEredua.getLabEredua().getBomberman().getY()==Y
				eredu.setTipo(5);
			}
			else if (lEz.get(i).getTipo()==1) {
				eredu.setTipo(1);
			}
			else {
				if (lEz.get(i).getTipo()==2) {//LaberintoEredua.getLabEredua().ausazZenbakia()>0.4 && !((X==0 && Y==0)||(X==0 && Y==1)||(X==1 && Y==0))
					eredu.setTipo(2);
					}
			}
			matrizea.add(label);
		}
	}	
		
	/*private void koordenatuakLortu(int posizioa) {
		if (posizioa<17) {
			X = posizioa;
			Y = 0;
		}
		else {
			X = posizioa%17;
			Y = posizioa/17;
		}
	}*/


	private Kontroladore getKontroladore() {
		if (kontroladore == null) {
			kontroladore = new Kontroladore();
		}
		return kontroladore;
	}
	
	private void mugitu(LaberintoEredua lE) {
		//((JLabel) matrizea.getComponent(getIndex(lE.getBomberman().getAurrekoY(), lE.getBomberman().getAurrekoX()))).setIcon(null);
		
        // Mover la imagen a la nueva posicion
		/*Image argazki = new ImageIcon(this.getClass().getResource("Bonberman.png")).getImage();
		Image scaledImage = argazki.getScaledInstance(matrizea.getComponent(getIndex(lE.getBomberman().getY(),lE.getBomberman().getX())).getWidth(),matrizea.getComponent(getIndex(lE.getBomberman().getY(),lE.getBomberman().getX())).getHeight(),Image.SCALE_DEFAULT);
		((JLabel) matrizea.getComponent(getIndex(lE.getBomberman().getY(),lE.getBomberman().getX()))).setIcon(new ImageIcon(scaledImage));
	*/}
	
	/*private int getIndex(int err, int zut) {
	    return err * 17 + zut;
	}*/
	
	private void borratu(LaberintoEredua lE) {
		//	if(lE.getBomberman().getX()-1>=0) ((JLabel) matrizea.getComponent(getIndex(lE.getBomberman().getY(), lE.getBomberman().getX()-1))).setIcon(null);
		//	if(lE.getBomberman().getX()+1<=16) ((JLabel) matrizea.getComponent(getIndex(lE.getBomberman().getY(), lE.getBomberman().getX()+1))).setIcon(null);
		//	if(lE.getBomberman().getY()-1>=0) ((JLabel) matrizea.getComponent(getIndex(lE.getBomberman().getY()-1, lE.getBomberman().getX()))).setIcon(null);
		//	if(lE.getBomberman().getY()+1<=10) ((JLabel) matrizea.getComponent(getIndex(lE.getBomberman().getY()+1, lE.getBomberman().getX()))).setIcon(null);
			
	}
	
	private class Kontroladore implements KeyListener{
		public void keyPressed(KeyEvent e) {
			LaberintoEredua lE = LaberintoEredua.getLabEredua();
			if (e.getKeyCode() == (KeyEvent.VK_RIGHT)) {
				lE.mugitu(1,0);
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				lE.mugitu(0,-1);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				lE.mugitu(0,1);
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				lE.mugitu(-1,0);
			}
			if (e.getKeyCode() == KeyEvent.VK_A) {
				lE.ingurunea();
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
		LaberintoEredua LE = LaberintoEredua.getLabEredua();
		//LaberintoBista.getLabBista();
		//mugitu(LE);
		//if (LE.getBorratu()) {
			//borratu(LE);
			//LE.kenduBorratu();
		//}
	}
}