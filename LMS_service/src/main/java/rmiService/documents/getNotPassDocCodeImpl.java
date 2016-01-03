package rmiService.documents;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.documentsdataservice.getNotPassDocCode;

public class getNotPassDocCodeImpl extends UnicastRemoteObject implements getNotPassDocCode{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	/**
	 * 
	 */
	private static final long serialVersionUID = 5802629699384695078L;

	private static getNotPassDocCodeImpl getNotPass= null;
	
	private getNotPassDocCodeImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public static getNotPassDocCodeImpl getInstance() throws RemoteException{
		if(getNotPass==null){
			getNotPass = new getNotPassDocCodeImpl();
		}
		return getNotPass;
	}
	
	@Override
	public ArrayList<String> getNotPassDocCode(String account) throws RemoteException{
		// TODO 自动生成的方法存根
		ArrayList<String> arrayList=new ArrayList<String>();
		sql="select code,doName from b付款单 where examined='1' and account ='"+account+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(1)+","+resultSet.getString(2));
			}
			sql="select code,doName from b寄件单 where examined='1' and account ='"+account+"'";
			 preparedStatement=connection.prepareStatement(sql);
			 resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(1)+","+resultSet.getString(2));
			}
			sql="select code,doName from b派件单 where examined='1' and account ='"+account+"'";
			 preparedStatement=connection.prepareStatement(sql);
			 resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(1)+","+resultSet.getString(2));
			}
			sql="select code,doName from b收件单 where examined='1' and account ='"+account+"'";
			 preparedStatement=connection.prepareStatement(sql);
			 resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(1)+","+resultSet.getString(2));
			}
			sql="select code,doName from b收款单 where examined='1' and account ='"+account+"'";
			 preparedStatement=connection.prepareStatement(sql);
			 resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(1)+","+resultSet.getString(2));
			}
			sql="select code,doName from b营业厅接收单 where examined='1' and account ='"+account+"'";
			 preparedStatement=connection.prepareStatement(sql);
			 resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(1)+","+resultSet.getString(2));
			}
			sql="select code,doName from b营业厅装车单 where examined='1' and account ='"+account+"'";
			 preparedStatement=connection.prepareStatement(sql);
			 resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(1)+","+resultSet.getString(2));
			}
			sql="select code,doName from b中转中心接收单 where examined='1' and account ='"+account+"'";
			 preparedStatement=connection.prepareStatement(sql);
			 resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(1)+","+resultSet.getString(2));
			}
			sql="select code,doName from b中转中心转运单 where examined='1' and account ='"+account+"'";
			 preparedStatement=connection.prepareStatement(sql);
			 resultSet=preparedStatement.executeQuery();
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
