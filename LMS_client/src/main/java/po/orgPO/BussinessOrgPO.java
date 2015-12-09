package po.orgPO;
//随便改一下//
import java.io.Serializable;
import java.util.ArrayList;

import po.accountPO.AccountInfoPO;


public class BussinessOrgPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Mcity;//所属中转中心城市
	private String city;//机构所在城市
	private String codeNumber;//机构编号，3位
	private String codeNumberOfMiddle;//所属中转中心编号，3位
	private ArrayList<AccountInfoPO> assisant;//营业厅业务员账号列表
	private ArrayList<AccountInfoPO> courier;//快递员账号列表
	private ArrayList<VehiclePO> vehicle;//车辆信息列表
	private ArrayList<DriverPO> driver;//司机信息列表
	
	
	public BussinessOrgPO(String Mcity,String city, String codeNumber, String codeNumberOfMiddle, ArrayList<AccountInfoPO> assisant,
			ArrayList<AccountInfoPO> courier, ArrayList<VehiclePO> vehicle, ArrayList<DriverPO> driver) {
		super();
		this.Mcity=Mcity;
		this.city = city;
		this.codeNumber = codeNumber;
		this.codeNumberOfMiddle = codeNumberOfMiddle;
		this.assisant = assisant;
		this.courier = courier;
		this.vehicle = vehicle;
		this.driver = driver;
		
//		for(AccountInfoPO po:assisant){
//			po.setState(2+"-"+Mcity+"-"+city+"-营业厅"+"-"+codeNumberOfMiddle+"-"+codeNumber);
//		}
//		for(AccountInfoPO po:courier){
//			po.setState(1+"-"+Mcity+"-"+city+"-营业厅"+"-"+codeNumberOfMiddle+"-"+codeNumber);
//		}
	}
	
	public String getMcity() {
		return Mcity;
	}

	public void setMcity(String mcity) {
		Mcity = mcity;
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
	
	public String getCodeNumberOfMiddle() {
		return codeNumberOfMiddle;
	}
	public void setCodeNumberOfMiddle(String codeNumberOfMiddle) {
		this.codeNumberOfMiddle = codeNumberOfMiddle;
	}
	public ArrayList<AccountInfoPO> getAssisant() {
		return assisant;
	}
	public void setAssisant(ArrayList<AccountInfoPO> assisant) {
		this.assisant = assisant;
	}
	public ArrayList<AccountInfoPO> getCourier() {
		return courier;
	}
	public void setCourier(ArrayList<AccountInfoPO> courier) {
		this.courier = courier;
	}
	public ArrayList<VehiclePO> getVehicle() {
		return vehicle;
	}
	public void setVehicle(ArrayList<VehiclePO> vehicle) {
		this.vehicle = vehicle;
	}
	public ArrayList<DriverPO> getDriver() {
		return driver;
	}
	public void setDriver(ArrayList<DriverPO> driver) {
		this.driver = driver;
	}
	
	public void addCourier(AccountInfoPO po){
		this.courier.add(po);	
		po.setState(2+"-"+Mcity+"-"+city+"-营业厅"+"-"+codeNumberOfMiddle+"-"+codeNumber);
	}
	
	public void removeCourier(AccountInfoPO po){
	    this.courier.remove(po);
	    po.setState("0");

	}
	
	public void addAssisant(AccountInfoPO po){
		this.assisant.add(po);	
		po.setState(3+"-"+Mcity+"-"+city+"-营业厅"+"-"+codeNumberOfMiddle+"-"+codeNumber);
	}
	
	public void removeAssisant(AccountInfoPO po){
	    this.assisant.remove(po);
	    po.setState("0");

	}
	
	public void addVehicle(VehiclePO po){
		this.vehicle.add(po);
	}
	
	public void removeVehicle(VehiclePO po){
		this.vehicle.remove(po);
	}

	public void addDriver(DriverPO po){
		this.driver.add(po);
	}
	
	public void removeDriverVO(DriverPO po){
		this.driver.remove(po);
	}
	
}