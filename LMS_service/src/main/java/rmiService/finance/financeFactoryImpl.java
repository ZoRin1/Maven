package rmiService.finance;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.financedataservice.AddBooksDataSer;
import dataservice.financedataservice.ChangeAccountDataSer;
import dataservice.financedataservice.CoverDataSer;
import dataservice.financedataservice.GetAccountDataSer;
import dataservice.financedataservice.GetAllPayDataSer;
import dataservice.financedataservice.GetBooksDataSer;
import dataservice.financedataservice.GetReceivablesBillsDataSer;
import dataservice.financedataservice.ProfitListDataSer;
import dataservice.financedataservice.StorageBooksDataSer;
import dataservice.financedataservice.StorageProDataSer;
import dataservice.financedataservice.financeFactory;

public class financeFactoryImpl extends UnicastRemoteObject implements financeFactory{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2201180716605599456L;

	public financeFactoryImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public AddBooksDataSer createAddBooksDataSer() throws RemoteException {
		// TODO 自动生成的方法存根
		
		return AddBooksDataSerImpl.getInstance();
	}

	@Override
	public CoverDataSer createCoverDataSer() throws RemoteException {
		// TODO 自动生成的方法存根
		return CoverDataSerImpl.getInstance();
	}

	@Override
	public GetAccountDataSer createGetAccountDataSer() throws RemoteException {
		// TODO 自动生成的方法存根
		return GetAccountDataSerImpl.getInstance();
	}

	@Override
	public GetAllPayDataSer createGetAllPayDataSer() throws RemoteException {
		// TODO 自动生成的方法存根
		return GetAllPayDataSerImpl.getInstance();
	}

	@Override
	public GetBooksDataSer createGetBooksDataSer() throws RemoteException {
		// TODO 自动生成的方法存根
		return GetBooksDataSerImpl.getInstance();
	}

	@Override
	public GetReceivablesBillsDataSer createGetReceivablesBillsDataSer()
			throws RemoteException {
		// TODO 自动生成的方法存根
		return GetReceivablesBillsDataSerImpl.getInstance();
	}

	@Override
	public ProfitListDataSer createProfitListDataSer() throws RemoteException {
		// TODO 自动生成的方法存根
		return ProfitListDataSerImpl.getInstance();
	}

	@Override
	public StorageBooksDataSer createStorageBooksDataSer()
			throws RemoteException {
		// TODO 自动生成的方法存根
		return new StorageBooksDataSerImpl();
	}

	@Override
	public StorageProDataSer createStorageProDataSer() throws RemoteException {
		// TODO 自动生成的方法存根
		return StorageProDataSerImpl.getInstance();
	}

	@Override
	public ChangeAccountDataSer createChangeAccountDateSer()
			throws RemoteException {
		// TODO 自动生成的方法存根
		return ChangeAccountDataSerImpl.getInstance();
	}
	
}
