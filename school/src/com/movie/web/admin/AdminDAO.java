package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.MemberGradeBean;
import com.movie.web.member.MemberBean;

public interface AdminDAO {
	public List<MemberGradeBean> selectMemGraList(); // 학생과, 성적 목록을 전부 가져온다
	public int insertScore(GradeBean gradeBean); // 여기서 id 값 이용, 성적 입력
	public List<MemberBean> selectMemList();
	public AdminBean selectAdmin(AdminBean admin);
}
