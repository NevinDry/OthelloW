package game;

public class Joueur {
	int numero;
	int noombreTour;
	int nombreCase;

	public Joueur(int num, int nombreTour){
		this.numero = num;
		this.noombreTour = nombreTour;
		this.nombreCase =0;
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
	
}
