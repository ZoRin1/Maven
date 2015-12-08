package documentblTest;

import java.util.ArrayList;

import po.documentsPO.ReceiptPO;
import businesslogic.documentsbl.GetReceipt;
import junit.framework.TestCase;

public class GetReceiptTest extends TestCase {
	private GetReceipt get;
	
	public void setUp(){
		get=new GetReceipt();
	}
	
	public void testGetReceipts(){
		ArrayList<ReceiptPO> list=get.getReceipts("000-000", "2015-12-8");
		ReceiptPO po=list.get(0);
		assertEquals(99.99,po.getFund());
	}
	
	public void testGetAllReceipts(){
		ArrayList<ReceiptPO> list=get.getAllReceipts("2015-12-7 22:04:00", "2015-12-7 22:04:00");
		ReceiptPO po=list.get(0);
		assertEquals(99.99,po.getFund());
	}
}
