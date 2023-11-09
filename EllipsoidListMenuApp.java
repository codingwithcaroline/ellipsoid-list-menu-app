import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
/**
*This program presents a menu.
*to the user with eight options
*and implements a series of
*functions.
*@author Caroline Kirkconnell
*@version 2/19/20
*/
public class EllipsoidListMenuApp {

/**
*Main method presents the user.
*with a menu with eight options.
*@param args - is not used.
*@throws FileNotFoundException if the file cannot be opened.
*/
   public static void main(String[] args) throws FileNotFoundException {
      String eListName = "no list name";
      ArrayList<Ellipsoid> myList = new ArrayList<Ellipsoid>();
      EllipsoidList myEList = new EllipsoidList(eListName, myList);
      String fileName = "no file name";
      
      //double label, a, b, c;   
      
      String code = "";
   
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Ellipsoid List System Menu\n"
                       + "R - Read File and Create Ellipsoid List\n"
                       + "P - Print Ellipsoid List\n" 
                       + "S - Print Summary\n"
                       + "A - Add Ellipsoid\n"   
                       + "D - Delete Ellipsoid\n"   
                       + "F - Find Ellipsoid\n"
                       + "E - Edit Ellipsoid\n"
                       + "Q - Quit");
   
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         code = scan.nextLine();
         if (code.length() == 0) {
            continue;
         }
         code = code.toUpperCase();
         char codeChar = code.charAt(0);
         switch(codeChar) {
         
            case 'R': //Reads input file which creates an
                   //EllipsoidList object.
               System.out.print("\tFile Name: ");
               fileName = scan.nextLine();
            
               myEList = myEList.readFile(fileName);
            
               System.out.println("\tFile read in and "
                              + "Ellipsoid List created\n");
               break;   
         
            case 'P': //Print Ellipsoid List
               System.out.println(myEList);
               break;
               
            case 'S': //Print list summary
               System.out.println("\n" + myEList.summaryInfo() + "\n");
               break;
          
            case 'A': //Adds an Ellipsoid object.
               System.out.print("\tlabel: ");
               String label = scan.nextLine();
               System.out.print("\ta: ");
               double a = Double.parseDouble(scan.nextLine());
               System.out.print("\tb: ");
               double b = Double.parseDouble(scan.nextLine());
               System.out.print("\tc: ");
               double c = Double.parseDouble(scan.nextLine());
            
               myEList.addEllipsoid(label, a, b, c);
               System.out.println("\t*** Ellipsoid added ***\n");
               break;   
              
            case 'D': //Deletes an Ellipsoid object.
               System.out.print("\tlabel: ");
               label = scan.nextLine();
               Ellipsoid e = myEList.deleteEllipsoid(label);
               if (e != null) {
                  System.out.println("\t\"" + e.getLabel() 
                                           + "\" deleted\n");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break; 
            
            case 'F': //Finds an Ellipsoid object.
               System.out.print("\tlabel: ");
               label = scan.nextLine();
               Ellipsoid found = myEList.findEllipsoid(label);
               if (found != null)
               {
                  System.out.println(found + "\n");
               }
               else
               {
                  System.out.println("\"" + label + "\"" + " not found\n");
               }
               break;
            
            case 'E': //Edits an Ellipsoid object.
               System.out.print("\tlabel: ");
               label = scan.nextLine();
               System.out.print("\ta: ");
               a = Double.parseDouble(scan.nextLine());
               System.out.print("\tb: ");
               b = Double.parseDouble(scan.nextLine());
               System.out.print("\tc: ");
               c = Double.parseDouble(scan.nextLine());
            
            
               Ellipsoid e1 = myEList.editEllipsoid(label, a, b, c);
               if (e1 != null) {
                  System.out.println("\t\"" + e1.getLabel() 
                                           + "\" successfully edited\n");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;  
                  
            case 'Q': //Quits the program.
               break;
               
            default:  //no match, loop again
               System.out.println("\t*** invalid code ***\n");
         }
      
      } while (!code.equalsIgnoreCase("Q"));   
      
   }
}
