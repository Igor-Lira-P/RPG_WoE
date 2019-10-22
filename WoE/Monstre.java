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
public class Monstre extends Creature{
    
     
     public Monstre (int  pV, int pA, int pP, int dA,int ptPar, Point2D pos)
     {
         super (pV,pA,pP,dA,ptPar,pos );

     }
     public Monstre (Monstre m)
     {
         super(m);

     }
     
        public Monstre ()
     {
      super();
     }

    public void affiche ()
    {
        System.out.println("Un monstre! sa position: ");
        this.getPos().affiche();
    }
     
}
