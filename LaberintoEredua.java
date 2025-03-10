package Pantailak;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import javax.swing.JLabel;

@SuppressWarnings("deprecation")
public class LaberintoEredua extends Observable{
	
	private static LaberintoEredua nLE = null;
	private ArrayList<GelaxkaEredu> gelaxkaZerrenda = null;//Gelaxkak bilduko dituen kolekzioa
	private final int zutabe = 17;
	private final int errenkada = 11;
	private JokalariEredu bonberman;
	private boolean borratu = false;
	
	private LaberintoEredua() {
		//gelaxkaZerrenda = new int[zutabe*errenkada];
		matrizeaSortu();
		this.bonberman = new JokalariEredu(0,0);
		setChanged();
		notifyObservers();
	}
	
	private void matrizeaSortu() { 								//Matrizea sortzen du
		int lerro, zut;
		for(lerro=0;lerro<errenkada;lerro++) {
			for(zut=0;zut<zutabe;zut++) {
				GelaxkaEredu gel = null;
				int i = zut%17;
				int pos = 17*lerro+zut;
				if (i%2!=0 && lerro%2!=0) {
					gel = new GelaxkaEredu(1);
					getGelaZerr().add(gel);//gelaxkaZerrenda[pos] = 1; //Bloke Gogorra
				}
				else if (ausazZenbakia()>0.4 && !((lerro==0 && zut==0)||(lerro==0 && zut==1)||(lerro==1 && zut==0))){
					gel = new GelaxkaEredu(2);
					getGelaZerr().add(gel); //Bloke Biguna
				}
				else if (lerro==0 && zut==0) {
					gel = new GelaxkaEredu(5);
					getGelaZerr().add(gel);
				}
				else {
					gel = new GelaxkaEredu(0);
					getGelaZerr().add(gel); //Hutsik
				}
				//System.out.print("\n"+pos);
				//getGelaZerr().add(new JLabel());//Gelaxkak kolekzioan sartzen ditu
			}
		}
	}
	
	public double ausazZenbakia() {								//Ausaz zenbaki bat aukeratzen du, bloke biguna edo etsai bat sortzeko
		Random ram = new Random();
		double aukera = ram.nextDouble();
		//System.out.print("\n"+aukera);
		return aukera;
	}
	
	public static LaberintoEredua getLabEredua() {
		if (nLE == null) {
			nLE = new LaberintoEredua();
		}
		return nLE;
	}

	public ArrayList<GelaxkaEredu> getGelaZerr() {
		if(gelaxkaZerrenda == null) {
			gelaxkaZerrenda = new ArrayList<>();
		}
		return gelaxkaZerrenda;
	}
	
	public JokalariEredu getBomberman() {
		return this.bonberman;
	}
	
	public void mugitu(int i, int j) {
		if (!((this.bonberman.getX()+i<0) || (this.bonberman.getY()+j<0) || (this.bonberman.getX()+i>16) || (this.bonberman.getY()+j>10))){
			if(!((getGelaZerr().get((this.bonberman.getY()+j)*17+this.bonberman.getX()+i).getTipo() == 1) || (getGelaZerr().get((this.bonberman.getY()+j)*17+this.bonberman.getX()+i).getTipo() == 2))) {
				this.bonberman.setAurrekoY(this.bonberman.getY());
				this.bonberman.setY(this.bonberman.getY()+j);
				this.bonberman.setAurrekoX(this.bonberman.getX());
				this.bonberman.setX(this.bonberman.getX()+i);
				getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setTipo(5);
				getGelaZerr().get((this.bonberman.getAurrekoY())*17+this.bonberman.getAurrekoX()).setTipo(0);
			}	
		}
		
		switch (i){
		case 0:
			getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setTipo(getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).getTipo());
			break;
		case -1:
			getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setTipo(6);
			break;
		case 1:
			getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setTipo(7);
			break;
		}
		switch (j){
		case 0:
			getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setTipo(getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).getTipo());
			break;
		case -1:
			getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setTipo(8);
			break;
		case 1:
			getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()).setTipo(9);
			break;
		}
		setChanged();
		notifyObservers();
	}
	
	public boolean getBorratu() {
		return this.borratu;
	}
	
	public boolean kenduBorratu() {
		return this.borratu = false;
	}
	
	public void ingurunea() {
		this.borratu = false;
		int pos = (this.bonberman.getY())*17+this.bonberman.getX();	
		if(this.bonberman.getX()-1>=0 && !(getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()-1).getTipo() == 1)) {
			//pos = (this.bonberman.getY())*17+this.bonberman.getX()+1*(-1);
			pos = pos-1;
			getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()-1).setTipo(0);
			System.out.print("\n"+pos);
			borratu = true;
		}
		if(this.bonberman.getX()+1<=16 && !(getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()+1).getTipo() == 1)) {
			//pos = this.bonberman.getY()*17+this.bonberman.getX()+1;
			pos = pos+1;
			getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()+1).setTipo(0);
			System.out.print("\n"+pos);
			borratu = true;
		}	
		if(this.bonberman.getY()-1>=0 && !(getGelaZerr().get((this.bonberman.getY()-1)*17+this.bonberman.getX()).getTipo() == 1)) { 
			//pos = (this.bonberman.getY()-1)*17+this.bonberman.getX();
			pos = pos-17;
			getGelaZerr().get((this.bonberman.getY()-1)*17+this.bonberman.getX()).setTipo(0);
			System.out.print("\n"+pos);
			borratu = true;
		}
		if(this.bonberman.getY()+1<=10 && !(getGelaZerr().get((this.bonberman.getY()+1)*17+this.bonberman.getX()).getTipo() == 1)) {
			//pos = (this.bonberman.getY()+1)*17+this.bonberman.getX();
			pos = pos+17;
			getGelaZerr().get((this.bonberman.getY()+1)*17+this.bonberman.getX()).setTipo(0);
			System.out.print("\n"+pos);
			borratu = true;
		}
		
		
		/*for(int i=-1; i<2; i++) {
			for(int j=-1; j<2; j++) {
				if ((i==-1 || i==1) && j==0) {
					if (this.bonberman.getX()-1>0 && this.bonberman.getX()+1<16 && 0<this.bonberman.getY() && this.bonberman.getY()<10) {
						getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()+1).setTipo(0);
						getGelaZerr().get((this.bonberman.getY())*17+this.bonberman.getX()-1).setTipo(0);
					}
				}
				borratu = true;
				if (this.bonberman.getX()>0 && this.bonberman.getX()<16 && this.bonberman.getY()+j<10 && this.bonberman.getY()+j>0) {
					getGelaZerr().get((this.bonberman.getY()+j)*17+this.bonberman.getX()).setTipo(0);
				}
				borratu = true;
				
			}
		}*/
		setChanged();
		notifyObservers();
	}
	
}
