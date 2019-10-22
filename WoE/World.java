/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author igorl
 */

public class World {


    public static ArrayList<Creature> toutCreature;
    public static ArrayList<Objet> toutObjet ;
    public static int TAILLE_X;
    public static int TAILLE_Y;
    private Joueur p1;
    public static Personnage player1;
    public static boolean isOver;
    public ElementDeJeu ElementJeu = new ElementDeJeu() {};

    /**
     * Constructor pour creer un monde aleatoire
     */
    public World() {
        //Initialiser les creatures et les objets
        toutObjet = new ArrayList<Objet> ();
        toutCreature = new ArrayList<Creature>(); 
        TAILLE_X = 7;
        TAILLE_Y = 7;
        creeMondeAlea();
        World.isOver = false;
        
    }
    /**
    Constructor pour le cas d'un chargement de jeu 
    */
    
 public World (int larguer, int longueur, ArrayList <Creature> creatures , ArrayList <Objet> objets)
 {
     World.TAILLE_X = larguer; 
     World.TAILLE_Y = longueur;
     //les entites sont deja place!
     toutObjet = new ArrayList<Objet>(objets);
     toutCreature = new ArrayList<Creature>(creatures);
     World.isOver = false;
     chargementMonde ();
 }

    /**
     * Creer un monde et y placer les personnages aleatoirement
     */
    public void creeMondeAlea() 
    {
        
        //initialiser plusieurs creatures et objets
       for (int i = 0; i < 5; i++) 
       {
            toutCreature.add(new Archer());
            toutCreature.add(new Mage());
            toutObjet.add(new Soin());
            toutObjet.add(new Mana());
            toutObjet.add(new Nourriture());
            toutObjet.add(new NuageToxique());
            toutObjet.add(new NuageToxique());
        }
        // Placer les objets
        for (Objet o : toutObjet) {
            placerAleaObjet(o);
        }
        // Placer les creatures
        for (Creature c : toutCreature) {
            placerAleaCreature(c);
        } 
        
        p1 = new Joueur();
        player1 = p1.creerPersonnage();
        
        
        // Placer le joueur
        placerAleaCreature(player1);
        //on commanence le jeu !
        do {
            afflicheWord();
            tourDeJeu(player1);
        }while (!World.isOver);

    }

    public void chargementMonde ()
    {
        //on commanence le jeu !
     do {
            afflicheWord();
            tourDeJeu(player1);
        } while (!World.isOver);
    }
            
     /**
      * A chaque tour, le joeur peut choisir: deplacer, combattre ou sauvergarder la partie courrante.
      * @param player le joueur
      */          
    public void tourDeJeu(Personnage player) 
    {
        Scanner scanner = new Scanner(System.in);
        String action, direction;
        ArrayList<Integer> directionVector;

        System.out.println("Deplacer (d), Combattre (c) ou Sauvergarder (s)?");
        action = scanner.nextLine();
        switch (action) {
            case "d":
                direction = scanner.nextLine();
                directionVector = stringToDirection(direction);
                player.deplace(directionVector.get(0), directionVector.get(1));
             //   player.affiche();
                player.modifierDureeNourriture();
                
                break;

            case "c":
                System.out.println("Quelle case est la creature? ");
                direction = scanner.nextLine();
                directionVector = stringToDirection(direction);
                Point2D posCreatureAtaquee = new Point2D(player.getPos().getX() + directionVector.get(0), player.getPos().getY() + directionVector.get(1));

                // On cherche la creature qui est situe sur posCreatureAtaquee.
                for (Creature c : toutCreature) {
                    if (c.getPos().getX() == posCreatureAtaquee.getX() && c.getPos().getY() == posCreatureAtaquee.getY()) {
                        ((Combattant) player).combattre(c);
                        player.modifierDureeNourriture();
                        // LA creature va attaquer le joueur si elle implement Combattant
                        if (c instanceof Combattant) 
                        {
                        System.out.println("Un" + c.getClass().getSimpleName() + " est en train de t'attaquer!");    
                        ((Combattant)c).combattre(player);
                        System.out.println("Vos points de vie :" + player.getPtVie());
                        }
                        break;
                    }

                }
                break;
                
            case "s" :
                SauvegarderPartieCourrante ();
                 System.exit(0); 
                break;

        }
        World.isThereNuage();
        
        ElementJeu.setTourGameOver();
        ElementJeu.affiche();
        
        mettreAjour ();

    }

    /**
     * Placer aléatoirement une créature dans le monde.
     *
     * @param c une créature
     */
    public void placerAleaCreature(Creature c) {
        Random alea = new Random();
        double angleAlea;
        int rayonAlea;

        //Si c est la premier creature dans le monde:
        if (toutCreature.isEmpty()) {
            Point2D posAlea = new Point2D(alea.nextInt(TAILLE_X), alea.nextInt(TAILLE_Y));
            c.setPos(posAlea);
        } else {
            Point2D cRef = World.toutCreature.get(alea.nextInt(toutCreature.size())).getPos();
            Point2D posTest = new Point2D(cRef);

            while (!World.posPossible(posTest)) {
                angleAlea = 2 * Math.random() * PI; // angle en radian entre 0 a 2pi
                rayonAlea = (int) alea.nextInt(4) + 1; // prendre un rayon entre 0 et 5
                posTest.setX(cRef.getX() + (int) (rayonAlea * cos(angleAlea)));
                posTest.setY(cRef.getY() + (int) (rayonAlea * sin(angleAlea)));
                cRef = World.toutCreature.get(alea.nextInt(toutCreature.size())).getPos();
            }
            c.setPos(posTest);
        }
        // World.toutPos.add(c.getPos());

    }

    /**
     * Placer aléatoirement un Objet dans le monde.
     *
     * @param o un Objet
     */

    public void placerAleaObjet(Objet o) 
    {
        Random alea = new Random();
        Point2D posAlea = new Point2D(alea.nextInt(TAILLE_X), alea.nextInt(TAILLE_Y));
        o.setPos(posAlea);
    }

  
    /**
     * Representer le monde par une matrice, 
     * 0 - cases vides
     * 1 - creature
     * 2 - Potion Sion 
     * 3 - Potion Mana
     * 4 - Nourriture 5 - un joueur speciale (controle)
     */
    public void afflicheWord() {

        System.out.println ("------------------WOE----------------------");
        String[][] matrix = new String[World.TAILLE_X + 1][World.TAILLE_Y + 1];
        for (int i =0; i< World.TAILLE_X + 1; i++){for (int j =0; j< World.TAILLE_Y + 1; j++){ matrix[i][j] = " 0 "; }}

        // Remplir la matrice 

        
  
        for (Objet o : toutObjet) {
            
            if (o instanceof Soin) {
                matrix[o.getPos().getX()][o.getPos().getY()] = " s ";
            }
            if (o instanceof Mana) {
                matrix[o.getPos().getX()][o.getPos().getY()] = " m ";
            }
            if (o instanceof Nourriture) {
                matrix[o.getPos().getX()][o.getPos().getY()] = " n ";
            }
            matrix[player1.getPos().getX()][player1.getPos().getY()] = "YOU";
        }
        
        for (Objet o : toutObjet)
        {
            if (o instanceof NuageToxique)
            {
                if ((((NuageToxique)o).getVisibilite()))
                {
                    ((NuageToxique)o).setVisibilite();
                    matrix[o.getPos().getX()][o.getPos().getY()] = "XXX";
                } 
            }
        }
        
          for (Creature c : toutCreature) {
            if (c instanceof Guerrier)
            {
                matrix[c.getPos().getX()][c.getPos().getY()] = " G ";
            }
             if (c instanceof Archer)
            {
                matrix[c.getPos().getX()][c.getPos().getY()] = " A ";
            }
              if (c instanceof Mage)
            {
                matrix[c.getPos().getX()][c.getPos().getY()] = " M ";
            }
              if (c instanceof Loup)
              {
                  matrix[c.getPos().getX()][c.getPos().getY()] = " L ";
              }
        }

        // Afficher :
        for (int j = World.TAILLE_Y; j > -1; j--) {
            for (int i = 0; i < World.TAILLE_Y + 1; i++) {
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }
         System.out.println ("------------------------------------------------");
    }

    /**
     * Vérifier si un point est occupé par une créature ou s’il appartient au
     * monde. Il retourne True s'il n'y pas de personnage dans cette position et
     * le point appartien au monde.
     *
     * @param pos postion
     * @return boollean
     */
    public static boolean posPossible(Point2D pos) {
        boolean T = true;

        if (pos.getX() < 0 || pos.getX() > World.TAILLE_X || pos.getY() < 0 || pos.getY() > World.TAILLE_Y) {
            T = false;
        } else {
            for (Creature c : toutCreature) {
                if (pos.isEqual(c.getPos())) {
                    T = false;
                }
            }
        }

        return T;

    }

    /**
     * Creer le monde avec l'interdition de la fonction interdiePosEnTroisUnites
     * ....
     *
     * @param c une creature
     */
    public void PlacerMondeAleaAvecInterdition(Creature c) {
        Random alea = new Random();
        Point2D posAlea;
        do {
            posAlea = new Point2D(alea.nextInt(TAILLE_X), alea.nextInt(TAILLE_Y));
        } while (interdiePosEnTroisUnites(posAlea));
        c.setPos(posAlea);

    }

    /**
     * Verifier si le point p est entourne par une creature ou non a une
     * distance de deux unités.
     *
     * @param p une position
     */
    public boolean interdiePosEnTroisUnites(Point2D p) {
        // On prend tout les caises qui entourne la creature en 3 unites et on utilise la varible posEntournee:
        boolean possible = true;

        for (int i = -2; i < 3; i++) {
            for (int k = -2; k < 3; k++) {
                if ((p.getX() + i < World.TAILLE_X && p.getX() + 1 > 0) && (p.getY() + k < World.TAILLE_Y && p.getY() + k > 0)) {
                    if (!posPossible(new Point2D(p.getX() + i, p.getY() + k))) // si il y a un creature, cela retourne false
                    {
                        possible = false;
                    }
                }
            }

        }
        return possible;
    }

    /**
     * Transformer une touche du clavier dans un Vector de deux entiers
     *
     * @param dir la touche du clavier qui porrait etre QWEADZXC
     */
    public static ArrayList<Integer> stringToDirection(String dir) {
        ArrayList<Integer> dirXY = new ArrayList();
        
        if(ElementDeJeu.typeClavier == 2)
        {
 
        switch (dir) { // QWERTY
            case "q":
                dirXY.add(0, -1);
                dirXY.add(1, 1);
                break;
            case "w":
                dirXY.add(0, 0);
                dirXY.add(1, 1);
                break;
            case "e":
                dirXY.add(0, 1);
                dirXY.add(1, 1);
                break;
            case "a":
                dirXY.add(0, -1);
                dirXY.add(1, 0);
                break;
            case "d":
                dirXY.add(0, 1);
                dirXY.add(1, 0);
                break;
            case "z":
                dirXY.add(0, -1);
                dirXY.add(1, -1);
                break;
            case "x":
                dirXY.add(0, 0);
                dirXY.add(1, -1);
                break;
            case "c":
                dirXY.add(0, 1);
                dirXY.add(1, -1);
                break;
            default:
                System.out.println("Direction n'est pas possible");
                dirXY.add(0, 0);
                dirXY.add(0, 0);
           
                break;
        }
        }else{
               switch (dir) { //AZERTY
            case "a":
                dirXY.add(0, -1);
                dirXY.add(1, 1);
                break;
            case "z":
                dirXY.add(0, 0);
                dirXY.add(1, 1);
                break;
            case "e":
                dirXY.add(0, 1);
                dirXY.add(1, 1);
                break;
            case "q":
                dirXY.add(0, -1);
                dirXY.add(1, 0);
                break;
            case "d":
                dirXY.add(0, 1);
                dirXY.add(1, 0);
                break;
            case "w":
                dirXY.add(0, -1);
                dirXY.add(1, -1);
                break;
            case "x":
                dirXY.add(0, 0);
                dirXY.add(1, -1);
                break;
            case "c":
                dirXY.add(0, 1);
                dirXY.add(1, -1);
                break;
            default:
                System.out.println("Direction n'est pas possible");
                dirXY.add(0, 0);
                dirXY.add(0, 0);
           
                break;
        }
        }
        
        return dirXY;
    }

    /**
     * Verifier si une creature a trouve un objet. Si elle le ramasse, on fait
     * appel a la methode modifier de la classe objets.
     *
     * @param p Personnage
     */
    public static void ramasserObjet(Personnage p) {

        for (Objet o : World.toutObjet) {
            if(!( o instanceof NuageToxique))
            {
                if (o.getPos().isEqual(p.getPos())) {
                o.modifier(p);
                break;
            }
            }
        }

    }
    public void SetLarguerWorld (int largeur){
        this.TAILLE_X = largeur;
    }
     public void SetLongeurWorld (int longuer){
        this.TAILLE_Y = longuer;
    }
     
       /**
     * Sauvergarder fichier d'un facon unique
     */
     public void SauvegarderPartieCourrante (){
         
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HHmmss_SSS");
         SauvegarderPartie partie = new  SauvegarderPartie("partieSauvergarde" + formatter.format(new Date()) + ".txt");
         
     }
        /**
     * Changer visibilite d'une nuage
     */
     public static void isThereNuage ()
     {
         for (Objet o: toutObjet)
         {
             if (o instanceof NuageToxique)
             {
                  if (((NuageToxique)o).getPos().isEqual (player1.getPos()))
                  {
                       ((NuageToxique)o).setVisibilite();
                       ((NuageToxique)o).modifier (player1);
                       break;
        
                  }
    
              }
             }
         }
     
      public void mettreAjour ()
      {
       for (int i =0 ; i<World.toutCreature.size(); i++)
       {
           if (toutCreature.get(i).getPtVie() <0)
           {
               toutCreature.remove(toutCreature.get(i));
           }
       }
      }
     }
             
             

