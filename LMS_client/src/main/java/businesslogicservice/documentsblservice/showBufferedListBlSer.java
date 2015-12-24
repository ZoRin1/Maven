package businesslogicservice.documentsblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface showBufferedListBlSer {
	/**
	 * 系统返回由单据编号和名称组成的数组
	 * 用于生成单据列表
	 * @author XiongKaiQi
	 * @throws RemoteException 
	 *
	 */
	public ArrayList<String> showList() throws RemoteException;
	/**
	 * 系统返回由单据编号和名称组成的数组
	 * 用于生成单据反馈列表
	 * @author XiongKaiQi
	 * @throws RemoteException 
	 *
	 */
	public ArrayList<String> showOwnList(String account) throws RemoteException;
}
