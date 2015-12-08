package businesslogicservice.modelservice.financeInfo;

import java.util.ArrayList;

import po.documentsPO.PaymentPO;

public interface GetPaymentSer {
	public ArrayList<PaymentPO> getAllPay(String end);
	
	public ArrayList<PaymentPO> getAllPay(String start, String end);
}
