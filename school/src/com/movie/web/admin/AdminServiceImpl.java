package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.MemberGradeBean;
import com.movie.web.member.MemberBean;

public class AdminServiceImpl implements AdminService {
	private static AdminService service = new AdminServiceImpl();
	AdminDAO dao = AdminDAOImpl.getInstance();
	
	public static AdminService getService() {
		return service;
	}

	@Override
	public List<MemberGradeBean> getMemGraList() {
		return dao.selectMemGraList();
	}

	@Override
	public int addScore(GradeBean gradeBean) {
		return dao.insertScore(gradeBean);
	}

	@Override
	public List<MemberBean> getMemList() {
		// TODO Auto-generated method stub
		return dao.selectMemList();
	}

	@Override
	public AdminBean getAdmin(AdminBean admin) {
		// TODO Auto-generated method stub
		return dao.selectAdmin(admin);
	}


}
