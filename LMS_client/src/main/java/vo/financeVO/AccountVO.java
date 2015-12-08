package vo.financeVO;


/**
 * 用于显示账户名称 和 余额
 * @author YangGuan
 *
 */
public class AccountVO {
	
	private String name; //账号名称
	private double sums; // 金额
	public AccountVO(String name, double sums) {
		super();
		this.name = name;
		this.sums = sums;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSums() {
		return sums;
	}
	public void setSums(double sums) {
		this.sums = sums;
	}
}
