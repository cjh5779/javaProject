package exam.ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAO {
	private Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// "oracle 접속종류:@dbms주소(도메인,ip):포트:sid 또는 포트/서비스name
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			String user = "SQL_SELECT"; 
			String pwd = "1234"; 
			
			con = DriverManager.getConnection(url, user, pwd);
			
			if(con!=null) {
				System.out.println("DB 연결 성공");
			} else {
				System.out.println("DB 연결 실패");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public ArrayList<ProductVO> ProductSelect() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ProductVO> prdList = new ArrayList<ProductVO>();
		
		try {
			con = getConnection();
			String query = "select * from product";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String prdName = rs.getString("prdName");
				String prdPrice = rs.getString("prdPrice");
				String prdMaker = rs.getString("prdMaker");
				String prdId = rs.getString("prdId");
				
				ProductVO vo = new ProductVO();
				vo.setPrdName(prdName);
				vo.setPrdPrice(prdPrice);
				vo.setPrdMaker(prdMaker);
				vo.setPrdId(prdId);
				
				prdList.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return prdList;
	}
}
