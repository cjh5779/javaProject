package secure.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.*;

import secure.injection.DBConn;

public class StudentInjectMain {
	public static void main(String[] args) {
		DBConn dbcon = new DBConn();
		Connection con = dbcon.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);

		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]|[select|delete|update|insert|create|alter|drop|union]"); 
		Matcher matcher = null;

		try {
			System.out.print("학생 번호 입력 : ");
			String studentNo = sc.nextLine();
			matcher = pattern.matcher(studentNo.toLowerCase());
			boolean match = true;
			while(matcher.find()) { 
				match=false;
				System.out.println("[주의] 필터링 문자열이 감지되었습니다. (하지만 차단되지는 않습니다)");
				break;
			}

			String sql = "select * from student where stdNo = '" + studentNo + "'";
			System.out.println("실행 쿼리: " + sql);

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			System.out.println("---------- 학생정보조회 ----------");
			System.out.println("학생번호 \t 학생이름 \t\t\t 학년");

			while(rs.next()) {
				String stdNo = rs.getString(1);
				String stdName = rs.getString(2);
				int stdYear = rs.getInt(3);

				System.out.format("%-10s\t %-20s\t\t %6d \n", stdNo, stdName, stdYear);
			}
			
		} catch(SQLException e) {
			System.out.println("SQL 쿼리 실행 중 오류 발생!");
			e.printStackTrace();
		} finally {
			// 자원 반납
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close(); // DBConn 구현 방식에 따라 다를 수 있음
			} catch (SQLException e) {
				e.printStackTrace();
			}
			sc.close();
		}
	}
}





//////////////////////////////////////////////////////////////////
/// 