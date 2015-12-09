package businesslogic.storagebl.CheckModel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.documentsPO.InBillsPO;
import po.documentsPO.OutbillsPO;
import presentation.mainui.ipConfig;
import dataservice.documentsdataservice.documentsFactory;
import dataservice.documentsdataservice.getCodeDataSer;
import dataservice.documentsdataservice.getDocumentInfoDataSer;
import vo.documentsVO.InBillsVO;
import vo.storageVO.InDepotInfVO;
import vo.storageVO.SimpleInDepotInfVO;
import businesslogicservice.storageblservice.check_inventoryBlSer;

public class CheckBL implements check_inventoryBlSer{
	
	private ipConfig ip;
	
	public CheckBL(){
		super();
		ip = new ipConfig();
	}
	
	@Override
	public ArrayList<SimpleInDepotInfVO> check(String account, String start, String end) {
		// TODO 自动生成的方法存根
		try {
			String ipp = ip.getIP();
			documentsFactory documentsFactory=(documentsFactory)Naming.lookup("rmi://"+ipp+"/docFactory");
			getCodeDataSer getCodeDataSer=documentsFactory.createGetCodeDataSer();
			ArrayList<String>Sto= getCodeDataSer.getStoCode(account,"入库单", start, end);
			getDocumentInfoDataSer getDocumentInfoDataSer=documentsFactory.createGetDocumentInfoDataSer();
			ArrayList<SimpleInDepotInfVO> stoList=new ArrayList<>();
			for (int i = 0; i < Sto.size(); i++) {
				String [] string=Sto.get(i).split(",");
				InBillsPO inBillsPO=(InBillsPO)getDocumentInfoDataSer.getDocumentInfo(string[0], string[1]);
				stoList.add(new SimpleInDepotInfVO(inBillsPO.getInDepotNum(), inBillsPO.getAreaNum(), inBillsPO.getRowNum(), inBillsPO.getShelvesNum(), inBillsPO.getSositionNum()));
			}
			return stoList;
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
		return null;
	}

	@Override
	public ArrayList<InDepotInfVO> inventory(String account, String start, String end) {
		// TODO 自动生成的方法存根
		try {
			String ipp = ip.getIP();
			documentsFactory documentsFactory=(documentsFactory)Naming.lookup("rmi://"+ipp+"/docFactory");
			getCodeDataSer getCodeDataSer=documentsFactory.createGetCodeDataSer();
			ArrayList<String>Sto= getCodeDataSer.getStoCode(account,"入库单", start, end);
			getDocumentInfoDataSer getDocumentInfoDataSer=documentsFactory.createGetDocumentInfoDataSer();
			ArrayList<InDepotInfVO> stoList=new ArrayList<>();
			for (int i = 0; i < Sto.size(); i++) {
				String [] string=Sto.get(i).split(",");
				InBillsPO inBillsPO=(InBillsPO)getDocumentInfoDataSer.getDocumentInfo(string[0], string[1]);
				stoList.add(new InDepotInfVO(inBillsPO.getInDepotNum(), inBillsPO.getInDepotDate(), inBillsPO.getDestination(), inBillsPO.getAreaNum(), inBillsPO.getRowNum(), inBillsPO.getShelvesNum(), inBillsPO.getSositionNum()));	
			}
			return stoList;
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
		return null;
	}

}
