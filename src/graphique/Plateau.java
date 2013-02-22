package graphique;

import java.awt.Graphics;
import java.io.IOException;
import javax.swing.JPanel;


public class Plateau  extends JPanel {
	
	int width;
	int height;
	int nbrCase;
	
	public int getWidth() {
		return width;
	}


	public int getHeight() {
		return height;
	}
	
	public int getNbrCase() {
		return height;
	}
	
	public Plateau(int width, int height, int nbrCase){
	    this.width = width - 100;
	    this.height = height -100;
	    this.nbrCase = nbrCase;
	}
	
	public void genererPlateau(){
		int x =10;
		int y = 10;
		Case matrice [][] = new Case[this.nbrCase][this.nbrCase]; 
		for(int i=0; i<this.nbrCase; i++){ 
			for(int j = 0; j < this.nbrCase; j++){
				matrice[i][j]= new Case(x,y,this.width/this.nbrCase,this.width/this.nbrCase,"red");
				System.out.println("x = "+x);
				System.out.println("y = "+y);
				y = y + this.width/this.nbrCase;
				matrice[i][j].paintComponent(this.getGraphics());
			} 
			
			y = 0;
			x = x + this.height/this.nbrCase;
		} 
	}
}