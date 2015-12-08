package rmiService.finance;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import po.financePO.ProfitPO;
import dataservice.financedataservice.StorageProDataSer;

public class StorageProDataSerImpl extends UnicastRemoteObject implements StorageProDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	/**
	 * 
	 */
	private static final long serialVersionUID = 406260526492263555L;

	public StorageProDataSerImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void setCostRecords(ProfitPO po)  throws RemoteException{
		// TODO 自动生成的方法存根
		double TotalRevenue = po.getTotalRevenue();
		double TotalPay = po.getTotalPay();
		String GenerationDate = po.getGenerationDate();
		String sql = "INSERT into 收益记录表(TotalRevenue,TotalPay,GenerationDate) values('"+TotalRevenue+"','"+TotalPay+"','"+GenerationDate+"')";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
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
