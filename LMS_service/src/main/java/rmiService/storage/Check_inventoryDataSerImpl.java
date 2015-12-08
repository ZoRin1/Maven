package rmiService.storage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.documentsPO.InBillsPO;
import dataservice.storagedataservice.Check_inventoryDataSer;

public class Check_inventoryDataSerImpl extends UnicastRemoteObject implements Check_inventoryDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	/**
	 * 
	 */
	private static final long serialVersionUID = 697980109468505212L;

	public Check_inventoryDataSerImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}


	@Override
	public ArrayList<InBillsPO> getBill(String division)  throws RemoteException{
		// TODO 自动生成的方法存根
		return null;
	}


	@Override
	public ArrayList<InBillsPO> getInBill(String start, String end)
			throws RemoteException {
		// TODO 自动生成的方法存根
		
		return null;
	}

}
