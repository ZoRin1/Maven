package po.documentsPO;

import java.io.Serializable;
import java.util.ArrayList;


public class OrderPO extends DocumentPO implements Serializable {
	private String code;//订单编号
	private String doName;//单据名
	private String account;//创建人账号
	private String date;//日期(具体到分钟）
	private String SenderName;//寄件人姓名
	private String SenderAddress;//寄件人地址
	private String SenderOrg;//寄件人单位
	private String SPhoneNumber;//寄件人电话
	private String SMobileNumber;//寄件人手机号
	private String ReceiverName;//收件人姓名
	private String ReceiverAddress;//收件人地址
	private String ReceiverOrg;//收件人单位
	private String RPhoneNumber;//收件人电话
	private String RMobileNumber;//收件人手机号
	private int number;//货物数量
	private double weight;//货物重量
	private double shape;//货物体积
	private String cargoNameList;//货物名
	private double[] sizeList;//货物大小

	private double sumCost;//总费用
	private String state;//快递种类
	
	public OrderPO(String code, String doName,String account,String date, String senderName,
			String senderAddress, String senderOrg, String sPhoneNumber,
			String sMobileNumber, String receiverName, String receiverAddress,
			String receiverOrg, String rPhoneNumber, String rMobileNumber,
			int number, double weight, double shape,
			String cargoNameList, double[] sizeList,
			 double sumCost, String state) {
		super();
		this.code = code;
		this.doName = doName;
		this.account=account;
		this.date=date;
		SenderName = senderName;
		SenderAddress = senderAddress;
		SenderOrg = senderOrg;
		SPhoneNumber = sPhoneNumber;
		SMobileNumber = sMobileNumber;
		ReceiverName = receiverName;
		ReceiverAddress = receiverAddress;
		ReceiverOrg = receiverOrg;
		RPhoneNumber = rPhoneNumber;
		RMobileNumber = rMobileNumber;
		this.number = number;
		this.weight = weight;
		this.shape = shape;
		this.cargoNameList = cargoNameList;
		this.sizeList = sizeList;
		this.sumCost = sumCost;
		this.state = state;
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
	public String getSenderName() {
		return SenderName;
	}
	public void setSenderName(String senderName) {
		SenderName = senderName;
	}
	public String getSenderAddress() {
		return SenderAddress;
	}
	public void setSenderAddress(String senderAddress) {
		SenderAddress = senderAddress;
	}
	public String getSenderOrg() {
		return SenderOrg;
	}
	public void setSenderOrg(String senderOrg) {
		SenderOrg = senderOrg;
	}
	public String getSPhoneNumber() {
		return SPhoneNumber;
	}
	public void setSPhoneNumber(String sPhoneNumber) {
		SPhoneNumber = sPhoneNumber;
	}
	public String getSMobileNumber() {
		return SMobileNumber;
	}
	public void setSMobileNumber(String sMobileNumber) {
		SMobileNumber = sMobileNumber;
	}
	public String getReceiverName() {
		return ReceiverName;
	}
	public void setReceiverName(String receiverName) {
		ReceiverName = receiverName;
	}
	public String getReceiverAddress() {
		return ReceiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		ReceiverAddress = receiverAddress;
	}
	public String getReceiverOrg() {
		return ReceiverOrg;
	}
	public void setReceiverOrg(String receiverOrg) {
		ReceiverOrg = receiverOrg;
	}
	public String getRPhoneNumber() {
		return RPhoneNumber;
	}
	public void setRPhoneNumber(String rPhoneNumber) {
		RPhoneNumber = rPhoneNumber;
	}
	public String getRMobileNumber() {
		return RMobileNumber;
	}
	public void setRMobileNumber(String rMobileNumber) {
		RMobileNumber = rMobileNumber;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getShape() {
		return shape;
	}
	public void setShape(double shape) {
		this.shape = shape;
	}
	public String getCargoNameList() {
		return cargoNameList;
	}
	public void setCargoNameList(String cargoNameList) {
		this.cargoNameList = cargoNameList;
	}
	public double[] getSizeList() {
		return sizeList;
	}
	public void setSizeList(double[] sizeList) {
		this.sizeList = sizeList;
	}
	public double getSumCost() {
		return sumCost;
	}
	public void setSumCost(double sumCost) {
		this.sumCost = sumCost;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
}
