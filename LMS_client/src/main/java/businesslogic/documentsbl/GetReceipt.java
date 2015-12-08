package businesslogic.documentsbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.documentsdataservice.documentsFactory;
import dataservice.documentsdataservice.getCodeDataSer;
import dataservice.documentsdataservice.getDocumentInfoDataSer;
import po.documentsPO.ReceiptPO;
import businesslogicservice.modelservice.financeInfo.GetReceiptSer;

public class GetReceipt implements GetReceiptSer{
	private ArrayList<String> list;
	private ArrayList<ReceiptPO> list1;
	private int size=0;
	private String str;
	@Override
	public ArrayList<ReceiptPO> getReceipts(String selling, String date) {
		// TODO Auto-generated method stub
		list=new ArrayList<>();
		list1=new ArrayList<>();
		ReceiptPO po;
		try {
			documentsFactory documentsFactory=(documentsFactory)Naming.lookup("rmi://127.0.0.1:6600/docFactory");
			getCodeDataSer getCodeDataSer=documentsFactory.createGetCodeDataSer();
			getDocumentInfoDataSer getDocumentInfoDataSer=documentsFactory.createGetDocumentInfoDataSer();
			String startTime=date+" 0:0:0";
			String endTime=date+" 23:59:59";
			list=getCodeDataSer.getReceiptCode(selling, "收款单", startTime, endTime);
			size=list.size();
			for(int i=0;i<size;i++){			
				String string[]=list.get(i).split(",");
				po=(ReceiptPO) getDocumentInfoDataSer.getDocumentInfo(string[0], string[1]);
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

	@Override
	public ArrayList<ReceiptPO> getAllReceipts(String end) {
		list=new ArrayList<>();
		list1=new ArrayList<>();
		ReceiptPO po;
		try {
			documentsFactory documentsFactory=(documentsFactory)Naming.lookup("rmi://127.0.0.1:6600/docFactory");
			getCodeDataSer getCodeDataSer=documentsFactory.createGetCodeDataSer();
			getDocumentInfoDataSer getDocumentInfoDataSer=documentsFactory.createGetDocumentInfoDataSer();
			list=getCodeDataSer.getCode("收款单", null, end);
			size=list.size();
			for(int i=0;i<size;i++){
				String string[]=list.get(i).split(",");
				po=(ReceiptPO) getDocumentInfoDataSer.getDocumentInfo(string[0], string[1]);
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

	@Override
	public ArrayList<ReceiptPO> getAllReceipts(String start, String end) {
		// TODO Auto-generated method stub
		list=new ArrayList<>();
		list1=new ArrayList<>();
		ReceiptPO po;
		try {
			documentsFactory documentsFactory=(documentsFactory)Naming.lookup("rmi://114.212.42.143:6600/docFactory");
			getCodeDataSer getCodeDataSer=documentsFactory.createGetCodeDataSer();
			getDocumentInfoDataSer getDocumentInfoDataSer=documentsFactory.createGetDocumentInfoDataSer();
			list=getCodeDataSer.getCode("收款单", start, end);
			size=list.size();
			for(int i=0;i<size;i++){
				String string[]=list.get(i).split(",");
				po=(ReceiptPO) getDocumentInfoDataSer.getDocumentInfo(string[0], string[1]);
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
