package com.movie.web.member;

public interface MemberDAO { // void 타입이 존재하지 않는다.
	public int insert(MemberBean member);
	public MemberBean selectById(String id, String password);
	public MemberBean selectMember(String id);
	public int update(MemberBean member);
	public int delete(String id);
	public boolean isMember(String id); //회원인지 아닌지 검사
}
