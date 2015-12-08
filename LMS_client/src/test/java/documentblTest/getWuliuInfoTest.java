package documentblTest;

import java.util.ArrayList;

import businesslogic.documentsbl.getWuliuInfo;
import junit.framework.TestCase;

public class getWuliuInfoTest extends TestCase {
	private getWuliuInfo get;
	
	public void setUp(){
		get=new getWuliuInfo();
	}
	//数据库中已存在这样一条物流信息
	public void testGetWuliuInfo(){
		ArrayList<String> list=get.getWuliuInfo("0000000002");
		String str=list.get(0);
		assertEquals("您的订单已经离开仙林营业厅", str);
	}
}
