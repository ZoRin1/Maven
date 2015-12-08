package dataservice.transportationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TransportationFactory extends Remote{
	
	public TransportationDataSer createTransportationDataSer()throws RemoteException;
}
