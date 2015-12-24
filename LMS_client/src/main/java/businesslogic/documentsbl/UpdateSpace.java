package businesslogic.documentsbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import po.documentsPO.InBillsPO;
import presentation.mainui.ipConfig;
import dataservice.documentsdataservice.documentsFactory;
import dataservice.documentsdataservice.getDocumentInfoDataSer;
import vo.storageVO.DepotVO;
import businesslogic.storagebl.OutDepot.OutDepotBL;
import businesslogicservice.modelservice.storageInfo.UpdateSpaceSer;

public class UpdateSpace implements UpdateSpaceSer{
	//此处仅和出库单有关
	private OutDepotBL out;
	private String city;
	private int qu;
	private int pai;
	private int jia;
	private int wei;
	private InBillsPO po;
	private ipConfig ip;
	public UpdateSpace(String InDepotCode,String city) throws RemoteException{
		super();
		ip = new ipConfig();
		try {
			String ipp = ip.getIP();
			documentsFactory documentsFactory=(documentsFactory)Naming.lookup("rmi://"+ipp+"/docFactory");
			getDocumentInfoDataSer getDocumentInfoDataSer=documentsFactory.createGetDocumentInfoDataSer();
			po=getDocumentInfoDataSer.getInDepotInfo("入库单", InDepotCode);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.qu = po.getAreaNum();
		this.pai = po.getRowNum();
		this.jia = po.getShelvesNum();
		this.wei = po.getSositionNum();
		this.city=city;
	}

	@Override
	public void updateDrive() throws RemoteException {
		// TODO Auto-generated method stub
		DepotVO vo = new DepotVO(qu, pai, jia, wei);
		out = new OutDepotBL();
		out.outDepot(vo,city);
	}
}
