package documentblTest;

import java.util.ArrayList;

import po.documentsPO.PaymentPO;
import businesslogic.documentsbl.GetPayment;
import junit.framework.TestCase;

public class GetPaymentTest extends TestCase {
	private GetPayment get;
	
	public void setUp(){
		get=new GetPayment();
	}
	
	public void testGetAllPay(){
		ArrayList<PaymentPO> list=get.getAllPay("2015-12-7 22:04:00");
		PaymentPO po=list.get(0);
		assertEquals(99.99,po.getFund());
	}
}
