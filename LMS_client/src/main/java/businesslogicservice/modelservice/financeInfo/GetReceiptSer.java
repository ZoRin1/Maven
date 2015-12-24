package businesslogicservice.modelservice.financeInfo;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.documentsPO.ReceiptPO;

public interface GetReceiptSer {
	public ArrayList<ReceiptPO> getReceipts(String selling, String date) throws RemoteException;
	
	public ArrayList<ReceiptPO> getAllReceipts(String end) throws RemoteException;
	
	public ArrayList<ReceiptPO> getAllReceipts(String start , String end) throws RemoteException;
}
