package vo.financeVO;


/**
 * 用于显示成本收益记录(总收入、总支出、生成日期)
 * @author YangGuan
 *
 */
public class ProfitVO {
	
	private double TotalRevenue; // 总收入
	private double TotalPay;  // 总支出
	private String GenerationDate;  //生成日期
	
	
	public ProfitVO(double totalRevenue, double totalPay, String generationDate) {
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
	
	
	
}
