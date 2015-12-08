package vo.documentsVO;


public class YDispatchVO  extends DocumentVO{
	private String date;//派件日期
	private String code;//派件单编号
	private String doName;//单据名
	private String code2;//对应订单编号
	private String account;//创建人账号
	private String name2;//派件快递员姓名
	public YDispatchVO(String date, String code, String doName, String code2, String account,String name2) {
		super();
		this.date = date;
		this.code = code;
		this.doName = doName;
		this.code2=code2;
		this.account = account;
		this.name2=name2;
	}


	public String getCode2() {
		return code2;
	}


	public void setCode2(String code2) {
		this.code2 = code2;
	}


	public String getName2() {
		return name2;
	}


	public void setName2(String name2) {
		this.name2 = name2;
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


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}

}
