package dataservice.storagedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.storagePO.DepotPO;

public interface InDepotDataSer extends Remote{
	
	
	public void inDepot(DepotPO depo,String city) throws RemoteException;
	
	public void inDepotExcel(String inDepotCode,String inDepotDate,DepotPO depo,String city)throws RemoteException;
}
