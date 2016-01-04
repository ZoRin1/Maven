package rmiService.organization;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.organizationdataservice.BussinessOrgDataSer;
import dataservice.organizationdataservice.FinanceOrgDataSer;
import dataservice.organizationdataservice.MiddleOrgDataSer;
import dataservice.organizationdataservice.organizationFactory;

public class organizationFactoryImpl extends UnicastRemoteObject implements organizationFactory{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2039095476184426122L;

	public organizationFactoryImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public BussinessOrgDataSer createBussinessOrgDataSer()
			throws RemoteException {
		// TODO 自动生成的方法存根
		return BussinessOrgDataSerImpl.getInstance();
	}

	@Override
	public FinanceOrgDataSer createFinanceOrgDataSer() throws RemoteException {
		// TODO 自动生成的方法存根
		return FinanceOrgDataSerImpl.getInstance();
	}

	@Override
	public MiddleOrgDataSer createMiddleOrgDataSer() throws RemoteException {
		// TODO 自动生成的方法存根
		return MiddleOrgDataSerImpl.getInstance();
	}

}
