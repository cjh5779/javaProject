package com.spring_mvc.jdbc2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring_mvc.jdbc2.dto.ProductDTO;

@Repository
public class ProductDAO {
    private DataSource dataFactory;

    @Autowired
    public ProductDAO(DataSource dataSource) {
        try {
            this.dataFactory = dataSource;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // 상품 정보 조회
    public ArrayList<ProductDTO> productSelect() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<ProductDTO> prdList = new ArrayList<ProductDTO>();

        try {
            con = dataFactory.getConnection();
            // 주의: 실제 DB에 있는 테이블명과 컬럼명에 맞게 쿼리를 수정하세요.
            String sql = "SELECT * FROM product"; 
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                ProductDTO dto = new ProductDTO();
                dto.setPrdId(rs.getString("prdId"));
                dto.setPrdName(rs.getString("prdName"));
                dto.setPrdPrice(rs.getInt("prdPrice"));
                dto.setPrdMaker(rs.getString("prdMaker"));
                
                prdList.add(dto);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            } catch(Exception e) {}
        }
        return prdList;
    }
}