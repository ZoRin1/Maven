package rmiService.organization;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.organizationdataservice.FinanceOrgDataSer;

public class FinanceOrgDataSerImpl extends UnicastRemoteObject implements FinanceOrgDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2675461398567508092L;

	public FinanceOrgDataSerImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public String[] find() throws RemoteException{
		// TODO 自动生成的方法存根
		sql="select financer from 财务部信息";
		String string[]=null;
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				if (resultSet.getString(1)!=null) {
					string=resultSet.getString(1).split(",");
					for (int i = 0; i < string.length; i++) {
						sql="select name from 帐号表";
						preparedStatement=connection.prepareStatement(sql);
						resultSet=preparedStatement.executeQuery();
						resultSet.next();
						string[i]=string[i]+"-"+resultSet.getString(1);
					}
					}				
			}
			connection.close();
			return string;
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
	public boolean insert(long ID) throws RemoteException{
		// TODO 自动生成的方法存根
		sql="select financer,codeNumber,city from 财务部信息";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			resultSet.next();
			if (resultSet.getString(1)==null) {
				sql="update 财务部信息 set financer = '"+Long.toString(ID)+",'";
			}
			else {
				sql="update 财务部信息 set financer = '"+resultSet.getString(1)+Long.toString(ID)+",'";
			}		
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			sql="update 帐号表 set state ='5-"+resultSet.getString(3)+"-财务部-"+resultSet.getString(2)+"' where ID='"+ID+"'";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			connection.close();
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(long ID) throws RemoteException{
		// TODO 自动生成的方法存根
		sql="select financer from 财务部信息";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			resultSet.next();
			String financerString[]=resultSet.getString(1).split(",");
			ArrayList<String>financerList=new ArrayList<String>();
			for (int i = 0; i < financerString.length; i++) {
				if (!financerString[i].equals(Long.toString(ID))) {
					financerList.add(financerString[i]);
				}
			}
			String financer="";
			for (int i = 0; i < financerList.size(); i++) {
				financer=financer+financerList.get(i)+",";
			}
			if (financer.equals("")) {
				sql="update 财务部信息 set financer= null";
			}
			else {
				sql="update 财务部信息 set financer= '"+financer+"'";
			}
			
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			sql="update 帐号表 set state ='0' where ID='"+ID+"'";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			connection.close();
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
