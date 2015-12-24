package businesslogic.storagebl.DriveModel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import presentation.mainui.ipConfig;
import dataservice.storagedataservice.UpdateSpaceDataSer;
import dataservice.storagedataservice.storageFactory;
import businesslogic.state.ResultMessage;
import businesslogicservice.storageblservice.DriveBlSer;

public class DriverBL implements DriveBlSer{
	
	private ipConfig ip;
	
	public DriverBL(){
		super();
		ip = new ipConfig();
	}
	
	@Override
	public ResultMessage drive(int shipping, int trains, int motor, String city) throws RemoteException{
		// TODO 自动生成的方法存根
		try {
			String ipp = ip.getIP();
			storageFactory stoFactory = (storageFactory)Naming.lookup("rmi://"+ipp+"/stoFactory");
			UpdateSpaceDataSer update = stoFactory.createUpdateSpaceDataSer();
			update.updateDrive(shipping, trains, motor, city);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}  catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
}
