package game;

import java.awt.Color;

public class Joueur {
	int numero;
	int noombreTour;
	int nombreCase;
	Color color;
	boolean noDisp;

	public Joueur(int num, int nombreTour, Color color){
		this.numero = num;
		this.noombreTour = nombreTour;
		this.nombreCase =0;
		this.color = color;
		this.noDisp = false;
	}
	
	public boolean getNoDisp() {
		return noDisp;
	}

	public void setNoDisp(boolean noDisp) {
		this.noDisp = noDisp;
	}

	public int getNombreCase() {
		return nombreCase;
	}

	public void setNombreCase(int nombreCase) {
		this.nombreCase = nombreCase;
	}

	public int getNoombreTour() {
		return noombreTour;
	}

	public void setNoombreTour(int noombreTour) {
		this.noombreTour = noombreTour;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void afficherScore(){
		System.out.println("Joueur : "+this.numero+"");
		System.out.println("Case : "+this.nombreCase+"");
		System.out.println("--");
	}
	
	public void afficherTour(){
		System.out.println("------- TOUR "+this.noombreTour+"-------");
	}

	
}
