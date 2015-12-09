package businesslogic.financebl.BooksModel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.financePO.BooksPO;
import presentation.mainui.ipConfig;
import dataservice.financedataservice.GetBooksDataSer;
import dataservice.financedataservice.financeFactory;
import vo.financeVO.BooksVO;
import businesslogicservice.financeblservice.GetBooksBlSer;

public class GetBooksBL implements GetBooksBlSer{
	
	private BooksVO vo;
	private ArrayList<BooksPO> booksPoList;
	private ipConfig ip;
	
	public GetBooksBL(){
		super();
		ip = new ipConfig();
	}

	@Override
	public ArrayList<BooksPO> getBooks() {
		// TODO 自动生成的方法存根
		try {
			String ipp = ip.getIP();
			financeFactory finFactory = (financeFactory)Naming.lookup("rmi://"+ipp+"/finFactory");
			GetBooksDataSer getBooks = finFactory.createGetBooksDataSer();
			booksPoList = getBooks.Books();
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
		return booksPoList;
	}
}
