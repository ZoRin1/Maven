package rmiService.documents;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.documentsdataservice.getCodeDataSer;

public class getCodeDataSerImpl extends UnicastRemoteObject implements getCodeDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	/**
	 * 
	 */
	private static final long serialVersionUID = 7578979922627164999L;

	private static getCodeDataSerImpl getCodeData= null;
	
	private getCodeDataSerImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public static getCodeDataSerImpl getInstance() throws RemoteException{
		if(getCodeData==null){
			getCodeData = new getCodeDataSerImpl();
		}
		return getCodeData;
	}
	
	@Override
	public ArrayList<String> getCode(String doName, String startTime,
			String endTime) throws RemoteException{
		// TODO 自动生成的方法存根
		//此处仅针对收款单，付款单
		ArrayList<String> arrayList=new ArrayList<String>();
		if (startTime==null) {
			switch (doName) {
			case "收款单":
				sql="select code,doName from 收款单 where date < '"+endTime+"'";
				break;
			case "付款单":
				sql="select code,doName from 付款单 where date < '"+endTime+"'";
				break;
			}		
		}
		else {
			switch (doName) {
			case "收款单":
				sql="select code,doName from 收款单 where date >'"+startTime+"' and date < '"+endTime+"'";
				break;
			case "付款单":
				sql="select code,doName from 付款单 where date > '"+startTime+"' and date < '"+endTime+"'";
				break;
			}		
		}		
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(1)+","+resultSet.getString(2));
			}
			connection.close();
			return arrayList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<String> getStoCode(String account, String doName,
			String startTime, String endTime) {
		// TODO Auto-generated method stub
		//此处仅针对入库单
		ArrayList<String> arrayList=new ArrayList<String>();
		if (startTime==null) {
			sql="select code,doName from 入库单 where InDepotDate < '"+endTime+"' and account='"+account+"'";
		}
		else {
			sql="select code,doName from 入库单 where InDepotDate > '"+startTime+"' and InDepotDate < '"+endTime+"' and account='"+account+"'";
		}		
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(1)+","+resultSet.getString(2));
			}
			connection.close();
			return arrayList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<String> getReceiptCode(String selling, String doName,
			String startTime, String endTime) {
		// TODO Auto-generated method stub
		ArrayList<String> arrayList=new ArrayList<String>();
		sql="select code,doName from 收款单 where date >'"+startTime+"' and date < '"+endTime+"' and OrgCode ='"+selling+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(1)+","+resultSet.getString(2));
			}
			connection.close();
			return arrayList;
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
