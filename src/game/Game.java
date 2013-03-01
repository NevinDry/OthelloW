package game;


import java.io.IOException;
import java.awt.*;
import java.applet.Applet;
import graphique.Fenetre;
import graphique.Plateau;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Game extends JPanel implements MouseListener{
	Joueur joueur1;
	Joueur joueur2;
	Plateau monPlateau;
	Fenetre maFenetre;
		
	
	public Game(){
		this.joueur1 = new Joueur(1, 0, Color.white);
		this.joueur2 = new Joueur(2, 0, Color.black);
		this.maFenetre = new Fenetre();
		this.monPlateau =  new Plateau(640,640,8,8);
		this.monPlateau.addMouseListener(this);
	}
	
	
	public void newTour(int x, int y){
		if (this.joueur1.getNoombreTour() == this.joueur2.getNoombreTour()){
			if(this.verifCase(this.monPlateau.trouverICase(x,y), this.monPlateau.trouverJCase(x,y), this.joueur1.color,this.joueur2.color)
					&& this.monPlateau.getCarreau()[this.monPlateau.trouverICase(x,y)][this.monPlateau.trouverJCase(x,y)] == null){
				this.monPlateau.ajouterCaseWithCoor(x, y, Color.white);	
			}
			else{
				System.out.println("coup non valide");
			}
			this.joueur1.nombreCase++;
			this.joueur1.noombreTour++;

		}
		else if(this.joueur1.getNoombreTour() < this.joueur2.getNoombreTour()){
			if(this.verifCase(this.monPlateau.trouverICase(x,y), this.monPlateau.trouverJCase(x,y),this.joueur1.color, this.joueur2.color) 
					&& this.monPlateau.getCarreau()[this.monPlateau.trouverICase(x,y)][this.monPlateau.trouverJCase(x,y)] == null){
				this.monPlateau.ajouterCaseWithCoor(x, y, Color.white);
			}else{
				System.out.println("coup non valide");
			}
			this.joueur1.nombreCase++;
			this.joueur1.noombreTour++;

		}else{
			if(this.verifCase(this.monPlateau.trouverICase(x,y), this.monPlateau.trouverJCase(x,y),this.joueur2.color, this.joueur1.color)
					&& this.monPlateau.getCarreau()[this.monPlateau.trouverICase(x,y)][this.monPlateau.trouverJCase(x,y)] == null){
				this.monPlateau.ajouterCaseWithCoor(x, y, Color.black);
			}else{
				System.out.println("coup non valide");
			}

			this.joueur2.nombreCase++;
			this.joueur2.noombreTour++;
		}
		this.joueur1.afficherTour();
		this.joueur1.afficherScore();
		this.joueur2.afficherScore();

		this.monPlateau.repaint();
	}

	public void resultat(){
		
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		this.newTour(e.getX(),e.getY());
	}


	
	public int verifCaseDirection(int i, int j, int inci, int incj, Color colorCurrent, Color colorAdversaire){
		int n_inc=0;
		 i+=inci; 
		 j+=incj;
		 
	
		while ((i<9) && (i>=1) && (j<9) && (j>=1) && (this.monPlateau.getCarreau()[i][j] != null && this.monPlateau.getCarreau()[i][j].getColor() == colorAdversaire)) {	
				i+=inci; 
				j+=incj;
				n_inc++;
		}
		if ((n_inc != 0) && (i<9) && (i>=1) && (j<9) && (j>=1) && ( this.monPlateau.getCarreau()[i][j] != null && this.monPlateau.getCarreau()[i][j].getColor() == colorCurrent)) {
			return n_inc;
		}
		else 
		{
			return 0;
		}
	}
	
	public boolean verifCase(int i,int j, Color colorCurrent, Color colorAdversaire){		
		if( this.verifCaseDirection(i, j, -1,0,colorCurrent, colorAdversaire) != 0
				|| this.verifCaseDirection(i, j, 1,0,colorCurrent, colorAdversaire) != 0
					|| this.verifCaseDirection(i, j, 0,-1,colorCurrent, colorAdversaire) != 0
						|| this.verifCaseDirection(i, j, 0,1,colorCurrent, colorAdversaire) != 0
							|| this.verifCaseDirection(i, j, -1,1,colorCurrent, colorAdversaire) != 0
								|| this.verifCaseDirection(i, j, 1,1,colorCurrent, colorAdversaire) != 0
									|| this.verifCaseDirection(i, j, 1,-1,colorCurrent, colorAdversaire) != 0
										|| this.verifCaseDirection(i, j, -1,-1,colorCurrent, colorAdversaire) != 0)
		{					
			System.out.println("vraaaaaiiiiii");
			return true;
		}else{
			System.out.println("fauuuuuuuuuuuuuuuuuuuuuuuuuuuuuux");
			return false;
		}		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	


}