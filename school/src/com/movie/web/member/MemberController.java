package com.movie.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.Constants;

@WebServlet({"/member/login_form.do", "/member/join_form.do", "/member/login.do", "/member/detail.do", "/member/logout.do", "/member/admin.do"}) // xml과 연결됨, 이렇게 배열 형식으로 서블릿을 지정한다.
public class MemberController extends HttpServlet { // HttpServlet 클래스를 상속받아
													// 만들어진 클래스.
	private static final long serialVersionUID = 1L;

	// 페이지 이동시에는 doGet (데이터 전달 없이)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Command command = CommandFactory.getCommand(request, response);
		String action = command.getAction();
		
		switch (action) {
			case "login_form" : 
				break;
			case "join_form" :
				break;
			case "login" :
				command.setView(command.getDirectory(), "detail");
				break;
			case "detail" :
				break;	
			case "logout" :
				command.setView(command.getDirectory(), "login_form");
				break;
			case "admin" :
				command.setView(command.getDirectory(), "admin");
				break;
			default :
				System.out.println("오류");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(command.getView()); // ~~~.jsp가 파라미터로 넘어감
		//request.getRequestDispatcher(new Command(result[0], result[1]).getView()); // login_form.jsp에																									// 내용전달
		dis.forward(request, response); // 페이지 이동, 위에서 지정한 URL (~~~~.jsp)로 페이지를 이동한다 (request와 response 객체를 가지고)
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
