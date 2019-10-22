/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 *
 * @author igorl
 */
public class Guerrier extends Personnage implements Combattant {
    
     public Guerrier () 
    {
        super ();
          this.setPourcentageAtt(60);
          this.setDegAtt(30);

    }
    public Guerrier ( Guerrier g)
    {
        super (g);

    }
    public Guerrier (String nom, int pVie, int pMagie, int prAtt, int prParade, int prMagie, int prResMagie, int pDegatAtt, int pDegatMagie, int distMax, int pParade, Point2D pos)
    {
       super ( nom,  pVie,  pMagie,  prAtt,  prParade,  prMagie,  prResMagie,  pDegatAtt,  pDegatMagie,  distMax,  pParade,  pos);
      
    }
     @Override
 public void affiche ()
    {
        System.out.println("Un guerrier! sa position: ");
        this.getPos().affiche();
    }
 
  /**
     *  Combat corps a corps
     * 
     * @param c  la creature
     */
        public void combattre (Creature c) 
    {
       
       if(!(this.getPos().distance(c.getPos())>1))
       {
        
          Random alea = new Random();
          int attAlea = alea.nextInt(99)+ 1;
          if(!(attAlea > this.getPourcentageAtt())) // Attaque reussie
          {
            System.out.println ("Attaque Reussie!");
             int degAlea = alea.nextInt(99)+ 1;
             if(degAlea > c.getPourcentagePar()) 
             {
                 System.out.println ("Defense Rate! Le degat total:" + this.getDegAtt());
                 c.setPtVie(c.getPtVie() - this.getDegAtt() ); // defense rate 
             }
             else
             {
                  System.out.println ("Defense Reusie! points de parade du défenseur:" + c.getPtPar());
                  c.setPtVie(c.getPtVie() - this.getDegAtt() + c.getPtPar()); // else :defense reussie 
             }
              System.out.println ("Points de vie restant de la creature: " + c.getPtVie());
          }
       
          else
          {
                        System.out.println ("Attaque Rate!");
          }
       
       }
        c.checkGameOver();
    }
}
    

