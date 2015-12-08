package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface financeFactory extends Remote{
	public AddBooksDataSer createAddBooksDataSer() throws RemoteException;
		
	public CoverDataSer createCoverDataSer() throws RemoteException;
	
	public GetAccountDataSer createGetAccountDataSer() throws RemoteException;
	
	public GetAllPayDataSer createGetAllPayDataSer() throws RemoteException;
	
	public GetBooksDataSer createGetBooksDataSer() throws RemoteException;
	
	public GetReceivablesBillsDataSer createGetReceivablesBillsDataSer() throws RemoteException;
	
	public ProfitListDataSer createProfitListDataSer() throws RemoteException;
	
	public StorageBooksDataSer createStorageBooksDataSer() throws RemoteException;
	
	public StorageProDataSer createStorageProDataSer() throws RemoteException;
	
	public ChangeAccountDataSer createChangeAccountDateSer() throws RemoteException;
}
