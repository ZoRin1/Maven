package businesslogicservice.financeblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.financeVO.*;

public interface GetAccountBlSer {
	
	
	/**
	 * 系统返回账户对象集合
	 * 用于账户查询
	 * @author YangGuan
	 * @throws RemoteException 
	 *
	 */
	public ArrayList<AccountVO> getAccount() throws RemoteException;
}
