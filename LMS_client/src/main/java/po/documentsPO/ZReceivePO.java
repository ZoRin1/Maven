package po.documentsPO;

import java.io.Serializable;
import java.util.ArrayList;

public class ZReceivePO extends DocumentPO implements Serializable {
	private String code;//中转单编号
	private String doName;//单据名
	private String date;
	private String account;//创建人账号
	private String zCode;//中转中心汽运编号
	private ArrayList<String> codeList;//订单条形码号列表
	private String departure;
	private String arrival;
	public ZReceivePO(String code, String doName, String date,String account, String zCode,ArrayList<String>codeList,
			String departure,String arrival) {
		super();
		this.code = code;
		this.doName = doName;
		this.date = date;
		this.account = account;
		this.zCode = zCode;
		this.codeList=codeList;
		this.departure = departure;
		this.arrival=arrival;
	}
	public ArrayList<String> getCodeList() {
		return codeList;
	}
	public void setCodeList(ArrayList<String> codeList) {
		this.codeList = codeList;
	}
	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDoName() {
		return doName;
	}
	public void setDoName(String doName) {
		this.doName = doName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getzCode() {
		return zCode;
	}
	public void setzCode(String zCode) {
		this.zCode = zCode;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}

}
