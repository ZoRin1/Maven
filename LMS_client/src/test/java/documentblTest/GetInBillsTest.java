package documentblTest;

import java.util.ArrayList;

import po.documentsPO.InBillsPO;
import businesslogic.documentsbl.GetInBills;
import junit.framework.TestCase;

public class GetInBillsTest extends TestCase {
	private GetInBills get;
	
	public void setUp(){
		get=new GetInBills();
	}
	//数据库中存有该时间段该账号的入库单
	public void testGetInBill(){
		ArrayList<InBillsPO> list=get.getInBill("111", "2015-12-7 22:04:00", "2015-12-7 22:04:00");
		InBillsPO po=list.get(0);
		assertEquals("北京", po.getDestination());
	}
	
	public void testGetAllInBills(){
		ArrayList<InBillsPO> list=get.getAllInBills("111", "2015-12-7 22:04:00");
		InBillsPO po=list.get(0);
		assertEquals("北京", po.getDestination());
	}
}
