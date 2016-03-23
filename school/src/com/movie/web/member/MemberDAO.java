package com.movie.web.member;

public interface MemberDAO {
	public void insert(MemberBean member);
	public MemberBean selectById(String id, String password);
	public MemberBean selectMember(String id);
	public MemberBean update(MemberBean member);
	public void delete(String id);
	public boolean isMember(String id); //회원인지 아닌지 검사
}
