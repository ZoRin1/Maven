package rmiService.documents;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.util.ArrayList;

import po.documentsPO.DocumentPO;
import po.documentsPO.GetOrderPO;
import po.documentsPO.InBillsPO;
import po.documentsPO.LoadingPO;
import po.documentsPO.OrderPO;
import po.documentsPO.OutbillsPO;
import po.documentsPO.PaymentPO;
import po.documentsPO.ReceiptPO;
import po.documentsPO.YDispatchPO;
import po.documentsPO.YReceivePO;
import po.documentsPO.ZLoadingPO;
import po.documentsPO.ZReceivePO;
import dataservice.documentsdataservice.getBufferedInfoDataSer;

public class getBufferedInfoDataSerImpl extends UnicastRemoteObject implements getBufferedInfoDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	/**
	 * 
	 */
	private static final long serialVersionUID = 9064602574450436617L;

	public getBufferedInfoDataSerImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public DocumentPO getBufferedInfo(String code, String doName) throws RemoteException{
		// TODO 自动生成的方法存根
		sql="select * from b"+doName+" where code='"+code+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			resultSet.next();
			switch (doName) {
			case "付款单":
				PaymentPO paymentPO=new PaymentPO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDouble(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8),resultSet.getString(9));
				connection.close();
				return paymentPO;
			case "寄件单":
				double sizeList[]=new double[3];
				String s2[]=resultSet.getString(19).split(",");
				for (int i = 0; i < sizeList.length; i++) {
					sizeList[i]=Double.parseDouble(s2[i]);
				}
				OrderPO orderPO=new OrderPO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10), resultSet.getString(11), resultSet.getString(12), resultSet.getString(13), resultSet.getString(14), resultSet.getInt(15), resultSet.getDouble(16), resultSet.getDouble(17),resultSet.getString(18), sizeList, resultSet.getDouble(20),resultSet.getString(21));
				connection.close();
				return orderPO;
			case "派件单":
				YDispatchPO yDispatchPO=new YDispatchPO(resultSet.getString(5), resultSet.getString(1), resultSet.getString(3), resultSet.getString(2), resultSet.getString(4), resultSet.getString(6));
				connection.close();
				return yDispatchPO;
			case "收件单":
				GetOrderPO getOrderPO=new GetOrderPO(resultSet.getString(1), resultSet.getString(3), resultSet.getString(2), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
				connection.close();
				return getOrderPO;
			case "收款单":
				ArrayList<String> tCode=new ArrayList<String>();
				String s[]=resultSet.getString(8).split(",");
				for (int i = 0; i < s.length; i++) {
					tCode.add(s[i]);
				}
				ReceiptPO receiptPO=new ReceiptPO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getDouble(7), resultSet.getString(6), tCode);
				connection.close();
				return receiptPO;
			case "营业厅接收单":
			YReceivePO yReceivePO=new YReceivePO(resultSet.getString(5), resultSet.getString(1), resultSet.getString(3), resultSet.getString(2), resultSet.getString(4), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8));
			connection.close();
			return yReceivePO;
			case "营业厅装车单":
				ArrayList<String> codeList=new ArrayList<String>();
				String codeLists[]=resultSet.getString(9).split(",");
				for (int i = 0; i < codeLists.length; i++) {
					codeList.add(codeLists[i]);
				}
				LoadingPO loadingPO=new LoadingPO(resultSet.getString(4), resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), codeList, resultSet.getDouble(10));
				connection.close();
				return loadingPO;
			case "中转中心接收单":
				ArrayList<String> coList=new ArrayList<String>();
				String coLists[]=resultSet.getString(6).split(",");
				for (int i = 0; i < coLists.length; i++) {
					coList.add(coLists[i]);
				}
			ZReceivePO zReceivePO=new ZReceivePO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),coList, resultSet.getString(7), resultSet.getString(8));
			connection.close();
			return zReceivePO;
			case "中转中心转运单":
				ArrayList<String> zcodeList=new ArrayList<String>();
				String zcodeLists[]=resultSet.getString(9).split(",");
				for (int i = 0; i < zcodeLists.length; i++) {
					zcodeList.add(zcodeLists[i]);
				}
				ZLoadingPO zLoadingPO=new ZLoadingPO(resultSet.getString(3), resultSet.getString(1), resultSet.getString(2), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), zcodeList, resultSet.getDouble(10));
				connection.close();
				return zLoadingPO;
			}
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

