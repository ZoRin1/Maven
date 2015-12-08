package documentblTest;

import po.documentsPO.GetOrderPO;
import businesslogic.documentsbl.getBufferedInfo;
import junit.framework.TestCase;

public class getBufferedInfoTest extends TestCase {
	private getBufferedInfo get;
	
	public void setup(){
		get = new getBufferedInfo();
	}
	//现在缓冲区中存入单据编号为0000000001的收件单,将其收件人姓名设为叶良辰
	public void testGetBufferedInfo(){
		GetOrderPO po=(GetOrderPO)get.getBufferedInfo("0000000001", "收件单");
		assertEquals("叶良辰", po.getReceiverName());
	}
}
