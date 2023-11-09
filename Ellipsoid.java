import java.text.DecimalFormat;
/**
*This program defines.
*Ellipsoid objects.
*@author Caroline Kirkconnell
*@version 2/5/2020
*/
public class Ellipsoid {
   private String label = "";
   private double a = 0;
   private double b = 0;
   private double c = 0;
/**
*This section of the code contains.
*the constructor followed by the methods
*required to gather information about the
*Ellipsoid object.
*@param labelIn - used.
*@param aIn - used.
*@param bIn - used.
*@param cIn - used.
*/
   public Ellipsoid(String labelIn, double aIn, double bIn, double cIn) 
   {
      setLabel(labelIn);
      setA(aIn);
      setB(bIn);
      setC(cIn);
   }
   //returns no parameters and returns
   //a String representing the label field.
   /**
   *@return label - used.
   */
   public String getLabel()
   {
      return label;
   }
   //Takes a String parameter and returns a boolean.
   //If the string parameter is not null, then the 
   //label field is set to "trimmed," String and
   //method returns true.
   /**
   *@param labelIn - used.
   *@return true or false - used.
   */
   public boolean setLabel(String labelIn)
   {
      if (labelIn != null)
      {
         label = labelIn.trim();
         return true;
      }
      return false;
   }
   //Accepts no parameters and returns a double
   //representing field a.
   /**
   *@return a - used.
   */
   public double getA()
   {
      return a;
   }
   //Accepts a double parameter and returns a boolean
   //as follows. If the double is greater than zero,
   //sets field a to the double passed in and returns
   //true. Otherwise, the method returns false and 
   //does not set the field.
   /**
      *@param aIn - used.
   *@return true or false - used.
   */
   public boolean setA(double aIn)
   {
      if (aIn > 0)
      {
         a = aIn;
         return true;
      }
      return false;
   }
   //Accepts no parameters and returns a double
   //representing field b.
   /**
   *@return b - used.
   */
   public double getB()
   {
      return b;
   }
   //Accepts a double parameter and returns a boolean
   //as follows. If the double is greater than zero,
   //sets field b to the double passed in and returns
   //true. Otherwise, the method returns false and 
   //does not set the field.
   /**
      *@param bIn - used.
   *@return true or false - used.
   */
   public boolean setB(double bIn)
   {
      if (bIn > 0)
      {
         b = bIn;
         return true;
      }
      return false;
   }
   //Accepts no parameters and returns a double
   //representing field c.
   /**
   *@return c - used.
   */
   public double getC()
   {
      return c;
   }
   //Accepts a double parameter and returns a boolean
   //as follows. If the double is greater than zero,
   //sets field c to the double passed in and returns
   //true. Otherwise, the method returns false and 
   //does not set the field.
   /**
      *@param cIn - used.
   *@return true or false - used.
   */
   public boolean setC(double cIn)
   {
      if (cIn > 0)
      {
         c = cIn;
         return true;
      }
      return false;
   }
   //Accepts no parameters and returns the double value
   //for the volume calculated using the given formula
   //and the values of the axes fields a, b, c.
   /**
      *@return volume - used.
   */
   public double volume()
   {
      double volume = ((4 * a * b * c * Math.PI) / 3);
      return volume;
   }
   //Accepts no parameters and returns the double value
   //for the surface area calculated using the given
   //formula and the values of axes fields a, b, c.
   /**
      *@return surfaceArea - used.
   */
   public double surfaceArea()
   {
      double calculationOne = (Math.pow(a * b, 1.6) 
         + Math.pow(a * c, 1.6) + Math.pow(b * c, 1.6));
      double calculationTwo = calculationOne / 3;
      double calculationThree = Math.pow(calculationTwo, (1 / 1.6));
      double surfaceArea = 4 * Math.PI * calculationThree;
      return surfaceArea;
   }
   //Returns a String containing the information about
   //the Ellipsoid object, including the decimal
   //formatting("#,##0.0###") for the double values.
   /**
      *@return out - used.
   */
   public String toString()
   {
      DecimalFormat df = new DecimalFormat("#,##0.0###");
      String out = "Ellipsoid \"" + label + "\"" + " with axes a = "
         + a + ", b = " + b + ", c = " + c + " units has: " 
         + "\n\tvolume = " + df.format(volume()) + " cubic units" 
         + "\n\tsurface area = " + df.format(surfaceArea()) + " square units";
      return out;
   }
}