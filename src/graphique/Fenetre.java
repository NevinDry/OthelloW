package graphique;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;



public class Fenetre extends JFrame
{	
	public Fenetre()
	{		
		this.setLayout(null);
		this.setTitle("Othello");
		this.setSize(640,670);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}