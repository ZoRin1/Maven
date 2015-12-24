package businesslogicservice.financeblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.financePO.BooksPO;
import vo.financeVO.*;

public interface GetBooksBlSer {
	
	/**
	 * 系统根据输入年份返回该年份的账本
	 * 用于期初建账
	 * @author YangGuan
	 * @throws RemoteException 
	 *
	 */
	public ArrayList<BooksPO> getBooks() throws RemoteException;
}
