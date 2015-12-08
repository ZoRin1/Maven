package dataservice.organizationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface organizationFactory extends Remote{
	
	public BussinessOrgDataSer createBussinessOrgDataSer()throws RemoteException;
	
	public FinanceOrgDataSer createFinanceOrgDataSer()throws RemoteException;
	
	public MiddleOrgDataSer createMiddleOrgDataSer()throws RemoteException;
}
