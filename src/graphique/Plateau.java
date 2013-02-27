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
	
	public Plateau(int longueur, int largueur, int nbCasex, int nbCasey)
	{	
		this.addMouseListener(this); 
		this.tailleX=longueur;
		this.tailleY=largueur;
		this.NbCaseX=nbCasex;
		this.NbCaseY=nbCasey;
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
		 Case[] carreau= new Case[64];
		 g.setColor(Color.black);
		 g.fillRect(0,0, this.tailleX,this.tailleY);
		 for (int i=1;i<=NbCaseX;i++)
		 {
			 for(int j=1;j<=NbCaseY;j++)
			 {
				carreau[i+j]= new Case(i+j,i,j,true);
				g.setColor(new Color(15,89,30));
				g.fillRect(i*65,j*65,50,50);
			 }
		 }	 
	}
	
	public Case retrouverCaseWithCoor(int x, int y){
		
		
		return null;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX());
		System.out.println(e.getY());
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
