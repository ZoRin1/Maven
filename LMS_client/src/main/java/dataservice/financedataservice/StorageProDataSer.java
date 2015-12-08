package dataservice.financedataservice;

import po.financePO.*;

public interface StorageProDataSer {
	
	/**
	 * 系统持久化存入成本收益记录
	 * @author YangGuan
	 *
	 */
	public void setCostRecords(ProfitPO po);
}
