package ex1;

import java.sql.Connection;
import java.sql.DriverManager;

public class PrdJDBConn {
	public Connection getConnection() {
		Connection con = null;
		
		// 외부 자원 활용 : try ~ catch 구문 안에서 진행되거나 throws 문을 추가하거나
		try {
			// DBMS 연결 관련 코드
			// 1. JDBC DRIVER 클래스의 객체 생성 : 런타임시 JDBC 드라이버 로드(자동 로그 : 생략 가능)
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			// 접속 변수 생성
			// "oracle 접속 종류 : @DBMS주소(도메인, IP):포트:SID 또는 /서비스 name"
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "C##SQL_USER";
			String pwd = "1234";
			
			// 2. Connection interface 참조변수에 구현객체 대입(DB 접속 후 접속 객체 반환) -> DriverManager
			con = DriverManager.getConnection(url, user, pwd);
			// db 접속 실패하면 catch, 저장값은 null
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
