package po.financePO;




/**
 * 用于存储或返回账本信息
 * @author YangGuan
 *
 */
import java.io.Serializable;
import java.util.ArrayList;

import po.accountPO.AccountInfoPO;
import po.documentsPO.InBillsPO;
import po.orgPO.BussinessOrgPO;
import po.orgPO.VehiclePO;


public class BooksPO  implements Serializable {
	
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String  bussinessHallCode; // 机构
	private String  middleCode;
	private String  financeCode;
	private String  IDCode; //人员
	private String  VehicleCode; // 车辆
	private String AccountName; //账户
	private String date;//日期
	
	public BooksPO(String name,String bussinessHallCode, String middleCode,
			String financeCode, String iDCode, String vehicleCode,
			String accountName,String date) {
		super();
		this.bussinessHallCode = bussinessHallCode;
		this.middleCode = middleCode;
		this.financeCode = financeCode;
		this.IDCode = iDCode;
		this.VehicleCode = vehicleCode;
		this.AccountName = accountName;
		this.date = date;
		this.name = name;
	}

	public String getBussinessHallCode() {
		return bussinessHallCode;
	}

	public void setBussinessHallCode(String bussinessHallCode) {
		this.bussinessHallCode = bussinessHallCode;
	}

	public String getMiddleCode() {
		return middleCode;
	}

	public void setMiddleCode(String middleCode) {
		this.middleCode = middleCode;
	}

	public String getFinanceCode() {
		return financeCode;
	}

	public void setFinanceCode(String financeCode) {
		this.financeCode = financeCode;
	}

	public String getIDCode() {
		return IDCode;
	}

	public void setIDCode(String iDCode) {
		IDCode = iDCode;
	}

	public String getVehicleCode() {
		return VehicleCode;
	}

	public void setVehicleCode(String vehicleCode) {
		VehicleCode = vehicleCode;
	}

	public String getAccountName() {
		return AccountName;
	}

	public void setAccountName(String accountName) {
		AccountName = accountName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
}
