package documentblTest;

import businesslogic.documentsbl.Examined;
import junit.framework.TestCase;

public class ExaminedTest extends TestCase {
	private Examined ex;
	
	public void setUp(){
		ex=new Examined();
	}
	
	public void testExamined1(){
		boolean b=ex.examined("0000000001", "收件单", true);
		assertTrue(b);
	}
	
	public void testExamined2(){
		boolean b=ex.examined("0000000001", "收件单", false);
		assertTrue(b);
	}
}
