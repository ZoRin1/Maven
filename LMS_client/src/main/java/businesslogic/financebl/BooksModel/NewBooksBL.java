package businesslogic.financebl.BooksModel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import presentation.mainui.ipConfig;
import dataservice.financedataservice.AddBooksDataSer;
import dataservice.financedataservice.financeFactory;
import businesslogicservice.financeblservice.NewBooksBlSer;

public class NewBooksBL implements NewBooksBlSer{
	
	private ipConfig ip;
	
	public NewBooksBL(){
		super();
		ip = new ipConfig();
	}
	@Override
	public void newBooks(String name) throws RemoteException{
		// TODO 自动生成的方法存根
		try {
			String ipp = ip.getIP();
			financeFactory finFactory  = (financeFactory)Naming.lookup("rmi://"+ipp+"/finFactory");
			AddBooksDataSer addBooks = finFactory.createAddBooksDataSer();
			addBooks.addBooks(name);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}  catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}