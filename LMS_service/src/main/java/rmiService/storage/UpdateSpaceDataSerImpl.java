package rmiService.storage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dataservice.storagedataservice.UpdateSpaceDataSer;

public class UpdateSpaceDataSerImpl extends UnicastRemoteObject implements UpdateSpaceDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	/**
	 * 
	 */
	private static final long serialVersionUID = 3234821361500843438L;
	
	private static UpdateSpaceDataSerImpl UpdateSpace = null;

	private UpdateSpaceDataSerImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public static UpdateSpaceDataSerImpl getInstance() throws RemoteException{
		if(UpdateSpace==null){
			UpdateSpace = new UpdateSpaceDataSerImpl();
			}
		return UpdateSpace;
	}
	

	@Override
	public void updateDrive(int shipping, int trains, int motor,String city)  throws RemoteException{
		// TODO 自动生成的方法存根
		
		String sql = "UPDATE "+city+"中转中心仓库"+" set AreaNum=5"+" where AreaNum=4 and SositionNum<="+shipping;
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			sql = "UPDATE "+city+"中转中心仓库"+" set AreaNum=6"+" where AreaNum=4 and SositionNum>"+shipping+" and SositionNum<="+(shipping+trains);
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			sql = "UPDATE "+city+"中转中心仓库"+" set AreaNum=7"+" where AreaNum=4 and SositionNum>"+(shipping+trains)+" and SositionNum<="+(shipping+trains+motor);
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
