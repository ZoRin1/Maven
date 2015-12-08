package rmiService.documents;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import po.documentsPO.DocumentPO;
import dataservice.documentsdataservice.GetDocCodeDataSer;


public class GetDocCodeDataSerImpl extends UnicastRemoteObject implements GetDocCodeDataSer {
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4615262875279176437L;
	
	protected GetDocCodeDataSerImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDocCode(String doName) throws RemoteException{
		// TODO Auto-generated method stub		
		try {
			if (doName.equals("出库单")||doName.equals("入库单")) {
				sql="select code from "+doName;
				Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				ResultSet resultSet=preparedStatement.executeQuery();
					if (resultSet.last()) {		
						int codenum=Integer.parseInt(resultSet.getString(1));
						codenum=codenum+1;
						String code=Integer.toString(codenum);
						while (code.length()!=10) {
							code="0"+code;
						}
						connection.close();
						return code;
					}
					else {
						connection.close();
						return "0000000001";
					}
			}
			else {
				sql="select code from b"+doName;
				Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				ResultSet resultSet=preparedStatement.executeQuery();
				if (resultSet.last()) {		
					int codenum=Integer.parseInt(resultSet.getString(1));
					codenum=codenum+1;
					String code=Integer.toString(codenum);
					while (code.length()!=10) {
						code="0"+code;
					}
					connection.close();
					return code;
				}
				else {
					sql="select code from "+doName;
					connection=DriverManager.getConnection(URL, USER, PASSWORD);
					preparedStatement=connection.prepareStatement(sql);
					resultSet=preparedStatement.executeQuery();
						if (resultSet.last()) {		
							int codenum=Integer.parseInt(resultSet.getString(1));
							codenum=codenum+1;
							String code=Integer.toString(codenum);
							while (code.length()!=10) {
								code="0"+code;
							}
							connection.close();
							return code;
						}
						else {
							connection.close();
							return "0000000001";
						}		
			}	
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	
	}
}