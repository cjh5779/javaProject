package bookcrud;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadWrite {
	public static BookDTO getBookInfo(Scanner sc) {
		BookDTO dto = null;
		try {
			System.out.println("***********************");
            System.out.println("도서 정보 등록");
            System.out.println("***********************");
            
            System.out.print("도서번호 입력 : ");
            String bookNo = sc.nextLine();
            
            System.out.print("도서명 입력 : ");
            String bookName = sc.nextLine();
            
            System.out.print("저자 입력 : ");
            String bookAuthor = sc.nextLine();
            
            System.out.print("가격 입력 : ");
            int bookPrice = Integer.parseInt(sc.nextLine());
            
            System.out.print("발행일 입력(yyyy-MM-dd) : ");
            String bookDateStr = sc.nextLine();
            
            SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = fm.parse(bookDateStr);
            java.sql.Date bookDate = new java.sql.Date(utilDate.getTime());
            
            System.out.print("재고 입력 : ");
            int bookStock = Integer.parseInt(sc.nextLine());
            
            System.out.print("출판사 번호 입력 : ");
            String pubNo = sc.nextLine();
            
            dto = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
            
		} catch(Exception e) {
			System.out.println("입력 오류");
		}
		return dto;
	}
	
	public static BookDTO getUpdateBookInfo(Scanner sc, String bookNo) {
        BookDTO dto = null;
        try {
            System.out.println("***********************");
            System.out.println("도서 정보 수정 (도서번호: " + bookNo + ")");
            System.out.println("***********************");
            
            System.out.print("도서명 입력 : ");
            String bookName = sc.nextLine();
            
            System.out.print("저자 입력 : ");
            String bookAuthor = sc.nextLine();
            
            System.out.print("가격 입력 : ");
            int bookPrice = Integer.parseInt(sc.nextLine());
            
            System.out.print("발행일 입력(yyyy-MM-dd) : ");
            String bookDateStr = sc.nextLine();
            
            SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = fm.parse(bookDateStr);
            java.sql.Date bookDate = new java.sql.Date(utilDate.getTime());
            
            System.out.print("재고 입력 : ");
            int bookStock = Integer.parseInt(sc.nextLine());
            
            System.out.print("출판사 번호 입력 : ");
            String pubNo = sc.nextLine();
            
            dto = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
            
        } catch (Exception e) {
            System.out.println("입력 오류");
        }
        return dto;
    }
	
	public static void printBookList(ArrayList<BookDTO> list) {
		System.out.println("*************************************************************************");
        System.out.println("도서 정보 조회");
        System.out.println("*************************************************************************");
        System.out.printf("%-10s %-20s %-10s %-10s %-15s %-5s %-10s\n", 
                "도서번호", "도서명", "저자", "가격", "발행일", "재고", "출판사번호");
        System.out.println("-------------------------------------------------------------------------");
        
        for (BookDTO dto : list) {
            System.out.printf("%-10s %-20s %-10s %-10d %-15s %-5d %-10s\n",
                    dto.getBookNo(), dto.getBookName(), dto.getBookAuthor(), 
                    dto.getBookPrice(), dto.getBookDate(), dto.getBookStock(), dto.getPubNo());
        }
	}
	
	public static String getBookNoInput(Scanner sc, String message) {
        System.out.print(message + "할 도서번호 입력 : ");
        return sc.nextLine();
    }
}
