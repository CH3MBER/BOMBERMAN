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
import java.awt.Color;

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
	private JPanel rb1;
	private JPanel rb2;
	private JPanel rb3;
	private JPanel cb1;
	private JPanel cb2;
	private JPanel cb3;
	private JLabel lblClassic;
	private JLabel lblSoft;
	private JLabel lblEmpty;
	
	
	@SuppressWarnings("deprecation")
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
	        private Image background = new ImageIcon(getClass().getResource("WhiteBomber1.png")).getImage();
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
		contentPanel.add(wb1, "name_181615658322600");
		wb1.setLayout(null);
		
		lblClassic = new JLabel("Classic");
		lblClassic.setForeground(new Color(255, 255, 255));
		lblClassic.setBounds(344, 192, 70, 23);
		wb1.add(lblClassic);
		
		lblSoft = new JLabel("Soft");
		lblSoft.setForeground(new Color(255, 255, 255));
		lblSoft.setBounds(344, 210, 70, 23);
		wb1.add(lblSoft);
		
		lblEmpty = new JLabel("Empty");
		lblEmpty.setForeground(new Color(255, 255, 255));
		lblEmpty.setBounds(344, 228, 70, 23);
		wb1.add(lblEmpty);
		wb1.setVisible(false);
		
		wb2 = new JPanel(){
	        private Image background = new ImageIcon(getClass().getResource("WhiteBomber2.png")).getImage();
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
	    wb2.setBounds(0, 0, 434, 261);
		contentPanel.add(wb2, "White2");
		wb2.setLayout(null);
		
		lblClassic = new JLabel("Classic");
		lblClassic.setForeground(new Color(255, 255, 255));
		lblClassic.setBounds(344, 192, 70, 23);
		wb2.add(lblClassic);
		
		lblSoft = new JLabel("Soft");
		lblSoft.setForeground(new Color(255, 255, 255));
		lblSoft.setBounds(344, 210, 70, 23);
		wb2.add(lblSoft);
		
		lblEmpty = new JLabel("Empty");
		lblEmpty.setForeground(new Color(255, 255, 255));
		lblEmpty.setBounds(344, 228, 70, 23);
		wb2.add(lblEmpty);
		wb2.setVisible(false);
		
		wb3 = new JPanel(){
	        private Image background = new ImageIcon(getClass().getResource("WhiteBomber3.png")).getImage();
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
		contentPanel.add(wb3, "name_181615675982700");
		wb3.setLayout(null);
		
		lblClassic = new JLabel("Classic");
		lblClassic.setForeground(new Color(255, 255, 255));
		lblClassic.setBounds(344, 192, 70, 23);
		wb3.add(lblClassic);
		
		lblSoft = new JLabel("Soft");
		lblSoft.setForeground(new Color(255, 255, 255));
		lblSoft.setBounds(344, 210, 70, 23);
		wb3.add(lblSoft);
		
		lblEmpty = new JLabel("Empty");
		lblEmpty.setForeground(new Color(255, 255, 255));
		lblEmpty.setBounds(344, 228, 70, 23);
		wb3.add(lblEmpty);
		wb3.setVisible(false);

		bb1 = new JPanel(){
	        private Image background = new ImageIcon(getClass().getResource("BlackBomber1.png")).getImage();
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
		contentPanel.add(bb1, "name_181615694094600");
		bb1.setLayout(null);
		
		lblClassic = new JLabel("Classic");
		lblClassic.setForeground(new Color(255, 255, 255));
		lblClassic.setBounds(344, 192, 70, 23);
		bb1.add(lblClassic);
		
		lblSoft = new JLabel("Soft");
		lblSoft.setForeground(new Color(255, 255, 255));
		lblSoft.setBounds(344, 210, 70, 23);
		bb1.add(lblSoft);
		
		lblEmpty = new JLabel("Empty");
		lblEmpty.setForeground(new Color(255, 255, 255));
		lblEmpty.setBounds(344, 228, 70, 23);
		bb1.add(lblEmpty);
		bb1.setVisible(false);

		bb2 = new JPanel(){
	        private Image background = new ImageIcon(getClass().getResource("BlackBomber2.png")).getImage();
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
		contentPanel.add(bb2, "name_181615711540300");
		bb2.setLayout(null);
		
		lblClassic = new JLabel("Classic");
		lblClassic.setForeground(new Color(255, 255, 255));
		lblClassic.setBounds(344, 192, 70, 23);
		bb2.add(lblClassic);
		
		lblSoft = new JLabel("Soft");
		lblSoft.setForeground(new Color(255, 255, 255));
		lblSoft.setBounds(344, 210, 70, 23);
		bb2.add(lblSoft);
		
		lblEmpty = new JLabel("Empty");
		lblEmpty.setForeground(new Color(255, 255, 255));
		lblEmpty.setBounds(344, 228, 70, 23);
		bb2.add(lblEmpty);
		bb2.setVisible(false);
		
		bb3 = new JPanel(){
	        private Image background = new ImageIcon(getClass().getResource("BlackBomber3.png")).getImage();
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
		contentPanel.add(bb3, "name_181615728938300");
		bb3.setLayout(null);
		
		lblClassic = new JLabel("Classic");
		lblClassic.setForeground(new Color(255, 255, 255));
		lblClassic.setBounds(344, 192, 70, 23);
		bb3.add(lblClassic);
		
		lblSoft = new JLabel("Soft");
		lblSoft.setForeground(new Color(255, 255, 255));
		lblSoft.setBounds(344, 210, 70, 23);
		bb3.add(lblSoft);
		
		lblEmpty = new JLabel("Empty");
		lblEmpty.setForeground(new Color(255, 255, 255));
		lblEmpty.setBounds(344, 228, 70, 23);
		bb3.add(lblEmpty);
		bb3.setVisible(false);
		
		cb1 = new JPanel(){
	        private Image background = new ImageIcon(getClass().getResource("BlueBomber1.png")).getImage();
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
		contentPanel.add(cb1, "name_181615658322600");
		cb1.setLayout(null);
		
		lblClassic = new JLabel("Classic");
		lblClassic.setForeground(new Color(255, 255, 255));
		lblClassic.setBounds(344, 192, 70, 23);
		cb1.add(lblClassic);
		
		lblSoft = new JLabel("Soft");
		lblSoft.setForeground(new Color(255, 255, 255));
		lblSoft.setBounds(344, 210, 70, 23);
		cb1.add(lblSoft);
		
		lblEmpty = new JLabel("Empty");
		lblEmpty.setForeground(new Color(255, 255, 255));
		lblEmpty.setBounds(344, 228, 70, 23);
		cb1.add(lblEmpty);
		cb1.setVisible(false);
		
		cb2 = new JPanel(){
	        private Image background = new ImageIcon(getClass().getResource("BlueBomber2.png")).getImage();
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
	    cb2.setBounds(0, 0, 434, 261);
		contentPanel.add(cb2, "White2");
		cb2.setLayout(null);
		
		lblClassic = new JLabel("Classic");
		lblClassic.setForeground(new Color(255, 255, 255));
		lblClassic.setBounds(344, 192, 70, 23);
		cb2.add(lblClassic);
		
		lblSoft = new JLabel("Soft");
		lblSoft.setForeground(new Color(255, 255, 255));
		lblSoft.setBounds(344, 210, 70, 23);
		cb2.add(lblSoft);
		
		lblEmpty = new JLabel("Empty");
		lblEmpty.setForeground(new Color(255, 255, 255));
		lblEmpty.setBounds(344, 228, 70, 23);
		cb2.add(lblEmpty);
		cb2.setVisible(false);
		
		cb3 = new JPanel(){
	        private Image background = new ImageIcon(getClass().getResource("BlueBomber3.png")).getImage();
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
		contentPanel.add(cb3, "name_181615675982700");
		cb3.setLayout(null);
		
		lblClassic = new JLabel("Classic");
		lblClassic.setForeground(new Color(255, 255, 255));
		lblClassic.setBounds(344, 192, 70, 23);
		cb3.add(lblClassic);
		
		lblSoft = new JLabel("Soft");
		lblSoft.setForeground(new Color(255, 255, 255));
		lblSoft.setBounds(344, 210, 70, 23);
		cb3.add(lblSoft);
		
		lblEmpty = new JLabel("Empty");
		lblEmpty.setForeground(new Color(255, 255, 255));
		lblEmpty.setBounds(344, 228, 70, 23);
		cb3.add(lblEmpty);
		cb3.setVisible(false);

		rb1 = new JPanel(){
	        private Image background = new ImageIcon(getClass().getResource("RedBomber1.png")).getImage();
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
		contentPanel.add(rb1, "name_181615694094600");
		rb1.setLayout(null);
		
		lblClassic = new JLabel("Classic");
		lblClassic.setForeground(new Color(255, 255, 255));
		lblClassic.setBounds(344, 192, 70, 23);
		rb1.add(lblClassic);
		
		lblSoft = new JLabel("Soft");
		lblSoft.setForeground(new Color(255, 255, 255));
		lblSoft.setBounds(344, 210, 70, 23);
		rb1.add(lblSoft);
		
		lblEmpty = new JLabel("Empty");
		lblEmpty.setForeground(new Color(255, 255, 255));
		lblEmpty.setBounds(344, 228, 70, 23);
		rb1.add(lblEmpty);
		rb1.setVisible(false);

		rb2 = new JPanel(){
	        private Image background = new ImageIcon(getClass().getResource("RedBomber2.png")).getImage();
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
		contentPanel.add(rb2, "name_181615711540300");
		rb2.setLayout(null);
		
		lblClassic = new JLabel("Classic");
		lblClassic.setForeground(new Color(255, 255, 255));
		lblClassic.setBounds(344, 192, 70, 23);
		rb2.add(lblClassic);
		
		lblSoft = new JLabel("Soft");
		lblSoft.setForeground(new Color(255, 255, 255));
		lblSoft.setBounds(344, 210, 70, 23);
		rb2.add(lblSoft);
		
		lblEmpty = new JLabel("Empty");
		lblEmpty.setForeground(new Color(255, 255, 255));
		lblEmpty.setBounds(344, 228, 70, 23);
		rb2.add(lblEmpty);
		rb2.setVisible(false);
		
		rb3 = new JPanel(){
	        private Image background = new ImageIcon(getClass().getResource("RedBomber3.png")).getImage();
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
		contentPanel.add(rb3, "name_181615728938300");
		rb3.setLayout(null);
		
		lblClassic = new JLabel("Classic");
		lblClassic.setForeground(new Color(255, 255, 255));
		lblClassic.setBounds(344, 192, 70, 23);
		rb3.add(lblClassic);
		
		lblSoft = new JLabel("Soft");
		lblSoft.setForeground(new Color(255, 255, 255));
		lblSoft.setBounds(344, 210, 70, 23);
		rb3.add(lblSoft);
		
		lblEmpty = new JLabel("Empty");
		lblEmpty.setForeground(new Color(255, 255, 255));
		lblEmpty.setBounds(344, 228, 70, 23);
		rb3.add(lblEmpty);
		rb3.setVisible(false);
	}


	private void eguneratuPantaila(int i, int j) {
		if(i==0 && j==0) {
			wb1.setVisible(true);
			wb2.setVisible(false);
			wb3.setVisible(false);
			bb1.setVisible(false);
			bb2.setVisible(false);
			bb3.setVisible(false);
			cb1.setVisible(false);
			cb2.setVisible(false);
			cb3.setVisible(false);
			rb1.setVisible(false);
			rb2.setVisible(false);
			rb3.setVisible(false);
		}
		else if(i==1 && j==0) {
			wb1.setVisible(false);
			wb2.setVisible(false);
			wb3.setVisible(false);
			bb1.setVisible(false);
			bb2.setVisible(false);
			bb3.setVisible(false);
			cb1.setVisible(true);
			cb2.setVisible(false);
			cb3.setVisible(false);
			rb1.setVisible(false);
			rb2.setVisible(false);
			rb3.setVisible(false);
		}
		else if(i==2 && j==0) {
			wb1.setVisible(false);
			wb2.setVisible(false);
			wb3.setVisible(false);
			bb1.setVisible(false);
			bb2.setVisible(false);
			bb3.setVisible(false);
			cb1.setVisible(false);
			cb2.setVisible(false);
			cb3.setVisible(false);
			rb1.setVisible(true);
			rb2.setVisible(false);
			rb3.setVisible(false);
		}
		else if(i==3 && j==0) {
			wb1.setVisible(false);
			wb2.setVisible(false);
			wb3.setVisible(false);
			bb1.setVisible(true);
			bb2.setVisible(false);
			bb3.setVisible(false);
			cb1.setVisible(false);
			cb2.setVisible(false);
			cb3.setVisible(false);
			rb1.setVisible(false);
			rb2.setVisible(false);
			rb3.setVisible(false);
		}
		
		else if(i==0 && j==1) {
			wb1.setVisible(false);
			wb2.setVisible(true);
			wb3.setVisible(false);
			bb1.setVisible(false);
			bb2.setVisible(false);
			bb3.setVisible(false);
			cb1.setVisible(false);
			cb2.setVisible(false);
			cb3.setVisible(false);
			rb1.setVisible(false);
			rb2.setVisible(false);
			rb3.setVisible(false);
		}
		else if(i==1 && j==1) {
			wb1.setVisible(false);
			wb2.setVisible(false);
			wb3.setVisible(false);
			bb1.setVisible(false);
			bb2.setVisible(false);
			bb3.setVisible(false);
			cb1.setVisible(false);
			cb2.setVisible(true);
			cb3.setVisible(false);
			rb1.setVisible(false);
			rb2.setVisible(false);
			rb3.setVisible(false);
		}
		else if(i==2 && j==1) {
			wb1.setVisible(false);
			wb2.setVisible(false);
			wb3.setVisible(false);
			bb1.setVisible(false);
			bb2.setVisible(false);
			bb3.setVisible(false);
			cb1.setVisible(false);
			cb2.setVisible(false);
			cb3.setVisible(false);
			rb1.setVisible(false);
			rb2.setVisible(true);
			rb3.setVisible(false);
		}
		else if(i==3 && j==1) {
			wb1.setVisible(false);
			wb2.setVisible(false);
			wb3.setVisible(false);
			bb1.setVisible(false);
			bb2.setVisible(true);
			bb3.setVisible(false);
			cb1.setVisible(false);
			cb2.setVisible(false);
			cb3.setVisible(false);
			rb1.setVisible(false);
			rb2.setVisible(false);
			rb3.setVisible(false);
		}
		
		else if(i==0 && j==2) {
			wb1.setVisible(false);
			wb2.setVisible(false);
			wb3.setVisible(true);
			bb1.setVisible(false);
			bb2.setVisible(false);
			bb3.setVisible(false);
			cb1.setVisible(false);
			cb2.setVisible(false);
			cb3.setVisible(false);
			rb1.setVisible(false);
			rb2.setVisible(false);
			rb3.setVisible(false);
		}
		else if(i==1 && j==2) {
			wb1.setVisible(false);
			wb2.setVisible(false);
			wb3.setVisible(false);
			bb1.setVisible(false);
			bb2.setVisible(false);
			bb3.setVisible(false);
			cb1.setVisible(false);
			cb2.setVisible(false);
			cb3.setVisible(true);
			rb1.setVisible(false);
			rb2.setVisible(false);
			rb3.setVisible(false);
		}
		else if(i==2 && j==2) {
			wb1.setVisible(false);
			wb2.setVisible(false);
			wb3.setVisible(false);
			bb1.setVisible(false);
			bb2.setVisible(false);
			bb3.setVisible(false);
			cb1.setVisible(false);
			cb2.setVisible(false);
			cb3.setVisible(false);
			rb1.setVisible(false);
			rb2.setVisible(false);
			rb3.setVisible(true);
		}
		else if(i==3 && j==2) {
			wb1.setVisible(false);
			wb2.setVisible(false);
			wb3.setVisible(false);
			bb1.setVisible(false);
			bb2.setVisible(false);
			bb3.setVisible(true);
			cb1.setVisible(false);
			cb2.setVisible(false);
			cb3.setVisible(false);
			rb1.setVisible(false);
			rb2.setVisible(false);
			rb3.setVisible(false);
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
