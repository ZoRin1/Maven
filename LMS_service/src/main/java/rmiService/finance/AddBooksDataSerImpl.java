package rmiService.finance;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.financePO.BooksPO;
import dataservice.financedataservice.AddBooksDataSer;

public class AddBooksDataSerImpl extends UnicastRemoteObject implements AddBooksDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	/**
	 * 
	 */
	private static final long serialVersionUID = -5937811362981589837L;
	
	private static AddBooksDataSerImpl addBooks= null;

	private AddBooksDataSerImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		
	}
	
	public static AddBooksDataSerImpl getInstance() throws RemoteException{
		if(addBooks==null){
			addBooks = new AddBooksDataSerImpl();
		}
		return addBooks;
	}

	@Override
	public void addBooks(String name) throws RemoteException {
		// TODO 自动生成的方法存根
		try {
			sql="select codeNumberOfMiddle,codeNumber from 营业厅信息";
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			String bussinessHallCode="";
			String middleCode="";
			while (resultSet.next()) {
				bussinessHallCode=bussinessHallCode+resultSet.getString(1)+resultSet.getString(2)+",";
				middleCode=middleCode+resultSet.getString(1)+",";
			}
			sql="select codeNumber from 财务部信息";
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			String financeCode="";
			if (resultSet.next()) {
				financeCode=resultSet.getString(1);
			}
			sql="select ID from 帐号表";
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			String IDCode="";
			while (resultSet.next()) {
				IDCode=IDCode+resultSet.getString(1)+",";
			}
			sql="select codeVehicle from 车辆信息";
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			String VehicleCode="";
			while (resultSet.next()) {
				VehicleCode=VehicleCode+resultSet.getString(1)+",";
			}
			sql="select name from 账户表";
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			String AccountName="";
			while (resultSet.next()) {
				AccountName=AccountName+resultSet.getString(1)+",";
			}
			Date now = new Date(); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			String riqi = dateFormat.format( now );
			sql="insert into 账本 (name,bussinessHallCode,financeCode,middleCode,IDCode,VehicleCode,AccountName,date) values ('" +name+"','"+bussinessHallCode+"','"+financeCode+"','"+middleCode+"','"+IDCode+"','"+VehicleCode+"','"+AccountName+"','"+riqi+"')";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
