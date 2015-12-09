package businesslogic.organizationbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import presentation.mainui.ipConfig;
import businesslogicservice.organizationblservice.FinanceOrgBLSer;
import dataservice.organizationdataservice.FinanceOrgDataSer;
import dataservice.organizationdataservice.organizationFactory;

public class FinanceBL implements FinanceOrgBLSer {
	
	private FinanceOrgDataSer financeOrgDataSer;
	private ipConfig ip;
	
	public FinanceBL() {
		// TODO Auto-generated constructor stub
		ip = new ipConfig();
		try {
			String ipp = ip.getIP();
			organizationFactory organizationFactory = (organizationFactory)Naming.lookup("rmi://"+ipp+"/orgFactory");
			this.financeOrgDataSer = organizationFactory.createFinanceOrgDataSer();
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
	public String[] getFinancersList() {
//		String[] result = {"1000001-张飞","1000002-李四","1000003-王伟"};
//		// TODO 自动生成的方法存根
		return this.financeOrgDataSer.find();
	}

	@Override
	public boolean addFinancer(long ID) {
		// TODO 自动生成的方法存根
		return this.financeOrgDataSer.insert(ID);
	}

	@Override
	public boolean removeFinancer(long ID) {
		// TODO 自动生成的方法存根
		return this.financeOrgDataSer.delete(ID);
	}

}
