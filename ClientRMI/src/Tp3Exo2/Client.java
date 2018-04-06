package Tp3Exo2;
import java.rmi.Naming;

import Tp3Exo2.MathInterface;
public class Client
{
   public static void main (String args [])
   {

      try
      {
      //String url="rmi: //"+args [0] +"/rmi";
     // String url="rmi://localhost:1099/sd";
          String url="rmi://127.0.0.1:1099/MTH";

          MathInterface stub=(MathInterface)Naming.lookup(url);

     System.out.println ("La somme est : "+stub.add(2, 5));
     System.out.println ("La soustraction est : "+stub.sub(2, 5));
     System.out.println ("La multiplication est : "+stub.Mul(2, 5));
     System.out.println ("La division est : "+stub.Div(2, 5));

      }
      catch (Exception e)
      {
         System.out.println ("Err :"+e.getMessage());  
      }
   }  
}
