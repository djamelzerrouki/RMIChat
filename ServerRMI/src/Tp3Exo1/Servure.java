package Tp3Exo1;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Servure {

	public Servure() {
		// TODO Auto-generated constructor stub
	}

	 public static void main (String args [])
	   {
	      try
	      {
	    	 LocateRegistry.createRegistry(1099);
	    	 
	    	  
	    	 BanQueInterfaceImpl obj=new BanQueInterfaceImpl();
	       // Naming. rebind ("rmi://localhost:1099/sd", obj);
	    	  System.out.println(obj.toString());
	    	 
	    	  Naming. rebind ("rmi://192.168.1.111:1099/MTH", obj);
	         System.out.println ("Conected...");


	      }
	      catch (Exception e)
	      {
	       
	         System.out.println ("Err Connection ...");
	      }
	}

}
