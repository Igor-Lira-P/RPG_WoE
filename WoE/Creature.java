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
public abstract class Creature extends ElementDeJeu{
     
     //Attributs 
    /**
    *@param ptVie Points de vie du personnage
    *@param pourcentageAtt Pourcentage de reussir un attaque
    * @param pourcentagePar pourcentage de réussir une défense 
    * @param degAtt  Les Dégâts de l'attaque 
    * @param ptPar Points de défense si on réussit à défendre l’attaque  
    */
    
     private int ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar;
     private Point2D pos;
     private int creatureId;
     
     public Creature (int  pV, int pA, int pP, int dA, int ptPar, Point2D pos)
     {
     this.pos = pos;
     this.ptVie = pV;
     this.pourcentageAtt = pA;
     this.pourcentagePar = pP;
     this.degAtt = dA;
     this.ptPar = ptPar;
     }
     public Creature (Creature c)
     {
      pos = c.pos;
      ptVie = c.ptVie;
      pourcentageAtt = c.pourcentageAtt;
      pourcentagePar = c.pourcentagePar;
      degAtt = c.degAtt;
      ptPar = c.ptPar;
     }
     
        public Creature ()
     {
      pos = new Point2D();
      ptVie = 100;
      pourcentageAtt = 50;
      pourcentagePar = 50;
      degAtt = 5;
      ptPar = 10;
      
     }
      public Creature (int id)
     {
      pos = new Point2D();
      ptVie = 100;
      pourcentageAtt = 50;
      pourcentagePar = 50;
      degAtt = 5;
      ptPar = 10;
      creatureId = id;
     }
      public int getPtVie () 
    {
         return  ptVie; 
    }
    public void setPtVie (int ptV)
    {
          ptVie = ptV;
    }   
    public int getPourcentageAtt () 
    {
         return  pourcentageAtt; 
    }
    public void setPourcentageAtt (int pA)
    {
          pourcentageAtt = pA;
    }  
    public int getPourcentagePar () 
    {
         return  pourcentagePar; 
    }
    public void setPourcentagePar (int pP)
    {
          pourcentagePar = pP;
    }
    public int getDegAtt () 
    {
         return  degAtt; 
    }
    public void setDegAtt(int dA)
    {
          degAtt = dA;
    }
     public Point2D getPos () 
    {
         return  pos; 
    }
    public void setPos (Point2D pos)
    {
          this.pos.setPosition(pos.getX(),pos.getY());
          
    }
    public int getPtPar()
    {
        return this.ptPar;
    }
    public void setPtPar (int ptPar)
    {
        this.ptPar = ptPar;
    }
            
     public abstract void affiche ();
      /**
     * Effectuer un déplacement de la creature si possible
     * 
     * @param dx - le déplacement selon l'axe x
     * @param dy - le déplacement selon l'axe y
     */
        
     public void deplace (int dx, int dy)
    {    
     if (! (Math.abs(dx) > 1 || Math.abs(dy) > 1))
     {
       Point2D newPos = new Point2D (this.pos.getX() + dx, this.pos.getY() + dy);
       
       if (World.posPossible(newPos))
       {
       this.pos.setX(newPos.getX());
       this.pos.setY(newPos.getY());
       
       if(this instanceof Personnage)
       {
            World.ramasserObjet(((Personnage)this));
       }      
       // Verifier s'il y a une potion dans la nouvelle position:
       
       }
       else 
       {
           System.out.println("Decplamente n'est pas possible!");
       }
     }
    }
   public void checkGameOver () {
       if (this.ptVie <1)
       {
           World.toutCreature.remove(this);
           if (this.equals(World.player1))
           {
               System.out.println ("C'est fini!!! GAMEOVER");
           }
       }
   }
      /**
     * Methode afflicher quelques informations du personnage soit nom et position

     */

}
