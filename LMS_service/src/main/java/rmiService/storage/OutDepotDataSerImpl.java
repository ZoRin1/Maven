package rmiService.storage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import po.storagePO.DepotPO;
import dataservice.storagedataservice.InDepotDataSer;
import dataservice.storagedataservice.OutDepotDataSer;

public class OutDepotDataSerImpl extends UnicastRemoteObject implements OutDepotDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	/**
	 * 
	 */
	private static final long serialVersionUID = -7266703194896409949L;
	
	private static OutDepotDataSerImpl OutDepot = null;

	private OutDepotDataSerImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public static OutDepotDataSerImpl getInstance() throws RemoteException{
		if(OutDepot == null){
			OutDepot = new OutDepotDataSerImpl();
		}
		return OutDepot;
	}

	@Override
	public void outDepot(DepotPO depo, String city) throws RemoteException {
		// TODO 自动生成的方法存根
		int qu =depo.getQu();
		int pai = depo.getPai();
		int jia = depo.getJia();
		int wei = depo.getWei();
		sql = "UPDATE "+city+"中转中心仓库"+" set isFull=0"+" where AreaNum="+qu+" and RowNum="+pai+" and ShelvesNum="+jia+" and SositionNum="+wei;
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			sql = "DELETE from "+city+"库存信息 where AreaNum="+qu+" and RowNum="+pai+" and ShelvesNum="+jia+" and SositionNum="+wei;
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
