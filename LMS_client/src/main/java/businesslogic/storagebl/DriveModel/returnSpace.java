package businesslogic.storagebl.DriveModel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import presentation.mainui.ipConfig;
import dataservice.storagedataservice.ReturnSpaceDataSer;
import dataservice.storagedataservice.storageFactory;
import businesslogic.state.ResultMessage;
import businesslogicservice.storageblservice.RetuenSpaceBlSer;

public class returnSpace implements RetuenSpaceBlSer{
	
	private ipConfig ip;
	
	public returnSpace(){
		super();
		ip = new ipConfig();
	}

	@Override
	public void returnSpace(String city) {
		// TODO 自动生成的方法存根
		try {
			String ipp = ip.getIP();
			storageFactory stoFactory = (storageFactory)Naming.lookup("rmi://"+ipp+"/stoFactory");
			ReturnSpaceDataSer returnSpace = stoFactory.createReturnSpaceDataSer();
			returnSpace.reSpace(city);
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

}
