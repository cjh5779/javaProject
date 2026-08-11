package exam.jdbc;

import java.sql.Statement;
import java.util.Scanner;

import exam.DBConn;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookEx {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConn dbCon = new DBConn();
		String bookNo, bookTitle, bookAuthor, pubNo;
		int bookPrice, bookStock;
		Date bookDate;

		Scanner sc = new Scanner(System.in);

		try {
			con = dbCon.getConnection();
			stmt = con.createStatement();

			String sql1 = "SELECT COUNT(*) FROM book";
			rs = stmt.executeQuery(sql1);
			if (rs.next()) {
				System.out.println("현재 등록된 총 도서 권수 : " + rs.getInt(1) + "권\n");
			}
			rs.close();

			System.out.print("검색할 기준 년도 입력 (예: 2021) : ");
			String inputYear = sc.nextLine();

			String sql2 = "SELECT * FROM book WHERE TO_CHAR(bookDate, 'YYYY') >= ?";
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, inputYear);
			rs = pstmt.executeQuery();

			System.out.println("---------- " + inputYear + "년 이후 발행 도서 조회 ----------");
			System.out.println("도서번호 \t 도서명 \t\t\t\t 저자 \t\t 가격 \t\t 발행일  \t 재고 \t 출판사 번호");

			while (rs.next()) {
				bookNo = rs.getString(1);
				bookTitle = rs.getString(2);
				bookAuthor = rs.getString(3);
				bookPrice = rs.getInt(4);
				bookDate = rs.getDate(5);
				bookStock = rs.getInt(6);
				pubNo = rs.getString(7);

				System.out.format("%-10s\t %-20s\t %-10s %6d %13s \t%3d %10s\n", bookNo, bookTitle, bookAuthor,
						bookPrice, bookDate, bookStock, pubNo);
			}
			rs.close();
			System.out.println(); // 줄바꿈

			
			System.out.print("검색할 저자 이름 일부 입력 (예: 길동) : ");
			String inputAuthor = sc.nextLine();

			String sql3 = "SELECT * FROM book WHERE bookAuthor LIKE '%' || ? || '%'";
			pstmt = con.prepareStatement(sql3);
			pstmt.setString(1, inputAuthor);
			rs = pstmt.executeQuery();

			System.out.println("---------- 저자명 '" + inputAuthor + "' 검색 결과 ----------");
			System.out.println("도서번호 \t 도서명 \t\t\t\t 저자 \t\t 가격 \t\t 발행일  \t 재고 \t 출판사 번호");

			while (rs.next()) {
				bookNo = rs.getString(1);
				bookTitle = rs.getString(2);
				bookAuthor = rs.getString(3);
				bookPrice = rs.getInt(4);
				bookDate = rs.getDate(5);
				bookStock = rs.getInt(6);
				pubNo = rs.getString(7);

				System.out.format("%-10s\t %-20s\t %-10s %6d %13s \t%3d %10s\n", bookNo, bookTitle, bookAuthor,
						bookPrice, bookDate, bookStock, pubNo);
			}
			rs.close();
			System.out.println(); // 줄바꿈

			System.out.print("검색할 최소 가격 입력 (예: 30000) : ");
			int inputPrice = Integer.parseInt(sc.nextLine());

			String sql4 = "SELECT * FROM book WHERE bookPrice >= ?";
			pstmt = con.prepareStatement(sql4);
			pstmt.setInt(1, inputPrice);
			rs = pstmt.executeQuery();

			System.out.println("---------- 가격 " + inputPrice + "원 이상 도서 검색 결과 ----------");
			System.out.println("도서번호 \t 도서명 \t\t\t\t 저자 \t\t 가격 \t\t 발행일  \t 재고 \t 출판사 번호");

			while (rs.next()) {
				bookNo = rs.getString(1);
				bookTitle = rs.getString(2);
				bookAuthor = rs.getString(3);
				bookPrice = rs.getInt(4);
				bookDate = rs.getDate(5);
				bookStock = rs.getInt(6);
				pubNo = rs.getString(7);

				System.out.format("%-10s\t %-20s\t %-10s %6d %13s \t%3d %10s\n", bookNo, bookTitle, bookAuthor,
						bookPrice, bookDate, bookStock, pubNo);
			}

			rs.close();
			stmt.close();
			pstmt.close();
			con.close();
			sc.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
