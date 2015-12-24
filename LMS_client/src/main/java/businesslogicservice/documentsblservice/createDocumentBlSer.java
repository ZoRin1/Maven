package businesslogicservice.documentsblservice;

import java.rmi.RemoteException;

import vo.documentsVO.DocumentVO;

public interface createDocumentBlSer {
	/**
	 * 要生成单据时返回一个单据编号
	 * @author XiongKaiQi
	 * @throws RemoteException 
	 *
	 */
	public String createDocument(String doName,String account) throws RemoteException;
}
