package rmiService.storage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.financePO.AccountPO;
import dataservice.storagedataservice.GetCountDataSer;

public class GetCountDataSerImpl extends UnicastRemoteObject implements GetCountDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	/**
	 * 
	 */
	private static final long serialVersionUID = -1373268748225869690L;
	
	private static GetCountDataSerImpl GetCount = null;

	private GetCountDataSerImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public static GetCountDataSerImpl getInstance() throws RemoteException{
		if(GetCount==null){
			GetCount = new GetCountDataSerImpl();
		}
		return GetCount;
	}

	@Override
	public int getCount(String city)  throws RemoteException{
		// TODO 自动生成的方法存根
		int count = 0;
		sql="SELECT AreaNum,RowNum,ShelvesNum,SositionNum from"+city+"中转中心仓库"+" where isFull=0";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			resultSet.last();
			count = resultSet.getRow();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}
