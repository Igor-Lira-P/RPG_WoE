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

public abstract class Objet extends ElementDeJeu {
    
     //Attributs 
    /**
    *@param pos position
    */
            private Point2D pos;
            
        
        public Objet ()
        {
            this.pos = new Point2D();
        }
             public Objet (Point2D pos)
        {
            this.pos = pos;
        }
        
        
         public Point2D getPos () 
    {
         return  this.pos; 
    }
    public void setPos (Point2D pos)
    {
          this.pos.setPosition(pos.getX(),pos.getY());
          
    }
       /**
     * Modifier les points du personnage, soit vie ou mana
     * @param c Personnage
     */
	
    public abstract void modifier (Personnage c);
}
