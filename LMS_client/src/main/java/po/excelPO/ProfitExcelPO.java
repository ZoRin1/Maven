package po.excelPO;

import java.io.Serializable;

public class ProfitExcelPO extends ExcelPO implements Serializable{
	
	private double TotalRevenue; // 总收入
	private double TotalPay;  // 总支出
	private String GenerationDate;  //生成日期
	private double Cost;
	public ProfitExcelPO(double totalRevenue, double totalPay,
			String generationDate) {
		super();
		TotalRevenue = totalRevenue;
		TotalPay = totalPay;
		GenerationDate = generationDate;
	}
	public double getTotalRevenue() {
		return TotalRevenue;
	}
	public void setTotalRevenue(double totalRevenue) {
		TotalRevenue = totalRevenue;
	}
	public double getTotalPay() {
		return TotalPay;
	}
	public void setTotalPay(double totalPay) {
		TotalPay = totalPay;
	}
	public String getGenerationDate() {
		return GenerationDate;
	}
	public void setGenerationDate(String generationDate) {
		GenerationDate = generationDate;
	}
	public double getCost() {
		return TotalRevenue - TotalPay;
	}
	public void setCost(double cost) {
		Cost = cost;
	}
	
	public Object getData(int index){
		switch(index){
		case 0:
			return getTotalRevenue();
		case 1:
			return getTotalPay();
		case 2:
			return getGenerationDate();
		case 3:
			return getCost();
		default:
			return null;
		}
	}
}
