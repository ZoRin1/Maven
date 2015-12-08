package dataservice.storagedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.storagePO.DepotExcelPO;

public interface GetDepotExcelDataSer extends Remote{
	
	public ArrayList<DepotExcelPO> getDepotExcel(String city)throws RemoteException;

}
