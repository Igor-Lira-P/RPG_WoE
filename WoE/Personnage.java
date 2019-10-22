/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import static java.time.Clock.system;
import java.util.ArrayList;

/**
 *
 * @author igorl
 */
public abstract class Personnage extends Creature {
    //Attributs 
    /**
    *@param nom Le nom du personnage
    *@param distAttMax La distance maximale permis pour effectuer un attaque
    *@param ptMana Point de Mana
    *@param porcentageMag Pourcentage de reussir un attaque magique
    *@param pourcentageResistMag Resistir un attaque magique
    *@param degMag Les Dégâts de l'attaque magique  
    */
    
    private String nom;
    private int distAttMax;
    private int ptMana, porcentageMag, pourcentageResistMag, degMag;
    private ArrayList<Nourriture> nourritureListe;
  
    
    
    public Personnage (String nom, int pVie, int pMana, int prAtt, int prParade, int prMagie, int prResMagie, int pDegatAtt, int pDegatMagie, int distMax, int pParade, Point2D pos)
    {
     super (pVie,  prAtt,  prParade, pDegatAtt, pParade, pos);
     this.distAttMax = distMax; 
     this.nom = nom;
     this.ptMana = pMana;
     this.degMag = pDegatMagie;
     this.porcentageMag = prMagie;
     this.pourcentageResistMag = prResMagie;
     
     
     nourritureListe = new ArrayList<Nourriture>();
    }    
    
    public Personnage (Personnage perso)
    {
     super (perso);
     this.nom = perso.nom;
     distAttMax = perso.distAttMax; 
     nourritureListe = perso.nourritureListe;
        
    }
    public Personnage ()
    {
     super();
     this.nom = "unnamed";
     distAttMax = 1; 
     this.setDegAtt(20);
     nourritureListe = new ArrayList<Nourriture>();
    }
       
    public String getNom ()
    {
        return nom;
    }
    public void setNom (String nom)
    {
        this.nom = nom;
    }

 public int getDistAttMax () 
    {
         return  distAttMax; 
    }
    public void setDistAttMax (int distMax)
    {
          this.distAttMax = distMax;
    }
     public int getPtMana () 
    {
         return  ptMana; 
    }
    public void setPtMana (int ptM)
    {
          ptMana = ptM;
    }

    
     public int getPourcentageMag () 
    {
         return  porcentageMag; 
    }
    public void setPourcentageMag (int pM)
    {
          porcentageMag = pM;
    }
    
    public int getPourcentageResistMag () 
    {
         return  pourcentageResistMag; 
    }
    public void setPourcentageResistMag (int rM)
    {
          pourcentageResistMag = rM;
    }
  
    
     public int getDegMag () 
    {
         return  degMag; 
    }
    public void setDegMag(int dM)
    {
          degMag = dM;
    }
    
    public void combattre (Creature c) {}
    
    public ArrayList<Nourriture> getNourritureListe ()
    {
        return this.nourritureListe;
    }
    public void setNourritureListe (Nourriture n)
    {
        this.nourritureListe.add(n);
    }
    public void modifierDureeNourriture ()
    {
        Nourriture nRemove=null;
       for (Nourriture n: this.nourritureListe)
        {
            if (n.getDuree() > 1)
            {
                n.setDuree(); 
            }
            else 
            {
               // Eliminer l'effet de la nourriture:
                this.setPourcentageAtt(this.getPourcentageAtt() - n.getpAtt());
                System.out.println ("L'effet d'un nourriture vien de finir, votre Pourcentage de reussir un attaque est desormais: " + this.getPourcentageAtt());
                nRemove = n;
            }  
        }
       if(nRemove !=null){
       this.nourritureListe.remove(nRemove);
       }
    }
    
    
}
