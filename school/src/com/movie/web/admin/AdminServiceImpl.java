package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.MemberGradeBean;

public class AdminServiceImpl implements AdminService {
	private static AdminService service = new AdminServiceImpl();
	AdminDAO dao = AdminDAOImpl.getInstance();
	
	public static AdminService getService() {
		return service;
	}

	@Override
	public List<MemberGradeBean> getMemberList() {
		return dao.selectMemberList();
	}

	@Override
	public int addScore(GradeBean gradeBean) {
		return dao.insertScore(gradeBean);
	}

}
