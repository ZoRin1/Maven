package rmiService.account;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.accountdataservice.AccountDataSer;
import dataservice.accountdataservice.accountFactory;

public class accountFactoryImpl extends UnicastRemoteObject implements accountFactory{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7439411849541497538L;

	public accountFactoryImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public AccountDataSer createAccountDataSer() throws RemoteException {
		// TODO 自动生成的方法存根
		return new AccountDataSerImpl();
	}

}
