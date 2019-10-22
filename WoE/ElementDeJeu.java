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
public abstract class ElementDeJeu {
    public static int typeClavier;
    public int tourGameOver;
    
    public ElementDeJeu ()
    {
        this.tourGameOver = 50;
    }
    
    public void setTourGameOver ()
    {
        this.tourGameOver = this.tourGameOver - 1;
        if (this.tourGameOver == 0 || World.player1.getPtVie() < 0)
        {
             System.out.println ("GAME OVER!");
             World.isOver = true;
        }
        if (World.toutCreature.size() == 0)
        {
             System.out.println ("BIEN JOUE !!!");
             World.isOver = true;
        }
    }
    public void affiche ()
    {
        System.out.println ("----------------------- Vous avez " + this.tourGameOver + " tours pour finir la partie!!!-----------------------");
        System.out.println ("----------------------- Il reste " + World.toutCreature.size() + " creatures a touer pour gagner le jeu! -------------------\n");
        System.out.println ("----------------------- Points de vie : " + World.player1.getPtVie() + "! -------------------\n");
    }
    
}
