package Tp3Exo3;
import java.rmi.Remote;
import java.rmi.RemoteException;

import javafx.collections.ObservableList;
 
public interface ChatInterface extends Remote{
	public String getName() throws RemoteException;
	public String send(String msg) throws RemoteException;
	public void setClient(ChatInterface c)throws RemoteException;
	public ChatInterface getClient() throws RemoteException;
	void getObservableList(String s) throws RemoteException;

}