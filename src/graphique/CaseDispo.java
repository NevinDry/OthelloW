package graphique;

import java.awt.Color;
import java.awt.Graphics;

public class CaseDispo extends Case{

	
	public CaseDispo(int Posx, int Posy, Color color) {
		super(Posx, Posy, color);
	}
	
	public void displayCaseDispo(Graphics g){
		g.setColor(this.color);
		g.fillRect(this.PosX*65+20,this.PosY*65+20,20,20);
	}


}
