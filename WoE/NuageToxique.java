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
public class NuageToxique extends Objet implements Deplacable {
    
    private int prAtt, prParade, pAtt,pParade;
    private boolean isVisible ;
    public NuageToxique ()
    {
        super();
        this.pAtt = 20;
        this.isVisible = false;
    }
    public NuageToxique ( int prAtt, int prParade, int pAtt, int pParade, Point2D pos) 
    {
        super (pos);
        this.pAtt = pAtt;
        this.isVisible = false;
        
    }
    
    public void deplacer (){
        
    }
    
    public void combattre (){
        
    }
    
    public void modifier (Personnage p)
    {
        System.out.println ("Vous etes en contact avec un nuage toxique! Vous avez perdu " + this.pAtt );
        p.setPtVie(p.getPtVie() - this.pAtt);
        
    }
    public int  getPrAtt ()
    {
        return this.prAtt;
    }
    public int getPrParade()
    {
        return this.prParade;
    }
    public int getpAtt ()
    {
        return this.pAtt;
    }
    public int getpParade ()
    {
        return this.pParade;
    }
    public boolean getVisibilite ()
    {
        return this.isVisible;
    }
    public void setVisibilite ()
    {
        this.isVisible = true;
    }
}

