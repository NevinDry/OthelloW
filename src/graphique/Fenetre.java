package graphique;
import javax.swing.JFrame;
  
public class Fenetre extends JFrame {
  
	public Fenetre(int width, int height){
	    this.setTitle("OthelloW");
	    this.setSize(width, height);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	}
	
	
}