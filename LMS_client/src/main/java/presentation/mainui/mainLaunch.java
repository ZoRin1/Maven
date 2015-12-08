package presentation.mainui;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.sound.midi.Receiver;

import po.accountPO.AccountInfoPO;
import po.documentsPO.GetOrderPO;
import po.documentsPO.InBillsPO;
import po.documentsPO.LoadingPO;
import po.documentsPO.OrderPO;
import po.documentsPO.OutbillsPO;
import po.documentsPO.PaymentPO;
import po.documentsPO.ReceiptPO;
import po.documentsPO.YDispatchPO;
import po.documentsPO.YReceivePO;
import po.documentsPO.ZLoadingPO;
import po.documentsPO.ZReceivePO;
import po.financePO.AccountPO;
import dataservice.accountdataservice.AccountDataSer;
import dataservice.accountdataservice.accountFactory;
import dataservice.documentsdataservice.GetDocCodeDataSer;
import dataservice.documentsdataservice.NotApproved;
import dataservice.documentsdataservice.addDocummentInfoDataSer;
import dataservice.documentsdataservice.deleteDataSer;
import dataservice.documentsdataservice.documentsFactory;
import dataservice.documentsdataservice.getBufferedCodeDataSer;
import dataservice.documentsdataservice.getBufferedInfoDataSer;
import dataservice.documentsdataservice.getCodeDataSer;
import dataservice.documentsdataservice.getNotPassDocCode;
import dataservice.documentsdataservice.getWuliuInfoDataSer;
import dataservice.financedataservice.CoverDataSer;
import dataservice.financedataservice.GetAccountDataSer;
import dataservice.financedataservice.GetReceivablesBillsDataSer;
import dataservice.financedataservice.financeFactory;
import dataservice.organizationdataservice.FinanceOrgDataSer;
import dataservice.organizationdataservice.organizationFactory;

public class mainLaunch {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException{
		documentsFactory documentsFactory=(documentsFactory)Naming.lookup("rmi://127.0.0.1:6600/docFactory");
		getCodeDataSer getCodeDataSer=documentsFactory.createGetCodeDataSer();
//		documentsFactory documentsFactory=(documentsFactory)Naming.lookup("rmi://127.0.0.1:6600/docFactory");
//			documentsFactory documentsFactory=(documentsFactory)Naming.lookup("rmi://127.0.0.1:6600/docFactory");
//			getWuliuInfoDataSer getWuliuInfoDataSer=documentsFactory.createGetWuliuInfoDataSer();
//			System.out.println(getWuliuInfoDataSer.getWuliuInfo("11"));
//			ArrayList<String> codeList=new ArrayList<String>();
//			codeList.add("1212");
//			codeList.add("1515");
//			codeList.add("51515");
//			double [] sizeList={15,15,15};
//			LoadingPO loadingPO=new LoadingPO("2015-5-21", "0505151511", "营业厅装车单", "0505151511", "鼓楼营业厅", "南京中转中心", "a", "a", codeList, 15.2);
//			OrderPO orderPO=new OrderPO("155155", "寄件单", "1551", "2015-5-21", "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", 1, 20.0, 20.0, "aaa", sizeList, 15.0, "tekuai");
//		OutbillsPO outbillsPO=new OutbillsPO("0505151511", "出库单", "0505151511", "2015-6-30", "1515", "北京中转中心", "feiji", "1515");
//			PaymentPO paymentPO=new PaymentPO("0505151511", "付款单", "2015-5-30", "15156", 1515, "a", "5151", "a", "ad");
//			ReceiptPO receiptPO=new ReceiptPO("15151516", "收款单", "2015-6-5", "151616", "1551", 1515, "asdasd", codeList);
//			YDispatchPO yDispatchPO=new YDispatchPO("2015-5-30", "151561", "派件单", "151515", "451616", "asdasd");
//			YReceivePO yReceivePO=new YReceivePO("2015-6-2", "15155", "营业厅接收单", "4515", "111515", "北京营业厅", "南京中转中心", "zhengchang");
//			ZLoadingPO zLoadingPO=new ZLoadingPO("2015-6-6", "451515", "中转中心转运单", "515151", "5251", "南京中转中心", "北京中转中心", "dfsdf", codeList, 1515);
//			ZReceivePO zReceivePO=new ZReceivePO("151515", "中转中心接收单", "2015-6-5", "asdasdas", "asdasd", codeList, "南京中转中心", "北京中转中心");
//			addDocummentInfoDataSer.addDocumentInfo(orderPO);
//			addDocummentInfoDataSer.addDocumentInfo(outbillsPO);
//			OutbillsPO outbillsPO=(OutbillsPO)getBufferedInfoDataSer.getBufferedInfo("0505151511", "出库单");
//			System.out.println(outbillsPO.getArrival());
//			deleteDataSer.delete("155155", "寄件单");
//			System.out.println("创建成功");
//			accountFactory accountFactory=(accountFactory)Naming.lookup("rmi://127.0.0.1:6600/accFactory");
//			AccountDataSer accountDataSer=accountFactory.createAccountDataSer();
//			System.out.println("155 21 是否正确: "+accountDataSer.campare(155, "21"));
//			AccountInfoPO accountInfoPO=new AccountInfoPO("w", 155, "21", "1-南京-鼓楼-营业厅-001-001", "515", "5155", "2015-6-3");
//			System.out.println("创建："+accountDataSer.insert(155,accountInfoPO));
//			System.out.println("155 21 是否正确: "+accountDataSer.campare(155, "21"));
//			accountInfoPO.setPassword("2");
//			System.out.println("更新: "+accountDataSer.update(155, accountInfoPO));
//			System.out.println("155 21 是否正确: "+accountDataSer.campare(155, "21"));
//			System.out.println("155 21 是否正确: "+accountDataSer.campare(155, "2"));
//			System.out.println("删除: "+accountDataSer.delete(155));
//			System.out.println("155 21 是否正确: "+accountDataSer.campare(155, "2"));
//			//GetAccountDataSer accountSer = (GetAccountDataSer)Naming.lookup("rmi://127.0.0.1:6600/accountSer");
//			financeFactory finFactory = (financeFactory)Naming.lookup("rmi://127.0.0.1:6600/finFactory");
//			GetAccountDataSer accountSer = finFactory.createGetAccountDataSer();
//			ArrayList<AccountPO> po = accountSer.getAccount();
//			for(AccountPO account:po){
//				System.out.print(account.getName()+"  "+account.getSums());
//				System.out.println();
//			}
//			
//			//GetReceivablesBillsDataSer getReceipt = (GetReceivablesBillsDataSer)Naming.lookup("rmi://127.0.0.1:6600/getReceipt");
//			GetReceivablesBillsDataSer getReceipt = finFactory.createGetReceivablesBillsDataSer();
//			ArrayList<ReceiptPO> rp = getReceipt.Receivables(null, null);
//			ArrayList<String> code = new ArrayList();
//			for(int i = 0 ; i < rp.size();i++){
//				System.out.print(rp.get(i).getDate()+"  ");
//				System.out.print(rp.get(i).getFund()+"  ");
//				System.out.print(rp.get(i).getAccount()+"    ");
//				code = rp.get(i).getTCode();
//				for(int j = 0 ; j < code.size();j++){
//					if(j==code.size()-1){
//						System.out.println(code.get(j));
//					}else{
//						System.out.print(code.get(j)+"  ");
//					}
//				}
//
//			}
//			//CoverDataSer coverSer = (CoverDataSer)Naming.lookup("rmi://127.0.0.1:6600/coverSer");
//			CoverDataSer coverSer = finFactory.createCoverDataSer();
//			coverSer.coverAccount(po);
//			
////			for(AccountPO account:po){
////				System.out.print(account.getName()+"  "+account.getSums());
////				System.out.println();
////			}

		
		
	}
}

