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
import java.awt.BorderLayout;
import java.awt.Color;

public class Laberintoa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel matrizea;

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
		//contentPane.setLayout(new GridLayout(11, 17, 0, 0));
		contentPane.add(getMatrizea(), BorderLayout.CENTER);
		setLocationRelativeTo(null);
	}
	
	private JPanel getMatrizea() {
		if(matrizea==null) {
			matrizea = new JPanel();
			matrizea.setLayout(new GridLayout(11, 17, 0, 0));
			matrizeaSortu();
		}
		return matrizea;
	}
	private void matrizeaSortu() {
		int ler, zut;
		for(ler=0;ler<11;ler++) {
			for(zut=0;zut<17;zut++) {
				matrizea.add(getLbl(ler, zut));
				//matrizea.setBackground(Color.blue);
			}
		}
	}
	
	private JLabel getLbl(int pL, int pZ) {
		JLabel lblNewLabel;
		if (pL%2!=0 && pZ%2!=0) {
			lblNewLabel = new JLabel("Bloke Gogorra");
			//lblNewLabel.setOpaque(true);
			//lblNewLabel.setBackground(Color.blue);
			lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.black));
			ImageIcon argazki = new ImageIcon(this.getClass().getResource("hard5.png"));
			Image icon = argazki.getImage();
			lblNewLabel.addComponentListener(new ComponentAdapter() { //Creo que habria que cambiar esto 
	            @Override
	            public void componentResized(ComponentEvent e) {
	                if (lblNewLabel.getWidth() > 0 && lblNewLabel.getHeight() > 0) {
	                    Image scaledImage = argazki.getImage().getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT);
	                    lblNewLabel.setIcon(new ImageIcon(scaledImage));
	                }
	            }
	        });
			
			
			
			ImageIcon argazkiBerria = new ImageIcon(icon);
			lblNewLabel.setIcon(argazkiBerria);
		}
		else {
			lblNewLabel = new JLabel("L"+pL+"Z"+pZ);
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(Color.CYAN);
			lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		}
		return lblNewLabel;
	}
}
