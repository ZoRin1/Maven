package businesslogic.financebl.ProfitListModel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.financePO.ProfitPO;
import presentation.mainui.ipConfig;
import dataservice.financedataservice.ProfitListDataSer;
import dataservice.financedataservice.financeFactory;
import vo.financeVO.ProfitVO;
import businesslogicservice.financeblservice.ProfitListBlSer;

public class ProfitListBL implements ProfitListBlSer{
	
	private ArrayList<ProfitVO> voList;
	private ipConfig ip;
	
	public ProfitListBL(){
		super();
		voList = new ArrayList<ProfitVO>();
		ip = new ipConfig();
	}
	
	
	@Override
	public ArrayList<ProfitVO> getProList() {
		// TODO 自动生成的方法存根
		String now ="";
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		now = sdf.format(date);
		ProfitVO vo;
		try {
			String ipp = ip.getIP();
			financeFactory finFactory  = (financeFactory)Naming.lookup("rmi://"+ipp+"/finFactory");
			ProfitListDataSer profitList = finFactory.createProfitListDataSer();
			ArrayList<ProfitPO> poList = profitList.ProList(now);
			for(int i = 0 ; i < poList.size();i++){
				vo = new ProfitVO(poList.get(i).getTotalRevenue(), poList.get(i).getTotalPay(), poList.get(i).getGenerationDate());
				voList.add(vo);
			}
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return voList;
	}

}