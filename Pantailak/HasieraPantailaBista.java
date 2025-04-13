package Sprites;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Action;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Pantailak.HasieraPantailaEredu;
import Pantailak.LaberintoEredua;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.CardLayout;
import javax.swing.JLabel;

public class HasieraPantailaBista extends JFrame implements Observer{

	private final JPanel contentPanel = new JPanel();
	private Kontroladorea kontroladore;
	private int labMota = 0;
	private int jokMota = 0;
	
	private JPanel wb1;
	private JPanel wb2;
	private JPanel wb3;
	private JPanel bb1;
	private JPanel bb2;
	private JPanel bb3;
	private JLabel lblNewLabel;
	private JLabel lblSoft;
	private JLabel lblEmpty;
	
	
	public HasieraPantailaBista() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new CardLayout(0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, "name_179309129675200");
		addKeyListener(getKontroladore());
		setLocationRelativeTo(null);	//Lehioa pantaila erdian egoteko
		setVisible(true);
		setResizable(false);
		setFocusable(true);
		contentPanel.setLayout(new CardLayout(0, 0));
		HasieraPantailaEredu.getHPE().addObserver(this);
		
		wb1 = new JPanel(){
	        private Image background = new ImageIcon(getClass().getResource("MenuaWhiteBonber1.jpg")).getImage();
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
		contentPanel.add(wb1, "name_181615658322600");
		wb1.setLayout(null);
		
		lblNewLabel = new JLabel("Classic");
		lblNewLabel.setBounds(314, 186, 70, 23);
		wb1.add(lblNewLabel);
		
		lblSoft = new JLabel("Soft");
		lblSoft.setBounds(314, 206, 70, 23);
		wb1.add(lblSoft);
		
		lblEmpty = new JLabel("Empty");
		lblEmpty.setBounds(314, 228, 70, 23);
		wb1.add(lblEmpty);
		wb1.setVisible(false);
		
		wb2 = new JPanel(){
	        private Image background = new ImageIcon(getClass().getResource("MenuaWhiteBonber2.jpg")).getImage();
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
	    wb2.setBounds(0, 0, 434, 261);
		contentPanel.add(wb2, "White2");
		wb2.setLayout(null);
		
		lblNewLabel = new JLabel("Classic");
		lblNewLabel.setBounds(314, 186, 70, 23);
		wb2.add(lblNewLabel);
		
		lblSoft = new JLabel("Soft");
		lblSoft.setBounds(314, 206, 70, 23);
		wb2.add(lblSoft);
		
		lblEmpty = new JLabel("Empty");
		lblEmpty.setBounds(314, 228, 70, 23);
		wb2.add(lblEmpty);
		wb2.setVisible(false);
		
		wb3 = new JPanel(){
	        private Image background = new ImageIcon(getClass().getResource("MenuaWhiteBonber3.jpg")).getImage();
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
		contentPanel.add(wb3, "name_181615675982700");
		wb3.setLayout(null);
		
		lblNewLabel = new JLabel("Classic");
		lblNewLabel.setBounds(314, 186, 70, 23);
		wb3.add(lblNewLabel);
		
		lblSoft = new JLabel("Soft");
		lblSoft.setBounds(314, 206, 70, 23);
		wb3.add(lblSoft);
		
		lblEmpty = new JLabel("Empty");
		lblEmpty.setBounds(314, 228, 70, 23);
		wb3.add(lblEmpty);
		wb3.setVisible(false);

		bb1 = new JPanel(){
	        private Image background = new ImageIcon(getClass().getResource("MenuaBlackBonber1.jpg")).getImage();
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
		contentPanel.add(bb1, "name_181615694094600");
		bb1.setLayout(null);
		
		lblNewLabel = new JLabel("Classic");
		lblNewLabel.setBounds(314, 186, 70, 23);
		bb1.add(lblNewLabel);
		
		lblSoft = new JLabel("Soft");
		lblSoft.setBounds(314, 206, 70, 23);
		bb1.add(lblSoft);
		
		lblEmpty = new JLabel("Empty");
		lblEmpty.setBounds(314, 228, 70, 23);
		bb1.add(lblEmpty);
		bb1.setVisible(false);

		bb2 = new JPanel(){
	        private Image background = new ImageIcon(getClass().getResource("MenuaBlackBonber2.jpg")).getImage();
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
		contentPanel.add(bb2, "name_181615711540300");
		bb2.setLayout(null);
		
		lblNewLabel = new JLabel("Classic");
		lblNewLabel.setBounds(314, 186, 70, 23);
		bb2.add(lblNewLabel);
		
		lblSoft = new JLabel("Soft");
		lblSoft.setBounds(314, 206, 70, 23);
		bb2.add(lblSoft);
		
		lblEmpty = new JLabel("Empty");
		lblEmpty.setBounds(314, 228, 70, 23);
		bb2.add(lblEmpty);
		bb2.setVisible(false);
		
		bb3 = new JPanel(){
	        private Image background = new ImageIcon(getClass().getResource("MenuaBlackBonber3.jpg")).getImage();
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
		contentPanel.add(bb3, "name_181615728938300");
		bb3.setLayout(null);
		
		lblNewLabel = new JLabel("Classic");
		lblNewLabel.setBounds(314, 186, 70, 23);
		bb3.add(lblNewLabel);
		
		lblSoft = new JLabel("Soft");
		lblSoft.setBounds(314, 206, 70, 23);
		bb3.add(lblSoft);
		
		lblEmpty = new JLabel("Empty");
		lblEmpty.setBounds(314, 228, 70, 23);
		bb3.add(lblEmpty);
		bb3.setVisible(false);
	}


	private void eguneratuPantaila(int i, int j) {
		if(i==0 && j==0) {
			wb1.setVisible(true);
			wb2.setVisible(false);
			wb3.setVisible(false);
			bb1.setVisible(false);
			bb2.setVisible(false);
			bb3.setVisible(false);
		}
		else if(i==1 && j==0) {
			wb1.setVisible(false);
			wb2.setVisible(false);
			wb3.setVisible(false);
			bb1.setVisible(true);
			bb2.setVisible(false);
			bb3.setVisible(false);
		}
		if(i==0 && j==1) {
			wb1.setVisible(false);
			wb2.setVisible(true);
			wb3.setVisible(false);
			bb1.setVisible(false);
			bb2.setVisible(false);
			bb3.setVisible(false);
		}
		else if(i==1 && j==1) {
			wb1.setVisible(false);
			wb2.setVisible(false);
			wb3.setVisible(false);
			bb1.setVisible(false);
			bb2.setVisible(true);
			bb3.setVisible(false);
		}
		if(i==0 && j==2) {
			wb1.setVisible(false);
			wb2.setVisible(false);
			wb3.setVisible(true);
			bb1.setVisible(false);
			bb2.setVisible(false);
			bb3.setVisible(false);
		}
		else if(i==1 && j==2) {
			wb1.setVisible(false);
			wb2.setVisible(false);
			wb3.setVisible(false);
			bb1.setVisible(false);
			bb2.setVisible(false);
			bb3.setVisible(true);
		}
	}
	
	private Kontroladorea getKontroladore() {
		if (kontroladore == null) {
			kontroladore = new Kontroladorea();
		}
		return kontroladore;
	}	

	private class Kontroladorea implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == (KeyEvent.VK_RIGHT)) {
				HasieraPantailaEredu.getHPE().bombermanAukera(1);
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				HasieraPantailaEredu.getHPE().laberintoAukera(-1);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				HasieraPantailaEredu.getHPE().laberintoAukera(1);
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				HasieraPantailaEredu.getHPE().bombermanAukera(-1);
			}
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				HasieraPantailaEredu.getHPE().aurreraEgin();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof int[]) {
			if(((int[])arg)[0]==-1) {
				setVisible(false);
			}
			else
				eguneratuPantaila(((int[])arg)[0], ((int[])arg)[1]);
		}
	}

}