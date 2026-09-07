package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.Util;

public class ProductDAO {
	public ArrayList<ProductDTO> productSelect() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ProductDTO> prdList = new ArrayList<ProductDTO>();
		
		try {
			con = Util.getConn();
			String query = "select * from PRODUCT";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String prdId = rs.getString("PRDID");
				String prdName = rs.getString("PRDNAME");
				int prdPrice = rs.getInt("PRDPRICE");
				String prdMaker = rs.getString("PRDMAKER");
				
				ProductDTO dto = new ProductDTO();
				dto.setPrdId(prdId);
				dto.setPrdName(prdName);
				dto.setPrdPrice(prdPrice);
				dto.setPrdMaker(prdMaker);
				
				prdList.add(dto);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return prdList;
	}
}