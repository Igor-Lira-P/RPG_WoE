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
public class Loup extends Monstre implements Combattant{
    public Loup ()
    {
    super ();
    }
    
    public Loup (Loup l)
    {
        super (l);
    }
    
    public Loup (int pV ,int pA, int pP, int dA, int ptPar, Point2D pos) 
    {
       super (pV,pA,pP,dA,ptPar,pos);
        
    }
    
    public void combattre (Creature c) 
    {
       c.setPtVie(c.getPtVie() - this.getDegAtt());
    }
    
}
