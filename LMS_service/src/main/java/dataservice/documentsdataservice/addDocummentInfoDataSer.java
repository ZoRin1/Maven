package dataservice.documentsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.documentsPO.DocumentPO;

public interface addDocummentInfoDataSer extends Remote{
	/**
	 * 
	 * 系统添加输入的单据信息
	 * @author XiongKaiQi
	 *
	 */
	public boolean addDocumentInfo(DocumentPO po)throws RemoteException;
}

