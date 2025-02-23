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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.Color;

public class Laberintoa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel matrizea;
	private ArrayList<JLabel> gelaxkaZerrenda = null;			//Gelaxkak bilduko dituen kolekzioa

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Laberintoa frame = new Laberintoa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Laberintoa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getMatrizea(), BorderLayout.CENTER);
		setLocationRelativeTo(null); 							//Lehioa pantaila erdian egoteko
	}
	
	private JPanel getMatrizea() {								//Matrizea hartzen du
		if(matrizea==null) {
			matrizea = new JPanel();
			matrizea.setLayout(new GridLayout(11, 17, 0, 0)); 	//Matrizearen dimentsioak zeintzuk izango diren zehazten ditu
			matrizeaSortu();									//Matrizea sortzen du
		}
		return matrizea;
	}
	private void matrizeaSortu() { 								//Matrizea sortzen du
		int lerro, zutabe;
		for(lerro=0;lerro<11;lerro++) {
			for(zutabe=0;zutabe<17;zutabe++) {
				JLabel label = getLbl(lerro, zutabe);
				matrizea.add(label);
				getGelaZerr().add(label); 						//Gelaxkak kolekzioan sartzen ditu
			}
		}
	}
	
	private JLabel getLbl(int pL, int pZ) {
		JLabel lblNewLabel;
		if (pL%2!=0 && pZ%2!=0) {
			lblNewLabel = new JLabel();
			//lblNewLabel.setOpaque(true);
			//lblNewLabel.setBackground(Color.blue);
			//lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.black));
			Image argazki = new ImageIcon(this.getClass().getResource("hard5.png")).getImage();
			lblNewLabel.addComponentListener(new ComponentAdapter() { //Creo que habria que cambiar esto 
	            @Override
	            public void componentResized(ComponentEvent e) {
	                if (lblNewLabel.getWidth() > 0 && lblNewLabel.getHeight() > 0) {
	                    Image scaledImage = argazki.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT);
	                    lblNewLabel.setIcon(new ImageIcon(scaledImage));
	                }
	            }
	        });
		}
		else {
			lblNewLabel = new JLabel();
			//lblNewLabel.setOpaque(true);
			//lblNewLabel.setBackground(Color.CYAN);
			//lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.black));
			if (ausazZenbakia()>0.4 && !((pL==0 && pZ==0)||(pL==0 && pZ==1)||(pL==1 && pZ==0))) {
				Image argazki = new ImageIcon(this.getClass().getResource("soft1.png")).getImage();
				lblNewLabel.addComponentListener(new ComponentAdapter() { //Creo que habria que cambiar esto 
		            @Override
		            public void componentResized(ComponentEvent e) {
		                if (lblNewLabel.getWidth() > 0 && lblNewLabel.getHeight() > 0) {
		                    Image scaledImage = argazki.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT);
		                    lblNewLabel.setIcon(new ImageIcon(scaledImage));
		                }
		            }
		        });
			}
		}
		return lblNewLabel;
	}
	
	private ArrayList<JLabel> getGelaZerr() {
		if (gelaxkaZerrenda == null) {
			gelaxkaZerrenda = new ArrayList<>();
		}
		return gelaxkaZerrenda;
	}
	
	private double ausazZenbakia() {								//Ausaz zenbaki bat aukeratzen du, bloke biguna edo etsai bat sortzeko
		Random ram = new Random();
		double aukera = ram.nextDouble(1);
		//System.out.print("\n"+aukera);
		return aukera;
	}
	
	
}
