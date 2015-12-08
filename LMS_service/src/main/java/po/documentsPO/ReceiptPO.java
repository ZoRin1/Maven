package po.documentsPO;

import java.io.Serializable;
import java.util.ArrayList;

public class ReceiptPO extends DocumentPO implements Serializable {
	private String code;//收款单编号
	private String doName;//单据名
	private String date;//收款日期
	private String account;//创建人账号
	private String OrgCode;//营业厅编号
	private double fund;//收款金额
	private String name2;//快递员姓名
	private ArrayList<String> TCode;//所有订单条形码号
	public ReceiptPO(String code, String doName, String date, String account,String OrgCode,double fund,
			String name2, ArrayList<String> tCode) {
		super();
		this.code = code;
		this.doName = doName;
		this.date = date;
		this.account=account;
		this.OrgCode=OrgCode;
		this.fund = fund;
		this.name2 = name2;
		TCode = tCode;
	}
	
	public String getOrgCode() {
		return OrgCode;
	}

	public void setOrgCode(String orgCode) {
		OrgCode = orgCode;
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
	public double getFund() {
		return fund;
	}
	public void setFund(double fund) {
		this.fund = fund;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public ArrayList<String> getTCode() {
		return TCode;
	}
	public void setTCode(ArrayList<String> tCode) {
		TCode = tCode;
	}
	
	
	
}
