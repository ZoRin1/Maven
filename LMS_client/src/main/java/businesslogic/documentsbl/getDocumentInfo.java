package businesslogic.documentsbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.documentsdataservice.documentsFactory;
import dataservice.documentsdataservice.getBufferedInfoDataSer;
import dataservice.documentsdataservice.getDocumentInfoDataSer;
import po.documentsPO.DocumentPO;
import vo.documentsVO.DocumentVO;
import vo.documentsVO.GetOrderVO;
import businesslogicservice.documentsblservice.getDocumentInfoBlSer;

public class getDocumentInfo implements getDocumentInfoBlSer{

	@Override
	public DocumentPO getDocumentInfo(String code, String doName) {
		// TODO Auto-generated method stub
		DocumentPO po=new DocumentPO();
		try {
		documentsFactory documentsFactory=(documentsFactory)Naming.lookup("rmi://127.0.0.1:6600/docFactory");
		getDocumentInfoDataSer getDocumentInfoDataSer =documentsFactory.createGetDocumentInfoDataSer();
		po=getDocumentInfoDataSer.getDocumentInfo(code, doName);
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
		return po;
	}

}
