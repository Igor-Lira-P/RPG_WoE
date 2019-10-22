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
public class Lapin extends Monstre {
    
    public Lapin ()
    {
    super ();
    }
    
    public Lapin (Lapin l)
    {
        super ( l);
    }
    
    public Lapin (int pV ,int pA, int pP, int dA,int ptPar,  Point2D pos) 
    {
      super (pV,pA,pP,dA,ptPar,pos );
        
    }
    
    
}
