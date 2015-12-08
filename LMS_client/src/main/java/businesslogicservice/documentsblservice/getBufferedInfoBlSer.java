package businesslogicservice.documentsblservice;

import po.documentsPO.DocumentPO;


public interface getBufferedInfoBlSer {
	/**vo神马的都棍吧
	 * 系统返回一个完整的PO对象
	 * 用于显示单据的完整信息
	 * @author XiongKaiQi
	 *
	 */

	public DocumentPO getBufferedInfo(String code, String doName);
}
