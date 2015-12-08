package dataservice.financedataservice;

import po.financePO.BooksPO;

public interface StorageBooksDataSer {
	
	
	/**
	 * 系统存储一个持久化对象（账本）
	 * @author YangGuan
	 *
	 */
	public void stoBooks(BooksPO book);
}