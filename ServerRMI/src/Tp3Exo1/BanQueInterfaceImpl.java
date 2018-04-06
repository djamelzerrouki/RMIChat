package Tp3Exo1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
public class BanQueInterfaceImpl extends UnicastRemoteObject 
                          implements BanQueInterface
{
   public BanQueInterfaceImpl () throws RemoteException
   {
super();
   }

@Override
public Date date() throws RemoteException {
	// TODO Auto-generated method stub
	return new Date();
}

@Override
public double convert(double d1) throws RemoteException {
	// TODO Auto-generated method stub
	return d1*11.3;
}
 


}  
