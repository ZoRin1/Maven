package po.documentsPO;

import java.io.Serializable;
import java.util.ArrayList;

public class ZLoadingPO extends DocumentPO implements Serializable {
	private String date;
	private String code;//装运单编号
	private String doName;//单据名
	private String account;//创建人账号
	private String transcode;//车辆代号
	private String departure;//出发地
	private String arrival;//到达地
	private String name2;//监装员姓名
	private ArrayList<String> codeList;//所有订单条形码号
	private double carriage;//运费
	public ZLoadingPO(String date, String code, String doName,String account,
			String transcode, String departure, String arrival, String name2,
			ArrayList<String> codeList, double carriage) {
		super();
		this.date = date;
		this.code = code;
		this.doName = doName;
		this.account = account;
		this.transcode = transcode;
		this.departure = departure;
		this.arrival = arrival;
		this.name2 = name2;
		this.codeList = codeList;
		this.carriage = carriage;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public String getTranscode() {
		return transcode;
	}
	public void setTranscode(String transcode) {
		this.transcode = transcode;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name) {
		this.name2 = name2;
	}
	public ArrayList<String> getCodeList() {
		return codeList;
	}
	public void setCodeList(ArrayList<String> codeList) {
		this.codeList = codeList;
	}
	public double getCarriage() {
		return carriage;
	}
	public void setCarriage(double carriage) {
		this.carriage = carriage;
	}
	
	
}

