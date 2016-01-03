package rmiService.storage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dataservice.storagedataservice.ReturnSpaceDataSer;

public class ReturnSpaceDataSerImpl extends UnicastRemoteObject implements ReturnSpaceDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	/**
	 * 
	 */
	private static final long serialVersionUID = 7725685187189213273L;
	
	private static ReturnSpaceDataSerImpl ReturnSpace = null;

	private ReturnSpaceDataSerImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public static ReturnSpaceDataSerImpl getInstance() throws RemoteException{
		if(ReturnSpace==null){
			ReturnSpace = new ReturnSpaceDataSerImpl();
		}
		return ReturnSpace;
	}

	@Override
	public void reSpace(String city)  throws RemoteException{
		// TODO 自动生成的方法存根
		String sql = "UPDATE "+city+"中转中心仓库"+" set AreaNum=4"+" where AreaNum=5";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			sql = "UPDATE "+city+"中转中心仓库"+" set AreaNum=4"+" where AreaNum=6";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			sql = "UPDATE "+city+"中转中心仓库"+" set AreaNum=4"+" where AreaNum=7";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
