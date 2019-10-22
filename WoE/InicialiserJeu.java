/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.awt.FileDialog;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author igorl
 */
public class InicialiserJeu {
    
    
     public static void main(String[] args)
     {
         World world;
         
         String modeJeu, nomFichier;
         System.out.println("A: un archer\n" +"M: un mage\n" + "G: un guerrier \nm: le mana\n" + "s: le soin\n" + "n: la nourriture");
         
        Scanner scanner = new Scanner(System.in);
         System.out.println("Quel type de clavier AZERTY (1) ou QWERTY (2)");
        ElementDeJeu.typeClavier = Integer.parseInt(scanner.nextLine());
         if( ElementDeJeu.typeClavier == 1)
         {
           System.out.println("Pour se deplacer utilise le clavier:\n A | Z | E \n Q |YOU| D \n W | X | C");  
         } else
         {
        System.out.println("Pour se deplacer utilise le clavier:\n Q | W | E \n A |YOU| D \n Z | X | C");
         }
        
        System.out.println("Inicialiser un monde aleatoire (a) ou charger (c) une partie?");
        
       
          modeJeu = scanner.nextLine();
          
          if (modeJeu.equals("a"))
          {
              world = new World ();
          }
          if (modeJeu.equals("c"))
          {
             try {
                 System.out.println("Nom du fichier?");
                 Runtime.getRuntime().exec("explorer.exe /select");
                 nomFichier = scanner.nextLine();
                 ChargementPartie nouveuJeu = new ChargementPartie(nomFichier);
            
             } 
             catch (IOException ex) {
                 Logger.getLogger(InicialiserJeu.class.getName()).log(Level.SEVERE, null, ex);
             }
               
          }
        
     }
}

