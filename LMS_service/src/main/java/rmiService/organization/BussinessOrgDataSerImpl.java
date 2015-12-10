package rmiService.organization;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




import po.orgPO.BussinessOrgPO;
import po.orgPO.DriverPO;
import po.orgPO.VehiclePO;
import dataservice.organizationdataservice.BussinessOrgDataSer;

public class BussinessOrgDataSerImpl extends UnicastRemoteObject implements BussinessOrgDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/lmssql";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2065348468020344293L;

	public BussinessOrgDataSerImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public String[] getBussinessmanList(String ID) throws RemoteException{
		// TODO 自动生成的方法存根
		ArrayList<String> assisantList=new ArrayList<String>();
		String IDString[]=ID.split("-");
		sql="select assisant from 营业厅信息 where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			resultSet.next();
			if (!resultSet.getString(1).equals("")) {
				String assisantString[]=resultSet.getString(1).split(",");
				for (int i = 0; i < assisantString.length; i++) {
					sql="select name from 帐号表 where ID ='"+assisantString[i]+"'";
					preparedStatement=connection.prepareStatement(sql);
					resultSet=preparedStatement.executeQuery();
					resultSet.next();
					assisantList.add(assisantString[i]+"-"+resultSet.getString(1));
				}
				String assisantarray[]=new String[assisantList.size()];
				for (int i = 0; i < assisantarray.length; i++) {
					assisantarray[i]=assisantList.get(i);
				}
				connection.close();
				return assisantarray;
			}
			else {
				return null;
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

	@Override
	public boolean addBussinessman(String ID, long bID) throws RemoteException{
		// TODO 自动生成的方法存根
		String IDString[]=ID.split("-");
		sql="select mcity,city,assisant from 营业厅信息 where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
			try {
				Class.forName(DRIVER);
				Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				ResultSet resultSet=preparedStatement.executeQuery();
				resultSet.next();
				if (resultSet.getString(1)==null) {
					sql="update 营业厅信息 set assisant='"+Long.toString(bID)+",' where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
				}else {
					sql="update 营业厅信息 set assisant='"+resultSet.getString(3)+Long.toString(bID)+",' where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
				}			
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
				sql="update 帐号表 set state = '2-"+resultSet.getString(1)+"-"+resultSet.getString(2)+"-营业厅-"+ID+"' where ID ='"+bID+"'";
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
	public boolean removeBussinessman(String ID, long bID) throws RemoteException{
		// TODO 自动生成的方法存根
		String IDString[]=ID.split("-");
		sql="select assisant from 营业厅信息 where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
			try {
				Class.forName(DRIVER);
				Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				ResultSet resultSet=preparedStatement.executeQuery();
				resultSet.next();
				String assisantString[]=resultSet.getString(1).split(",");
				ArrayList<String>assisantList=new ArrayList<String>();
				for (int i = 0; i < assisantString.length; i++) {
					if (!assisantString[i].equals(Long.toString(bID))) {
						assisantList.add(assisantString[i]);
					}
				}
				String assisant="";
				for (int i = 0; i < assisantList.size(); i++) {
					assisant=assisant+assisantList.get(i)+",";
				}
				sql="update 营业厅信息 set assisant='"+assisant+",' where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
				sql="update 帐号表 set state ='0' where ID='"+bID+"'";
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
	public String[] getCourierList(String ID, long bID)throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<String> courierList=new ArrayList<String>();
		String IDString[]=ID.split("-");
		sql="select courier from 营业厅信息 where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			resultSet.next();
			if (!resultSet.getString(1).equals("")) {
				String courierString[]=resultSet.getString(1).split(",");
				for (int i = 0; i < courierString.length; i++) {
					sql="select name from 帐号表 where ID ='"+courierString[i]+"'";
					preparedStatement=connection.prepareStatement(sql);
					resultSet=preparedStatement.executeQuery();
					resultSet.next();
					courierList.add(courierString[i]+"-"+resultSet.getString(1));
				}
				String courierarray[]=new String[courierList.size()];
				for (int i = 0; i < courierarray.length; i++) {
					courierarray[i]=courierList.get(i);
				}
				connection.close();
				return courierarray;
			}else {
				return null;
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

	@Override
	public boolean addCourier(String ID, long bID) throws RemoteException{
		// TODO 自动生成的方法存根
		String IDString[]=ID.split("-");
		sql="select courier from 营业厅信息 where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
			try {
				Class.forName(DRIVER);
				Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				ResultSet resultSet=preparedStatement.executeQuery();
				resultSet.next();
				if (resultSet.getString(1)==null) {
					sql="update 营业厅信息 set courier='"+Long.toString(bID)+",' where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
					
				}else {
					sql="update 营业厅信息 set courier='"+resultSet.getString(1)+Long.toString(bID)+",' where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
					
				}
					preparedStatement=connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
				sql="update 帐号表 set state = '1-"+resultSet.getString(1)+"-"+resultSet.getString(2)+"-营业厅-"+ID+"' where ID ='"+bID+"'";
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
	public boolean removeCourier(String ID, long bID) throws RemoteException{
		// TODO 自动生成的方法存根
		String IDString[]=ID.split("-");
		sql="select courier from 营业厅信息 where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
			try {
				Class.forName(DRIVER);
				Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				ResultSet resultSet=preparedStatement.executeQuery();
				resultSet.next();
				String courierString[]=resultSet.getString(1).split(",");
				ArrayList<String>courierList=new ArrayList<String>();
				for (int i = 0; i < courierString.length; i++) {
					if (!courierString[i].equals(Long.toString(bID))) {
						courierList.add(courierString[i]);
					}
				}
				String courier="";
				for (int i = 0; i < courierList.size(); i++) {
					courier=courier+courierList.get(i)+",";
				}
				sql="update 营业厅信息 set courier='"+courier+",' where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
				sql="update 帐号表 set state ='0' where ID='"+bID+"'";
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
	public String[] getVehicleList(String ID) throws RemoteException{
		// TODO 自动生成的方法存根
		String IDString[]=ID.split("-");
		sql="select vehicle from 营业厅信息 where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			resultSet.next();
			if (!resultSet.getString(1).equals("")) {
				String vehicleString[]=resultSet.getString(1).split(",");
				connection.close();
				return vehicleString;	
			}else {
				return null;
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

	@Override
	public VehiclePO getVehicleInfo(String ID, String codeVehicle) throws RemoteException{
		// TODO 自动生成的方法存根
		sql="select * from 车辆信息 where codeVehicle ='"+codeVehicle+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			resultSet.next();
			VehiclePO vehiclePO=new VehiclePO(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
			connection.close();
			return vehiclePO;
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
	public boolean addVehicle(String ID, VehiclePO po) throws RemoteException{
		// TODO 自动生成的方法存根
		sql="insert into 车辆信息 (codeVehicle,codeCity,codeBussinessHall,codeID,platNumber,date) values ('"+po.getCodeVehicle()+"','"+po.getCodeCity()+"','"+po.getCodeBussinessHall()+"','"+po.getCodeID()+"','"+po.getPlateNumber()+"','"+po.getDate()+"')";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			String IDString[]=ID.split("-");
			sql="select vehicle from 营业厅信息 where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";			
				preparedStatement=connection.prepareStatement(sql);
					ResultSet resultSet=preparedStatement.executeQuery();
					resultSet.next();
					if (resultSet.getString(1)==null) {
						sql="update 营业厅信息 set vehicle='"+po.getCodeVehicle()+",' where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
						
					}else {
						sql="update 营业厅信息 set vehicle='"+resultSet.getString(1)+po.getCodeVehicle()+",' where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
						
					}
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
	public boolean removeVehicle(String ID, String codeVehicle) throws RemoteException{
		// TODO 自动生成的方法存根
		sql="delete from 车辆信息 where codeVehicle ='"+codeVehicle+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			String IDString[]=ID.split("-");
			sql="select vehicle from 营业厅信息 where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
			preparedStatement=connection.prepareStatement(sql);
					ResultSet resultSet=preparedStatement.executeQuery();
					resultSet.next();
					String vehicleString[]=resultSet.getString(1).split(",");
					ArrayList<String>vehicleList=new ArrayList<String>();
					for (int i = 0; i < vehicleString.length; i++) {
						if (!vehicleString[i].equals(codeVehicle)) {
							vehicleList.add(vehicleString[i]);
						}
					}
					String vehicle="";
					for (int i = 0; i < vehicleList.size(); i++) {
						vehicle=vehicle+vehicleList.get(i)+",";
					}
					sql="update 营业厅信息 set vehicle='"+vehicle+",' where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
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
	public boolean changeVehicle(String ID, VehiclePO po) throws RemoteException{
		// TODO 自动生成的方法存根
		
		return false;
	}

	@Override
	public String[] getDriverList(String ID) throws RemoteException{
		// TODO 自动生成的方法存根
		String IDString[]=ID.split("-");
		sql="select driver from 营业厅信息 where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			resultSet.next();
			if (!resultSet.getString(1).equals("")) {
				String vehicleString[]=resultSet.getString(1).split(",");
				connection.close();
				return vehicleString;
			}else {
				return null;
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

	@Override
	public DriverPO getDriverInfo(String ID, String codeDriver) throws RemoteException{
		// TODO 自动生成的方法存根
		sql="select * from 司机信息 where codeDriver ='"+codeDriver+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			resultSet.next();
			DriverPO driverPO=new DriverPO(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10));
			connection.close();
			return driverPO;
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
	public boolean addDriver(String ID, DriverPO po) throws RemoteException{
		// TODO 自动生成的方法存根
		sql="insert into 司机信息 (codeDriver,codeCity,codeBussinessHall,codeID,name,date,ID,phone,sex,toDate) values ('"+po.getCodeDriver()+"','"+po.getCodeCity()+"','"+po.getCodeBussinessHall()+"','"+po.getCodeID()+"','"+po.getName()+"','"+po.getDate()+"','"+po.getID()+"','"+po.getPhone()+"','"+po.getSex()+"','"+po.getToDate()+"')";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			String IDString[]=ID.split("-");
			sql="select driver from 营业厅信息 where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";			
				preparedStatement=connection.prepareStatement(sql);
					ResultSet resultSet=preparedStatement.executeQuery();
					resultSet.next();
					if (resultSet.getString(1)==null) {
						sql="update 营业厅信息 set driver='"+po.getCodeDriver()+",' where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
						
					}else {
						sql="update 营业厅信息 set driver='"+resultSet.getString(1)+po.getCodeDriver()+",' where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
						
					}
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
	public boolean removeDriver(String ID, String codeDriver) throws RemoteException{
		// TODO 自动生成的方法存根
		sql="delete from 司机信息 where codeDriver ='"+codeDriver+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			String IDString[]=ID.split("-");
			sql="select driver from 营业厅信息 where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
			preparedStatement=connection.prepareStatement(sql);
					ResultSet resultSet=preparedStatement.executeQuery();
					resultSet.next();
					String driverString[]=resultSet.getString(1).split(",");
					ArrayList<String>driverList=new ArrayList<String>();
					for (int i = 0; i < driverString.length; i++) {
						if (!driverString[i].equals(codeDriver)) {
							driverList.add(driverString[i]);
						}
					}
					String driver="";
					for (int i = 0; i < driverList.size(); i++) {
						driver=driver+driverList.get(i)+",";
					}
					sql="update 营业厅信息 set driver='"+driver+",' where codeNumberOfMiddle ='"+IDString[0]+"' and codeNumber ='"+IDString[1]+"'";
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
	public boolean changeDriver(String ID, DriverPO po) throws RemoteException{
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean addBussinessHall(String ID, BussinessOrgPO po) throws RemoteException{
		// TODO 自动生成的方法存根
		try {
			sql="select city from 营业厅信息 where city='"+po.getCity()+"'";
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				return false;
			}
			else {
				sql="insert into 营业厅信息 (city,mcity,codeNumber,codeNumberOfMiddle) values ('"+po.getCity()+"','"+po.getMcity()+"','"+po.getCodeNumber()+"','"+po.getCodeNumberOfMiddle()+"')";
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
				sql="select bussinessHall from 中转中心信息 where codeNumber ='"+po.getCodeNumberOfMiddle()+"'";
				preparedStatement=connection.prepareStatement(sql);
				resultSet=preparedStatement.executeQuery();
				resultSet.next();
				if (resultSet.getString(1)==null) {
					sql="update 中转中心信息 set bussinessHall='"+po.getCodeNumber()+",' where codeNumber ='"+po.getCodeNumberOfMiddle()+"'";
				}
				else {
					sql="update 中转中心信息 set bussinessHall='"+resultSet.getString(1)+po.getCodeNumber()+",' where codeNumber ='"+po.getCodeNumberOfMiddle()+"'";
				}			
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
				connection.close();
				return true;
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
	public boolean removeBussinessHall(String ID, String codeNumber) throws RemoteException{
		// TODO 自动生成的方法存根
		try {
		String IDString[]=ID.split("-");
		sql="select assisant,courier,vehicle,driver from 营业厅信息 where codeNumber ='"+codeNumber+"' and codeNumberOfMiddle ='"+IDString[0]+"'";
		Class.forName(DRIVER);
		Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		ResultSet resultSet=preparedStatement.executeQuery();
		resultSet.next();
		String assisantList[]=resultSet.getString(1).split(",");
		String courierList[]=resultSet.getString(2).split(",");
		String vehicleList[]=resultSet.getString(3).split(",");
		String driverList[]=resultSet.getString(4).split(",");
		for (int i = 0; i < assisantList.length; i++) {
			removeBussinessman(ID, Long.parseLong(assisantList[i]));
		}
		for (int i = 0; i < courierList.length; i++) {
			removeCourier(ID,Long.parseLong(courierList[i]));
		}
		for (int i = 0; i < vehicleList.length; i++) {
			removeVehicle(ID, vehicleList[i]);
		}
		for (int j = 0; j < driverList.length; j++) {
			removeDriver(ID, driverList[j]);
		}
		sql="delete from 营业厅信息 where codeNumber ='"+codeNumber+"' and codeNumberOfMiddle ='"+IDString[0]+"'";	
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			sql="select bussinessHall from 中转中心信息 where codeNumber='"+IDString[0]+"'";
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			resultSet.next();
			String bussinessHallString[]=resultSet.getString(1).split(",");
			ArrayList<String>bussinessHallList=new ArrayList<String>();
			for (int i = 0; i < bussinessHallString.length; i++) {
				if (!bussinessHallString[i].equals(codeNumber)) {
					bussinessHallList.add(bussinessHallString[i]);
				}
			}
			String bussinessHall="";
			for (int i = 0; i < bussinessHallList.size(); i++) {
				bussinessHall=bussinessHall+bussinessHallList.get(i)+",";
			}
			sql="update 中转中心信息 set bussinessHall='"+bussinessHall+",' where codeNumber ='"+IDString[0]+"'";
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
	public String getCodeNumber() throws RemoteException{
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean changeCodeNumberOfMiddle(String ID, String codeNumberOfMiddle) throws RemoteException{
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public String getInfo(String ID) throws RemoteException{
		// TODO 自动生成的方法存根
		String s[]=ID.split("-");
		String cityString=null;
		sql="select city from 营业厅信息 where codeNumberOfMiddle ='"+s[0]+"' and codeNumber ='"+s[1]+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				cityString= resultSet.getString(1);
				connection.close();
			}		
			return cityString;
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
	public boolean changeCity(String ID, String city) throws RemoteException{
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean changeCodeNumber(String ID, String codeNumber) throws RemoteException{
		// TODO 自动生成的方法存根
		return false;
	}


}
