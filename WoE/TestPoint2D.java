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
public class TestPoint2D {

     public static void main(String[] args) {
         System.out.println("Ici, on a crée un point p1");
         Point2D p1;
         p1 = new Point2D(1,1);
     
         System.out.println("Ici, on a crée un point p2 à partir de p1");
         Point2D p2;
         p2 = new Point2D(p1);
         
         p1.setX(3);
         System.out.println("Ici, on montre que p1 et p2 sont deux objects différents");
         p1.affiche();
         p2.affiche();
         
         System.out.println("Ici, on a mis des nouvelles coordonnées pour les 2 points");
         p1.setPosition(5, 5);
         p2.setPosition(7, 3);
        
         p1.affiche();
         p2.affiche();
         
         System.out.println("Ici, on a transladé les deux points");
         p1.translate(3, 3);
         p2.translate(4, 4);
         
         p1.affiche();
         p2.affiche();
     }
}
