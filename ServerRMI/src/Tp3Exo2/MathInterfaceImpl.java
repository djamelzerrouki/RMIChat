package Tp3Exo2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class MathInterfaceImpl extends UnicastRemoteObject 
                          implements MathInterface
{
   public MathInterfaceImpl () throws RemoteException
   {
super();
   }
 
   @Override
   public double add (double d1, double d2) throws RemoteException
   {
   return d1+d2;
   }
@Override
public double sub(double d1, double d2) throws RemoteException {
	// TODO Auto-generated method stub
	return d1-d2;
}

@Override
public double Mul(double d1, double d2) throws RemoteException {
	// TODO Auto-generated method stub
	return d1*d2;
}

@Override
public double Div(double d1, double d2) throws RemoteException {
	// TODO Auto-generated method stub
	return d1/d2;
}

//Step 3, is to code a driver program, which will create an instance of the class, and register it with the rmiregistry 



}  
