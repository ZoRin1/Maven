package rmiService.finance;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.financePO.BooksPO;
import dataservice.financedataservice.StorageBooksDataSer;

public class StorageBooksDataSerImpl extends UnicastRemoteObject implements StorageBooksDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	/**
	 * 
	 */
	private static final long serialVersionUID = 2299733282039569422L;

	public StorageBooksDataSerImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void stoBooks(BooksPO book)  throws RemoteException{
		// TODO 自动生成的方法存根
		
	}

}
