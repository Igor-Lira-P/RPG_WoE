/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author igorl
 */
public class SauvegarderPartie {
       
    
    private String source = "partieSauvergarde.txt";
    private BufferedWriter fichier;
     
    public SauvegarderPartie (String source)
    {
        this.source = source;
        SauvegarderPartieCourrant(World.toutCreature, World.toutObjet);
    }
    public void SauvegarderPartieCourrant (ArrayList<Creature> creatures, ArrayList<Objet> objets)
    {
        String ligne;
     try { 
        fichier = new BufferedWriter(new FileWriter(this.source));

        for (Creature c: creatures)
        {
            if (c instanceof Personnage)
            {
                getTextePourauvergarder((Personnage)c, fichier);
                
            }
             if (c instanceof Monstre)
            {
                getTextePourauvergarder((Monstre)c, fichier);
                
            }
        }
                
       for (Objet o: objets)
       {
           if (o instanceof Mana)
           {
               getTextePourauvergarder ((Mana)o, fichier);
           }
           if (o instanceof Soin)
           {
                 getTextePourauvergarder ((Soin)o, fichier);
           }
           if (o instanceof NuageToxique)
           {
                 getTextePourauvergarder ((NuageToxique)o, fichier);
           }
       }
       getTextePourauvergarderPlayer (World.player1, fichier);
       fichier.write ("Largeur " + World.TAILLE_X);
        fichier.newLine();
       fichier.write ("Hauteur " + World.TAILLE_Y);
         fichier.newLine();        
        fichier.close();
        } 
        catch (Exception e){e.printStackTrace();}
            
    }
    
    public void getTextePourauvergarder (Personnage p, BufferedWriter fichier)
    {
        try {
                                                                                                        //(nom, pVie,pMana,prAtt,prParade,prMagie,prResMagie,pDegatAtt,pDegatMagie,distMax,pParade,new Point2D(posx, posy),nbFleches);
         if (p instanceof Archer){
              fichier.write(p.getClass().getSimpleName() + " " + ((Archer)p).getNom() + " "+ ((Archer)p).getPtVie()+" " +  p.getPtMana()+ " " + ((Archer)p).getPourcentageAtt()+ " " + ((Archer)p).getPourcentagePar() + " " + ((Archer)p).getPourcentageMag() + " " + p.getPourcentageResistMag() + " " + ((Archer)p).getDegAtt() + " " + ((Archer)p).getDegMag() + " " + ((Archer)p).getDistAttMax() + " " + ((Archer)p).getPtPar() + " " + ((Archer)p).getPos().getX() + " " + ((Archer)p).getPos().getY() + " " +  ((Archer) p).getNbFleches());
         }
         else
         {
              fichier.write(p.getClass().getSimpleName() + " " + p.getNom()+" " + p.getPtVie()+ " " +  p.getPtMana()+ " " + p.getPourcentageAtt()+ " " + p.getPourcentagePar() + " " + p.getPourcentageMag() + " " + p.getPourcentageResistMag() + " " +  p.getDegAtt() + " " + p.getDegMag() + " " + p.getDistAttMax() + " " + p.getPtPar() + " " + p.getPos().getX() + " " + p.getPos().getY() );
         }
           fichier.newLine();
             
        } catch (IOException ex) {
            Logger.getLogger(SauvegarderPartie.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
        public void getTextePourauvergarderPlayer (Personnage p, BufferedWriter fichier)
    {
        try {
          
         if (p instanceof Archer){
              fichier.write("Player "+  p.getClass().getSimpleName() + " " + ((Archer)p).getNom() + " "+ ((Archer)p).getPtVie()+" " + p.getPtMana() + " " + ((Archer)p).getPourcentageAtt()+ " " + ((Archer)p).getPourcentagePar() + " " + ((Archer)p).getPourcentageMag() + " " + p.getPourcentageResistMag() + " " +  ((Archer)p).getDegAtt() + " " + ((Archer)p).getDegMag() + " " + ((Archer)p).getDistAttMax() + " " + ((Archer)p).getPtPar() + " " + ((Archer)p).getPos().getX() + " " + ((Archer)p).getPos().getY() + " " + ((Archer) p).getNbFleches());
         }
         else
         {
              fichier.write("Player " + p.getClass().getSimpleName() + " " + p.getNom()+" "+p.getPtVie()+" " + p.getPtMana() + " " +  p.getPourcentageAtt()+ " " + p.getPourcentagePar() + " " + p.getPourcentageMag() + " " + p.getPourcentageResistMag() + " " +  p.getDegAtt() + " " + p.getDegMag() + " " + p.getDistAttMax() + " " + p.getPtPar() + " " + p.getPos().getX() + " " + p.getPos().getY() );
         }
           fichier.newLine();
             
        } catch (IOException ex) {
            Logger.getLogger(SauvegarderPartie.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void getTextePourauvergarder (Monstre m, BufferedWriter fichier)
    {
        try {
            fichier.write(m.getClass().getSimpleName() + " " + m.getPtVie()+ " " + m.getPourcentageAtt()+ " " + m.getPourcentagePar() +  " " + m.getDegAtt() +" " + m.getPtPar() + " " + m.getPos().getX() + " " + m.getPos().getY() );
             fichier.newLine();       
        } catch (IOException ex) {
            Logger.getLogger(SauvegarderPartie.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    public void getTextePourauvergarder (Mana m, BufferedWriter fichier)
    {
        try {
            fichier.write(m.getClass().getSimpleName() + " " + m.getMana() + " " + m.getPos().getX() + " " + m.getPos().getY());
             fichier.newLine();
        } catch (IOException ex) {
            Logger.getLogger(SauvegarderPartie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void getTextePourauvergarder (Soin s, BufferedWriter fichier)
    {
        try {
            fichier.write(s.getClass().getSimpleName() + " " + s.getSoin()+ " " + s.getPos().getX() + " " + s.getPos().getY());
             fichier.newLine();
        } catch (IOException ex) {
            Logger.getLogger(SauvegarderPartie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getTextePourauvergarder (NuageToxique n, BufferedWriter fichier)
    {
        try {
            fichier.write(n.getClass().getSimpleName() + " " + n.getPrAtt() + " " + n.getPrParade() + " " + n.getpAtt() + " " + n.getpParade() + " " + n.getPos().getX() + " " + n.getPos().getY());
             fichier.newLine();
        } catch (IOException ex) {
            Logger.getLogger(SauvegarderPartie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void  getTextePourauvergarder (Joueur j)
    {
        
    }
            
}
