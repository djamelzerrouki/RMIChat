package Tp3Exo2;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface MathInterface extends Remote
{
  public  double add (double d1, double d2) throws RemoteException;
  public  double sub (double d1, double d2) throws RemoteException;
  public  double Mul (double d1, double d2) throws RemoteException;
  public  double Div (double d1, double d2) throws RemoteException;

} 