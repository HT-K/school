package com.movie.web.grade;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.member.MemberBean;
import com.movie.web.member.MemberService;
import com.movie.web.member.MemberServiceImpl;

/**
 * Servlet implementation class GradeController
 */
@WebServlet("/grade/my_grade.do")
public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GradeService service = GradeServiceImpl.getInstance(); // 싱글톤 패턴을 사용하여 이미 생성된 GradeServiceImpl 객체를 가져와서 사용함
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Command command = CommandFactory.getCommand(request, response);
		String action = command.getAction();
		
		/*GradeService service = new GradeServiceImpl(); // 싱글톤 패턴 적용 전에는 이렇게 doGet메소드 안에서 서비스 객체를 생성해서 사용했음 */		
		GradeBean grade = new GradeBean();
		
		switch (action) {
		case "my_grade":
			grade = service.getGradesById(request.getParameter("id")); // detail.jsp 에서 my_grade.do 를 호출할 떄 id 값이 같이 넘어온다.
			request.setAttribute("score", grade); // id를 이용하여 데이터베이스에서 성적을 담아서 온 GradeBean객체를 score라는 이름으로 참조할 수 있도록 request 객체에 담는다.
			command.setView(command.getDirectory(), "my_grade");
			break;

		default:
			break;
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(command.getView()); // ~~~.jsp가 파라미터로 넘어감																							// 내용전달
		dis.forward(request, response); // 페이지 이동, 위에서 지정한 URL (~~~~.jsp)로 페이지를 이동한다 (request와 response 객체를 가지고)
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
