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
public class Mage extends Personnage implements Combattant{

        
    public Mage () 
    {
        //Quelques valeurs default:
        super ();
        this.setPtMana(10);
        this.setPourcentageMag(70);
        this.setDegMag(30);

    }
    public Mage ( Mage m)
    {
        super (m);

    }
    public Mage (String nom, int pVie, int pMagie, int prAtt, int prParade, int prMagie, int prResMagie, int pDegatAtt, int pDegatMagie, int distMax, int pParade, Point2D pos)
    {
        super ( nom,  pVie,  pMagie,  prAtt,  prParade,  prMagie,  prResMagie,  pDegatAtt,  pDegatMagie,  distMax,  pParade,  pos);
        this.setPtMana(10);
    }
        

    @Override
     public void affiche ()
    {
        System.out.println("Un Mage!Nom: \n" + this.getNom() + ",Position: ");
        this.getPos().affiche();
    }
    /**
     *  Combat magique
     * 
     * @param c  la creature
     */
        public void combattre (Creature c) 
    {
            System.out.println ("Log de Combat!");
           if (this.getPtMana() > 0 && this.getPos().distance(c.getPos()) >= 1 && this.getPos().distance(c.getPos()) <= this.getDistAttMax())
           {
               this.setPtMana(this.getPtMana()-1);
               Random alea = new Random();
               int attAlea = alea.nextInt(99)+ 1;
                if(!(attAlea > this.getPourcentageMag()))
                {
                    System.out.println ("Attaque Reussie!");
                    int degAlea = alea.nextInt(99)+ 1;
                    
                   if(degAlea > c.getPourcentagePar())
                   {
                    System.out.println ("Defense Ratee!");
                    c.setPtVie(c.getPtVie() - this.getDegMag()); // defense rate 
                   } else 
                   {
                    System.out.println ("Defense Reussi!");
                    c.setPtVie(c.getPtVie() - this.getDegMag() + c.getPtPar()); // defense reussie
                   }
                    System.out.println ("Points de vie restant: " + c.getPtVie());
                }
                else
                {
                     System.out.println ("Attaque ratee!");
                }
               
           }
                c.checkGameOver();
    }
}
