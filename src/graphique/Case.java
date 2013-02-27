package graphique;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;



public class Case extends MouseAdapter{
private int Numero;
private int PosX;
private int PosY;
private boolean etat;

	public Case(int n, int Posx, int Posy, boolean Etat)
	{

		this.Numero=n;
		this.PosX=Posx;
		this.PosY=Posy;
		this.etat=Etat;

	}

	public int getNumero()
	{
		return this.Numero;
	}
	public boolean getEtat()
	{
		return this.etat;
	}
	public void changementEtat()
	{
		this.etat=false;
	}

	public void mouseClicked(MouseEvent event) {

        System.out.println(event.getComponent());
    }

}