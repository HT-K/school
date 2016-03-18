package com.movie.web.grade;

import java.util.Vector;
import java.util.ArrayList;
import java.util.Map;

public interface GradeDAO {
	// C 성적표 등록 
		public void insert(GradeBean gradeBean); // 추상 메소드
		// R 성적표 리스트 출력
		public ArrayList<MemberGradeBean> selectAll();
		// R 성적표 조회(학번)
		public MemberGradeBean selectGradeByHak(int hak);
		// R 성적표 조회(이름)
		public Vector<MemberGradeBean> selectGradesById(String name);
		// R 카운트 조회
		public int count();
		// U 성적표 수정
		public String update(GradeBean grade);
		// D 성적표 삭제
		public String delete(int hak);
	
}
