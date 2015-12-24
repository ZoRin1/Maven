package businesslogic.transportationbl;

import java.rmi.RemoteException;

public class CostAndRouteController {
	TransportationBL tBL ;
	public  CostAndRouteController() throws RemoteException {
		tBL= new TransportationBL();
	}
	
	
	public double getCost(int type) {
		// TODO 自动生成的方法存根
		return tBL.getCost(type);
	}
	
	public double getDistance(String line) {
		// TODO 自动生成的方法存根
		return tBL.getDistance(line);
	}
}
