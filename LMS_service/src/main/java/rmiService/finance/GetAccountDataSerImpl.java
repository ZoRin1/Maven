package rmiService.finance;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.financePO.AccountPO;
import dataservice.financedataservice.GetAccountDataSer;

public class GetAccountDataSerImpl extends UnicastRemoteObject implements GetAccountDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;

	/**
	 * 
	 */
	private static final long serialVersionUID = 4464096386614953251L;

	public  GetAccountDataSerImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public ArrayList<AccountPO> getAccount() throws RemoteException {
		// TODO 自动生成的方法存根
		sql="SELECT * from 账户表";
		ArrayList<AccountPO> po = new ArrayList<AccountPO>();
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				AccountPO acc = new AccountPO(resultSet.getString(1),resultSet.getDouble(2));
				po.add(acc);
			}
			connection.close();
			return po;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
