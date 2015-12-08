package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.financePO.BooksPO;

public interface StorageBooksDataSer extends Remote{
	
	
	/**
	 * 系统存储一个持久化对象（账本）
	 * @author YangGuan
	 *
	 */
	public void stoBooks(BooksPO book) throws RemoteException;
}
