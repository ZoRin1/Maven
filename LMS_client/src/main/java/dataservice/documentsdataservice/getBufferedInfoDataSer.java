package dataservice.documentsdataservice;

import po.documentsPO.DocumentPO;

public interface getBufferedInfoDataSer {
	/**
	 * 系统返回一个完整的PO对象
	 * 用于显示单据的完整信息
	 * @author XiongKaiQi
	 *
	 */
	public DocumentPO getBufferedInfo(String code,String doName);//xiugai
}
