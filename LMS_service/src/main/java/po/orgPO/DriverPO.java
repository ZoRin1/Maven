package po.orgPO;
/**
 * 用来表示司机信息持久化对象
 */
import java.io.Serializable;

public class DriverPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codeDriver;//司机编号，城市编号+营业厅编号+编号
	private String codeCity;//城市编号，3位数字，南京025，如000
	private String codeBussinessHall;//营业厅编号，3位数字如000
	private String codeID;//编号，3位数字如000
	
	private String name;//姓名
	private String date;//出生日期
	private String ID;//身份证号码
	private String phone;//手机号码
	private String sex;//性别
	private String toDate;//行驶证期限
	public DriverPO( String codeCity, String codeBussinessHall, String codeID, String name,
			String date, String iD, String phone, String sex, String toDate) {
		super();
		this.codeDriver = codeCity+codeBussinessHall+codeID;
		this.codeCity = codeCity;
		this.codeBussinessHall = codeBussinessHall;
		this.codeID = codeID;
		this.name = name;
		this.date = date;
		ID = iD;
		this.phone = phone;
		this.sex = sex;
		this.toDate = toDate;
	}
	public String getCodeDriver() {
		return codeDriver;
	}
	public void setCodeDriver(String codeDriver) {
		this.codeDriver = codeDriver;
	}
	public String getCodeCity() {
		return codeCity;
	}
	public void setCodeCity(String codeCity) {
		this.codeCity = codeCity;
	}
	public String getCodeBussinessHall() {
		return codeBussinessHall;
	}
	public void setCodeBussinessHall(String codeBussinessHall) {
		this.codeBussinessHall = codeBussinessHall;
	}
	public String getCodeID() {
		return codeID;
	}
	public void setCodeID(String codeID) {
		this.codeID = codeID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	

}