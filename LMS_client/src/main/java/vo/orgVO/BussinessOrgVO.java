package vo.orgVO;

import java.util.ArrayList;

import businesslogic.accountbl.AccountInfoController;
import vo.accountVO.AccountNumberVO;

/**
 * 用来表示营业厅
 * 
 * @author YangHua'an
 *
 */
public class BussinessOrgVO {
	private String Mcity;//所属中转中心城市
	public String getMcity() {
		return Mcity;
	}

	public void setMcity(String mcity) {
		Mcity = mcity;
	}

	private String city;//机构所在城市
	private String codeNumber;//机构编号，3位
	private String codeNemberOfMiddle;//所属中转中心编号；3位
	private ArrayList<String> assisant;//营业厅业务员账号列表
	private ArrayList<String> courier;//快递员账号列表
	private ArrayList<String> vehicle;//车辆信息列表
	private ArrayList<String> driver;//司机信息列表
	


	public BussinessOrgVO(String Mcity,String city, String codeNumber, String codeNemberOfMiddle,
			ArrayList<String> assisant, ArrayList<String> courier, ArrayList<String> vehicle,
			ArrayList<String> driver) {
		super();
		this.Mcity=Mcity;
		this.city = city;
		this.codeNumber = codeNumber;
		this.codeNemberOfMiddle = codeNemberOfMiddle;
		this.assisant = assisant;
		this.courier = courier;
		this.vehicle = vehicle;
		this.driver = driver;
		
//		for(AccountNumberVO vo:assisant){
//			vo.setState(2+"-"+Mcity+"-"+city+"-营业厅"+"-"+Mcity+"-"+city);
//		}
//		for(AccountNumberVO vo:courier){
//			vo.setState(1+"-"+Mcity+"-"+city+"-营业厅"+"-"+Mcity+"-"+city);
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

	public String getCodeNemberOfMiddle() {
		return codeNemberOfMiddle;
	}

	public void setCodeNemberOfMiddle(String codeNemberOfMiddle) {
		this.codeNemberOfMiddle = codeNemberOfMiddle;
	}

	public ArrayList<String> getAssisant() {
		return assisant;
	}

	public void setAssisant(ArrayList<String> assisant) {
		this.assisant = assisant;
	}

	public ArrayList<String> getCourier() {
		return courier;
	}

	public void setCourier(ArrayList<String> courier) {
		this.courier = courier;
	}
	
	
	public ArrayList<String> getVehicle() {
		return vehicle;
	}

	public void setVehicle(ArrayList<String> vehicle) {
		this.vehicle = vehicle;
	}

	public ArrayList<String> getDriver() {
		return driver;
	}

	public void setDriver(ArrayList<String> driver) {
		this.driver = driver;
	}

//	public void addAssisant(String vo){
//		this.assisant.add(vo);	
//		AccountInfoController accountInfoController = new AccountInfoController();
//		accountInfoController.getInfo(Long.parseLong(vo)).setState(2+"-"+Mcity+"-"+city+"-营业厅"+"-"+Mcity+"-"+city);
//	}
//	
//	public void removeAssisant( String vo){
//	    this.assisant.remove(vo);
//	    AccountInfoController accountInfoController = new AccountInfoController();
//		accountInfoController.getInfo(Long.parseLong(vo)).setState("0");
//
//	}
//	
//	public void addCourier(String vo){
//		this.courier.add(vo);
//		AccountInfoController accountInfoController = new AccountInfoController();
//		accountInfoController.getInfo(Long.parseLong(vo)).setState(1+"-"+Mcity+"-"+city+"-营业厅"+"-"+Mcity+"-"+city);
//	}
//	
//	public void removeCourier( String vo){
//	    this.courier.remove(vo);
//	    AccountInfoController accountInfoController = new AccountInfoController();
//		accountInfoController.getInfo(Long.parseLong(vo)).setState("0");
//	   
//
//	}
//	
//	public void addVehicle(String vo){
//		this.vehicle.add(vo);
//	}
//	
//	public void removeVehicle(String vo){
//		this.vehicle.remove(vo);
//	}
//
//	public void addDriver(String vo){
//		this.driver.add(vo);
//	}
//	
//	public void removeDriverVO(String vo){
//		this.driver.remove(vo);
//	}
	
}
