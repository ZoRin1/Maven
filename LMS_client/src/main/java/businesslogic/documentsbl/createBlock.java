package businesslogic.documentsbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import po.documentsPO.DocumentPO;
import presentation.mainui.ipConfig;
import dataservice.documentsdataservice.GetDocCodeDataSer;
import dataservice.documentsdataservice.addDocummentInfoDataSer;
import dataservice.documentsdataservice.documentsFactory;
import businesslogicservice.documentsblservice.createBlockBlSer;

public class createBlock implements createBlockBlSer{
	
	private ipConfig ip;

	@Override
	public boolean createBlock(DocumentPO po) throws RemoteException {
		// TODO Auto-generated method stub
		boolean a=true;
		ip = new ipConfig();
		try {
			String ipp = ip.getIP();
			documentsFactory documentsFactory=(documentsFactory)Naming.lookup("rmi://"+ipp+"/docFactory");
			addDocummentInfoDataSer addDocummentInfoDataSer=documentsFactory.createaddDocummentInfoDataSer();
			a=addDocummentInfoDataSer.addDocumentInfo(po);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	

}
