package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.MemberGradeBean;

public interface AdminService {
	public List<MemberGradeBean> getMemberList(); // 학생의 리스트 목록을 가져온다
	public int addScore(GradeBean gradeBean); // 여기서 id 값 이용
}
