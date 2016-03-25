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
import com.movie.web.global.DispatcherServlet;

@WebServlet({"/member/login_form.do", "/member/join_form.do", "/member/login.do", 
	"/member/detail.do", "/member/logout.do", "/member/join.do", 
	"/member/update_form.do", "/member/update.do", "/member/delete.do", "/member/admin.do"}) // xml과 연결됨, 이렇게 배열 형식으로 서블릿을 지정한다.
public class MemberController extends HttpServlet { // HttpServlet 클래스를 상속받아 만들어진 클래스.
	private static final long serialVersionUID = 1L;
	MemberService service = MemberServiceImpl.getInstance(); // 싱글톤 패턴으로 MemberServiceImpl 객체를 가져온다.
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Command command = CommandFactory.getCommand(request, response); // 받아온 URL을 쪼개는 메소드 호출
		MemberBean member = new MemberBean(); // 멤버 빈은 사용자마다 달라야 하므로 doGet 혹은 doPost가 호출될 때 마다 생성되어야 하므로 싱글톤 패턴으로 하면 안된다.

		switch (command.getAction()) { // URI에서 action만 받아온다.
		case "update_form":
			System.out.println("===수정폼으로 이동완료===");
			request.setAttribute("member", service.detail(request.getParameter("id")));
			command.setView(command.getDirectory(), "update_form");
			break;
		case "delete":
			System.out.println("===탈퇴완료===");
			if (service.remove(request.getParameter("id")) == 1) {
				System.out.println("탈퇴성공");
				command.setView("global", "main");
			} else {
				System.out.println("탈퇴 실패");
			}
			break;
		case "logout":
			command.setView(command.getDirectory(), "login_form");
			break;
		case "admin":
			command.setView(command.getDirectory(), "admin");
			break;
		case "login":
			System.out.println("로그인");
			/*
			 * if (service.login(request.getParameter("id"),
			 * request.getParameter("password")) == null) { System.out.println(
			 * "로그인 실패"); request.setAttribute("message", "비밀번호가 일치하지 않습니다.");
			 * command.setView(command.getDirectory(), "login_form"); } else {
			 * System.out.println("로그인 성공"); request.setAttribute("member",
			 * service.login(request.getParameter("id"),
			 * request.getParameter("password"))); // request 객체에 MemberBean 객체를
			 * 담아서 detail.jsp 페이지로 보낸다. command.setView(command.getDirectory(),
			 * "detail"); // id와 비번 둘다 정확할 경우 }
			 */

			if (service.isMember(request.getParameter("id"))) { // 입력받은 id 값이데이터베이스에 있는지없는지 검사
				if (service.login(request.getParameter("id"), request.getParameter("password")) == null) { // id는 데이터베이스에있으나비번이다를경우
					command.setView(command.getDirectory(), "login_form");
					// request.setAttribute("message", "비밀번호가 틀립니다");
					// command.setView(command.getDirectory(), "login_fail");
				} else {
					request.setAttribute("member", service.login(request.getParameter("id"), request.getParameter("password")));
					command.setView(command.getDirectory(), "detail"); // id와 비번
																		// 둘다
																		// 정확할
																		// 경우
				}
			} else {
				request.setAttribute("message", "아이디가 없습니다");
				command.setView(command.getDirectory(), "login_fail");
			}
			break;
		case "join":
			member.setId(request.getParameter("id")); // join_form.jsp에서 받아온 값들을
														// member 객체에 저장해서
														// service.join에 보낸다.
			member.setPassword(request.getParameter("password"));
			member.setName(request.getParameter("name"));
			member.setAddr(request.getParameter("addr"));
			member.setBirth(Integer.parseInt(request.getParameter("birth")));
			if (service.join(member) == 1) {
				command.setView(command.getDirectory(), "login_form");
			} else {
				command.setView(command.getDirectory(), "join_form");
			}
			break;
		case "update": // 업데이트 폼에서 업데이트 완료 시 다시 디테일로 가서 변경된 정보를 보여줘야 한다.
			System.out.println("===업데이트 완료===");
			member.setId(request.getParameter("id")); // 업데이트 폼에서 변경된 정보를 가지고 와서
														// MemberBean 객체에 저장
			member.setPassword(request.getParameter("password"));
			member.setName(request.getParameter("name"));
			member.setAddr(request.getParameter("addr"));
			member.setBirth(Integer.parseInt(request.getParameter("birth")));

			if (service.update(member) == 1) {
				request.setAttribute("member", member); // 변경된 값을 request 객체를 통해
														// 다음 페이지로 보낸다.
				command.setView(command.getDirectory(), "detail");
			} else {
				request.setAttribute("member", member); // 변경된 값을 request 객체를 통해
														// 다음 페이지로 보낸다.
				command.setView(command.getDirectory(), "update_form");
			}
			break;
		default:
			System.out.println("오류");
		}

		DispatcherServlet.goNextPage(request, response, command.getView());
	}
}
