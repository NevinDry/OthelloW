package game;

public class Joueur {
	int numero;
	int noombreTour;

	public Joueur(int num, int nombreTour){
		this.numero = num;
		this.noombreTour = nombreTour;
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
