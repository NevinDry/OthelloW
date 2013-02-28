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
		this.joueur1 = new Joueur(1, 0);
		this.joueur2 = new Joueur(2, 0);
		this.monPlateau =  new Plateau(640,640,8,8);
		this.maFenetre = new Fenetre();
		this.monPlateau.addMouseListener(this);
	}
	
	
	public void newTour(int x, int y){
		if (this.joueur1.getNoombreTour() == this.joueur2.getNoombreTour()){
			this.monPlateau.ajouterCaseWithCoor(x, y, Color.white);
			this.joueur1.noombreTour++;
		}
		else if(this.joueur1.getNoombreTour() < this.joueur2.getNoombreTour()){
			this.monPlateau.ajouterCaseWithCoor(x, y, Color.white);
			this.joueur1.noombreTour++;
		}else{
			this.monPlateau.ajouterCaseWithCoor(x, y, Color.black);
			this.joueur2.noombreTour++;
		}
		this.monPlateau.repaint();
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		this.newTour(e.getX(),e.getY());
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