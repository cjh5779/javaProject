package jdbc.update;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import jdbc.DBConn;

public class CRUDTestDelete {
	public static void main(String[] args) {
		// 도서테이블에 레코드 insert
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;

		DBConn dbCon = new DBConn();
		String bookNo, bookTitle, bookAuthor, bookDate, pubNo;
		int bookPrice, bookStock;

		Scanner sc = new Scanner(System.in);

		try {
			con = dbCon.getConnection();

			// 미완성 쿼리 구문, 수정 쿼리는 일부 컬럼만 수정이 가능하지만
			// 프로그램을 통한 수정은 매번 수정 컬럼 변경 불가능 모든 컬럼을 수정하는 방식을 사용
			// 단 기본키의 값은 제외(조건절에 사용)
			String sql = "delete book where bookNo=?";
			pstmt = con.prepareStatement(sql);

			// 사용자로부터 데이터 입력 받기
			System.out.print("삭제할 도서의 도서번호 입력 : ");
			bookNo = sc.nextLine();
			

			// 데이터 바인딩

			pstmt.setString(1, bookNo);


			int tmpRes = pstmt.executeUpdate(); // 바인딩까지 완료된 쿼리를 실행

			if (tmpRes == 1) System.out.println("도서정보 삭제 성공");

		} catch (Exception e) {
			e.printStackTrace();
		}
		// db에 저장 완료 후 확인용 출력
		try {
			// 쿼리
			String query = "SELECT * FROM book";
			// 쿼리를 저장하고 전달, 실행 담당 객체를 하나 생성 : Statement 객체 생성
			stmt = con.createStatement();
			// 쿼리를 dbms에 전달, 실행요청, 실행된 결과반환 : 반환이 성공하면 조회된 결과가 rs의 참조로 반환
			ResultSet rs = stmt.executeQuery(query); // select 구문일 때 사용하는 메소드, ResultSet 반환

			System.out.println("---------- 전체 도서 정보 조회 ----------");
			System.out.println("도서번호 \t 도서명 \t\t\t\t 저자 \t\t 가격 \t\t 발행일  \t 재고 \t 출판사 번호");

			while (rs.next()) {
				bookNo = rs.getString(1);
				bookTitle = rs.getString(2);
				bookAuthor = rs.getString(3);
				bookPrice = rs.getInt(4);
				Date bookDate1 = rs.getDate(5);
				bookStock = rs.getInt(6);
				pubNo = rs.getString(7);

				// 한행씩 출력
				System.out.format("%-10s\t %-20s\t %-10s %6d %13s \t%3d %10s\n", bookNo, bookTitle, bookAuthor,
						bookPrice, bookDate1, bookStock, pubNo);
			}

			rs.close();
			stmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println("오류 발생");
			e.printStackTrace();
		}
	}
}
