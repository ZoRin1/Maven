package documentblTest;

import po.documentsPO.GetOrderPO;
import businesslogic.documentsbl.getDocumentInfo;
import junit.framework.TestCase;

public class getDocumentInfoTest extends TestCase {
	private getDocumentInfo get;
	
	public void setUp(){
		get=new getDocumentInfo();
	}
	//现在数据库中存入单据编号为0000000001的收件单,将其收件人姓名设为叶良辰
	public void testGetDocumentInfo(){
		GetOrderPO po=(GetOrderPO)get.getDocumentInfo("0000000001", "收件单");
		assertEquals("叶良辰", po.getReceiverName());
	}
}
