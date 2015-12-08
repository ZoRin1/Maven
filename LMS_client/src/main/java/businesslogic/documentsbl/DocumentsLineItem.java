package businesslogic.documentsbl;

import businesslogic.transportationbl.TransportationController;

public class DocumentsLineItem{
	double distance=0;
	double cost=0;
	double weight=0;
	int type=1;
	int days=0;
	//此处所需line是起始城市名-到达城市名
	public DocumentsLineItem(String line, int type, double weight) {
		super();
		TransportationController co=new TransportationController();
		distance=co.getDistance(line);
		cost=co.getCost(type);
		this.weight=weight;
		this.type=type;
	}
	public DocumentsLineItem(int type){
		TransportationController co=new TransportationController();
		this.type=type;
		cost=co.getCost(type);
	}
	public double getTotal(){
		return distance*cost*weight;
	}
	public int getDays() {
		// TODO Auto-generated method stub
		if(type==1){
			days=(int) (distance/80)+1;
		}
		else if(type==2){
			days=(int) (distance/100)+1;
		}
		else{
			days=(int) (distance/200)+1;
		}
		return days;
	}
	public double getCost(){
		return 0.3*10000*cost;
	}
}
