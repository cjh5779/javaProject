package bookcrud;

import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) {
		IBookDAO dao = new BookDAO(); 
        Scanner sc = new Scanner(System.in);
        String selMenu = null;
        
        while(true) {
            try {
                System.out.println("***********************");
                System.out.println("도서 관리 프로그램");
                System.out.println("***********************");
                System.out.println("다음 메뉴에서 선택");
                System.out.println("1. 도서 등록");
                System.out.println("2. 도서 정보 조회 (전체/검색)");
                System.out.println("3. 도서 정보 수정");
                System.out.println("4. 도서 정보 삭제");
                System.out.println("5. 종료");
                System.out.print("메뉴 번호 입력 : ");
                
                selMenu = sc.nextLine();
                
            } catch(Exception e) {
                System.out.println("잘못된 입력입니다.");
            }
            
            switch(selMenu) {
            case "1": 
                dao.insertBook(ReadWrite.getBookInfo(sc));
                break;
                
            case "2": 
                System.out.print("전체 조회는 빈칸 엔터, 검색은 검색어(도서명/저자/출판사)를 입력하세요 : ");
                String keyword = sc.nextLine();
                
                if (keyword.trim().isEmpty()) {
                    ReadWrite.printBookList(dao.getAllBooks()); 
                } else {
                    ReadWrite.printBookList(dao.searchBooks(keyword));
                }
                break;
                
            case "3": 
                ReadWrite.printBookList(dao.getAllBooks()); 
                String updateNo = ReadWrite.getBookNoInput(sc, "수정");
                BookDTO updateDto = ReadWrite.getUpdateBookInfo(sc, updateNo);
                dao.updateBook(updateDto);
                break;
                
            case "4": 
                String deleteNo = ReadWrite.getBookNoInput(sc, "삭제");
                dao.deleteBook(deleteNo);
                break;
                
            case "5": 
                System.out.println("종료합니다.");
                sc.close();
                System.exit(0);
                break;
                
            default:
                System.out.println("1~5 사이의 번호를 입력해 주세요.");
                break;
            }
        }
	}
}