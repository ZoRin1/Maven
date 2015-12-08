package businesslogic.documentsbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import po.documentsPO.DocumentPO;
import dataservice.documentsdataservice.GetDocCodeDataSer;
import dataservice.documentsdataservice.addDocummentInfoDataSer;
import dataservice.documentsdataservice.documentsFactory;
import businesslogicservice.documentsblservice.createBlockBlSer;

public class createBlock implements createBlockBlSer{

	@Override
	public boolean createBlock(DocumentPO po) {
		// TODO Auto-generated method stub
		boolean a=true;
		try {
			documentsFactory documentsFactory=(documentsFactory)Naming.lookup("rmi://114.212.42.143:6600/docFactory");
			addDocummentInfoDataSer addDocummentInfoDataSer=documentsFactory.createaddDocummentInfoDataSer();
			a=addDocummentInfoDataSer.addDocumentInfo(po);
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
