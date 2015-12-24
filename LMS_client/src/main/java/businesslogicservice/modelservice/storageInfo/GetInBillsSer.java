package businesslogicservice.modelservice.storageInfo;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.documentsPO.InBillsPO;

public interface GetInBillsSer {
	//startTime可以为null，time格式为年-月-日 时:分:秒
	public ArrayList<InBillsPO> getInBill(String account,String start ,String end) throws RemoteException;
	//只有截止日期
	public ArrayList<InBillsPO> getAllInBills(String account,String end) throws RemoteException;
}
