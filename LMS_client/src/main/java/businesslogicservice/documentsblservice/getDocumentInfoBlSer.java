package businesslogicservice.documentsblservice;

import java.rmi.RemoteException;

import po.documentsPO.DocumentPO;

public interface getDocumentInfoBlSer {
	/**
	 * 系统返回一个完整的VO对象
	 * 用于显示单据的完整信息
	 * @author XiongKaiQi
	 * @throws RemoteException 
	 *
	 */
	public DocumentPO getDocumentInfo(String code,String doName) throws RemoteException;
}
