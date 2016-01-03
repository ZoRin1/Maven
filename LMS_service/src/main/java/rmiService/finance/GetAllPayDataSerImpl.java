package rmiService.finance;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.documentsPO.PaymentPO;
import dataservice.financedataservice.GetAllPayDataSer;

public class GetAllPayDataSerImpl extends UnicastRemoteObject implements GetAllPayDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	/**
	 * 
	 */
	private static final long serialVersionUID = -1800323976608159048L;
	
	private static GetAllPayDataSerImpl GetAllPay = null;

	private GetAllPayDataSerImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public static GetAllPayDataSerImpl getInstance() throws RemoteException{
		if(GetAllPay==null){
			GetAllPay = new GetAllPayDataSerImpl();
		}
		return GetAllPay;
	}


	@Override
	public ArrayList<PaymentPO> getAllPay(String start, String end)  throws RemoteException{
		// TODO 自动生成的方法存根
		sql="SELECT * from 付款单 where datediff(d,"+start+","+ end+")>0";
		ArrayList<PaymentPO> ArrPo = new ArrayList<PaymentPO>();
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				PaymentPO po = new PaymentPO(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getDouble(5), resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9));
				ArrPo.add(po);
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ArrPo;
	}



	@Override
	public ArrayList<PaymentPO> getPay(String date) throws RemoteException {
		// TODO 自动生成的方法存根
		sql="SELECT * from 付款单 where date<="+date;
		ArrayList<PaymentPO> ArrPo = new ArrayList<PaymentPO>();
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				PaymentPO po = new PaymentPO(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getDouble(5), resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9));
				ArrPo.add(po);
			}
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ArrPo;
	}

	
}
