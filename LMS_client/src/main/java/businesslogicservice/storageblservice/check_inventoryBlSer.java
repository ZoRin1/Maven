package businesslogicservice.storageblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.documentsPO.OutbillsPO;
import vo.storageVO.*;

public interface check_inventoryBlSer {
	
	/**
	 * 系统根据输入的开始时间和结束时间返回该时间段简化入库单的数组
	 * @author YangGuan
	 * @param account TODO
	 * @throws RemoteException 
	 *
	 */
	public ArrayList<SimpleInDepotInfVO>  check(String account,String start, String end) throws RemoteException;
	
	
	
	/**
	 *系统根据生成的截止点返回包含各区入库单的集合
	 * @author YangGuan
	 * @param account TODO
	 * @param start TODO
	 * @param end TODO
	 * @throws RemoteException 
	 *
	 */
	public ArrayList<InDepotInfVO> inventory(String account, String start, String end) throws RemoteException;

}
