package businesslogic.organizationbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogicservice.organizationblservice.BussinessOrgBLSer;
import dataservice.accountdataservice.accountFactory;
import dataservice.organizationdataservice.BussinessOrgDataSer;
import dataservice.organizationdataservice.organizationFactory;
import po.orgPO.BussinessOrgPO;
import po.orgPO.DriverPO;
import po.orgPO.VehiclePO;
import vo.orgVO.BussinessOrgVO;
import vo.orgVO.DriverVO;
import vo.orgVO.VehicleVO;

public class BusinessBL implements BussinessOrgBLSer {
	private BussinessOrgDataSer bussinessOrgDataSer;

 public BusinessBL() {
		// TODO Auto-generated constructor stub				
		try {
			organizationFactory organizationFactory = (organizationFactory)Naming.lookup("rmi://114.212.42.143:6600/orgFactory");
			this.bussinessOrgDataSer = organizationFactory.createBussinessOrgDataSer();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	@Override
	public String[] getBussinessmanList(String ID) {
//		String[] result = {"1000001-张飞","1000002-李四","1000003-王伟"};
		// TODO 自动生成的方法存根
		return this.bussinessOrgDataSer.getBussinessmanList(ID);
	}

	@Override
	public boolean addBussinessman(String ID, long bID) {
		// TODO 自动生成的方法存根
		return this.bussinessOrgDataSer.addBussinessman(ID, bID);
	}

	@Override
	public boolean removeBussinessman(String ID, long bID) {
		// TODO 自动生成的方法存根
		return this.bussinessOrgDataSer.removeBussinessman(ID, bID);
	}

	@Override
	public String[] getCourierList(String ID) {
		String[] result = {"1000001-张飞","1000002-李四","1000003-王伟"};
		// TODO 自动生成的方法存根
		return this.bussinessOrgDataSer.getCourierList(ID, 0);
	}

	@Override
	public boolean addCourier(String ID, long bID) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean removeCourier(String ID, long bID) {
		// TODO 自动生成的方法存根
		return this.bussinessOrgDataSer.removeCourier(ID, bID);
	}

	@Override
	public String[] getVehicleList(String ID) {
		// TODO 自动生成的方法存根
		return this.bussinessOrgDataSer.getVehicleList(ID);
	}

	@Override
	public VehicleVO getVehicleInfo(String ID, String codeVehicle) {
		// TODO 自动生成的方法存根
		VehiclePO po = this.bussinessOrgDataSer.getVehicleInfo(ID, codeVehicle);
		return new VehicleVO(po.getCodeCity(), po.getCodeBussinessHall(), po.getCodeID(), po.getPlateNumber(), po.getDate());
	}

	@Override
	public boolean addVehicle(String ID, VehicleVO vo) {
		// TODO 自动生成的方法存根
		return this.bussinessOrgDataSer.addVehicle(ID, new VehiclePO(vo.getCodeCity(),
				vo.getCodeBussinessHall(), vo.getCodeID(), vo.getPlateNumber(), vo.getDate()));
	}

	@Override
	public boolean removeVehicle(String ID, String codeVehicle) {
		// TODO 自动生成的方法存根
		return this.bussinessOrgDataSer.removeVehicle(ID, codeVehicle);
	}

	@Override
	public boolean changeVehicle(String ID, VehicleVO vo) {
		// TODO 自动生成的方法存根
		return this.bussinessOrgDataSer.changeVehicle(ID, new VehiclePO(vo.getCodeCity(),
				vo.getCodeBussinessHall(), vo.getCodeID(), vo.getPlateNumber(), vo.getDate()));
	}

	@Override
	public String[] getDriverList(String ID) {
		// TODO 自动生成的方法存根
		return this.bussinessOrgDataSer.getDriverList(ID);
	}

	@Override
	public DriverVO getDriverInfo(String ID, String codeDriver) {
		// TODO 自动生成的方法存根
		DriverPO po = this.bussinessOrgDataSer.getDriverInfo(ID, codeDriver);
		return new DriverVO(po.getCodeCity(), po.getCodeBussinessHall(), po.getCodeID(), 
				po.getName(), po.getDate(), po.getID(), po.getPhone(), po.getSex(), po.getToDate());
	}

	@Override
	public boolean addDriver(String ID, DriverVO vo) {
		// TODO 自动生成的方法存根
		return this.bussinessOrgDataSer.addDriver(ID, new DriverPO(vo.getCodeCity(), vo.getCodeBussinessHall(),
				vo.getCodeID(), vo.getName(), vo.getDate(), vo.getID(), vo.getPhone(), vo.getSex(), vo.getToDate()));
	}

	@Override
	public boolean removeDriver(String ID, String codeDriver) {
		// TODO 自动生成的方法存根
		return this.bussinessOrgDataSer.removeDriver(ID, codeDriver);
	}

	@Override
	public boolean changeDriver(String ID, DriverVO vo) {
		// TODO 自动生成的方法存根
		return this.bussinessOrgDataSer.changeDriver(ID, new DriverPO(vo.getCodeCity(), vo.getCodeBussinessHall(),
				vo.getCodeID(), vo.getName(), vo.getDate(), vo.getID(), vo.getPhone(), vo.getSex(), vo.getToDate()));
	}

	@Override
	public boolean addBussinessHall(String ID, BussinessOrgVO vo) {
		// TODO 自动生成的方法存根
		return this.bussinessOrgDataSer.addBussinessHall(ID, new BussinessOrgPO(null, vo.getCity(), 
				vo.getCodeNumber(), vo.getCodeNemberOfMiddle(), null, null, null, null));
	}

	@Override
	public boolean removeBussinessHall(String ID, String codeNumber) {
		// TODO 自动生成的方法存根
		return this.bussinessOrgDataSer.removeBussinessHall(ID, codeNumber);
	}

	@Override
	public String getCodeNumber() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean changeCodeNumberOfMiddle(String ID, String codeNumberOfMiddle) {
		// TODO 自动生成的方法存根
		return this.bussinessOrgDataSer.changeCodeNumberOfMiddle(ID, codeNumberOfMiddle);
	}

	@Override
	public String getInfo(String ID) {
		// TODO 自动生成的方法存根
//		String result = "鼓楼";
		return this.bussinessOrgDataSer.getInfo(ID);
	}

	@Override
	public boolean changeCity(String ID, String city) {
		// TODO 自动生成的方法存根
		return this.bussinessOrgDataSer.changeCity(ID, city);
	}

	@Override
	public boolean changeCodeNumber(String ID, String codeNumber) {
		// TODO 自动生成的方法存根
		return this.bussinessOrgDataSer.changeCodeNumber(ID, codeNumber);
	}

}
