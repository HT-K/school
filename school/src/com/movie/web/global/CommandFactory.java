package com.movie.web.global;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandFactory { // Factory Pattern , new라는 생성자를 쓰는 것을 감춰라
	public static Command getCommand(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getServletPath(); // /member/login_form.do ==> 이것을 받아온다.
		String[] tmp = path.split("/"); // /member/login_form.do을 "/"로 구분해서 문자열들을 저장

		String directory = tmp[1]; // == path.split("/")[1]; // member 를 저장
		String action = tmp[2].substring(0, tmp[2].indexOf(".")); // login_form 을 저장

		System.out.println("디렉토리 :" + directory);
		System.out.println("액션 :" + action);
		
		Command c = new Command(directory, action);
		return c;
	}
	
}
