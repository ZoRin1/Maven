package dataservice.financedataservice;

import java.util.ArrayList;

import po.documentsPO.ReceiptPO;

public interface GetReceivablesBillsDataSer {
	
	
	
	/**
	 * 系统根据输入的营业厅编号和日期返回
	 * 该日期一个持久化对象集合（该营业厅的收款单集合）
	 * 用于结算管理
	 * @author YangGuan
	 *
	 */
	public ArrayList<ReceiptPO> Receivables(String selling, String date);
	
	
	/**
	 * 系统生成当前日期的截止点并根据输入的营业厅编号返回
	 * 该营业厅截止日期前持久化对象集合（所有收款单集合）
	 * 用于成本收益表
	 * @author YangGuan
	 *
	 */
	public ArrayList<ReceiptPO> getReceivables(String selling,String date);
	
	/**
	 *系统根据输入的营业厅编号和日期段返回一个持久化对象集合（收款单）
	 * 用于经营情况表
	 * @author YangGuan
	 *
	 */
	public ArrayList<ReceiptPO> getAllReceivables(String selling,String start , String end);
}

