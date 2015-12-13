package businesslogicservice.documentsblservice;

import vo.documentsVO.DocumentVO;

public interface createDocumentBlSer {
	/**
	 * 要生成单据时返回一个单据编号
	 * @author XiongKaiQi
	 *
	 */
	public String createDocument(String doName,String account);
}
