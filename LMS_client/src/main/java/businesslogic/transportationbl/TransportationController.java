package businesslogic.transportationbl;

import java.rmi.RemoteException;

import vo.transportationVO.RouteVO;

public class TransportationController {
	TransportationBL tBL ;
	public TransportationController() throws RemoteException{
		tBL= new TransportationBL();
	}

	public boolean changeDistance(RouteVO route) {
		// TODO 自动生成的方法存根
		return tBL.changeDistance(route);
	}


	public boolean changeCost(int type, double cost) {
		// TODO 自动生成的方法存根
		return tBL.changeCost(type, cost);
	}


	public double getCost(int type) {
		// TODO 自动生成的方法存根
		return tBL.getCost(type);
	}


	public boolean addRoute(RouteVO route) {
		// TODO 自动生成的方法存根
		return tBL.addRoute(route);
	}


	public double getDistance(String line) {
		// TODO 自动生成的方法存根
		return tBL.getDistance(line);
	}


	public String[] getCityList(String city) {
		// TODO 自动生成的方法存根
		return tBL.getCityList(city);
	}

	public double[] getSalary(int employee) {
		// TODO Auto-generated method stub
		return tBL.getSalary(employee);
	}


	public boolean changeSalary(int employee, double[] salary) {
		// TODO Auto-generated method stub
		return tBL.changeSalary(employee, salary);
	}

}
