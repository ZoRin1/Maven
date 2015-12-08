package businesslogicservice.documentsblservice;

import po.documentsPO.DocumentPO;

public interface getDocumentInfoBlSer {
	/**
	 * 系统返回一个完整的VO对象
	 * 用于显示单据的完整信息
	 * @author XiongKaiQi
	 *
	 */
	public DocumentPO getDocumentInfo(String code,String doName);
}
