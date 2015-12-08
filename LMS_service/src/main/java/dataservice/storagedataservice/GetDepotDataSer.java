package dataservice.storagedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.storagePO.DepotPO;

public interface GetDepotDataSer extends Remote{
	
	public DepotPO getDepot(String city, int AreaNum) throws RemoteException;
	
}
