package businesslogic.documentsbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.documentsdataservice.documentsFactory;
import dataservice.documentsdataservice.getBufferedInfoDataSer;
import dataservice.documentsdataservice.getDocumentInfoDataSer;
import po.documentsPO.DocumentPO;
import presentation.mainui.ipConfig;
import vo.documentsVO.DocumentVO;
import vo.documentsVO.GetOrderVO;
import businesslogicservice.documentsblservice.getDocumentInfoBlSer;

public class getDocumentInfo implements getDocumentInfoBlSer{

	private ipConfig ip;
	
	@Override
	public DocumentPO getDocumentInfo(String code, String doName) throws RemoteException{
		// TODO Auto-generated method stub
		DocumentPO po=new DocumentPO();
		ip = new ipConfig();
		try {
			String ipp = ip.getIP();
		documentsFactory documentsFactory=(documentsFactory)Naming.lookup("rmi://"+ipp+"/docFactory");
		getDocumentInfoDataSer getDocumentInfoDataSer =documentsFactory.createGetDocumentInfoDataSer();
		po=getDocumentInfoDataSer.getDocumentInfo(code, doName);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NotBoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return po;
	}

}
