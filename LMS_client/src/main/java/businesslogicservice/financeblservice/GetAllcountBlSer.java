package businesslogicservice.financeblservice;

import java.util.ArrayList;

import vo.documentsVO.ReceiptVO;

public interface GetAllcountBlSer {
	
	/**
	 * 系统根据输入计算并返回合计金额
	 * @author YangGuan
	 *
	 */
	public double getAllciunt(ArrayList<ReceiptVO> vo);
}
