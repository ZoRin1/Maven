package vo.transportationVO;
/**
 * 用于显示距离常量修改时的路线
 * 包括线路和距离
 * @author YangHua'an
 *
 */
public class RouteVO {
	
	private String line;//用来保存线路，形式：起点城市-终点城市
	private double distance;//用来保存距离
	public RouteVO(String line, double distance) {
		super();
		this.line = line;
		this.distance = distance;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	

	
	
}
