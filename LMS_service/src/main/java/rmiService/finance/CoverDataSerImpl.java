package rmiService.finance;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import po.financePO.AccountPO;
import dataservice.financedataservice.CoverDataSer;

public class CoverDataSerImpl extends UnicastRemoteObject implements CoverDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	/**
	 * 
	 */
	private static final long serialVersionUID = 8859049058295725046L;
	
	private static CoverDataSerImpl CoverData = null;

	private CoverDataSerImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public static CoverDataSerImpl getInstance() throws RemoteException{
		if(CoverData == null){
			CoverData = new CoverDataSerImpl();
		}
		
		return CoverData;
	}

	@Override
	public void coverAccount(ArrayList<AccountPO> po)  throws RemoteException {
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement;
			String  sql="delete from 账户表";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();		
			// TODO 自动生成的方法存根
			//每次只允许一个财务人员进行 账户管理！  这个判断条件以后优化
			for(int i = 0 ; i < po.size();i++){
				AccountPO p = po.get(i);
				String name = p.getName();
				double sums = p.getSums();
					sql = "INSERT into 账户表(name,sums) values('"+name+"','"+sums+"')";	
					preparedStatement=connection.prepareStatement(sql);
					preparedStatement.executeUpdate();				
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		ArrayList<AccountPO> pp = po;
	}

}
