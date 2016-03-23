package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.MemberGradeBean;

public interface AdminDAO {
	public List<MemberGradeBean> selectMemberList(); // 학생의 리스트 목록을 가져온다
	public int insertScore(GradeBean gradeBean); // 여기서 id 값 이용, 성적 입력
}
