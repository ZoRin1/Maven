package businesslogic.organizationbl;

import vo.orgVO.DriverVO;
import vo.orgVO.VehicleVO;

public class BhclerkController {
	
	BusinessBL bBL = new BusinessBL();
	
	public String[] getVehicleList(String ID) {
		// TODO 自动生成的方法存根
		return bBL.getVehicleList(ID);
	}


	public VehicleVO getVehicleInfo(String ID, String codeVehicle) {
		// TODO 自动生成的方法存根
		return bBL.getVehicleInfo(ID, codeVehicle);
	}


	public boolean addVehicle(String ID, VehicleVO vo) {
		// TODO 自动生成的方法存根
		return bBL.addVehicle(ID, vo);
	}


	public boolean removeVehicle(String ID, String codeVehicle) {
		// TODO 自动生成的方法存根
		return bBL.removeVehicle(ID, codeVehicle);
	}


	public boolean changeVehicle(String ID, VehicleVO vo) {
		// TODO 自动生成的方法存根
		return bBL.changeVehicle(ID, vo);
	}


	public String[] getDriverList(String ID) {
		// TODO 自动生成的方法存根
		return bBL.getDriverList(ID);
	}


	public DriverVO getDriverInfo(String ID, String codeDriver) {
		// TODO 自动生成的方法存根
		return bBL.getDriverInfo(ID, codeDriver);
	}


	public boolean addDriver(String ID, DriverVO vo) {
		// TODO 自动生成的方法存根
		return bBL.addDriver(ID, vo);
	}


	public boolean removeDriver(String ID, String codeDriver) {
		// TODO 自动生成的方法存根
		return bBL.removeDriver(ID, codeDriver);
	}


	public boolean changeDriver(String ID, DriverVO vo) {
		// TODO 自动生成的方法存根
		return bBL.changeDriver(ID, vo);
	}

}
