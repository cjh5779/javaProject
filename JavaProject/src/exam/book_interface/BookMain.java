package exam.book_interface;

import java.util.ArrayList;

public class BookMain {
    public static void main(String[] args) {
        IBookDAO dao = new BookDAO();
        
        BookDTO newBook = new BookDTO("1000", "자바", "홍길동", 28000);
        dao.insertBook(newBook);
        
        BookDTO foundBook = dao.selectBook("1001");
        System.out.println("조회된 도서: " + foundBook.toString());
        
        ArrayList<BookDTO> allBooks = dao.selectAllBooks();
        for (int i = 0; i < allBooks.size(); i++) {
            BookDTO b = allBooks.get(i);
            System.out.println(b.toString());
        }
        
        newBook.setPrice(25000);
        dao.updateBook(newBook);
        
        dao.deleteBook("1002");
    }
}