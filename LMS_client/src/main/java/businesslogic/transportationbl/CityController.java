package businesslogic.transportationbl;

import java.rmi.RemoteException;

public class CityController {
	TransportationBL tBL;
	public  CityController() throws RemoteException {
		 tBL= new TransportationBL();
	}
	
	public boolean addCity(String city) {
		// TODO 自动生成的方法存根
		return tBL.addCity(city);
	}

	
	public boolean removeCity(String city) {
		// TODO 自动生成的方法存根
		return tBL.removeCity(city);
	}

}
