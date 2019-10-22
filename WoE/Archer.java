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
public class Archer extends Personnage implements Combattant
{
      /**
     * @param nbFleches - nombre des fleches disponibles
     */

    private int nbFleches;
    
    public Archer () 
    {      
        super ();
        this.nbFleches = 5;
        this.setDistAttMax(2);        
    }
    public Archer ( Archer arc )
    {
        super (arc);
        nbFleches = arc.nbFleches;
    }
    public Archer (String nom, int pVie, int pMagie, int prAtt, int prParade, int prMagie, int prResMagie, int pDegatAtt, int pDegatMagie, int distMax, int pParade, Point2D pos, int nbF)
    {
        super ( nom,  pVie,  pMagie,  prAtt,  prParade,  prMagie,  prResMagie,  pDegatAtt,  pDegatMagie,  distMax,  pParade,  pos);
        this.nbFleches = nbF;
    }
    public int getNbFleches()
    {
        return nbFleches;
    }
    public void setNbFleches (int nbF)
    {
         this.nbFleches = nbF;
    }
    public void affiche()
    {
     System.out.println("Un Archer, nom: " + this.getNom() + "! sa position:" );
     this.getPos().affiche();
     
    }
 
    /**
     *  Combat a distance
     * 
     * @param c  la creature
     */
	
        public void combattre (Creature c) 
        {
            System.out.println ("Log de combat!");
            
             if(this.nbFleches < 1) { System.out.println( "Il n'y a plus de fleches!!!");}   
              else {      
                  if(this.getPos().distance(c.getPos()) >= 1 && this.getPos().distance(c.getPos()) <= this.getDistAttMax() )
                  {
                    this.setNbFleches(this.nbFleches-1);
                     Random alea = new Random();
                     int attAlea = alea.nextInt(99)+ 1;
                              if(!(attAlea > this.getPourcentageAtt()))
                              { // Attaque reussie {
                                  System.out.println ("Attaque Reussie!");
                                   int degAlea = alea.nextInt(99)+ 1;
                                   c.setPtVie(c.getPtVie()- this.getDegAtt() ); // defense rate 
                               }
                 else{ System.out.println ("Attaque Rate!"); }
           System.out.println ("Points de vie restant : " + c.getPtVie());
          }
     
     }
             c.checkGameOver();
    }
}
