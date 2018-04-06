package Tp3Exo1;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
public interface BanQueInterface extends Remote
{
  public  Date date () throws RemoteException;
  public  double convert (double d1) throws RemoteException;
  
} 