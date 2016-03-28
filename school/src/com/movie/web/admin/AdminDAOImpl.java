package com.movie.web.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie.web.global.Constants;
import com.movie.web.global.DatabaseFactory;
import com.movie.web.global.Vendor;
import com.movie.web.grade.GradeBean;
import com.movie.web.grade.MemberGradeBean;
import com.movie.web.member.MemberBean;

public class AdminDAOImpl implements AdminDAO {
	private static AdminDAO instance = new AdminDAOImpl();
	private Connection conn; // 오라클 연결 객체
	private Statement stmt; // 쿼리 전송 객체1
	private PreparedStatement pstmt; // 쿼리 전송 객체2
	private ResultSet rs; // 쿼리 결과 저장 객체
	
	public AdminDAOImpl() {
		conn = DatabaseFactory.getDatabase(Vendor.ORACLE,Constants.ID, Constants.PASSWORD).getConnection();
	}
	
	public static AdminDAO getInstance() {
		return instance;
	}

	@Override
	public List<MemberGradeBean> selectMemGraList() {
		List<MemberGradeBean> temp = new ArrayList<MemberGradeBean>();
		
		try {
			stmt = conn.createStatement(); // 이것도 팩토리 패턴이다.
			rs = stmt.executeQuery("SELECT * FROM v_Member_Grade");

			while (rs.next()) { // rs에 요소가 있는 만큼 돌아라
				MemberGradeBean bean = new MemberGradeBean();
				bean.setScore_seq(rs.getInt("score_seq"));
				bean.setId(rs.getString("id"));
				bean.setJava(rs.getInt("java"));
				bean.setSql(rs.getInt("sql"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSpring(rs.getInt("spring"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				temp.add(bean);
			}
		} catch (Exception e) {
			System.out.println("selectMemberList() 에서 에러 발생");
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public int insertScore(GradeBean gradeBean) {
		int result = 0;
		String query = "INSERT INTO Grade VALUES (scoreSeq.NEXTVAL,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query); 
			pstmt.setString(1, gradeBean.getId());
			pstmt.setInt(2, gradeBean.getJava());
			pstmt.setInt(3, gradeBean.getSql());
			pstmt.setInt(4, gradeBean.getJsp());
			pstmt.setInt(5, gradeBean.getSpring());
			result = pstmt.executeUpdate(); // 오라클은 삽입문이 성공하면 (1 row affected)라고 보내준다, 숫자 1을 보내준다!!!
		} catch (Exception e) {
			System.out.println("insertScore()에서 에러 발생");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<MemberBean> selectMemList() { // 학생 목록을 데이터베이스에서 가져온다.
		List<MemberBean> temp = new ArrayList<MemberBean>();
		
		try {
			stmt = conn.createStatement(); // 이것도 팩토리 패턴이다.
			rs = stmt.executeQuery("SELECT * FROM Member");

			while (rs.next()) { // rs에 요소가 있는 만큼 돌아라
				MemberBean bean = new MemberBean();
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				temp.add(bean);
			}
		} catch (Exception e) {
			System.out.println("selectMemList() 에서 에러 발생");
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public AdminBean selectAdmin(AdminBean admin) {
		AdminBean temp = new AdminBean();
		try {
			stmt = conn.createStatement(); // 이것도 팩토리 패턴이다.
			rs = stmt.executeQuery("SELECT * FROM Admin");

			while (rs.next()) { // rs에 요소가 있는 만큼 돌아라
				if (admin.getId().equals(rs.getString("id")) && admin.getPassword().equals(rs.getString("password"))) {
					temp.setId(rs.getString("id"));
					temp.setName(rs.getString("name"));
					temp.setPassword(rs.getString("password"));
					temp.setAddr(rs.getString("addr"));
					temp.setBirth(rs.getInt("birth"));
					temp.setRole(rs.getString("role"));
				}
			}
		} catch (Exception e) {
			System.out.println("selectAdmin() 에서 에러 발생");
			e.printStackTrace();
		}
		return temp;
	}

}
