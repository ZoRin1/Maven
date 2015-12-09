package po.orgPO;
/**
 * 用来表示中转中心持久化对象
 * 
 * @author YangHua'an
 *
 */
import java.io.Serializable;
import java.util.ArrayList;

import po.accountPO.AccountInfoPO;


public class MiddleOrgPO implements Serializable {
	
	/**
	 * 
	 * 序列号版本号
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String city;//机构所在城市
	private String codeNumber;//机构编号，财务部唯一且为000；
	private ArrayList<AccountInfoPO> assisant;//中转中心营业员账号列表
	private ArrayList<AccountInfoPO> storger;//仓库管理员账号列表
	private ArrayList<BussinessOrgPO> bussinessHall;//下辖营业厅列表
//	private ArrayList<VehiclePO> vehicle;//车辆信息列表
//private ArrayList<DriverPO> driver;//司机信息列表
	
	public MiddleOrgPO(String city, String codeNumber, ArrayList<AccountInfoPO> assisant,
			ArrayList<AccountInfoPO> storger, ArrayList<BussinessOrgPO> bussinessHall) {
		super();
		this.city = city;
		this.codeNumber = codeNumber;
		this.assisant = assisant;
		this.storger = storger;
		this.bussinessHall = bussinessHall;
//		this.vehicle = vehicle;
//		this.driver = driver;
		
//		for(AccountInfoPO po:assisant){
//			po.setState(3+"-"+city+"-中转中心"+"-"+codeNumber);
//		}
//		
//		for(AccountInfoPO po:storger){
//			po.setState(4+"-"+city+"-中转中心"+"-"+codeNumber);
//		}
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCodeNumber() {
		return codeNumber;
	}

	public void setCodeNumber(String codeNumber) {
		this.codeNumber = codeNumber;
	}

	public ArrayList<AccountInfoPO> getAssisant() {
		return assisant;
	}

	public void setAssisant(ArrayList<AccountInfoPO> assisant) {
		this.assisant = assisant;
	}

	public ArrayList<AccountInfoPO> getStorger() {
		return storger;
	}

	public void setStorger(ArrayList<AccountInfoPO> storger) {
		this.storger = storger;
	}

	public ArrayList<BussinessOrgPO> getBussinessHall() {
		return bussinessHall;
	}

	public void setBussinessHall(ArrayList<BussinessOrgPO> bussinessHall) {
		this.bussinessHall = bussinessHall;
	}

//	public ArrayList<VehiclePO> getVehicle() {
//		return vehicle;
//	}
//
//	public void setVehicle(ArrayList<VehiclePO> vehicle) {
//		this.vehicle = vehicle;
//	}
//
//	public ArrayList<DriverPO> getDriver() {
//		return driver;
//	}
//
//	public void setDriver(ArrayList<DriverPO> driver) {
//		this.driver = driver;
//	}
	
	public void addAssisant(AccountInfoPO po){
		this.assisant.add(po);	
		po.setState(3+"-"+city+"-中转中心"+"-"+codeNumber);
	}
	
	public void removeAssisant( AccountInfoPO po){
	    this.assisant.remove(po);
	    po.setState("0");

	}
	
	public void addStorger(AccountInfoPO po){
		this.assisant.add(po);	
		po.setState(4+"-"+city+"-中转中心"+"-"+codeNumber);
	}
	
	public void removeStorger( AccountInfoPO po){
	    this.storger.remove(po);
	    po.setState("0");

	}
	
	public void addBussinessOrg(BussinessOrgPO po){
		this.bussinessHall.add(po);	
	}
	
	public void removeBussinessOrg(BussinessOrgPO po){
		this.bussinessHall.remove(po);	
	}
	
//	public void addVehicle(VehiclePO po){
//		this.vehicle.add(po);
//	}
//	
//	public void removeVehicle(VehiclePO po){
//		this.vehicle.remove(po);
//	}
//
//	public void addDriver(DriverPO po){
//		this.driver.add(po);
//	}
//	
//	public void removeDriver(DriverPO po){
//		this.driver.remove(po);
//	}
//	


}
