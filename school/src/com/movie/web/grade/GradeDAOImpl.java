package com.movie.web.grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.movie.web.global.Constants;
import com.movie.web.member.MemberBean;

public class GradeDAOImpl implements GradeDAO{
	private Connection conn; // 오라클 연결 객체
	private Statement stmt; // 쿼리 전송 객체
	private PreparedStatement pstmt; // 쿼리 전송 객체 2
	private ResultSet rs; // 리턴 값 회수 객체
	
	@Override
	public void insert(GradeBean gradeBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<MemberGradeBean> selectAll() {
		ArrayList<MemberGradeBean> tmpList = new ArrayList<MemberGradeBean>();
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM v_Member_Grade");

			while (rs.next()) { // rs에 요소가 있는 만큼 돌아라
				MemberGradeBean temp = new MemberGradeBean();
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setPassword(rs.getString("password"));
				temp.setAddr(rs.getString("addr"));
				temp.setBirth(rs.getInt("birth"));
				temp.setHak(rs.getInt("hak"));
				temp.setJava(rs.getInt("java"));
				temp.setSql(rs.getInt("sql"));
				temp.setJsp(rs.getInt("jsp"));
				temp.setSpring(rs.getInt("spring"));
				tmpList.add(temp);
			}
		} catch (Exception e) {
			System.out.println("selectMember()에서 에러 발생");
			e.printStackTrace();
		}
		return tmpList;
	}

	@Override
	public MemberGradeBean selectGradeByHak(int hak) {
		MemberGradeBean memGre = new MemberGradeBean();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM v_Member_Grade WHERE hak =" + "'"+hak+"'");

			while (rs.next()) { // rs에 요소가 있는 만큼 돌아라
				memGre.setId(rs.getString("id"));
				memGre.setName(rs.getString("name"));
				memGre.setPassword(rs.getString("password"));
				memGre.setAddr(rs.getString("addr"));
				memGre.setBirth(rs.getInt("birth"));
				memGre.setHak(rs.getInt("hak"));
				memGre.setJava(rs.getInt("java"));
				memGre.setSql(rs.getInt("sql"));
				memGre.setJsp(rs.getInt("jsp"));
				memGre.setSpring(rs.getInt("spring"));
			}
		} catch (Exception e) {
			System.out.println("selectMember()에서 에러 발생");
			e.printStackTrace();
		}
		return memGre;
	}

	@Override
	public Vector<MemberGradeBean> selectGradesById(String name) {
		Vector<MemberGradeBean> memGreVec = new Vector<MemberGradeBean>();
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM v_Member_Grade WHERE name =" + "'"+name+"'");

			while (rs.next()) { // rs에 요소가 있는 만큼 돌아라
				MemberGradeBean memGre = new MemberGradeBean(); // 중복된 이름이 있다면 각각의 객체에 담기게 하기 위해 지역변수로 객체를 생성해둔다.
				
				memGre.setId(rs.getString("id"));
				memGre.setName(rs.getString("name"));
				memGre.setPassword(rs.getString("password"));
				memGre.setAddr(rs.getString("addr"));
				memGre.setBirth(rs.getInt("birth"));
				memGre.setHak(rs.getInt("hak"));
				memGre.setJava(rs.getInt("java"));
				memGre.setSql(rs.getInt("sql"));
				memGre.setJsp(rs.getInt("jsp"));
				memGre.setSpring(rs.getInt("spring"));
				memGreVec.add(memGre);
			}
		} catch (Exception e) {
			System.out.println("selectMember()에서 에러 발생");
			e.printStackTrace();
		}
		return memGreVec;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String update(GradeBean grade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int hak) {
		// TODO Auto-generated method stub
		return null;
	}

}
