package dataservice.financedataservice;

import java.util.ArrayList;

import po.financePO.*;

public interface GetAccountDataSer {
	
	
	/**
	 * 系统返回一个持久化对象集合（账户）
	 * 用于账户查询
	 * @author YangGuan
	 *
	 */
	public ArrayList<AccountPO> getAccount();
}
