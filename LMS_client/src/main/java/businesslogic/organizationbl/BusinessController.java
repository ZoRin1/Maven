package businesslogic.organizationbl;

import java.rmi.RemoteException;

import businesslogicservice.storageblservice.usedSpaceBlSer;
import vo.orgVO.BussinessOrgVO;

public class BusinessController {
	BusinessBL bBL;
	public  BusinessController() throws RemoteException {
		bBL = new BusinessBL();
	}
	
	
	public String[] getBussinessmanList(String ID) {
		// TODO 自动生成的方法存根
		return bBL.getBussinessmanList(ID);
	}


	public boolean addBussinessman(String ID, long bID) {
		// TODO 自动生成的方法存根
		return bBL.addBussinessman(ID, bID);
	}


	public boolean removeBussinessman(String ID, long bID) {
		// TODO 自动生成的方法存根
		return bBL.removeBussinessman(ID, bID);
	}


	public String[] getCourierList(String ID) {
		// TODO 自动生成的方法存根
		return bBL.getCourierList(ID);
	}


	public boolean addCourier(String ID, long bID) {
		// TODO 自动生成的方法存根
		return bBL.addCourier(ID, bID);
	}


	public boolean removeCourier(String ID, long bID) {
		// TODO 自动生成的方法存根
		return bBL.removeCourier(ID, bID);
	}
	
	public boolean addBussinessHall(String ID, BussinessOrgVO vo) {
		// TODO 自动生成的方法存根
		return bBL.addBussinessHall(ID, vo);
	}


	public boolean removeBussinessHall(String ID, String codeNumber) {
		// TODO 自动生成的方法存根
		return bBL.removeBussinessHall(ID, codeNumber);
	}


	public String getCodeNumber() {
		// TODO 自动生成的方法存根
		return bBL.getCodeNumber();
	}


	public boolean changeCodeNumberOfMiddle(String ID, String codeNumberOfMiddle) {
		// TODO 自动生成的方法存根
		return bBL.changeCodeNumberOfMiddle(ID, codeNumberOfMiddle);
	}


	public String getInfo(String ID) {
		// TODO 自动生成的方法存根
		return bBL.getInfo(ID);
	}


	public boolean changeCity(String ID, String city) {
		// TODO 自动生成的方法存根
		return bBL.changeCity(ID, city);
	}


	public boolean changeCodeNumber(String ID, String codeNumber) {
		// TODO 自动生成的方法存根
		return bBL.changeCodeNumber(ID, codeNumber);
	}


}
