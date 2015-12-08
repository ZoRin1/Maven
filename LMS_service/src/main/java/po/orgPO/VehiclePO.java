package po.orgPO;
/**
 * 用来表示车辆信息持久化对象
 */
import java.io.Serializable;

public class VehiclePO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codeVehicle;//车辆代号，城市编号+营业厅编号+编号
	private String codeCity;//城市编号，3位数字，南京025，如000
	private String codeBussinessHall;//营业厅编号，3位数字如000
	private String codeID;//编号，3位数字如000
	
	private String plateNumber;//车牌号，如苏A00000
	
	private String date;//服役时间，如2015-05-09

	public VehiclePO( String codeCity, String codeBussinessHall, String codeID, String plateNumber,
			String date) {
		super();
		this.codeVehicle = codeCity+codeBussinessHall+codeID;
		this.codeCity = codeCity;
		this.codeBussinessHall = codeBussinessHall;
		this.codeID = codeID;
		this.plateNumber = plateNumber;
		this.date = date;
	}

	public String getCodeVehicle() {
		return codeVehicle;
	}

	public void setCodeVehicle(String codeVehicle) {
		this.codeVehicle = codeVehicle;
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

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	

}
