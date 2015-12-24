package businesslogic.documentsbl;

import java.rmi.RemoteException;

import businesslogic.storagebl.DriveModel.returnSpace;
import businesslogic.transportationbl.TransportationController;

public class DocumentsLineItem{
	double distance=0;
	double cost=0;
	double weight=0;
	int type=1;
	int days=0;
	//此处所需line是起始城市名-到达城市名
	public DocumentsLineItem(String line, int type, double weight) throws RemoteException {
		super();
		TransportationController co=new TransportationController();
		distance=co.getDistance(line)/100;
		cost=co.getCost(type);
		this.weight=weight;
		this.type=type;
	}
	public DocumentsLineItem(int type) throws RemoteException{
		TransportationController co=new TransportationController();
		this.type=type;
		cost=co.getCost(type);
	}
	public DocumentsLineItem(int type,double weight) throws RemoteException{
		TransportationController co=new TransportationController();
		this.type=type;
		cost=co.getCost(type);
		this.weight=weight;
	}
	public double getTotal(){
		return distance*cost*weight;
	}
	public int getDays() {
		// TODO Auto-generated method stub
		if(type==1){
			days=(int) (distance/0.8)+1;
		}
		else if(type==2){
			days=(int) (distance/1)+1;
		}
		else{
			days=(int) (distance/2)+1;
		}
		return days;
	}
	public double getCost(){
		return 0.3*10000*cost;
	}
	public double getOwnCost(){
		return 0.3*weight*cost;
	}
}
