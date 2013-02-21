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
	    this.width = width;
	    this.height = height;
	    this.nbrCase = nbrCase;
	}
	
	public void genererPlateauWithGrid(){
		
				String matrice [][] = new String[3][3]; 
				for(int i=0; i<3; i++){ 
				for(int j = 0; j < 3; j++){
					matrice[i][j]="esedfzs";
					System.out.println(matrice[i][j]); 
				} 
				} 
			
	}
	
	/*
	public void genererPlateau(){
		int i = 1;
		int incrementWidth = 0;
		while(incrementWidth<this.width){
			System.out.println(i);
			
			
			incrementWidth += this.width/this.nbrCase;
		}
	}
	*/
}