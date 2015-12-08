package businesslogic.transportationbl;

public class CostAndRouteController {
	
	TransportationBL tBL = new TransportationBL();
	
	public double getCost(int type) {
		// TODO 自动生成的方法存根
		return tBL.getCost(type);
	}
	
	public double getDistance(String line) {
		// TODO 自动生成的方法存根
		return tBL.getDistance(line);
	}
}
