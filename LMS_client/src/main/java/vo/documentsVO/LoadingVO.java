package vo.documentsVO;

import java.util.ArrayList;

public class LoadingVO  extends DocumentVO{
	private String date;
	private String code;//装运单编号
	private String doName;//单据名
	private String name;//创建人姓名
	private String departure;//出发地
	private String arrival;//目的地
	private String supervisor;//监装员
	private String supercargo;//押运员
	private ArrayList<String> codeList;//所有托运单号
	private double charge;//运费
	
	public LoadingVO(String date, String code, String doName, String name, String departure,
			String arrival, String supervisor, String supercargo,
			ArrayList<String> codeList, double charge) {
		super();
		this.date = date;
		this.code = code;
		this.doName = doName;
		this.name =name;
		this.departure = departure;
		this.arrival = arrival;
		this.supervisor = supervisor;
		this.supercargo = supercargo;
		this.codeList = codeList;
		this.charge = charge;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public String getSupercargo() {
		return supercargo;
	}

	public void setSupercargo(String supercargo) {
		this.supercargo = supercargo;
	}

	public ArrayList<String> getCodeList() {
		return codeList;
	}

	public void setCodeList(ArrayList<String> codeList) {
		this.codeList = codeList;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}
}
