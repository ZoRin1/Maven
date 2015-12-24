package businesslogic.documentsbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import presentation.mainui.ipConfig;
import dataservice.documentsdataservice.documentsFactory;
import dataservice.documentsdataservice.getBufferedCodeDataSer;
import dataservice.documentsdataservice.getNotPassDocCode;
import businesslogicservice.documentsblservice.showBufferedListBlSer;

public class showBufferedList implements showBufferedListBlSer{
	//总经理的审批单据里显示所有单据使用
	
	private ipConfig ip;
	
	public showBufferedList(){
		ip = new ipConfig();
	}
	
	@Override
	public ArrayList<String> showList() throws RemoteException{
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<>();
		try {
			String ipp = ip.getIP();
		documentsFactory documentsFactory=(documentsFactory)Naming.lookup("rmi://"+ipp+"/docFactory");
		getBufferedCodeDataSer getBufferedCodeDataSer=documentsFactory.createGetBudderedCodeDataSer();
		list=getBufferedCodeDataSer.getCode();
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  catch (NotBoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	}
	//单据反馈中使用
	@Override
	public ArrayList<String> showOwnList(String account) throws RemoteException{
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<>();
		try {
			String ipp = ip.getIP();
		documentsFactory documentsFactory=(documentsFactory)Naming.lookup("rmi://"+ipp+"/docFactory");
		getNotPassDocCode getNotPassDocCode=documentsFactory.createGetNotPassDocCode();
		list=getNotPassDocCode.getNotPassDocCode(account);
		return list;
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  catch (NotBoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	}
	
}
