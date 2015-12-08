package rmiService.storage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import po.storagePO.DepotPO;
import dataservice.storagedataservice.GetDepotDataSer;

public class GetDepotDataSerImpl extends UnicastRemoteObject implements GetDepotDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	/**
	 * 
	 */
	private static final long serialVersionUID = -9159493132460553460L;

	public GetDepotDataSerImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public DepotPO getDepot(String city, int AreaNum)  throws RemoteException{
		// TODO 自动生成的方法存根
		sql="SELECT AreaNum,RowNum,ShelvesNum,SositionNum from "+city+"中转中心仓库"+" where isFull=0 and AreaNum="+AreaNum;
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			DepotPO po=null;
			if(resultSet.next()){
				po = new DepotPO(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4));	
			}
			int qu=0,pai=0,jia=0,hao=0;
			qu = resultSet.getInt(1);
			pai = resultSet.getInt(2);
			jia = resultSet.getInt(3);
			hao = resultSet.getInt(4);
		    sql = "UPDATE "+city+"中转中心仓库"+" set isFull=1"+" where AreaNum="+qu+" and RowNum="+pai+" and ShelvesNum="+jia+" and SositionNum="+hao;
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			return po;
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
