package businesslogicservice.modelservice.financeInfo;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.documentsPO.PaymentPO;

public interface GetPaymentSer {
	public ArrayList<PaymentPO> getAllPay(String end) throws RemoteException;
	
	public ArrayList<PaymentPO> getAllPay(String start, String end) throws RemoteException;
}
