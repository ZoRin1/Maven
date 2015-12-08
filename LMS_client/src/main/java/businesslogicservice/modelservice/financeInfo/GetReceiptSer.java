package businesslogicservice.modelservice.financeInfo;

import java.util.ArrayList;

import po.documentsPO.ReceiptPO;

public interface GetReceiptSer {
	public ArrayList<ReceiptPO> getReceipts(String selling, String date);
	
	public ArrayList<ReceiptPO> getAllReceipts(String end);
	
	public ArrayList<ReceiptPO> getAllReceipts(String start , String end);
}
