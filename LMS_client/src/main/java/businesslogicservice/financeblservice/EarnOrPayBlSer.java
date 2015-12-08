package businesslogicservice.financeblservice;

public interface EarnOrPayBlSer {
	
	/**
	 * 系统根据输入的截止日期计算并返回总收入
	 * @author YangGuan
	 *
	 */
	public  double allEarn(String end);
	
	
	/**
	 * 系统根据输入的截止日期计算并返回总支出
	 * @author YangGuan
	 *
	 */
	public double allPay(String end);
	
}
