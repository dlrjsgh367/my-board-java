package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private Connection conn;
	
	public MemberDAO(Connection conn) {
		this.conn = conn;
	}
	
	public int register(Member member) throws SQLException {
		String query = "INSERT INTO member (name, sex, age, job, hobby) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getSex());
			pstmt.setInt(3, member.getAge());
			pstmt.setString(4, member.getJob());
			pstmt.setString(5, member.getHobby());
			
			return pstmt.executeUpdate();	
		}
	}
	
	public List<Member> getAllMembers() throws SQLException {
	    String query = "SELECT * FROM member ORDER BY created_at DESC";
	    List<Member> list = new ArrayList<>();
	    try (PreparedStatement pstmt = conn.prepareStatement(query);
	         ResultSet rs = pstmt.executeQuery()) {
	        while (rs.next()) {
	            Member member = new Member();
	            member.setId(rs.getInt("id"));
	            member.setName(rs.getString("name")); // 컬럼 이름과 일치하도록 수정
	            member.setSex(rs.getString("sex"));
	            member.setAge(rs.getInt("age"));
	            member.setJob(rs.getString("job"));  // 중복 제거
	            member.setHobby(rs.getString("hobby"));
	            member.setCreatedAt(rs.getString("created_at"));
	            list.add(member);
	        }
	    }
	    return list;
	}
}
