package com.movie.web.member;

import java.util.HashMap;
import java.util.Map.Entry;

public class MemberServiceImpl implements MemberService {
	HashMap<String, MemberBean> map;
	MemberDAO dao = new MemberDAOImpl(); // MemberDAO 인터페이스를 구현한 MemberDAOImpl 객체 생성
	
	public MemberServiceImpl() {
		map = new HashMap<String, MemberBean>();
	}
	
	@Override
	public void join(MemberBean member) {
		// 회원가입
		map.put(member.getId(), member); // 키 값으로 id Value로 member객체를 넣는다.
	}

	@Override
	public MemberBean login(String id, String password) {
		// 로그인
		// 아이디가 존재하지 않아서 실패한 경우와 비번이 틀려서 실패한 경우에 따라서 메시지를 전달해줘야함
		MemberBean member = new MemberBean();
		
		if (!dao.isMember(id)) { //id가 없는 경우
			return null;
		}
		
		// id가 db에 있는 경우
		member = dao.selectMember(id); // 해당 id를 가진 사용자의 모든 정보를 가져와서 bean 객체에 넣는다.
		if (member.getPassword().equals(password)) { // 비밀번호 확인
			return member; // id도 있고 비번이 같은 경우
		} else {
			return null;
		}
	}
		
	
	@Override
	public MemberBean detail(String id) {
		// 내 정보보기
		MemberBean member = dao.selectMember(id); // MemberDAOImpl 클래스에 구현한 selectMember 메소드를 호출하여 데이터베이스에서 MemberBean 객체에 내용을 넣어서 받아온다.
		return member;
	}

	@Override
	public MemberBean update(MemberBean member) {
		// 수정
		map.replace(member.getId(), member);
		return member;
	}

	@Override
	public MemberBean remove(String id) {
		// 삭제
		
		MemberBean member = map.remove(id);
		return member;
	}

	@Override
	public boolean isMember(String id) {
		return dao.isMember(id);
	}
}
