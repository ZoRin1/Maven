package businesslogic.financebl.ProfitModel;

import java.text.SimpleDateFormat;
import java.util.Date;

import po.financePO.ProfitPO;
import vo.financeVO.ProfitVO;

public class ProfitController {
	
	private CostStatisticsBL cost;
	
	//返回ProfitVO逻辑类
	private ProfitBL profit;
	private double earn;
	private double pay;
	private String date;
	private addProfit add;
	
	
	public ProfitController() {
		super();
		cost = new CostStatisticsBL();
		profit = new ProfitBL();
		add = new addProfit();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		date = df.format(new Date());
	}

	//不太需要
//	public double earn(String [] selling){
//		return 0;
//	}
	
	//不太需要
//	public double pay(String [] selling){
//		return 0;
//	}
	
	public ProfitVO returnPro(String end){
		earn = cost.CalculateGet(end);
		pay = cost.CalculatePay(end);
		ProfitVO pro = new ProfitVO(earn,pay,date);
		return pro;
	}
	
	public void addPro(){
		ProfitPO po = new ProfitPO(earn, pay, date);
		add.addPro(po);
	}
	
	
}
