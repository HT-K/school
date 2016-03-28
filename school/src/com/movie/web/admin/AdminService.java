package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.MemberGradeBean;
import com.movie.web.member.MemberBean;

public interface AdminService {
	public List<MemberGradeBean> getMemGraList(); // 학생과, 성적 목록을 전부 가져온다
	public int addScore(GradeBean gradeBean); // 여기서 id 값 이용
	public List<MemberBean> getMemList();
	public AdminBean getAdmin(AdminBean admin);
}
