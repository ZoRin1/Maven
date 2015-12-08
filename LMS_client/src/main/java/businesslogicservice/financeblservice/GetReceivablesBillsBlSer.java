package businesslogicservice.financeblservice;

import java.util.ArrayList;

import vo.documentsVO.ReceiptVO;

public interface GetReceivablesBillsBlSer {
	
	
	/**
	 * 系统根据输入的营业厅编号和日期返回该日期该营业厅的收款单集合
	 * @author YangGuan
	 *
	 */
	public ArrayList<ReceiptVO> getReceivables(String selling, String date);
	
	
	
	
	/**
	 * 系统生成当前日期的截止点并根据输入的营业厅编号
	 * 返回该营业厅截止日期前的所有收款单集合
	 * @author YangGuan
	 *
	 */
	public ArrayList<ReceiptVO> getAllReceivables(String end);
	
	
	/**
	 *系统根据输入的日期段和营业厅返回相应的收款单集合
	 *用于经营情况表
	 * @author YangGuan
	 *
	 */
	public ArrayList<ReceiptVO> getSomeReceivables(String start,String end);
}
