package game;

import java.io.IOException;
import java.awt.*;
import java.applet.Applet;
import graphique.Fenetre;
import graphique.Plateau;
import java.awt.Graphics;

public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
			Fenetre maFenetre = new Fenetre(800, 800);
			//Thread.currentThread();
			//Thread.sleep(2000);
			Plateau monPlateau = new Plateau(maFenetre.getWidth(), maFenetre.getHeight(), 8);
			maFenetre.setContentPane(monPlateau);
			monPlateau.genererPlateauWithGrid();
	}

}
