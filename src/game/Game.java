package game;


import java.io.IOException;
import java.awt.*;
import java.applet.Applet;
import graphique.Fenetre;
import graphique.Plateau;
import java.awt.Graphics;

public class Game {

	public static void main(String[] args) {
			Fenetre maFenetre = new Fenetre();
			Plateau monPlateau = new Plateau(640,640,8,8);
			maFenetre.setContentPane(monPlateau);
			maFenetre.setVisible(true);
			monPlateau.paintComponent(maFenetre.getGraphics());		
	}

}