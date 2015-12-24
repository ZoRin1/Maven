package businesslogic.organizationbl;

import java.rmi.RemoteException;

import vo.orgVO.MiddleOrgVO;

public class MiddleController {
	MiddleBL mBL;
	public MiddleController() throws RemoteException{
		 mBL= new MiddleBL();
	}
	
	
	

	public String[] getBussinessmanList(String ID) {
		// TODO 自动生成的方法存根
		return mBL.getBussinessmanList(ID);
	}


	public boolean addBussinessman(String ID, long bID) {
		// TODO 自动生成的方法存根
		return mBL.addBussinessman(ID, bID);
	}

	
	public boolean removeBussinessman(String ID, long bID) {
		// TODO 自动生成的方法存根
		return mBL.removeBussinessman(ID, bID);
	}

	
	public String[] getStorgerList(String ID) {
		// TODO 自动生成的方法存根
		return mBL.getStorgerList(ID);
	}

	
	public boolean addStorger(String ID, long bID) {
		// TODO 自动生成的方法存根
		return mBL.addStorger(ID, bID);
	}


	public boolean removeStorger(String ID, long bID) {
		// TODO 自动生成的方法存根
		return mBL.removeStorger(ID, bID);
	}

	
	public String[] getBussinessHallList(String ID) {
		// TODO 自动生成的方法存根
		return mBL.getBussinessHallList(ID);
	}


	public String GetInfo(String ID) {
		// TODO 自动生成的方法存根
		return mBL.GetInfo(ID);
	}


	public boolean changeCity(String ID, String city) {
		// TODO 自动生成的方法存根
		return mBL.changeCity(ID, city);
	}


	public boolean addMiddleOrg(String ID, MiddleOrgVO vo) {
		// TODO 自动生成的方法存根
		return mBL.addMiddleOrg(ID, vo);
	}


	public boolean removeMiddleOrg(String codeNumber) {
		// TODO 自动生成的方法存根
		return mBL.removeMiddleOrg(codeNumber);
	}


}
