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
public class Mana extends Portion{
    
    private int mana;
    public Mana ()
    {
        super();
        this.mana = 5;
    }
    public Mana (int mana, Point2D pos)
    {
        super(pos);
        this.mana = mana; 
    }
    public int getMana ()
    {
        return this.mana;
    }
    public void modifier (Personnage p)
    {
     if (p instanceof Mage) {
     System.out.println ("Vous avez consume un potion Mana \n Points de mana avant: " +  ((Mage)p).getPtMana());
     ((Mage)p).setPtVie(((Mage)p).getPtMana()+ this.mana);
     System.out.println ("Points de mana apres: " + ((Mage)p).getPtMana() );
     }
     else {
         System.out.println("Vous n'etes pas un mage pour prendre la potion Mana");
     }
    }
}
