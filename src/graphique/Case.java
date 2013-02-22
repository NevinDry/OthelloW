package graphique;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Case extends JPanel{
	int coordonneeX;
	int coordonneeY;
	int width;
	int height;
	String color;
	

	
	public int getCoordonneeX() {
		return coordonneeX;
	}

	public void setCoordonneeX(int coordonneeX) {
		this.coordonneeX = coordonneeX;
	}

	public int getCoordonneeY() {
		return coordonneeY;
	}

	public void setCoordonneeY(int coordonneeY) {
		this.coordonneeY = coordonneeY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Case(int coordonneeX, int coordonneeY, int width, int height, String color) {
		this.coordonneeX = coordonneeX;
		this.coordonneeY = coordonneeY;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	

	 public void paintComponent(Graphics g){
		 System.out.println(this.coordonneeX);
		 System.out.println(this.coordonneeY);
		 g.drawRect(this.coordonneeX, this.coordonneeY, this.width, this.height);
		 //g.drawString("case"+this.coordonneeX, this.coordonneeX, this.coordonneeY);
	 }               
		
	
	


}
