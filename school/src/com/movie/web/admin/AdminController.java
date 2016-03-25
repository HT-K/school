package com.movie.web.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.grade.GradeBean;
import com.movie.web.grade.MemberGradeBean;
import com.movie.web.member.MemberBean;

@WebServlet({"/admin/admin_form.do", "/admin/member_list.do"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GradeBean gradeBean = new GradeBean();
	AdminService service = AdminServiceImpl.getService();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Command command = CommandFactory.getCommand(request, response);
		//MemberGradeBean bean = new MemberGradeBean();
		List<MemberGradeBean> listBean = new ArrayList<MemberGradeBean>();
		List<MemberBean> memList = new ArrayList<MemberBean>();
		
		System.out.println("command.directory() = " + command.getDirectory());
		System.out.println("command.action() = " + command.getAction());
		
		switch (command.getAction()) {
		case "admin_form" :
			listBean = service.getMemberList();
			request.setAttribute("list", listBean);
			command.setView(command.getDirectory(), "admin_form");
			break;
		default:
			break;
		}	
		DispatcherServlet.goNextPage(request, response, command.getView());
	}
}
