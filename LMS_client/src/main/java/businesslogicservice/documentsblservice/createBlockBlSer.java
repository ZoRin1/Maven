package businesslogicservice.documentsblservice;

import java.rmi.RemoteException;

import po.documentsPO.DocumentPO;


public interface createBlockBlSer {
	/**
	 * 展示层传入单据信息
	 * 系统返回一boolean
	 * 显示是否保存成功
	 * @author XiongKaiQi
	 * @throws RemoteException 
	 *
	 */
	public boolean createBlock(DocumentPO po) throws RemoteException;
}
