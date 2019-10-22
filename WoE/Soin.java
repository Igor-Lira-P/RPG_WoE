/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @author igorl
 */
public class Soin extends Portion{
    
    private int soin;
    public Soin ()
    {
        super();
        this.soin = 20;
    }
    public Soin (int soin, Point2D pos)
    {
        super();
        this.soin = soin; 
    }
     public int getSoin ()
    {
        return this.soin;
    }
    public void modifier (Personnage p)
    {
     System.out.println ("Vous avez consume un potion Soin \n Points de vie avant: " +  p.getPtVie());
     p.setPtVie(p.getPtVie() + this.soin);
     System.out.println ("Points de vie apres: " +  p.getPtVie());
     World.toutObjet.remove(this);
    }
}
