package Sprites;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.Action;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Pantailak.LaberintoEredua;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class HasieraPantailaBista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Kontroladorea kontroladore;
	private JRadioButton btnClassic;
	private JRadioButton btnSoft;
	private JRadioButton btnEmpty;
	private JRadioButton btnZuria;
	private JRadioButton btnBeltza;
	private JButton okButton;
	private final ButtonGroup buttonGroupJokalari = new ButtonGroup();
	private final ButtonGroup buttonGroupLaberinto = new ButtonGroup();
	private int labMota = 0;
	private int jokMota = 0;
	
	
	public HasieraPantailaBista() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getRdbClassic());
		contentPanel.add(getRdbSoft());
		contentPanel.add(getRdbEmpty());
		contentPanel.add(getRdbZuria());
		contentPanel.add(getRdbBeltza());
		contentPanel.add(getBtnOK());
		setVisible(true);
	}
	
	private JRadioButton getRdbClassic() {
		if (btnClassic == null) {
			btnClassic = new JRadioButton("Classic");
			btnClassic.addActionListener(getKontroladore());
			buttonGroupLaberinto.add(btnClassic);
			btnClassic.setBounds(81, 44, 101, 23);
		}
		return btnClassic;
	}

	private JRadioButton getRdbSoft() {
		if (btnSoft == null) {
			btnSoft = new JRadioButton("Soft");
			btnSoft.addActionListener(getKontroladore());
			buttonGroupLaberinto.add(btnSoft);
			btnSoft.setBounds(309, 44, 101, 23);
		}
		return btnSoft;
	}	
	
	private JRadioButton getRdbEmpty() {
		if (btnEmpty == null) {
			btnEmpty = new JRadioButton("Empty");
			btnEmpty.addActionListener(getKontroladore());
			buttonGroupLaberinto.add(btnEmpty);
			btnEmpty.setBounds(184, 44, 101, 23);
		}
		return btnEmpty;
	}
	
	private JRadioButton getRdbZuria() {
		if (btnZuria == null) {
			btnZuria = new JRadioButton("Zuria");
			btnEmpty.addActionListener(getKontroladore());
			buttonGroupJokalari.add(btnZuria);
			btnZuria.setBounds(81, 150, 103, 21);
		}
		return btnZuria;
	}
	
	private JRadioButton getRdbBeltza() {
		if (btnBeltza == null) {
			btnBeltza = new JRadioButton("Beltza");
			btnBeltza.addActionListener(getKontroladore());
			buttonGroupJokalari.add(btnBeltza);
			btnBeltza.setBounds(247, 150, 103, 21);
		}
		return btnBeltza;
	}
	
	private JButton getBtnOK() {
		if (okButton == null) {
			okButton = new JButton("OK");
			//okButton.setActionCommand("OK");
			okButton.addActionListener(getKontroladore());
			okButton.setBounds(278, 228, 117, 25);
		}
		return okButton;
	}

	private Kontroladorea getKontroladore() {
		if (kontroladore == null) {
			kontroladore = new Kontroladorea();
		}
		return kontroladore;
	}	

	private class Kontroladorea implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() instanceof JRadioButton) {
	            JRadioButton selectedRadioButton = (JRadioButton) e.getSource();
	            if (selectedRadioButton.equals(btnClassic)) {
	                labMota = 0;
	            } 
	            else if (selectedRadioButton.equals(btnSoft)) {
	                labMota = 1;
	            }
	            else if (selectedRadioButton.equals(btnEmpty)) {
	                labMota = 2;
	            }
	            else if (selectedRadioButton.equals(btnZuria)) {
	                jokMota = 0;
	            }
	            else if (selectedRadioButton.equals(btnBeltza)) {
	                jokMota = 1;
	            }
	        } 
			else if (e.getSource() instanceof JButton) { //Esto hacerlo en el eredu 
	            JButton clickedButton = (JButton) e.getSource();
	            if (clickedButton.equals(okButton)) {
	            	LaberintoEredua.getLabEredua().setAukerak(labMota, jokMota);
	    			LaberintoBista lB = new LaberintoBista();
	    			LaberintoEredua.getLabEredua().eguneratu();
	            	setVisible(false);
	            }
	        }
		}
}
	
}
