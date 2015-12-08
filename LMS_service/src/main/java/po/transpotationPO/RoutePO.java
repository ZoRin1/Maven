package po.transpotationPO;
/**
 * 用来表示路线持久化对象
 * 
 * @author YangHua'an
 *
 */
import java.io.Serializable;

public class RoutePO implements Serializable {

	/**
	 * 
	 * 序列号版本号
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String line;//用来保存线路，形式：起点城市-终点城市
	private double distance;//用来保存距离
	
	public RoutePO(String line, double distance) {
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
