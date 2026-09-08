package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
    private DataSource dataFactory;
    
    // Connection과 PreparedStatement는 스레드 안전성을 위해 클래스 변수에서 제거하고
    // 각 메서드 내부의 지역 변수로 사용해야 합니다.

    public MemberDAO() {
        try {
            Context ctx = new InitialContext();
            Context envCtx = (Context) ctx.lookup("java:/comp/env");
            this.dataFactory = (DataSource) envCtx.lookup("jdbc/oracle");
            // 불필요하게 중복된 envCtx.lookup() 호출 제거
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<MemberVO> listMembers() {
        List<MemberVO> memberList = new ArrayList<>(); // 제네릭 타입 명시
        String query = "SELECT * FROM member ORDER BY MEMJOINDATE DESC";

        // try-with-resources 구문을 사용하여 예외 발생 시에도 자원을 확실하게 반환
        try (Connection conn = dataFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("MEMID");
                String pwd = rs.getString("MEMPWD");
                String name = rs.getString("MEMNAME");
                String email = rs.getString("MEMEMAIL");
                Date joinDate = rs.getDate("MEMJOINDATE");
                MemberVO memVO = new MemberVO(id, pwd, name, email, joinDate);
                memberList.add(memVO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return memberList;
    }

    public void addMember(MemberVO m) {
        String query = "INSERT INTO member (memid, mempwd, memname, mememail) VALUES(?, ?, ?, ?)";
        
        try (Connection conn = dataFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, m.getId());
            pstmt.setString(2, m.getPwd());
            pstmt.setString(3, m.getName());
            pstmt.setString(4, m.getEmail());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public MemberVO findMember(String _id) {
        MemberVO memInfo = null;
        String query = "SELECT * FROM member WHERE memid=?";
        
        try (Connection conn = dataFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, _id);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                // 데이터가 없을 경우를 대비해 반드시 if문으로 확인해야 합니다.
                if (rs.next()) {
                    String id = rs.getString("memid");
                    String pwd = rs.getString("mempwd");
                    String name = rs.getString("memname");
                    String email = rs.getString("mememail");
                    Date joinDate = rs.getDate("memjoinDate");
                    memInfo = new MemberVO(id, pwd, name, email, joinDate);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return memInfo;
    }
    
    public void modMember(MemberVO memberVO) {
        String query = "UPDATE member SET mempwd=?, memname=?, mememail=? WHERE memid=?";
        
        try (Connection conn = dataFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, memberVO.getPwd());
            pstmt.setString(2, memberVO.getName());
            pstmt.setString(3, memberVO.getEmail());
            pstmt.setString(4, memberVO.getId());
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delMember(String id) {
        String query = "DELETE FROM member WHERE memid=?";
        
        try (Connection conn = dataFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            // 기존 코드에서는 여기서 conn.close()가 누락되어 커넥션 고갈(Pool exhaustion) 위험이 있었습니다.
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}