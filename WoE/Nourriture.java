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

public class Nourriture extends Objet{
    
//Attributs 
    /**
    *@param bonus false = malus, vrai = bonus au personnage
 
    */
    private int pAttBonus, pAttMalus;
    private int duree;
    private final boolean effet;
    
    public Nourriture ()
    {
        this.pAttBonus = 30;
        this.pAttMalus = -30;
        Random r = new Random ();
        this.effet = r.nextBoolean();
        this.duree = 4;
    }
    public void modifier (Personnage p)
    {       
        if (this.effet)
        {
            p.setPourcentageAtt(p.getPourcentageAtt() + this.pAttBonus);        
        }
        else 
        {
             p.setPourcentageAtt(p.getPourcentageAtt() + this.pAttMalus);
        }
        afficher(p);
        p.setNourritureListe(this);
        World.toutObjet.remove (this);
      }       
    public int getDuree ()
    {
        return this.duree;
    }
    public void setDuree ()
    {
        this.duree = this.duree -1;
    }
    public int getpAtt ()
    {
        int att;
        if (this.effet)
        {
            att = this.pAttBonus;
        }
        else
        {
            att = this.pAttMalus;
        }
        return att;
    }
    public boolean getEffet ()
    {
        return this.effet;
    }
    public void afficher (Personnage p)
    {
        System.out.println("Vous avez cosumme un nourriture ");
        if (this.effet)
        {
            System.out.println("---------BONUS " + this.pAttBonus + " pourcentage d'attaque ------------\n Pourcentage de reussir un attaque:" + p.getPourcentageAtt());
        }
        else {
            System.out.println("--------MALUS " + this.pAttMalus + " pourcentage d'attaque-------------\n Pourcentage de reussir un attaque:" + p.getPourcentageAtt());
    }
    }
    
}
