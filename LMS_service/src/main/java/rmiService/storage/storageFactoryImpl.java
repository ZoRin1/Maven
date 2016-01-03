package rmiService.storage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.storagedataservice.Check_inventoryDataSer;
import dataservice.storagedataservice.GetCountDataSer;
import dataservice.storagedataservice.GetDepotDataSer;
import dataservice.storagedataservice.GetDepotExcelDataSer;
import dataservice.storagedataservice.InDepotDataSer;
import dataservice.storagedataservice.OutDepotDataSer;
import dataservice.storagedataservice.ReturnSpaceDataSer;
import dataservice.storagedataservice.UpdateSpaceDataSer;
import dataservice.storagedataservice.UsedSpaceDataSer;
import dataservice.storagedataservice.storageFactory;

public class storageFactoryImpl extends UnicastRemoteObject implements storageFactory{
	/**
	 * 
	 */
	private static final long serialVersionUID = 656543013505655717L;

	public storageFactoryImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public Check_inventoryDataSer createCheck_inventoryDataSer()
			throws RemoteException {
		// TODO 自动生成的方法存根
		return Check_inventoryDataSerImpl.getInstance();
	}

	@Override
	public GetCountDataSer createGetCountDataSer() throws RemoteException {
		// TODO 自动生成的方法存根
		return GetCountDataSerImpl.getInstance();
	}

	@Override
	public GetDepotDataSer createGetDepotDataSer() throws RemoteException {
		// TODO 自动生成的方法存根
		return GetDepotDataSerImpl.getInstance();
	}

	@Override
	public InDepotDataSer createInDepotDataSer() throws RemoteException {
		// TODO 自动生成的方法存根
		return InDepotDataSerImpl.getInstance();
	}

	@Override
	public ReturnSpaceDataSer createReturnSpaceDataSer() throws RemoteException {
		// TODO 自动生成的方法存根
		return ReturnSpaceDataSerImpl.getInstance();
	}

	@Override
	public UpdateSpaceDataSer createUpdateSpaceDataSer() throws RemoteException {
		// TODO 自动生成的方法存根
		return UpdateSpaceDataSerImpl.getInstance();
	}

	@Override
	public UsedSpaceDataSer createUsedSpaceDataSer() throws RemoteException {
		// TODO 自动生成的方法存根
		return UsedSpaceDataSerImpl.getInstance();
	}

	@Override
	public OutDepotDataSer createOutDepotDataSer() throws RemoteException {
		// TODO 自动生成的方法存根
		return OutDepotDataSerImpl.getInstance();
	}

	@Override
	public GetDepotExcelDataSer createGetDepotExcelDataSer()
			throws RemoteException {
		// TODO 自动生成的方法存根
		return GetDepotExcelDataSerImpl.getInstance();
	}

}
