package businesslogic.organizationbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogicservice.organizationblservice.MiddleOrgBLSer;
import dataservice.organizationdataservice.MiddleOrgDataSer;
import dataservice.organizationdataservice.organizationFactory;
import po.orgPO.MiddleOrgPO;
import presentation.mainui.ipConfig;
import vo.orgVO.MiddleOrgVO;

public class MiddleBL implements MiddleOrgBLSer {
	
	private MiddleOrgDataSer middleOrgDataSer;
	private ipConfig ip;
	
	public MiddleBL() {
		// TODO Auto-generated constructor stub
		try {
			String ipp = ip.getIP();
			organizationFactory organizationFactory = (organizationFactory)Naming.lookup("rmi://"+ipp+"/orgFactory");
			this.middleOrgDataSer = organizationFactory.createMiddleOrgDataSer();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public String[] getBussinessmanList(String ID) {
		String[] result = {"1000001-张飞","1000002-李四","1000003-王伟"};
		// TODO 自动生成的方法存根
		return this.middleOrgDataSer.getBussinessmanList(ID);
	}

	@Override
	public boolean addBussinessman(String ID, long bID) {
		// TODO 自动生成的方法存根
		return this.middleOrgDataSer.addBussinessman(ID, bID);
	}

	@Override
	public boolean removeBussinessman(String ID, long bID) {
		// TODO 自动生成的方法存根
		return this.middleOrgDataSer.removeBussinessman(ID, bID);
	}

	@Override
	public String[] getStorgerList(String ID) {
//		String[] result = {"1000001-张飞","1000002-李四","1000003-王伟"};
		// TODO 自动生成的方法存根
		return this.middleOrgDataSer.getStorgerList(ID);
	}

	@Override
	public boolean addStorger(String ID, long bID) {
		// TODO 自动生成的方法存根
		return this.middleOrgDataSer.addStorger(ID, bID);
	}

	@Override
	public boolean removeStorger(String ID, long bID) {
		// TODO 自动生成的方法存根
		return this.middleOrgDataSer.removeStorger(ID, bID);
	}

	@Override
	public String[] getBussinessHallList(String ID) {
//		String[] result = {"100-001-鼓楼营业厅","100-002-仙林营业厅"};
		// TODO 自动生成的方法存根
		return this.middleOrgDataSer.getBussinessHallList(ID);
	}

	@Override
	public String GetInfo(String ID) {
		// TODO 自动生成的方法存根
//		String result = "南京";
		return this.middleOrgDataSer.GetInfo(ID);
	}

	@Override
	public boolean changeCity(String ID, String city) {
		// TODO 自动生成的方法存根
		return this.middleOrgDataSer.changeCity(ID, city);
	}

	@Override
	public boolean addMiddleOrg(String ID, MiddleOrgVO vo) {
		// TODO 自动生成的方法存根
		return this.middleOrgDataSer.addMiddleOrg(ID, new MiddleOrgPO(vo.getCity(), vo.getCodeNumber(), null, null, null));
	}

	@Override
	public boolean removeMiddleOrg(String ID) {
		// TODO 自动生成的方法存根
		return this.middleOrgDataSer.removeMiddleOrg(ID);
	}

}
