package exam.book_interface;

import java.util.ArrayList;

public interface IBookDAO {
	void insertBook(BookDTO book);
	BookDTO selectBook(String isbn);
	ArrayList<BookDTO> selectAllBooks();
	void updateBook(BookDTO book);
	void deleteBook(String isbn);
}
