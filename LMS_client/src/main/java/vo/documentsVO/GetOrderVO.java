package vo.documentsVO;


public class GetOrderVO extends DocumentVO{
	private String code;//收件单编号
	private String doName;//单据名
	private String code1;//对应订单编号
	private String account;//创建人账号
	private String ReceiverName;//收件人姓名
	private String date;//收件日期（具体到分钟）
	public GetOrderVO(String code, String doName, String code1, String account,String receiverName,
			String date) {
		super();
		this.code = code;
		this.doName = doName;
		this.code1=code1;
		this.account=account;
		ReceiverName = receiverName;
		this.date = date;
	}
	
	public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
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
	public String getReceiverName() {
		return ReceiverName;
	}
	public void setReceiverName(String receiverName) {
		ReceiverName = receiverName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
