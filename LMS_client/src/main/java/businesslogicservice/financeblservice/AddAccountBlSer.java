package businesslogicservice.financeblservice;

import vo.financeVO.*;

public interface AddAccountBlSer {
	
	
	/**
	 * 系统返回一个初始化好的VO对象
	 * 用于添加一个账户对象
	 * @author YangGuan
	 *
	 */
	public AccountVO addAccount(String name, double money);
}
