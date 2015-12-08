package dataservice.storagedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.storagePO.DepotPO;

public interface OutDepotDataSer extends Remote{

	public void outDepot(DepotPO depo,String city)throws RemoteException;
	
}
