package po.financePO;

import java.io.Serializable;



/**
 * 用于存储或返回账户名称 和 余额
 * @author YangGuan
 *
 */
public class AccountPO  implements Serializable {
	
	
	private String name; //账户名称
	private double sums; // 金额
	
	
	public AccountPO(String name, double sums) {
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

