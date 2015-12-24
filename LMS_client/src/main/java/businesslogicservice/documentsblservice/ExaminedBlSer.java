package businesslogicservice.documentsblservice;

import java.rmi.RemoteException;

public interface ExaminedBlSer {
	/**
	 * 展示层传入系统审批状况
	 * 系统返回审批状况是否保存
	 * @author XiongKaiQi
	 * @throws RemoteException 
	 *
	 */

	public boolean examined(String code,String doName,boolean examined) throws RemoteException;
}
