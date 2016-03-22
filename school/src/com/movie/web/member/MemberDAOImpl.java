package com.movie.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.movie.web.global.Constants;

public class MemberDAOImpl implements MemberDAO {
	private Connection conn; // 오라클 연결 객체
	private Statement stmt; // 쿼리 전송 객체1
	private PreparedStatement pstmt; // 쿼리 전송 객체2
	private ResultSet rs; // 쿼리 결과 저장 객체
	
	

	@Override
	public void insert(MemberBean member) { // 회원가입 양식에서 입력받은 값들을 데이터베이스에 삽입
		String id = member.getId();
		String name = member.getName();
		String password = member.getPassword();
		String addr = member.getAddr();
		int birth = member.getBirth();
		
		String query = "INSERT INTO Member VALUES (?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, password);
			pstmt.setString(4, addr);
			pstmt.setInt(5, birth);
			pstmt.executeQuery();
		} catch (Exception e) {
			System.out.println("insert()에서 에러 발생");
			e.printStackTrace();
		}
	}

	@Override
	public MemberBean selectById(String id, String password) {
		MemberBean temp = new MemberBean(); // 데이터베이스에서 내용을 받아와서 저장할 Bean 객체다.
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Member WHERE id =" + "'"+id+"' and password = " + "'"+password+"'");

			while (rs.next()) { // rs에 요소가 있는 만큼 돌아라
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setPassword(rs.getString("password"));
				temp.setAddr(rs.getString("addr"));
				temp.setBirth(rs.getInt("birth"));
			}
		} catch (Exception e) {
			System.out.println("selectById()에서 에러 발생");
			e.printStackTrace();
		}
		//System.out.println("쿼리 조회 결과 :" + temp.getAddr());
		
		return temp;
		
	}

	@Override
	public MemberBean selectMember(String id) {
		MemberBean temp = new MemberBean(); // 데이터베이스에서 내용을 받아와서 저장할 Bean 객체다.
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Member WHERE id =" + "'"+id+"'");

			while (rs.next()) { // rs에 요소가 있는 만큼 돌아라
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setPassword(rs.getString("password"));
				temp.setAddr(rs.getString("addr"));
				temp.setBirth(rs.getInt("birth"));
			}
		} catch (Exception e) {
			System.out.println("selectMember()에서 에러 발생");
			e.printStackTrace();
		}
		//System.out.println("쿼리 조회 결과 :" + temp.getAddr());
		
		return temp;
	}

	@Override
	public void update(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isMember(String id) {
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT id FROM Member");

			while (rs.next()) { // rs에 요소가 있는 만큼 돌아라
				if (id.equals(rs.getString("id"))) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println("isMember()에서 에러 발생");
			e.printStackTrace();
		}
		return false;
	}
}
