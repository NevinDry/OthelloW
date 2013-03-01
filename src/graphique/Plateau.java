package graphique;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


public  class Plateau extends JPanel implements MouseListener{
	
	private int tailleX;
	private int tailleY;
	private int NbCaseX;
	private int NbCaseY;
	private int nbrCaseBlanc;
	private int nbrCaseNoir;
	
	
	public int getNbrCaseBlanc() {
		return nbrCaseBlanc;
	}
	public void setNbrCaseBlanc(int nbrCaseBlanc) {
		this.nbrCaseBlanc = nbrCaseBlanc;
	}
	public int getNbrCaseNoir() {
		return nbrCaseNoir;
	}
	public void setNbrCaseNoir(int nbrCaseNoir) {
		this.nbrCaseNoir = nbrCaseNoir;
	}
	public Case[][] getCarreau() {
		return carreau;
	}
	public void setCarreau(Case[][] carreau) {
		this.carreau = carreau;
	}
	private Case[][] carreau;

	
	public Plateau(int longueur, int largueur, int nbCasex, int nbCasey)
	{	
		this.tailleX=longueur;
		this.tailleY=largueur;
		this.NbCaseX=nbCasex;
		this.NbCaseY=nbCasey;
		this.carreau =  new Case[9][9];
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
		this.setNbrCaseBlanc(0);
		this.setNbrCaseNoir(0);
		 g.setColor(new Color(172,193,190));
		 g.fillRect(0,0, this.tailleX,this.tailleY);

		 //affichage de ma grille
		 //tout l'aspect graphique est géré ici, problème au niveau de l'affichage
		 //Les Case devraient avoir leur propre methode d'affichage
		 for (int i=1;i<=NbCaseX;i++)
		 {
			 for(int j=1;j<=NbCaseY;j++)
			 {

				if(this.carreau[i][j] instanceof graphique.CaseDispo){
					g.setColor(new Color(15,89,30));
					g.fillRect(i*65,j*65,60,60);
					g.setColor(this.carreau[i][j].color);
					g.fillRect(i*65+20,j*65+20,40*30/100,40*30/100);
				
				}
				else if(this.carreau[i][j] instanceof graphique.Case){
					g.setColor(new Color(15,89,30));
					g.fillRect(i*65,j*65,60,60);
					g.setColor(this.carreau[i][j].color);
					g.fillRect(i*65+10,j*65+10,40,40);
					if(this.carreau[i][j].color == Color.white){
						this.nbrCaseBlanc++;
					}else{
						this.nbrCaseNoir++;	
					}
				}
				else{
					g.setColor(new Color(15,89,30));
					g.fillRect(i*65,j*65,60,60);
				}	

			 }
		 }	
		 this.repaint();
	}
	
	public void genererPlateau(Graphics g){
		for (int i=1;i<=NbCaseX;i++)
		 {
			 for(int j=1;j<=NbCaseY;j++)
			 {
				 if((i==4 && j==4) || (i==5 && j==5)){
					 	this.carreau[i][j]= new Case(i,j,Color.white);

				 }else if((i==4 && j==5) || (i==5 && j==4)){
						this.carreau[i][j]= new Case(i,j,Color.black);
				}      
			}
		}			
	}
	
	public void ajouterCaseWithCoor(int x, int y, Color color){
		for (int i=1;i<=NbCaseX;i++)
		 {
			 for(int j=1;j<=NbCaseY;j++)
			 {
				if((i == x) && (y==j) ){
					this.carreau[i][j]= new Case(i,j, color);
				}
			 }
		 }	
	}
	
	public int trouverICase(int x, int y){
		for (int i=1;i<=NbCaseX;i++)
		 {
			 for(int j=1;j<=NbCaseY;j++)
			 {
				if((x > i*65  && x < (1+i)*65 ) && (y > j*65  && y < (1+j)*65)){
					return i;
				}
			 }
		 }
		return 0;
	}
	
	public int trouverJCase(int x, int y){
		for (int i=1;i<=NbCaseX;i++)
		 {
			 for(int j=1;j<=NbCaseY;j++)
			 {
				if((x > i*65  && x < (1+i)*65 ) && (y > j*65  && y < (1+j)*65)){
					return j;
				}
			 }
		 }
		return 0;
	}
	


	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println(e.getX());
		//System.out.println(e.getY());
		//ajouterCaseWithCoor(e.getX(),e.getY(), Color.black);
		
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
