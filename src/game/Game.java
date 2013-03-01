package game;


import java.io.IOException;
import java.awt.*;
import java.applet.Applet;

import graphique.CaseDispo;
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
	int nombreTour;
		
	
	public Game(){
		this.maFenetre = new Fenetre();
		this.monPlateau =  new Plateau(640,640,8,8);
		this.monPlateau.addMouseListener(this);
		this.nombreTour = 0;
	}
	
	public void initGame(){
		this.joueur1 = new Joueur(1, 0, Color.white);
		this.joueur2 = new Joueur(2, 0, Color.black);
		this.monPlateau.genererPlateau(this.maFenetre.getGraphics());
		this.checkCase(this.joueur1,this.joueur2);
		this.monPlateau.paintComponent(this.maFenetre.getGraphics());
	}
	
	
	public void newTour(int x, int y){
		this.nombreTour++;
		int[][] tabCase = new int[64][64];
		if (this.joueur1.getNoombreTour() == this.joueur2.getNoombreTour()){
			if(this.verifCase(this.monPlateau.trouverICase(x,y), this.monPlateau.trouverJCase(x,y), this.joueur1.color,this.joueur2.color)
					&& this.monPlateau.getCarreau()[this.monPlateau.trouverICase(x,y)][this.monPlateau.trouverJCase(x,y)] instanceof graphique.CaseDispo){
				this.monPlateau.ajouterCaseWithCoor(this.monPlateau.trouverICase(x,y), this.monPlateau.trouverJCase(x,y), Color.white);	
				this.joueur1.noombreTour++;
				
				tabCase = toReturn(this.monPlateau.trouverICase(x,y) ,this.monPlateau.trouverJCase(x,y),this.joueur1.color,this.joueur2.color);
				this.flipCase(tabCase, this.joueur1.color);
				this.checkCase(this.joueur2,this.joueur1);
			}
			else{
				System.out.println("coup non valide");
			}

		}else{
			if(this.verifCase(this.monPlateau.trouverICase(x,y), this.monPlateau.trouverJCase(x,y),this.joueur2.color, this.joueur1.color)
					&& this.monPlateau.getCarreau()[this.monPlateau.trouverICase(x,y)][this.monPlateau.trouverJCase(x,y)] instanceof graphique.CaseDispo){
				this.monPlateau.ajouterCaseWithCoor(this.monPlateau.trouverICase(x,y), this.monPlateau.trouverJCase(x,y), Color.black);					this.joueur2.nombreCase++;
				this.joueur2.noombreTour++;
				
				tabCase = toReturn(this.monPlateau.trouverICase(x,y) ,this.monPlateau.trouverJCase(x,y),this.joueur2.color,this.joueur1.color);
				this.flipCase(tabCase, this.joueur2.color);
				this.checkCase(this.joueur1,this.joueur2);

			}else{
				System.out.println("coup non valide");
			}
		}


		this.monPlateau.paintComponent(this.maFenetre.getGraphics());
		this.afficherTour();
		this.joueur1.nombreCase = this.monPlateau.getNbrCaseBlanc();
		this.joueur2.nombreCase = this.monPlateau.getNbrCaseNoir();
		this.joueur1.afficherScore();
		this.joueur2.afficherScore();



	}
	
	public void afficherTour(){
		System.out.println("--------"+this.nombreTour+"-----------");
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
			return true;
		}else{
			return false;
		}		
	}
	
	public void checkCase(Joueur joueur1, Joueur joueur2){
		int nombreChoix=0;
		for (int i=1;i<=this.monPlateau.getNbCaseX();i++)
		 {
			 for(int j=1;j<=this.monPlateau.getNbCaseY();j++)
			 {
				
				 if(this.monPlateau.getCarreau()[i][j] instanceof graphique.CaseDispo || this.monPlateau.getCarreau()[i][j] == null ){
					 this.monPlateau.getCarreau()[i][j] = null;
					 if(this.verifCase(i, j, joueur1.color,joueur2.color)
							&& this.monPlateau.getCarreau()[i][j] == null){
						this.monPlateau.getCarreau()[i][j] = new CaseDispo(i,j, Color.red, 20);
						nombreChoix++;
					}
					
				}
			 }
		 }
		if(nombreChoix == 0){
			System.out.println("Plus de case disponible, Decomptes des points");
			this.checkForVictory(this.joueur1,this.joueur2);

		}
	}
	
	
	public int[][] toReturn(int i,int j,Color colorCurrent, Color colorAdversaire){
		int[][] tabCase = new int[64][64];
		int nbCase =1;
		
		if( this.verifCaseDirection(i, j, -1,0,colorCurrent, colorAdversaire) != 0 )
		{
				int nb = this.verifCaseDirection(i, j, -1,0,colorCurrent, colorAdversaire);
				for (int a=0;a<nb;a++){
					
					i=i-1;
					j=j+0;
					tabCase[nbCase][1] = i;
					tabCase[nbCase][2] = j;
					nbCase++;
				}
		}
		
		if( this.verifCaseDirection(i, j, 1,0,colorCurrent, colorAdversaire) != 0 )
		{
				int nb = this.verifCaseDirection(i, j, 1,0,colorCurrent, colorAdversaire);
				for (int a=0;a<nb;a++){
					i=i+1;
					j=j+0;
					tabCase[nbCase][1] = i;
					tabCase[nbCase][2] = j;
					nbCase++;
				}
		}
		
		if( this.verifCaseDirection(i, j, 0,-1,colorCurrent, colorAdversaire) != 0 )
		{
				int nb = this.verifCaseDirection(i, j, 0,-1,colorCurrent, colorAdversaire);
				for (int a=0;a<nb;a++){
					i=i+0;
					j=j-1;
					tabCase[nbCase][1] = i;
					tabCase[nbCase][2] = j;
					nbCase++;
				}
		}
		
		if( this.verifCaseDirection(i, j, 0,1,colorCurrent, colorAdversaire) != 0 )
		{
				int nb = this.verifCaseDirection(i, j, 0,1,colorCurrent, colorAdversaire);
				for (int a=0;a<nb;a++){
					i=i+0;
					j=j+1;
					tabCase[nbCase][1] = i;
					tabCase[nbCase][2] = j;
					nbCase++;
				}
		}
		
		if( this.verifCaseDirection(i, j, -1,1,colorCurrent, colorAdversaire) != 0 )
		{
				int nb = this.verifCaseDirection(i, j, -1,1,colorCurrent, colorAdversaire);
				for (int a=0;a<nb;a++){
					i=i-1;
					j=j+1;
					tabCase[nbCase][1] = i;
					tabCase[nbCase][2] = j;
					nbCase++;
				}
		}
		
		if( this.verifCaseDirection(i, j, 1,1,colorCurrent, colorAdversaire) != 0 )
		{
				int nb = this.verifCaseDirection(i, j, 1,1,colorCurrent, colorAdversaire);
				for (int a=0;a<nb;a++){
					i=i+1;
					j=j+1;
					tabCase[nbCase][1] = i;
					tabCase[nbCase][2] = j;
					nbCase++;
				}
		}
		
		if( this.verifCaseDirection(i, j, 1,-1,colorCurrent, colorAdversaire) != 0 )
		{
				int nb = this.verifCaseDirection(i, j, 1,-1,colorCurrent, colorAdversaire);
				for (int a=0;a<nb;a++){
					i=i+1;
					j=j-1;
					tabCase[nbCase][1] = i;
					tabCase[nbCase][2] = j;
					nbCase++;
				}
		}
		
		if( this.verifCaseDirection(i, j, -1,-1,colorCurrent, colorAdversaire) != 0 )
		{
				int nb = this.verifCaseDirection(i, j, -1,-1,colorCurrent, colorAdversaire);
				for (int a=0;a<=nb;a++){
					i=i-1;
					j=j-1;
					tabCase[nbCase][1] = i;
					tabCase[nbCase][2] = j;
					nbCase++;
				}
		}
		return tabCase;	
	}
	
	public void flipCase(int[][] tabCase, Color color){
		for(int a=0; a<64; a++){
			if(tabCase[a][1] != 0 && tabCase[a][2] != 0){
				this.monPlateau.ajouterCaseWithCoor(tabCase[a][1],tabCase[a][2] , color);	

			}
		}
	}
	
	public void checkForVictory(Joueur joueur1, Joueur joueur2){
		if(joueur1.nombreCase>joueur2.nombreCase){
			System.out.println("Felicitation Joueur "+joueur1.numero+" vous avez gagné !!");
		}else if(joueur1.nombreCase<joueur2.nombreCase){
			System.out.println("Felicitation Joueur "+joueur2.numero+" vous avez gagné !!");
		}else{
			System.out.println("Match nul !");
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