package dataservice.documentsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface getWuliuInfoDataSer extends Remote{
	public ArrayList<String> getWuliuInfo(String code)throws RemoteException;
}
