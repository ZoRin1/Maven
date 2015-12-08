package businesslogic.organizationbl;

public class FinanceController {
	
	FinanceBL fBL = new FinanceBL();
	
	public String[] getFinancersList() {
		// TODO 自动生成的方法存根
		return fBL.getFinancersList();
	}


	public boolean addFinancer(long ID) {
		// TODO 自动生成的方法存根
		return fBL.addFinancer(ID);
	}


	public boolean removeFinancer(long ID) {
		// TODO 自动生成的方法存根
		return fBL.removeFinancer(ID);
	}

}
