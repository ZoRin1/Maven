package dataservice.financedataservice;

import java.util.ArrayList;

import po.financePO.*;

public interface CoverDataSer {
	
	
	/**
	 * 系统覆盖整个持久化对象集合
	 * 对账户进行删、改、初始化操作完成后
	 * @author YangGuan
	 *
	 */
	public void coverAccount(ArrayList<AccountPO> po);
}
