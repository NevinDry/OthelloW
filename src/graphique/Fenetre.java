package graphique;
import javax.swing.JFrame;
  
public class Fenetre extends JFrame {
	int width;
	int height;
	

	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}


	public Fenetre(int width, int height){
	    this.width = width;
	    this.height = height;
		this.setTitle("OthelloW");
	    this.setSize(this.width, this.height);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	}
	
	
}