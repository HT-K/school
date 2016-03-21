package com.movie.web.global;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/global/main.do")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Command command = CommandFactory.getCommand(request, response);
		String action = command.getAction();
		
		switch (action) {
			case "main":
				command.setView(command.getDirectory(), "main");
				break;
	
			default:
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(command.getView()); // ~~~.jsp가 파라미터로 넘어감
		//request.getRequestDispatcher(new Command(result[0], result[1]).getView()); // login_form.jsp에																									// 내용전달
		dis.forward(request, response); // 페이지 이동, 위에서 지정한 URL (~~~~.jsp)로 페이지를 이동한다 (request와 response 객체를 가지고)
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
