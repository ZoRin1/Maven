package businesslogicservice.financeblservice;

import java.util.ArrayList;

import vo.documentsVO.PaymentVO;

public interface GetAllPayBlSer {
	
	
	/**
	 * 系统生成当前日期的截止点并根据输入的营业厅编号
	 * 返回该营业厅截止日期前的所有付款单集合
	 * @author YangGuan
	 *
	 */
	public ArrayList<PaymentVO> getAllPay(String selling);
	
	/**
	 *系统根据输入的日期段和营业厅返回相应的付款单集合
	 * @author YangGuan
	 *
	 */
	public ArrayList<PaymentVO> getAllPay(String selling,String start, String end);
	
}
