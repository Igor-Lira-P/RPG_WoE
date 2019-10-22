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
public class Paysan extends Personnage {
    
    public Paysan ()
    {
    super ();
    }
    public Paysan (Paysan p) 
    {
        super (p);
    }
    public Paysan (String nom, int pVie, int pMagie, int prAtt, int prParade, int prMagie, int prResMagie, int pDegatAtt, int pDegatMagie, int distMax, int pParade, Point2D pos)
    {
          super ( nom,  pVie,  pMagie,  prAtt,  prParade,  prMagie,  prResMagie,  pDegatAtt,  pDegatMagie,  distMax,  pParade,  pos);
    }
    @Override
        public void affiche ()
    {
        System.out.println("Un Paysan, sa position: ");
        this.getPos().affiche();
    }
}
