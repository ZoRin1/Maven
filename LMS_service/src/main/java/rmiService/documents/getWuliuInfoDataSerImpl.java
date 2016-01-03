package rmiService.documents;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.documentsdataservice.getWuliuInfoDataSer;

public class getWuliuInfoDataSerImpl extends UnicastRemoteObject implements getWuliuInfoDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4615262875279176437L;
	
	private static getWuliuInfoDataSerImpl getWuliuInfo= null;
	
	private getWuliuInfoDataSerImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static getWuliuInfoDataSerImpl getInstance() throws RemoteException{
		if(getWuliuInfo==null){
			getWuliuInfo = new getWuliuInfoDataSerImpl();
		}
		return getWuliuInfo;
	}
	
	@Override
	public ArrayList<String> getWuliuInfo(String code) throws RemoteException{
		// TODO Auto-generated method stub
		ArrayList<String> arrayList=new ArrayList<String>();
		sql="select * from 物流信息 where code ='"+code+"'";
		try {
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				arrayList.add(resultSet.getString(2));
				arrayList.add(resultSet.getString(3));
				arrayList.add(resultSet.getString(4));
				arrayList.add(resultSet.getString(5));
				arrayList.add(resultSet.getString(6));
				arrayList.add(resultSet.getString(7));
				arrayList.add(resultSet.getString(8));
				arrayList.add(resultSet.getString(9));
				arrayList.add(resultSet.getString(10));
				connection.close();
				return arrayList;
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
