package po.excelPO;

public class BillsExcelPO extends ExcelPO{
	private String code;
	private String date;
	private String name;
	private double fund;
	public BillsExcelPO(String code, String date, String name, double fund) {
		super();
		this.code = code;
		this.date = date;
		this.name = name;
		this.fund = fund;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFund() {
		return fund;
	}
	public void setFund(double fund) {
		this.fund = fund;
	}
	
	public Object getData(int index){
		switch(index){
		case 0:
			return getCode();
		case 1:
			return getDate();
		case 2:
			return getName();
		case 3:
			return getFund();
		default:
			return null;
		}
	}
	
}
