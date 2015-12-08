package dataservice.storagedataservice;

import java.util.ArrayList;

import po.documentsPO.*;

public interface Check_inventoryDataSer {
	
	
	
	/**
	 * 系统根据输入的开始时间和结束时间返回一个持久化对象合集(入库单)
	 * 已请求库存查询
	 * @author YangGuan
	 *
	 */
	public ArrayList<InBillsPO> getInBill(int start , int end);
	
	
	/**
	 * 系统生成截止点并返回当天该仓库输入的分区的截止点之前的持久化对象集合（入库单）
	 * 已请求库存盘点
	 * @author YangGuan
	 *
	 */
	public ArrayList<InBillsPO> getBill(String division);
	
}
