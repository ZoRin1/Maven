package rmiService.documents;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.documentsdataservice.deleteDataSer;

public class deleteDataSerImpl extends UnicastRemoteObject implements deleteDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	/**
	 * 
	 */
	private static final long serialVersionUID = 6945635844601249905L;

	public deleteDataSerImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}


	@Override
	public boolean delete(String code, String doName) throws RemoteException{
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
				sql="insert into 付款单(code,doName,date,account,fund,name,account2,type,remark) values ('"+resultSet.getString(1)+"','"+resultSet.getString(2)+"','"+resultSet.getString(3)+"','"+resultSet.getString(4)+"','"+resultSet.getString(5)+"','"+resultSet.getString(6)+"','"+resultSet.getString(7)+"','"+resultSet.getString(8)+"','"+resultSet.getString(9)+"')";
				break;
			case "寄件单":
				sql="insert into 寄件单(code,doName,account,date,SenderName,SenderAddress,SenderOrg,SPhoneNumber,SMobileNumber,ReceiverName,ReceiverAddress,ReceiverOrg,RPhoneNumber,RMobileNumber,number,weight,shape,cargoNameList,sizeList,sumCost,state) values ('"+resultSet.getString(1)+"','"+resultSet.getString(2)+"','"+resultSet.getString(3)+"','"+resultSet.getString(4)+"','"+resultSet.getString(5)+"','"+resultSet.getString(6)+"','"+resultSet.getString(7)+"','"+resultSet.getString(8)+"','"+resultSet.getString(9)+"','"+resultSet.getString(10)+"','"+resultSet.getString(11)+"','"+resultSet.getString(12)+"','"+resultSet.getString(13)+"','"+resultSet.getString(14)+"','"+resultSet.getInt(15)+"','"+resultSet.getDouble(16)+"','"+resultSet.getDouble(17)+"','"+resultSet.getString(18)+"','"+resultSet.getString(19)+"','"+resultSet.getDouble(20)+"','"+resultSet.getString(21)+"')";
			break;
			case "派件单":
				sql="insert into 派件单(code,code2,doName,account,date,name) values ('"+resultSet.getString(1)+"','"+resultSet.getString(2)+"','"+resultSet.getString(3)+"','"+resultSet.getString(4)+"','"+resultSet.getString(5)+"','"+resultSet.getString(6)+"')";
				break;
			case "收件单":
				sql="insert into 收件单(code,code2,doName,account,ReceiverName,date) values ('"+resultSet.getString(1)+"','"+resultSet.getString(2)+"','"+resultSet.getString(3)+"','"+resultSet.getString(4)+"','"+resultSet.getString(5)+"','"+resultSet.getString(6)+"')";
				break;
			case "收款单":
				sql="insert into 收款单(code,doName,date,account,OrgCode,name,fund,Tcode) values ('"+resultSet.getString(1)+"','"+resultSet.getString(2)+"','"+resultSet.getString(3)+"','"+resultSet.getString(4)+"','"+resultSet.getString(5)+"','"+resultSet.getString(6)+"','"+resultSet.getDouble(7)+"','"+resultSet.getString(8)+"')";
				break;
			case "营业厅接收单":
				sql="insert into 营业厅接收单(code,code2,doName,account,date,departure,arrival,state) values ('"+resultSet.getString(1)+"','"+resultSet.getString(2)+"','"+resultSet.getString(3)+"','"+resultSet.getString(4)+"','"+resultSet.getString(5)+"','"+resultSet.getString(6)+"','"+resultSet.getString(7)+"','"+resultSet.getString(8)+"')";
				break;
			case "营业厅装车单":
				sql="insert into 营业厅装车单(code,doName,account,date,departure,arrival,supervisor,supercargo,codeList,charge) values ('"+resultSet.getString(1)+"','"+resultSet.getString(2)+"','"+resultSet.getString(3)+"','"+resultSet.getString(4)+"','"+resultSet.getString(5)+"','"+resultSet.getString(6)+"','"+resultSet.getString(7)+"','"+resultSet.getString(8)+"','"+resultSet.getString(9)+"','"+resultSet.getDouble(10)+"')";
				break;
			case "中转中心接收单":
			sql="insert into 中转中心接收单(code,doName,date,account,zCode,codeList,departure,arrival) values ('"+resultSet.getString(1)+"','"+resultSet.getString(2)+"','"+resultSet.getString(3)+"','"+resultSet.getString(4)+"','"+resultSet.getString(5)+"','"+resultSet.getString(6)+"','"+resultSet.getString(7)+"','"+resultSet.getString(8)+"')";
			break;
			case "中转中心转运单":
				sql="insert into 中转中心转运单(code,doName,date,account,transcode,departure,arrival,name,codeList,carriage) values ('"+resultSet.getString(1)+"','"+resultSet.getString(2)+"','"+resultSet.getString(3)+"','"+resultSet.getString(4)+"','"+resultSet.getString(5)+"','"+resultSet.getString(6)+"','"+resultSet.getString(7)+"','"+resultSet.getString(8)+"','"+resultSet.getString(9)+"','"+resultSet.getDouble(10)+"')";
				break;
			}
			resultSet.close();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			ResultSet resultSet2;
			String dateString;
			String stateString;
			String s[];
			switch (doName) {
			case "寄件单":
				sql="select account,date from b寄件单 where code='"+code+"'";
				preparedStatement=connection.prepareStatement(sql);
				resultSet2=preparedStatement.executeQuery();
				resultSet2.next();
				dateString=resultSet2.getString(2);
				sql="select state from 帐号表 where ID='"+resultSet2.getString(1)+"'";
				preparedStatement=connection.prepareStatement(sql);
				resultSet2=preparedStatement.executeQuery();
				resultSet2.next();
				stateString=resultSet2.getString(1);
				s=stateString.split("-");
				String wuliu1=dateString+" 您的快递已到达"+s[2]+"营业厅";
				sql="insert into 物流信息 (code,wuliu1) values ('"+code+"','"+wuliu1+"')";
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
				break;
			case "收件单":
				sql="select code2,date,ReceiverName from b收件单 where code='"+code+"'";
				preparedStatement=connection.prepareStatement(sql);
				resultSet2=preparedStatement.executeQuery();
				resultSet2.next();		
				String wuliu9=resultSet2.getString(2)+" 您的快递已签收 签收人:"+resultSet2.getString(3);
				sql="update 物流信息 set wuliu9='"+wuliu9+"' where code='"+resultSet2.getString(1)+"'";
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
				break;
			case "营业厅接收单":
				sql="select code2,date,arrival from b营业厅接收单 where code='"+code+"'";
				preparedStatement=connection.prepareStatement(sql);
				resultSet2=preparedStatement.executeQuery();
				resultSet2.next();
				String wuliu7=resultSet2.getString(2)+" 您的快递已到达"+resultSet2.getString(3)+"营业厅";
				sql="update 物流信息 set wuliu7='"+wuliu7+"'  where code='"+resultSet2.getString(1)+"'";
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
				break;
			
			case "派件单":
				sql="select code2,date from b派件单 where code='"+code+"'";
				preparedStatement=connection.prepareStatement(sql);
				resultSet2=preparedStatement.executeQuery();
				resultSet2.next();
				String wuliu8=resultSet2.getString(2)+" 您的快递正在派件";
				sql="update 物流信息 set wuliu8='"+wuliu8+"' where code ='"+resultSet2.getString(1)+"'";
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
				break;
			case "营业厅装车单":
				sql="select date,codeList,departure from b营业厅装车单 where code='"+code+"'";
				preparedStatement=connection.prepareStatement(sql);
				resultSet2=preparedStatement.executeQuery();
				resultSet2.next();	
				s=resultSet2.getString(2).split(",");
				String wuliu26=resultSet2.getString(1)+" 您的快递已离开"+resultSet2.getString(3);
				for (int i = 0; i < s.length; i++) {
					sql="select wuliu2 from 物流信息 where code='"+s[i]+"'";
					preparedStatement=connection.prepareStatement(sql);
					resultSet2=preparedStatement.executeQuery();
					resultSet2.next();
					if (resultSet2.getString(1)!=null) {
						sql="update 物流信息 set wuliu6='"+wuliu26+"中转中心' where code ='"+s[i]+"'";
					}
					else {
						sql="update 物流信息 set wuliu2='"+wuliu26+"营业厅' where code ='"+s[i]+"'";
					}
					preparedStatement=connection.prepareStatement(sql);
					preparedStatement.executeUpdate();
				}
				break;
			case "中转中心接收单":
				sql="select date,codeList,arrival from b中转中心接收单 where code='"+code+"'";
				preparedStatement=connection.prepareStatement(sql);
				resultSet2=preparedStatement.executeQuery();
				resultSet2.next();	
				s=resultSet2.getString(2).split(",");
				String wuliu35=resultSet2.getString(1)+" 您的快递已到达"+resultSet2.getString(3)+"中转中心";
				for (int i = 0; i < s.length; i++) {
					sql="select wuliu3 from 物流信息 where code='"+s[i]+"'";
					preparedStatement=connection.prepareStatement(sql);
					resultSet2=preparedStatement.executeQuery();
					resultSet2.next();
					if (resultSet2.getString(1)!=null) {
						sql="update 物流信息 set wuliu5='"+wuliu35+"' where code ='"+s[i]+"'";
					}
					else {
						sql="update 物流信息 set wuliu3='"+wuliu35+"' where code ='"+s[i]+"'";
					}
					preparedStatement=connection.prepareStatement(sql);
					preparedStatement.executeUpdate();
				}
				break;
			case "中转中心转运单":
				sql="select date,codeList,departure from b中转中心转运单 where code='"+code+"'";
				preparedStatement=connection.prepareStatement(sql);
				resultSet2=preparedStatement.executeQuery();
				resultSet2.next();	
				s=resultSet2.getString(2).split(",");
				String wuliu6=resultSet2.getString(1)+" 您的快递已离开"+resultSet2.getString(3)+"中转中心";
				for (int i = 0; i < s.length; i++) {
				sql="update 物流信息 set wuliu6='"+wuliu6+"' where code ='"+s[i]+"'";
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
			}
				break;
			}
			sql="delete from b"+doName+" where code='"+code+"'";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			connection.close();
			return true;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
