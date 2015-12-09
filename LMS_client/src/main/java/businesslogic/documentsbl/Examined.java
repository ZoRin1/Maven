package businesslogic.documentsbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import presentation.mainui.ipConfig;
import dataservice.documentsdataservice.NotApproved;
import dataservice.documentsdataservice.deleteDataSer;
import dataservice.documentsdataservice.documentsFactory;
import businesslogicservice.documentsblservice.ExaminedBlSer;

public class Examined implements ExaminedBlSer{

	
	private ipConfig ip;
	
	@Override
	public boolean examined(String code, String doName, boolean Examined) {
		// TODO Auto-generated method stub
		boolean a=false;
		ip = new ipConfig();
		try {
			String ipp = ip.getIP();
		documentsFactory documentsFactory=(documentsFactory)Naming.lookup("rmi://"+ipp+"/docFactory");
		if(Examined==true){
			deleteDataSer deleteDataSer=documentsFactory.createDeleteDataSer();
			a=deleteDataSer.delete(code, doName);
		}
		else{
			NotApproved NotApproved=documentsFactory.createNotApproved();
			a=NotApproved.NotApproved(code, doName);
		}
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NotBoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return a;
	}

}
