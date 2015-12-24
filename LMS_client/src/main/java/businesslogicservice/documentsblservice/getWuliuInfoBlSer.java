package businesslogicservice.documentsblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface getWuliuInfoBlSer {
	public ArrayList<String> getWuliuInfo(String code) throws RemoteException;
}
