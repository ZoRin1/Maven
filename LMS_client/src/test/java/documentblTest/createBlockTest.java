package documentblTest;

import po.documentsPO.GetOrderPO;
import businesslogic.documentsbl.createBlock;
import junit.framework.TestCase;

public class createBlockTest extends TestCase {
	private createBlock cr;
	
	public void setUp(){
		cr=new createBlock();
	}
	
	public void testCreateBlock(){
		GetOrderPO po=new GetOrderPO("0000000001", "收件单", "0000000001", "3219432", "叶良辰", "2015-12-8 20:20:20");
		boolean b=cr.createBlock(po);
		assertTrue(b);
	}
}
