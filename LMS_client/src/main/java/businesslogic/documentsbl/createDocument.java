package businesslogic.documentsbl;

//import mockObject.MockGetPosition;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.documentsdataservice.GetDocCodeDataSer;
import dataservice.documentsdataservice.documentsFactory;
import businesslogicservice.documentsblservice.createDocumentBlSer;

public class createDocument implements createDocumentBlSer{

	@Override
	public String createDocument(String doName) {
		// TODO Auto-generated method stub
		String code=null;
		try {
			documentsFactory documentsFactory=(documentsFactory)Naming.lookup("rmi://114.212.42.143:6600/docFactory");
			GetDocCodeDataSer getDocCodeDataSer=documentsFactory.createGetDocCodeDataSer();
			code=getDocCodeDataSer.getDocCode(doName);
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
		return code; 
	}
}