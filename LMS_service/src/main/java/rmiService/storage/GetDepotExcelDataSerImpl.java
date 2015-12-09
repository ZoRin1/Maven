package rmiService.storage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.excelPO.DepotExcelPO;
import po.financePO.AccountPO;
import dataservice.storagedataservice.GetDepotExcelDataSer;

public class GetDepotExcelDataSerImpl extends UnicastRemoteObject implements GetDepotExcelDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7976806849167294036L;

	protected GetDepotExcelDataSerImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public ArrayList<DepotExcelPO> getDepotExcel(String city)
			throws RemoteException {
		// TODO 自动生成的方法存根
		sql = "SELECT * from "+city+"库存信息";
		ArrayList<DepotExcelPO> excelPO = new ArrayList<DepotExcelPO>();
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				//DepotExcelPO po = new DepotExcelPO(Integer.parseInt(resultSet.getString(1)), Integer.parseInt(resultSet.getString(2)), Integer.parseInt(resultSet.getString(3)), Integer.parseInt(resultSet.getString(4)), resultSet.getString(5), resultSet.getString(6));
				DepotExcelPO po = new DepotExcelPO(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6));
				excelPO.add(po);
			}
			connection.close();
			return excelPO;
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
