package businesslogic.storagebl.CheckModel;

import java.rmi.RemoteException;
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


	public ArrayList<SimpleInDepotInfVO>conCheck(String account,String start, String end) throws RemoteException {		
		return check.check(account, start, end);
	}
	

	public ArrayList<InDepotInfVO> conInventory(String account,String start, String end) throws RemoteException {
		return check.inventory(account, start, end);
	}
	
} 
