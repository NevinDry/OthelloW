package graphique;

import java.awt.Color;
import java.awt.Graphics;

public class CaseDispo extends Case{
	private int visibility;
	
	public CaseDispo(int Posx, int Posy, Color color, int visib) {
		super(Posx, Posy, color);
		this.visibility = visib;
	}
	
	public void displayCaseDispo(Graphics g){
		g.setColor(this.color);
		g.fillRect(this.PosX*65+20,this.PosY*65+20,20,20);
	}

	public void cliCkable(){
		
	}
	

	public int getVisibility() {
		return visibility;
	}
	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}
	

}
