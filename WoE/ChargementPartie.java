/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author igorl
 */
public class ChargementPartie {
    
         /**
     * @param source nom du fichier
     * @param fichier buffer du fichier
     * @param world le nouveau world crée
     * @param larguer taille du monde selon x
     * @param longueur taille du monde selon y
     * @param creatures toutes les creatures qui seront cree dans le monde a partir du fichier de lecture
     * @param objets toutes les objets qui seront cree dans le monde a partir du fichier de lecture
     */
    private String source;
    BufferedReader fichier;
    private World world;
    private int largeur, longeur;
    private ArrayList <Creature> creatures;
    private ArrayList <Objet> objets;
    
     /**
     *  Constructor  
     * @param source nom du fichier a partir duquel on va creer le monde
     */
    public ChargementPartie (String source) 
    {
        creatures = new ArrayList <Creature> ();
        objets = new ArrayList <Objet>();
         this.source = source;
         chargerPartie();
    }
    /**
     * On crée plusieurs créatures et objets en prenant les attributs d'un fichier
     * @return un nouveau monde
     */
    public World chargerPartie() 
    {
        String ligne;

        try { 
        fichier = new BufferedReader(new FileReader(this.source));
        ligne = fichier.readLine();
        while (ligne != null) 
        {
           initialiserObjets (ligne); 
           ligne = fichier.readLine();      
        }
        fichier.close();
        } 
        catch (Exception e){e.printStackTrace();}
        
        // inicialiser le monde avec toutes les informations
        world = new World (largeur, longeur, creatures, objets);
        return world;
    }
    
      /**
     * On prend un ligne du fichier pour lire tout les attributs et on crée un entité 
     */
    public void initialiserObjets (String lectureLine)
    {
        String delimiteurs = " ,.;";
        
     // --------les informations qu'on peut trouver dans le fichier:
       int pVie,pMana,prAtt ,prParade ,prMagie,prResMagie, pDegatAtt, pDegatMagie,distMax,pParade, posx, posy, pSoin,nbFleches; 
       String nom;
     //---------------------  
       boolean  playerAtt = false;
       
       String attribut;
       StringTokenizer tokenizer; 
       tokenizer = new StringTokenizer(lectureLine, delimiteurs);
        attribut = tokenizer.nextToken();
        attribut = attribut.toLowerCase();
        
       do {
        switch (attribut) 
        {
            case "player":
               attribut =  tokenizer.nextToken(); 
               attribut = attribut.toLowerCase();
               playerAtt = true;
                break;
            case "largeur":
              largeur =  Integer.parseInt(tokenizer.nextToken());
                break;
            case "hauteur":
              longeur = Integer.parseInt(tokenizer.nextToken());
                break;
            case "guerrier":
              
                nom = tokenizer.nextToken(); 
                pVie = Integer.parseInt(tokenizer.nextToken());
                pMana = Integer.parseInt(tokenizer.nextToken());
                prAtt = Integer.parseInt(tokenizer.nextToken());
                prParade = Integer.parseInt(tokenizer.nextToken());
                prMagie = Integer.parseInt(tokenizer.nextToken());
                prResMagie = Integer.parseInt(tokenizer.nextToken());
                pDegatAtt = Integer.parseInt(tokenizer.nextToken());
                pDegatMagie = Integer.parseInt(tokenizer.nextToken());
                distMax = Integer.parseInt(tokenizer.nextToken());
                pParade = Integer.parseInt(tokenizer.nextToken());
                posx = Integer.parseInt(tokenizer.nextToken());
                posy = Integer.parseInt(tokenizer.nextToken());
                Guerrier g = new Guerrier (nom, pVie,pMana,prAtt,prParade,prMagie,prResMagie,pDegatAtt,pDegatMagie,distMax,pParade,new Point2D(posx, posy));
                creatures.add(g);
                if (playerAtt)
                {
                    World.player1 = g;
                    playerAtt = false;
                }

                break;
            case "mage":
                nom = tokenizer.nextToken(); 
                pVie = Integer.parseInt(tokenizer.nextToken());
                pMana = Integer.parseInt(tokenizer.nextToken());
                prAtt = Integer.parseInt(tokenizer.nextToken());
                prParade = Integer.parseInt(tokenizer.nextToken());
                prMagie = Integer.parseInt(tokenizer.nextToken());
                prResMagie = Integer.parseInt(tokenizer.nextToken());
                pDegatAtt = Integer.parseInt(tokenizer.nextToken());
                pDegatMagie = Integer.parseInt(tokenizer.nextToken());
                distMax = Integer.parseInt(tokenizer.nextToken());
                pParade = Integer.parseInt(tokenizer.nextToken());
                posx = Integer.parseInt(tokenizer.nextToken());
                posy = Integer.parseInt(tokenizer.nextToken());
                Mage m = new Mage (nom, pVie,pMana,prAtt,prParade,prMagie,prResMagie,pDegatAtt,pDegatMagie,distMax,pParade,new Point2D(posx, posy));
                creatures.add(m);
                   if (playerAtt)
                {
                    World.player1 = m;
                    playerAtt = false;
                }
                break;
            case "archer":
                nom = tokenizer.nextToken(); 
                pVie = Integer.parseInt(tokenizer.nextToken());
                pMana = Integer.parseInt(tokenizer.nextToken());
                prAtt = Integer.parseInt(tokenizer.nextToken());
                prParade = Integer.parseInt(tokenizer.nextToken());
                prMagie = Integer.parseInt(tokenizer.nextToken());
                prResMagie = Integer.parseInt(tokenizer.nextToken());
                pDegatAtt = Integer.parseInt(tokenizer.nextToken());
                pDegatMagie = Integer.parseInt(tokenizer.nextToken());
                distMax = Integer.parseInt(tokenizer.nextToken());
                pParade = Integer.parseInt(tokenizer.nextToken());
                posx = Integer.parseInt(tokenizer.nextToken());
                posy = Integer.parseInt(tokenizer.nextToken());
                nbFleches = Integer.parseInt(tokenizer.nextToken());
                
                Archer a = new Archer (nom, pVie,pMana,prAtt,prParade,prMagie,prResMagie,pDegatAtt,pDegatMagie,distMax,pParade,new Point2D(posx, posy),nbFleches);
                creatures.add(a);
                   if (playerAtt)
                {
                    World.player1 = a;
                    playerAtt = false;
                }
                break;
            case "paysan":
                  nom = tokenizer.nextToken(); 
                pVie = Integer.parseInt(tokenizer.nextToken());
                pMana = Integer.parseInt(tokenizer.nextToken());
                prAtt = Integer.parseInt(tokenizer.nextToken());
                prParade = Integer.parseInt(tokenizer.nextToken());
                prMagie = Integer.parseInt(tokenizer.nextToken());
                prResMagie = Integer.parseInt(tokenizer.nextToken());
                pDegatAtt = Integer.parseInt(tokenizer.nextToken());
                pDegatMagie = Integer.parseInt(tokenizer.nextToken());
                distMax = Integer.parseInt(tokenizer.nextToken());
                pParade = Integer.parseInt(tokenizer.nextToken());
                posx = Integer.parseInt(tokenizer.nextToken());
                posy = Integer.parseInt(tokenizer.nextToken());
                
                Paysan p = new Paysan (nom, pVie,pMana,prAtt,prParade,prMagie,prResMagie,pDegatAtt,pDegatMagie,distMax,pParade,new Point2D(posx, posy));
                creatures.add(p);
                playerAtt = false;
                break;
            case "loup":
                pVie = Integer.parseInt(tokenizer.nextToken());
                prAtt = Integer.parseInt(tokenizer.nextToken());
                prParade = Integer.parseInt(tokenizer.nextToken());
                pDegatAtt = Integer.parseInt(tokenizer.nextToken());
                pParade = Integer.parseInt(tokenizer.nextToken());
                posx = Integer.parseInt(tokenizer.nextToken());
                posy = Integer.parseInt(tokenizer.nextToken());
                Loup l = new Loup (pVie,prAtt,prParade,pDegatAtt,pParade, new Point2D(posx, posy));
                creatures.add(l);
                playerAtt = false;
                break;
            case "lapin":
                pVie = Integer.parseInt(tokenizer.nextToken());
                prAtt = Integer.parseInt(tokenizer.nextToken());
                prParade = Integer.parseInt(tokenizer.nextToken());
                pDegatAtt = Integer.parseInt(tokenizer.nextToken());
                pParade = Integer.parseInt(tokenizer.nextToken());
                posx = Integer.parseInt(tokenizer.nextToken());
                posy = Integer.parseInt(tokenizer.nextToken());
                Lapin lp = new Lapin(pVie,prAtt,prParade,pDegatAtt,pParade, new Point2D(posx, posy));
                creatures.add(lp);
                playerAtt = false;
                break;
            case  "nuageToxique":
              //  int prAtt, int prParade, int pAtt, int pParade, Point2D pos
                prAtt = Integer.parseInt(tokenizer.nextToken());
                prParade = Integer.parseInt(tokenizer.nextToken());
                pDegatAtt = Integer.parseInt(tokenizer.nextToken());
                pParade = Integer.parseInt(tokenizer.nextToken());
                posx = Integer.parseInt(tokenizer.nextToken());
                posy = Integer.parseInt(tokenizer.nextToken());
                NuageToxique n = new NuageToxique(prAtt,prParade,pDegatAtt,pParade, new Point2D(posx, posy));
                objets.add(n);
                playerAtt = false;
                
                break; 
                
            case "soin":
                pSoin = Integer.parseInt(tokenizer.nextToken());
                posx = Integer.parseInt(tokenizer.nextToken());
                posy = Integer.parseInt(tokenizer.nextToken());
                Soin s = new Soin (pSoin, new Point2D(posx, posy));
                objets.add(s);
                playerAtt = false;
            
                break;
                
            case "mana":
                pMana = Integer.parseInt(tokenizer.nextToken());
                posx = Integer.parseInt(tokenizer.nextToken());
                posy = Integer.parseInt(tokenizer.nextToken());
                Mana mana = new Mana (pMana, new Point2D(posx, posy));
                objets.add(mana);
                playerAtt = false;
                
            default:
                playerAtt = false;
                break;
  
        }
       }while (playerAtt);
       
    }
      
    
}

