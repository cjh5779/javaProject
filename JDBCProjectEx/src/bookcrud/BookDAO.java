package bookcrud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bookcrud.DBConn;
import bookcrud.BookDTO;

public class BookDAO implements IBookDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	BookDTO book = null;
	
	public BookDAO() {
		con = DBConn.getConnection();
	}

	@Override
	public void insertBook(BookDTO dto) {
		try {
			String sql = "insert into book values(?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBookNo());
            pstmt.setString(2, dto.getBookName());
            pstmt.setString(3, dto.getBookAuthor());
            pstmt.setInt(4, dto.getBookPrice());
            pstmt.setDate(5, dto.getBookDate());
            pstmt.setInt(6, dto.getBookStock());
            pstmt.setString(7, dto.getPubNo());
            
            int result = pstmt.executeUpdate();
            
            if(result > 0) {
            	System.out.println("성공 : 도서정보가 등록되었습니다.");
            }
            
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(pstmt);
		}
		
	}

	@Override
	public ArrayList<BookDTO> getAllBooks() {
		ArrayList<BookDTO> BookList = new ArrayList<>();
		try {
			String sql = "select * from book order by bookNo";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String bookNo = rs.getString(1);
				String bookName = rs.getString(2);
				String bookAuthor = rs.getString(3);
				int bookPrice = rs.getInt(4);
				Date bookDate = rs.getDate(5);
				int bookStock = rs.getInt(6);
				String pubNo = rs.getString(7);
				
				// rs -> dto -> arrayList에 추가
				book = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
				BookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(pstmt, rs);
		}
		return BookList;
	}

	@Override
	public ArrayList<BookDTO> searchBooks(String keyword) {
		ArrayList<BookDTO> BookList = new ArrayList<>();
		return null;
	}

	@Override
	public void updateBook(BookDTO dto) {
		try {
			String sql = "UPDATE BOOK SET bookName=?, bookAuthor=?, bookPrice=?, bookDate=?, bookStock=?, pubNo=? WHERE bookNo=?";	
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBookName());
            pstmt.setString(2, dto.getBookAuthor());
            pstmt.setInt(3, dto.getBookPrice());
            pstmt.setDate(4, dto.getBookDate());
            pstmt.setInt(5, dto.getBookStock());
            pstmt.setString(6, dto.getPubNo());
            pstmt.setString(7, dto.getBookNo());
            
            int result = pstmt.executeUpdate();
            
            if(result > 0) {
            	System.out.println("성공 : 도서 정보가 등록되었습니다.");
            } else {
            	System.out.println("해당 도서번호가 존재하지 않습니다.");
            }
		} catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(pstmt);
        }
			
	}

	@Override
	public void deleteBook(String bookNo) {
		try {
            String sql = "DELETE FROM BOOK WHERE bookNo=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, bookNo);
            
            int result = pstmt.executeUpdate();
            if(result > 0) {
                System.out.println("성공 : " + bookNo + " 도서를 삭제하였습니다. 도서 정보 조회에서 확인하세요.");
            } else {
                System.out.println("해당 도서번호가 존재하지 않습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(pstmt);
        }
		
	}
	
}
