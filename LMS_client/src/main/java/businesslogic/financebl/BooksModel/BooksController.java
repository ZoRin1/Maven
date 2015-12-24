package businesslogic.financebl.BooksModel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.financePO.BooksPO;

public class BooksController {
	
	private GetBooksBL getBooks;
	private NewBooksBL newBooks;
	
	public ArrayList<BooksPO> getBook() throws RemoteException{
		getBooks = new GetBooksBL();
		ArrayList<BooksPO> poList = getBooks.getBooks();
		return poList;
	}
	
	public void newBook(String name) throws RemoteException{
		newBooks = new NewBooksBL();
		newBooks.newBooks(name);
	}
}
