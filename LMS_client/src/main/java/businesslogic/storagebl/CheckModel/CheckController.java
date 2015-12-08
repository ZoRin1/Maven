package businesslogic.storagebl.CheckModel;

import java.util.ArrayList;

import po.documentsPO.OutbillsPO;
import vo.storageVO.InDepotInfVO;
import vo.storageVO.SimpleInDepotInfVO;

public class CheckController {
	
	private CheckBL check;
	
	
	
	public CheckController() {
		super();
		check = new CheckBL();
	}


	public ArrayList<SimpleInDepotInfVO>conCheck(String account,String start, String end) {		
		return check.check(account, start, end);
	}
	

	public ArrayList<InDepotInfVO> conInventory(String account,String start, String end) {
		return check.inventory(account, start, end);
	}
	
} 
