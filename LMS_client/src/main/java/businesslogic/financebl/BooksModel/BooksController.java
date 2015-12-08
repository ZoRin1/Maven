package businesslogic.financebl.BooksModel;

import java.util.ArrayList;

import po.financePO.BooksPO;

public class BooksController {
	
	private GetBooksBL getBooks;
	private NewBooksBL newBooks;
	
	public ArrayList<BooksPO> getBook(){
		getBooks = new GetBooksBL();
		ArrayList<BooksPO> poList = getBooks.getBooks();
		return poList;
	}
	
	public void newBook(String name){
		newBooks = new NewBooksBL();
		newBooks.newBooks(name);
	}
}
