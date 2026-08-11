package ex1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductMain {
	public static void main(String[] args) {
		// Connection 사용자 정의 클래스 활용 db 접속 테스트
		PrdJDBConn dbCon = new PrdJDBConn();
		Connection con = dbCon.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		if (con == null) {
			System.out.println("db 생성 실패");
		} else {
			System.out.println("db 생성 성공");

			try {
				// 쿼리
				String query = "SELECT * FROM productfin";
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);

				System.out.println("------------------------- 전체 상품 정보 조회 -------------------------");
				System.out.println("상품번호 \t 상품명 \t\t 가격 \t\t 제조사 \t 색상 \t 카테고리");


				while (rs.next()) {
					String prdNo = rs.getString(1);
					String prdName = rs.getString(2);
					int prdPrice = rs.getInt(3);
					String prdMaker = rs.getString(4);
					String prdColor = rs.getString(5);
					String ctgNo = rs.getString(6);
					

					System.out.format("%-10s\t %-20s\t %,10d\t %-10s\t %-10s\t %-10s\n", prdNo, prdName, prdPrice,
							prdMaker, prdColor, ctgNo);
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

}
