/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author igorl
 */
public class ExemplesExceptions {
    
     public static void main(String[] args) 
     {
       


         
         try{
	ArrayList<Integer> list = new ArrayList<Integer>();
	list.add(2);
	Iterator<Integer> iterator = list.iterator();
	while(iterator.hasNext())  {
	Integer integer = iterator.next();
        if (integer==2)
        list.remove(integer);	
        }
         }
        catch(java.util.ConcurrentModificationException e)
        {
	System.out.println("Attention!" );
	System.out.println("Exception thrown  :" + e);
        }
       try
       {
	Object x = new Integer(0);
        System.out.println((String)x);
        }
        catch(ClassCastException e)
        {
	System.out.println("Attention!" );
	System.out.println("Exception thrown  :" + e);
        }
        
        try
        {
	ArrayList caractereList;
	caractereList = null;
	System.out.println(caractereList.add(1));
        }
        catch(NullPointerException e)
        {
	System.out.println("Exception thrown  :" + e);
        }
         try
        {
	int tableau[] = new int[2];
	System.out.println(tableau[2]);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
	System.out.println("Attention!" );
	System.out.println("Exception thrown  :" + e);
        }

       
         try 
         {
            System.out.println(2/0);
         }
         catch  (ArithmeticException e)
         {
             System.out.println("Vous avez mis un erreur arithmetic !");
         }

     }
}
