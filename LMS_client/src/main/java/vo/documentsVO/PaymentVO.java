package vo.documentsVO;


public class PaymentVO  extends DocumentVO{
	private String code;//付款单编号
	private String doName;//单据名
	private String date;
	private String account;//创建人账号
	private double fund;//付款金额
	private String name2;//付款人姓名
	private String account2;//付款账号
	private String type;//条目
	private String remark;//备注
	
	public PaymentVO(String code, String doName, String date, String account, double fund,
			String name2, String account2, String type, String remark) {
		super();
		this.code = code;
		this.doName = doName;
		this.date = date;
		this.account= account;
		this.fund = fund;
		this.name2 = name2;
		this.account2 = account2;
		this.type = type;
		this.remark = remark;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getDoName() {
		return doName;
	}
	public void setDoName(String doName) {
		this.doName = doName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	
	public String getAccount2() {
		return account2;
	}
	public void setAccount2(String account2) {
		this.account2 = account2;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
