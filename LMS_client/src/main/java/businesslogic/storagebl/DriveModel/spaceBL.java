package businesslogic.storagebl.DriveModel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import presentation.mainui.ipConfig;
import dataservice.storagedataservice.UsedSpaceDataSer;
import dataservice.storagedataservice.storageFactory;
import businesslogicservice.storageblservice.usedSpaceBlSer;

public class spaceBL implements usedSpaceBlSer{

	private storageFactory stoFactory;
	private UsedSpaceDataSer used;
	private ipConfig ip;
	
	public spaceBL(){
		ip = new ipConfig();
		try {
			String ipp = ip.getIP();
			stoFactory = (storageFactory)Naming.lookup("rmi://"+ipp+"/stoFactory");
			used = stoFactory.createUsedSpaceDataSer();
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
	public int[] usedSpaceInf(String city) {
		// TODO Auto-generated method stub
		int[] usedSpace = used.getUsedSpace(city);
		return usedSpace;
	}

	@Override
	public int[] allSpaceInf(String city) {
		// TODO Auto-generated method stub
		int[] allSpace = used.getAllSpace(city);
		return allSpace;
	}

	@Override
	public int getJiDongSpace(String city) {
		// TODO 自动生成的方法存根
		int JiDongSpace = used.getJiDongSpace(city);
		return JiDongSpace;
	}
	
	

}