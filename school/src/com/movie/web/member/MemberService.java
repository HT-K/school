package com.movie.web.member;

import java.util.HashMap;

public interface MemberService {
	//인터페이스는 추상메소드만 와야한다는 규칙이 있어서 abstract를 생략가능하다
	//그러나 추상클래스는 구상메소드 즉 {}이 포함된 메소드 존재가 가능하므로 둘을 구분하기 위해서 반드시 abstract를 붙여야한다.
	public void join(MemberBean member);
	public MemberBean login(String id, String password) throws Exception;
	public MemberBean detail(String id);
	public MemberBean update(MemberBean member);
	public MemberBean remove(String id);
}
