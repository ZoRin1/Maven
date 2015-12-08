package dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface accountFactory extends Remote{
	
	public AccountDataSer createAccountDataSer() throws RemoteException;
	
}
