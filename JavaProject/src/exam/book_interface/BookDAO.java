package exam.book_interface;

import java.util.ArrayList;

public class BookDAO implements IBookDAO {

    @Override
    public void insertBook(BookDTO book) {
        System.out.println("[DB Insert] '" + book.getTitle() + "' 도서가 성공적으로 등록되었습니다.");
    }

    @Override
    public BookDTO selectBook(String isbn) {
        System.out.println("[DB Select] 도서번호 " + isbn + "번의 도서 정보를 조회합니다.");
        return new BookDTO(isbn, "임의의 책 제목", "아무개", 15000); 
    }

    @Override
    public ArrayList<BookDTO> selectAllBooks() {
        System.out.println("[DB SelectAll] 등록된 모든 도서 목록을 조회합니다.");
        
        ArrayList<BookDTO> bookList = new ArrayList<>();
        bookList.add(new BookDTO("1001", "파이썬", "이몽룡", 30000));
        bookList.add(new BookDTO("1002", "데이터베이스", "춘향", 20000));
        
        return bookList;
    }

    @Override
    public void updateBook(BookDTO book) {
        System.out.println("[DB Update] 도서번호 " + book.getIsbn() + "번의 도서 정보가 수정되었습니다.");
    }

    @Override
    public void deleteBook(String isbn) {
        System.out.println("[DB Delete] 도서번호 " + isbn + "번의 도서가 삭제되었습니다.");
    }
}