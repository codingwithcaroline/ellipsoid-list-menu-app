import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
*This class stores the name.
*of the list and an ArrayList of
*Ellipsoid objects.
*@author Caroline Kirkconnell
*@version 2/14/2020
*/
public class EllipsoidList {

   private String ellipsoidName;
   private ArrayList<Ellipsoid> eList;
   
   /** 
    *Following the constructor is a list. 
    *of methods that return the name of the
    *list, number of Ellipsoid objects in the
    *EllipsoidList, total volume, total surface
    *area, average volume, and average surface
    *area for all the Ellipsoid objects in the
    *EllipsoidList. The toString method returns
    *a String containing the name of the list, 
    *followed by each Ellipsoid in the ArrayList
    *and a summaryInfo method returns summary
    *information about the list.
    *@param ellipsoidNameIn for listName
    *@param eListIn for eList
    */
   public EllipsoidList(String ellipsoidNameIn, ArrayList<Ellipsoid> eListIn) {
      ellipsoidName = ellipsoidNameIn;
      eList = eListIn;
   }
    
    /** 
    *@return the Ellipsoid name
    */
   public String getName() {
      return ellipsoidName;
   }
   
    /** 
    *@return the number of Ellipsoids
    */
   public int numberOfEllipsoids() {
      return  eList.size();
   }
   
    /** 
    *@return the total volume for all Ellipsoid objects.
    */
   public double totalVolume() {
      double totalVolume = 0;
      int index = 0;
      while (index < eList.size()) {
         totalVolume += eList.get(index).volume();
         index++;
      }
      
      return totalVolume;
   }
   
    /** 
    *@return the total surface area for all Ellipsoid objects.
    */
   public double totalSurfaceArea() {
      double totalSArea = 0;
      int index = 0;
      while (index < eList.size()) {
         totalSArea += eList.get(index).surfaceArea();
         index++;
      }
      
      return totalSArea;
   }
   
   /**
   *@return the average volume for all Ellipsoid objects.
   */
   public double averageVolume() {
      double averageVol = 0;
      if (eList.size() > 0)
      {
         averageVol = totalVolume() / eList.size();
         return averageVol;
      }
      return averageVol;
   }
   /**
   *@return the average surface area for all Ellipsoid objects.
   */
   public double averageSurfaceArea() {
      double avgSArea = 0;
      if (eList.size() > 0)
      {
         avgSArea = totalSurfaceArea() / eList.size();
         return avgSArea;
      }
      return avgSArea;
   }

   /** 
   *@return String containing the name of
   *the list followed by each Ellipsoid in 
   *the ArrayList. 
   *(includes name of Ellipsoid and the ellipsoid objects)
   */
   public String toString() {
      String result = ellipsoidName + "\n";
      int index = 0;
      while (index < eList.size()) {
         result += "\n" + eList.get(index) + "\n"; 
         index++;  
      }   
      return result;
   }
   
    /** 
    *@return String containing the name of
    *the list followed by various summary items:
    *number of Ellipsoid objects, total volume,
    *total surface area, average volume, and average
    *surface area. 
    *(includes name of ellipsoids and results for various method calls)
    */
   public String summaryInfo() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String result = "";
      result += "----- Summary for " + getName() + " -----"; 
      result += "\nNumber of Ellipsoid Objects: " + numberOfEllipsoids();
      result += "\nTotal Volume: " + df.format(totalVolume()) + " cubic units"; 
      result += "\nTotal Surface Area: "  
         + df.format(totalSurfaceArea()) + " square units";
      result += "\nAverage Volume: "  
         + df.format(averageVolume()) + " cubic units";
      result += "\nAverage Surface Area: " 
         + df.format(averageSurfaceArea()) + " square units";
    
      return result;
   }
    
    /**
    *@return ArrayList of Ellipsoid objects.
    *
    *
    */
   public ArrayList<Ellipsoid> getList() {
      return eList;
   }
    
    /**
    *Takes a String parameter representing the file name. 
    *reads in the file, storing the list name and creating 
    *an ArrayList of Ellipsoid objects, uses the list name 
    *and the ArrayList to create an EllipsoidList object.
    *@return the EllipsoidList object.
    *@param fileName - used.
    *@throws FileNotFoundException - used.
    */
   public EllipsoidList readFile(String fileName) throws FileNotFoundException {
      ArrayList<Ellipsoid> myList = new ArrayList<Ellipsoid>();
   
      //Scanner scan = new Scanner(System.in);
      //System.out.print("Enter file name: ");
      //String fileName = scan.nextLine();
      
      Scanner scanFile = new Scanner(new File(fileName));
   
      String ellipsoidListName = scanFile.nextLine();
      
      while (scanFile.hasNext()) {
      
         String label = scanFile.nextLine();
         double a = Double.parseDouble(scanFile.nextLine());
         double b = Double.parseDouble(scanFile.nextLine());
         double c = Double.parseDouble(scanFile.nextLine());
         
         Ellipsoid e = new Ellipsoid(label, a, b, c);
         myList.add(e);           
      }
      scanFile.close();
      
      EllipsoidList myEllipsoidList 
         = new EllipsoidList(ellipsoidListName, myList);
   
      return myEllipsoidList;                    
   }
   
    /**
    *Takes four parameters (label, a, b, and c), 
    *creates a new Ellipsoid object, and adds it
    *to the EllipsoidList object (i.e., adds it
    *to the ArrayList of Ellipsoid objects in the
    *EllipsoidList object.
    *@param label - used.
    *@param a - used.
    *@param b - used.
    *@param c - used.
    */
   public void addEllipsoid(String label, double a, 
      double b, double c) {
      Ellipsoid elNew = new Ellipsoid(label, a, b, c);
      eList.add(elNew);
    
   }
    
    /**
    *@return corresponding Ellipsoid object if.
    *found in the EllipsoidList object; otherwise
    *returns null.
    *Takes a label of an Ellipsoid as the String
    *parameter.
    *@param label - used.
    */
   public Ellipsoid findEllipsoid(String label) {
      for (Ellipsoid listItem: eList)
      {
         if (listItem.getLabel().equalsIgnoreCase(label))
         {
            return listItem;
         }
      }
      return null;
   }
       
    /**
    *@return the Ellipsoid if it is found in the.
    *EllipsoidList object and deleted; otherwise
    *returns null.
    *Takes a String as a parameter that represents
    *the label of the Ellipsoid.
    *@param label - used.
    */
   public Ellipsoid deleteEllipsoid(String label) {
      Ellipsoid varE1 = null;
      varE1 = findEllipsoid(label);
      if (findEllipsoid(label) != null)
      {
         
         eList.remove(varE1);
         return varE1;
      }
      return varE1;
   }
    
    /**
    *@return Ellipsoid object if found.
    *If not found, returns null.
    *Takes four parameters (label a, b, and c), 
    *uses the label to find the corresponding 
    *Ellipsoid object.
    *@param label - used
    *@param a - used.
    *@param b - used.
    *@param c - used.
    */
   public Ellipsoid editEllipsoid(String label, double a, 
      double b, double c) {
      Ellipsoid varE1 = null;
      varE1 = findEllipsoid(label);
      if (varE1 != null)
      {
         varE1.setA(a);
         varE1.setB(b);
         varE1.setC(c);
         return varE1;
      }
      return varE1;
   }
    
}





