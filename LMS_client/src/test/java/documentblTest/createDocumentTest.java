package documentblTest;

import businesslogic.documentsbl.createDocument;
import junit.framework.TestCase;

public class createDocumentTest extends TestCase {
	private createDocument cr;
	
	public void setUp(){
		cr=new createDocument();
	}
	
	public void testCreateDocument(){
		String str=cr.createDocument("收件单");
		int length=str.length();
		assertEquals(10, length);
	}
}
