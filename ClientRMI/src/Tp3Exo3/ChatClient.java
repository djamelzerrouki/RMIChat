package Tp3Exo3;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;
 
public class ChatClient {
	public static void main (String[] argv) {
	    try {
	    	 // LocateRegistry.createRegistry(1099);
 //System.setSecurityManager(new RMISecurityManager());

		    	Scanner s=new Scanner(System.in);
		    	System.out.println("Enter Your name and press Enter:");
		    	String name=s.nextLine().trim();
		    	
		    	ChatInterface client = new Chat(name);
		          String url="rmi://127.0.0.1:1099/chat";

		    	ChatInterface server = (ChatInterface)Naming.lookup(url);
		    
		    	String msg="["+client.getName()+"] got connected";
		    	server.send(msg);
		    	System.out.println("[System] Chat Remote Object is ready:");
		    	server.setClient(client);
 
		    	while(true){
		    		msg=s.nextLine().trim();
		    		msg="["+client.getName()+"] "+msg;		    		
	    			server.send(msg);
		    	}
 
	    	}catch (Exception e) {
	    		System.out.println("[System] Server failed: " + e);
	    	}
		}
}