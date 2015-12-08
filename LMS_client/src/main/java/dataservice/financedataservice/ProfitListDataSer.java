package dataservice.financedataservice;

import java.util.ArrayList;

import po.financePO.*;

public interface ProfitListDataSer {
	
	/**
	 *系统根据输入的时间返回一个持久化对象集合（成本收益记录)
	 *用于成本收益表
	 * @author YangGuan
	 *
	 */
	public ArrayList<ProfitPO> ProList(String date);
}
