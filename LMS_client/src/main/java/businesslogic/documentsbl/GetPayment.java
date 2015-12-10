package businesslogic.documentsbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.documentsdataservice.documentsFactory;
import dataservice.documentsdataservice.getCodeDataSer;
import dataservice.documentsdataservice.getDocumentInfoDataSer;
import businesslogicservice.modelservice.financeInfo.GetPaymentSer;
import po.documentsPO.PaymentPO;
import presentation.mainui.ipConfig;


public class GetPayment implements GetPaymentSer{
	private ArrayList<String> list;
	private ArrayList<PaymentPO> list1;
	private int size=0;
	private ipConfig ip;
	
	public GetPayment(){
		super();
		ip = new ipConfig();
	}
	public ArrayList<PaymentPO> getAllPay(String end) {
		// TODO Auto-generated method stub
		list=new ArrayList<String>();
		list1=new ArrayList<PaymentPO>();
		PaymentPO po;
		try {
			String ipp = ip.getIP();
			documentsFactory documentsFactory=(documentsFactory)Naming.lookup("rmi://"+ipp+"/docFactory");
			getCodeDataSer getCodeDataSer=documentsFactory.createGetCodeDataSer();
			getDocumentInfoDataSer getDocumentInfoDataSer=documentsFactory.createGetDocumentInfoDataSer();
			list=getCodeDataSer.getCode("付款单", null, end);
			size=list.size();
			for(int i=0;i<size;i++){
				String str[]=list.get(i).split(",");
				
				po=(PaymentPO) getDocumentInfoDataSer.getDocumentInfo(str[0], str[1]);
				list1.add(po);
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
		return list1;
	}

	public ArrayList<PaymentPO> getAllPay(String start, String end) {
		// TODO Auto-generated method stub
		list=new ArrayList<String>();
		list1=new ArrayList<PaymentPO>();
		PaymentPO po;
		try {
			String ipp = ip.getIP();
			documentsFactory documentsFactory=(documentsFactory)Naming.lookup("rmi://"+ipp+"/docFactory");
			getCodeDataSer getCodeDataSer=documentsFactory.createGetCodeDataSer();
			getDocumentInfoDataSer getDocumentInfoDataSer=documentsFactory.createGetDocumentInfoDataSer();
			list=getCodeDataSer.getCode("付款单",start, end);
			size=list.size();
			for(int i=0;i<size;i++){
				String str[]=list.get(i).split(",");
				po=(PaymentPO) getDocumentInfoDataSer.getDocumentInfo(str[0], str[1]);
				list1.add(po);
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
		return list1;
	}

}
