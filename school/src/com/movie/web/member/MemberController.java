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

@WebServlet({"/member/login_form.do", "/member/join_form.do", "/member/login.do", 
	"/member/detail.do", "/member/logout.do", "/member/admin.do"}) // xml과 연결됨, 이렇게 배열 형식으로 서블릿을 지정한다.
public class MemberController extends HttpServlet { // HttpServlet 클래스를 상속받아
													// 만들어진 클래스.
	private static final long serialVersionUID = 1L;

	// 페이지 이동시에는 doGet (데이터 전달 없이)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Command command = CommandFactory.getCommand(request, response); // 받아온 URL을 쪼개는 메소드 호출
		String action = command.getAction(); // URI에서 action만 받아온다.
		
		MemberService service = new MemberServiceImpl();
		
		switch (action) {
			case "login_form" : 
				break;
			case "join_form" :
				break;
			case "login" :
				System.out.println("로그인");
				if (service.login(request.getParameter("id"), request.getParameter("password")) == null) {
					System.out.println("로그인 실패");
					command.setView(command.getDirectory(), "login_form");
				} else {
					System.out.println("로그인 성공");
					request.setAttribute("member", service.login(request.getParameter("id"), request.getParameter("password"))); // request 객체에 MemberBean 객체를 담아서 detail.jsp 페이지로 보낸다.
					command.setView(command.getDirectory(), "detail"); // id와 비번 둘다 정확할 경우
				}
				
				/*if (service.isMember(request.getParameter("id"))) { // 입력받은 id 값이 데이터베이스에 있는지 없는지 검사
					if (service.login(request.getParameter("id"), request.getParameter("password")) == null) { // id는 데이터베이스에 있으나 비번이 다를 경우
						command.setView(command.getDirectory(), "login_form");
					} else {
						command.setView(command.getDirectory(), "detail"); // id와 비번 둘다 정확할 경우
					}
				}*/
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
		dis.forward(request, response); // 페이지 이동, 위에서 지정한 URL (~~~~.jsp)로 페이지를 이동한다 (request와 response 객체를 가지고 지정된 페이지로 이동한다.)
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
