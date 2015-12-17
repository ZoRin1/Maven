package rmiService.finance;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dataservice.financedataservice.ChangeAccountDataSer;
import dataservice.financedataservice.CostException;
import dataservice.financedataservice.CustomException;

public class ChangeAccountDataSerImpl extends UnicastRemoteObject implements ChangeAccountDataSer{
	
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;

	/**
	 * 
	 */
	private static final long serialVersionUID = -7023399732468707278L;

	protected ChangeAccountDataSerImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public int changeEarn(String accountName, double earn) throws RemoteException{
		// TODO 自动生成的方法存根
		double addEarn=0;
//		sql="UPDATE 账户表"+" set AreaNum=5"+" where AreaNum=4 and SositionNum<="+shipping;
		sql="SELECT * from 账户表 where Name='"+accountName+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				String temp = resultSet.getString(2);
				addEarn = Double.parseDouble(temp)+earn;
			}else{
				return -1;
			}
			
			sql = "UPDATE 账户表"+" set sums='"+addEarn+"' where name='"+accountName+"'";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int changePay(String accountName, double earn) throws RemoteException{
		// TODO 自动生成的方法存根
		double subPay=0;
		sql="SELECT * from 账户表 where Name='"+accountName+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				String temp = resultSet.getString(2);
				subPay = Double.parseDouble(temp)-earn;
				
				if(subPay<0){
					return -2;
				}
			}else{
				return -1;
			}
			
			sql = "UPDATE 账户表"+" set sums="+subPay+" where name='"+accountName+"'";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
	}

}
