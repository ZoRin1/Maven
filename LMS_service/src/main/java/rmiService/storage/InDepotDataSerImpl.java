package rmiService.storage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import po.storagePO.DepotPO;
import dataservice.storagedataservice.InDepotDataSer;

public class InDepotDataSerImpl extends UnicastRemoteObject implements InDepotDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	/**
	 * 
	 */
	private static final long serialVersionUID = -6673633418400744648L;

	public InDepotDataSerImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void inDepot(DepotPO depo,String city)  throws RemoteException{
		// TODO 自动生成的方法存根
		int qu =depo.getQu();
		int pai = depo.getPai();
		int jia = depo.getJia();
		int wei = depo.getWei();
		//String sql = "UPDATE"+city+"中转中心仓库"+"set AreaNum="+qu+","+"RowNum="+pai+","+"ShelvesNum="+jia+","+"SositionNum="+wei+"where isFull=1";
		String sql = "UPDATE "+city+"中转中心仓库"+" set isFull=1"+" where AreaNum="+qu+" and RowNum="+pai+" and ShelvesNum="+jia+" and SositionNum="+wei;
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

	@Override
	public void inDepotExcel(String inDepotCode, String inDepotDate,
			DepotPO depo, String city) throws RemoteException {
		// TODO 自动生成的方法存根
		int qu =depo.getQu();
		int pai = depo.getPai();
		int jia = depo.getJia();
		int wei = depo.getWei();
		sql="insert into "+city+"库存信息 (AreaNum,RowNum,ShelvesNum,SositionNum,code,date) values ('" +qu+"','"+pai+"','"+jia+"','"+wei+"','"+inDepotCode+"','"+inDepotDate+"')";
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
