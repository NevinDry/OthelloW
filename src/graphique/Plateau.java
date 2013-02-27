package graphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.*;




public  class Plateau extends JPanel implements MouseListener{
	
	
	
	private int tailleX;
	private int tailleY;
	private int NbCaseX;
	private int NbCaseY;
	Case[] carreau;
	
	public Plateau(int longueur, int largueur, int nbCasex, int nbCasey)
	{	
		this.addMouseListener(this); 
		this.tailleX=longueur;
		this.tailleY=largueur;
		this.NbCaseX=nbCasex;
		this.NbCaseY=nbCasey;
		this.carreau =  new Case[64];
	}
	public int getTailleX()
	{
		return this.tailleX;
	}
	public int getTailleY()
	{
		return this.tailleY;
	}
	public int getNbCaseX()
	{
		return this.NbCaseX;
	}
	public int getNbCaseY()
	{
		return this.NbCaseY;
	}
	public void paintComponent(Graphics g)
	{
		 g.setColor(Color.black);
		 g.fillRect(0,0, this.tailleX,this.tailleY);
		 for (int i=1;i<=NbCaseX;i++)
		 {
			 for(int j=1;j<=NbCaseY;j++)
			 {
				g.setColor(new Color(15,89,30));
				g.fillRect(i*65,j*65,50,50);
			 }
		 }	 
	}
	
	public void genererPlateau(){
		for (int i=1;i<=NbCaseX;i++)
		 {
			 for(int j=1;j<=NbCaseY;j++)
			 {
				this.carreau[i+j]= new Case(i+j,i,j,true);
			 }
		 }	
	}
	
	public Case retrouverCaseWithCoor(int x, int y){
		System.out.println(x);
		System.out.println(y);
		for (int i=1;i<=NbCaseX;i++)
		 {
			 for(int j=1;j<=NbCaseY;j++)
			 {


				if((x > i*65  && x < (1+i)*65 ) && (y > j*65  && y < (1+j)*65)){
					/* System.out.println("i*65 = "+i*65);
					 System.out.println("2*i*65 = "+2*i*65);
					 System.out.println("j*65 = "+j*65);
					 System.out.println("2*j*65 = "+2*j*65);
					
					*/
					System.out.println(this.carreau[i+j].getNumero());
					return this.carreau[i+j];
				}
			 }
		 }	 
		
		return null;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println(e.getX());
		//System.out.println(e.getY());
		retrouverCaseWithCoor(e.getX(),e.getY());
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
