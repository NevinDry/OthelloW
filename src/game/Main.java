package game;

import java.awt.BorderLayout;

import javax.swing.JButton;

public class Main {
	public static void main(String[] args) {
		Game maGame = new Game();
		
		maGame.maFenetre.setContentPane(maGame.monPlateau);
		maGame.maFenetre.setVisible(true);
		maGame.initGame();


	}
}
