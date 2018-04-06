package Tp3Exo3;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javafx.application.Platform;
import javafx.collections.ObservableList;
 
public class Chat extends UnicastRemoteObject implements ChatInterface  {
	 
	private static final long serialVersionUID = 1L;
	public String name;
	public ChatInterface client=null;
  

	public Chat(String n  )  throws RemoteException { 
		this.name=n;   
 	}
	public String getName() throws RemoteException {
		return this.name;
	}
 
	public void setClient(ChatInterface c){
		client=c;
	}
 
	public ChatInterface getClient(){
		return client;
	}
 
	public String send(String s) throws RemoteException{
		System.out.println(s);
		return s;
	}
	@Override
	public  synchronized void getObservableList(String s) throws RemoteException {
		Platform.runLater(new Runnable(){

			@Override
			public void run() {
				DisagnServer. observableList.add(s);
				
			}
			});
 	}	
}