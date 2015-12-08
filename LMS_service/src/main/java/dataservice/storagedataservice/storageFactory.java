package dataservice.storagedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface storageFactory extends Remote{
	public Check_inventoryDataSer createCheck_inventoryDataSer() throws RemoteException;
	
	public GetCountDataSer createGetCountDataSer() throws RemoteException;
	
	public GetDepotDataSer createGetDepotDataSer() throws RemoteException;
	
	public InDepotDataSer createInDepotDataSer() throws RemoteException;
	
	public ReturnSpaceDataSer createReturnSpaceDataSer() throws RemoteException;
	
	public UpdateSpaceDataSer createUpdateSpaceDataSer() throws RemoteException;
	
	public UsedSpaceDataSer createUsedSpaceDataSer() throws RemoteException;
	
	public OutDepotDataSer createOutDepotDataSer() throws RemoteException;
	
	public GetDepotExcelDataSer createGetDepotExcelDataSer() throws RemoteException;
}
