package Tp3Exo1;
import Tp3Exo1.BanQueInterface;
import java.rmi.Naming;
public class Client
{
   public static void main (String args [])
   {

      try
      {
      //String url="rmi: //"+args [0] +"/rmi";
     // String url="rmi://localhost:1099/sd";
          String url="rmi://192.168.1.111:1099/MTH";

          BanQueInterface stub=(BanQueInterface)Naming.lookup(url);
System.out.println(stub.date());
System.out.println(stub.convert(70));

      }
      catch (Exception e)
      {
         System.out.println ("Err :"+e.getMessage());  
      }
   }  
}
