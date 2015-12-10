package rmiService.transportation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.transpotationPO.RoutePO;
import dataservice.transportationdataservice.TransportationDataSer;

public class TransportationDataSerImpl extends UnicastRemoteObject implements TransportationDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	/**
	 * 
	 */
	private static final long serialVersionUID = 8389026287336221175L;

	public TransportationDataSerImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public boolean updateDistance(RoutePO route) throws RemoteException{
		// TODO 自动生成的方法存根

		try {
			sql="select * from 线路 where line='"+route.getLine()+"'";
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				sql="update 线路 set distance='"+route.getDistance()+"' where line ='"+route.getLine()+"'";
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
				connection.close();
				return true;
			}else {
				return false;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCost(int type, double cost)throws RemoteException {
		// TODO 自动生成的方法存根
		sql="update 成本常量 set cost='"+cost+"' where type ='"+type+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
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

	@Override
	public double findCost(int type) throws RemoteException{
		// TODO 自动生成的方法存根
		sql="select cost from 成本常量 where type ='"+type+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			resultSet.next();
			double cost=resultSet.getDouble(1);
			connection.close();
			return cost;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean insertRoute(RoutePO route) throws RemoteException{
		// TODO 自动生成的方法存根
		sql="insert into 线路 (line,distance) values('"+route.getLine()+"','"+route.getDistance()+"')";
				try {
					Class.forName(DRIVER);
					Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
					PreparedStatement preparedStatement=connection.prepareStatement(sql);
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

	@Override
	public double findDistance(String line) throws RemoteException{
		// TODO 自动生成的方法存根
		sql="select distance from 线路 where line ='"+line+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			resultSet.next();
			double distance=resultSet.getDouble(1);
			connection.close();
			return distance;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public String[] findCityList(String city) throws RemoteException{
		// TODO 自动生成的方法存根
		sql="select city from 城市 where city <>'"+city+"'";
		ArrayList<String>cityList=new ArrayList<String>();
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				cityList.add(resultSet.getString(1));
			}
			connection.close();
			String [] citys=new String[cityList.size()];
			for (int i = 0; i < citys.length; i++) {
				citys[i]=cityList.get(i);
			}
			return citys;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insertCity(String city) throws RemoteException{
		// TODO 自动生成的方法存根
		sql="insert into 城市 (city) values('"+city+"')";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			sql="create table "+city+"中转中心仓库 as select * from 仓库";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			sql="create table "+city+"库存信息 like 库存信息";
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

	@Override
	public boolean removeCity(String city) throws RemoteException{
		// TODO 自动生成的方法存根
		sql="delete from 城市 where city='"+city+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			sql="drop table '"+city+"'";
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
	/*
	 * 获得工资策略
	 * @param employee 员工种类
	 * 1代表快递员
	 * 2代表营业厅业务员
	 * 3代表中转中心业务员
	 * 4代表中转中心仓库管理员
	 * 5代表财务人员
	 * 6代表总经理
	 * 7代表系统管理员
	 
	 *@return double[] 对应员工的三个工资策略数值的数组  分别是 按月  计次  提成
	 *
	 */
	public double[] getSalary(int employee) throws RemoteException{
		sql="select salary1,salary2,salary3 from 工资策略 where employee='"+employee+"'";
		double salary[]=new double[3];
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			resultSet.next();
			salary[0]=resultSet.getDouble(1);
			salary[1]=resultSet.getDouble(2);
			salary[2]=resultSet.getDouble(3);
			connection.close();
			return salary;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	/*
	 * 修改工资策略
	 * @param employee 员工种类
	 * 1代表快递员
	 * 2代表营业厅业务员
	 * 3代表中转中心业务员
	 * 4代表中转中心仓库管理员
	 * 5代表财务人员
	 * 6代表总经理
	 * 7代表系统管理员
	 * @param salary 员工的三个工资策略数值的数组  分别是 按月  计次  提成
	 * @return boolean 修改操作是否成功
	 * 
	 */
	
	public boolean changeSalary(int employee,double [] salary) throws RemoteException{
		sql="update 工资策略 set salary1='"+salary[0]+"',salary2='"+salary[1]+"',salary3='"+salary[2]+"' where employee ='"+employee+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
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