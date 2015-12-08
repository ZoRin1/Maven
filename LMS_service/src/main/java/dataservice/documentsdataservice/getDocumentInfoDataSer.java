package dataservice.documentsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.documentsPO.DocumentPO;
import po.documentsPO.InBillsPO;

public interface getDocumentInfoDataSer extends Remote{
	/**
	 * 系统返回一个完整PO对象
	 * 用于显示编码对应单据对象详细信息
	 * @author XiongKaiQi
	 *
	 */
	public DocumentPO getDocumentInfo(String code,String doName)throws RemoteException;//xiugai
	/**
	 * 系统返回一个完整PO对象
	 * 用于显示入库快递编号对应入库单对象详细信息
	 * @author XiongKaiQi
	 *
	 */
	public InBillsPO getInDepotInfo(String doName,String InDepotNum)throws RemoteException;
}
