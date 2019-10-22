/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Scanner;

/**
 *
 * @author igorl
 */
public class  Joueur  {
    private String typePersonnage;
    private String nomPersonnage;
    private Personnage jouer;
    public Joueur () {
    }
    /**
     * L'utilisateur peut choisir le type de personnage et le nom
     * @return Personnage
     */
    public Personnage creerPersonnage ()
    {
        Scanner scanner = new Scanner(System.in);

         System.out.println("Veuillez saisir le type de Personnage\nGuerrier(g)\nArcher(a)\nMage(m)");
         typePersonnage = scanner.nextLine();
         System.out.println("Veuillez choisir un nom pour le personnage");
         scanner = new Scanner(System.in);
         nomPersonnage = scanner.nextLine();
        
         // lES ATTRIBUTS du player :
         
        int pVie = 200,  pMagie = 100,  prAtt = 60,  prParade= 10,  prMagie= 60,  prResMagie = 60,  pDegatAtt = 70 ,  pDegatMagie = 70,  distMax = 1,  pParade = 60;
        Point2D pos = new Point2D (0,0);
        
        switch (typePersonnage) 
        { 
            case "g":
            jouer = new Guerrier(nomPersonnage,  pVie,  pMagie,  prAtt,  prParade,  prMagie,  prResMagie,  pDegatAtt,  pDegatMagie,  distMax,  pParade,  pos); 
            break;
            case "a":
            jouer = new Archer(nomPersonnage,  pVie,  pMagie,  prAtt,  prParade,  prMagie,  prResMagie,  pDegatAtt,  pDegatMagie,  distMax,  pParade,  pos, 50);
            break;
             case "m":
            jouer = new Mage(nomPersonnage,  pVie,  pMagie,  prAtt,  prParade,  prMagie,  prResMagie,  pDegatAtt,  pDegatMagie,  distMax,  pParade,  pos);
            break;
            default:
            System.out.println ("Vous n'avez pas bien ecrit");
            System.exit(0);
            break;
        }
        jouer.setNom(nomPersonnage);
        return jouer;
    }
    public void affiche ()
    {
        
    }
 
}
