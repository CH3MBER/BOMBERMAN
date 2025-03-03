package Pantailak;

import java.awt.EventQueue;
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
	private JPanel contentPane;
	private JPanel matrizea;
	private int X;
	private int Y;
	private JokalariBista bomberman;
	private Kontroladore kontroladore = null;
	private int kont = 10;
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(sortuLaberintoa(), BorderLayout.CENTER);
		addKeyListener(getKontroladore());
		setLocationRelativeTo(null);
		setVisible(true);
		setFocusable(true);
		LaberintoEredua.getLabEredua().addObserver(this);//Lehioa pantaila erdian egoteko
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
		for (int i=0; i<LaberintoEredua.getLabEredua().getGelaZerr().size();i++) {
			koordenatuakLortu(i);
			JLabel label = LaberintoEredua.getLabEredua().getGelaZerr().get(i);
			if (X==0 && Y==0) { //LaberintoEredua.getLabEredua().getBomberman().getX()==X && LaberintoEredua.getLabEredua().getBomberman().getY()==Y
				Image argazki = new ImageIcon(this.getClass().getResource("WhiteFront1.png")).getImage();
				label.addComponentListener(new ComponentAdapter() { //Creo que habria que cambiar esto 
		            @Override
		            public void componentResized(ComponentEvent e) {
		                if (label.getWidth() > 0 && label.getHeight() > 0) {
		                    Image scaledImage = argazki.getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_DEFAULT);;
		                    label.setIcon(new ImageIcon(scaledImage));
		                }
		            }
		        });
				//label.addKeyListener(getKontroladore());
			}
			else if (X%2!=0 && Y%2!=0) {
				Image argazki = new ImageIcon(this.getClass().getResource("BlokeGogorra.png")).getImage();
				label.addComponentListener(new ComponentAdapter() { //Creo que habria que cambiar esto 
		            public void componentResized(ComponentEvent e) {
		                if (label.getWidth() > 0 && label.getHeight() > 0) {
		                    Image scaledImage = argazki.getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_DEFAULT);
		                    label.setIcon(new ImageIcon(scaledImage));
		                }
		            }
		         });
			}
			else {
				if (LaberintoEredua.getLabEredua().ausazZenbakia()>0.4 && !((X==0 && Y==0)||(X==0 && Y==1)||(X==1 && Y==0))) {
					Image argazki = new ImageIcon(this.getClass().getResource("BlokeBiguna.png")).getImage();
					label.addComponentListener(new ComponentAdapter() { //Creo que habria que cambiar esto 
			            @Override
			            public void componentResized(ComponentEvent e) {
			                if (label.getWidth() > 0 && label.getHeight() > 0) {
			                    Image scaledImage = argazki.getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_DEFAULT);
			                    label.setIcon(new ImageIcon(scaledImage));
			                }
			            }
			        });
				}
			}
			matrizea.add(label);
		}
	}	
		
	private void koordenatuakLortu(int posizioa) {
		if (posizioa<17) {
			X = posizioa;
			Y = 0;
		}
		else {
			X = posizioa%17;
			Y = posizioa/17;
		}
	}


	private Kontroladore getKontroladore() {
		if (kontroladore == null) {
			kontroladore = new Kontroladore();
		}
		return kontroladore;
	}
	
	private void mugitu(LaberintoEredua lE) {
		/*TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				updateKont();
			}		
		};
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 50);
		*/
		((JLabel) matrizea.getComponent(getIndex(lE.getBomberman().getAurrekoX(), lE.getBomberman().getAurrekoY()))).setIcon(null);
		
        // Mover la imagen a la nueva posicion
		Image argazki = new ImageIcon(this.getClass().getResource("whitefront1.png")).getImage();
		Image scaledImage = argazki.getScaledInstance(matrizea.getComponent(getIndex(lE.getBomberman().getX(),lE.getBomberman().getY())).getWidth(),matrizea.getComponent(getIndex(lE.getBomberman().getX(),lE.getBomberman().getY())).getHeight(),Image.SCALE_DEFAULT);
		((JLabel) matrizea.getComponent(getIndex(lE.getBomberman().getX(),lE.getBomberman().getY()))).setIcon(new ImageIcon(scaledImage));
	}
	
	/*private void updateKont() {
		kont--;
		if (kont == 0) {
			Image argazki = new ImageIcon(this.getClass().getResource("blackdown4.png")).getImage();
			Image scaledImage = argazki.getScaledInstance(matrizea.getComponent(getIndex(0,0)).getWidth(),matrizea.getComponent(getIndex(0,0)).getHeight(),Image.SCALE_DEFAULT);
			((JLabel) matrizea.getComponent(getIndex(0,1))).setIcon(new ImageIcon(scaledImage));
		}
	}*/
	
	
	private int getIndex(int fila, int columna) {
	    return fila * 17 + columna;
	}
	
	private class Kontroladore implements KeyListener{
		public void keyPressed(KeyEvent e) {
			LaberintoEredua lE = LaberintoEredua.getLabEredua();
			if (e.getKeyCode() == (KeyEvent.VK_RIGHT)) {
				lE.mugitu(0,1);
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				lE.mugitu(0,-17);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				lE.mugitu(0,17);
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				lE.mugitu(0,-1);
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
		mugitu(LE);
	}
}