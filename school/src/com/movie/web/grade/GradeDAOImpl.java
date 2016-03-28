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
import com.movie.web.global.DatabaseFactory;
import com.movie.web.global.Vendor;
import com.movie.web.member.MemberBean;

public class GradeDAOImpl implements GradeDAO{
	private Connection conn; // 오라클 연결 객체
	private Statement stmt; // 쿼리 전송 객체
	private PreparedStatement pstmt; // 쿼리 전송 객체 2
	private ResultSet rs; // 리턴 값 회수 객체
	
	private static GradeDAO instance = new GradeDAOImpl(); // 싱글톤 패턴을 적용하여 static으로 Deep Copy방식으로 GradeDAOImpl 객체 생성  
	
	public static GradeDAO getInstance() { // 이 GradeDAOImpl 클래스가 필요한 곳에서 이 static 메소드를 호출하면 이미 생성되어 있는 GradeDAOImpl 객체를 가져갈 수 있게 된다(1개로 모두 공유해서 사용가능)
		return instance;
	}

	public GradeDAOImpl() {
		conn = DatabaseFactory.getDatabase(Vendor.ORACLE,Constants.ID, Constants.PASSWORD).getConnection(); // 인스턴스 변수는 필드에서 초기화 하지 않는다. 생성자에서 초기화 해줘라
	}
	
	@Override
	public void insert(GradeBean gradeBean) {
		int score_seq = gradeBean.getScore_seq();
		String id = gradeBean.getId();
		int java = gradeBean.getJava();
		int sql = gradeBean.getSql();
		int jsp = gradeBean.getJsp();
		int spring = gradeBean.getSpring();
		
		String query = "INSERT INTO Grade VALUES (?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, score_seq);
			pstmt.setString(2, id);
			pstmt.setInt(3, java);
			pstmt.setInt(4, sql);
			pstmt.setInt(5, jsp);
			pstmt.setInt(6, spring);
			pstmt.executeQuery();
		} catch (Exception e) {
			System.out.println("insert()에서 에러 발생");
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<MemberGradeBean> selectAll() {
		ArrayList<MemberGradeBean> tmpList = new ArrayList<MemberGradeBean>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM v_Member_Grade");

			while (rs.next()) { // rs에 요소가 있는 만큼 돌아라
				MemberGradeBean temp = new MemberGradeBean();
				
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setPassword(rs.getString("password"));
				temp.setAddr(rs.getString("addr"));
				temp.setBirth(rs.getInt("birth"));
				temp.setScore_seq(rs.getInt("score_seq"));
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
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM v_Member_Grade WHERE hak =" + "'"+hak+"'");

			while (rs.next()) { // rs에 요소가 있는 만큼 돌아라
				memGre.setId(rs.getString("id"));
				memGre.setName(rs.getString("name"));
				memGre.setPassword(rs.getString("password"));
				memGre.setAddr(rs.getString("addr"));
				memGre.setBirth(rs.getInt("birth"));
				memGre.setScore_seq(rs.getInt("score_seq"));
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
	public ArrayList<MemberGradeBean> selectGradesByName(String name) {
		ArrayList<MemberGradeBean> tmpList = new ArrayList<MemberGradeBean>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM v_Member_Grade WHERE name =" + "'"+name+"'");

			while (rs.next()) { // rs에 요소가 있는 만큼 돌아라
				MemberGradeBean tmpBean = new MemberGradeBean(); // 중복된 이름이 있다면 각각의 객체에 담기게 하기 위해 지역변수로 객체를 생성해둔다.
				
				tmpBean.setId(rs.getString("id"));
				tmpBean.setName(rs.getString("name"));
				tmpBean.setPassword(rs.getString("password"));
				tmpBean.setAddr(rs.getString("addr"));
				tmpBean.setBirth(rs.getInt("birth"));
				tmpBean.setScore_seq(rs.getInt("score_seq"));
				tmpBean.setJava(rs.getInt("java"));
				tmpBean.setSql(rs.getInt("sql"));
				tmpBean.setJsp(rs.getInt("jsp"));
				tmpBean.setSpring(rs.getInt("spring"));
				tmpList.add(tmpBean);
			}
		} catch (Exception e) {
			System.out.println("selectMember()에서 에러 발생");
			e.printStackTrace();
		}
		return tmpList;
	}
	
	@Override
	public GradeBean selectGradesById(String id) {
		GradeBean grade = new GradeBean();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Grade WHERE id =" + "'"+id+"'");

			while (rs.next()) { // rs에 요소가 있는 만큼 돌아라
				grade.setScore_seq(rs.getInt("score_seq"));
				grade.setId(rs.getString("id"));
				grade.setJava(rs.getInt("java"));
				grade.setSql(rs.getInt("sql"));
				grade.setJsp(rs.getInt("jsp"));
				grade.setSpring(rs.getInt("spring"));
			}
		} catch (Exception e) {
			System.out.println("selectGradesById()에서 에러 발생");
			e.printStackTrace();
		}
		return grade;
	}
	

	@Override
	public int count() {
		int count = 0;
		String sql = "SELECT COUNT(*) AS count FROM v_Member_Grade";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) { //방법 1
				count = rs.getInt("count");
			}
			
			/*rs = stmt.executeQuery(sql); // 방법2
			if (rs.next()) {
				count = rs.getInt(1);
			}*/
			
			/*rs.last(); // 방법 3, 이게 성능 상 가장 좋다.
			count = rs.getRow();*/
			
		} catch (Exception e) {
			System.out.println("insert()에서 에러 발생");
			e.printStackTrace();
		}
		return count;
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
