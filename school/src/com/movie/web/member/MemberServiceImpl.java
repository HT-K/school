package com.movie.web.member;

import java.util.HashMap;
import java.util.Map.Entry;

public class MemberServiceImpl implements MemberService {
	HashMap<String, MemberBean> map;
	MemberDAO dao = MemberDAOImpl.getInstance(); // 싱글톤패턴으로 생성한 객체를 가져온다 (이렇게 호출하면 생성한 하나의 객체를 가지고 다른 곳에서도 호출할 수 있다.)
	private static MemberService instance = new MemberServiceImpl(); // 싱글톤 패턴으로 객체를 사용하기 위함.
	
	/*MemberDAO dao = new MemberDAOImpl(); // MemberDAO 인터페이스를 구현한 MemberDAOImpl 객체 생성, 싱글톤 패턴 전에는 이렇게 썼다.*/	
	
	public static MemberService getInstance() {
		return instance;
	}


	public MemberServiceImpl() {
		map = new HashMap<String, MemberBean>();
	}
	
	@Override
	public int join(MemberBean member) {
		// 회원가입
		return dao.insert(member); // 입력받은 회원양식의 값들을 MemberBean 객체인 member에 set 한 후 이곳으로 가져와서 다시 dao에 넘긴다.
	}

	@Override
	public MemberBean login(String id, String password) {
		// 로그인
		// 아이디가 존재하지 않아서 실패한 경우와 비번이 틀려서 실패한 경우에 따라서 메시지를 전달해줘야함
		MemberBean member = new MemberBean();
		
/*		if (!dao.isMember(id)) { //id가 없는 경우
			return null;
		}*/
		
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
	public int update(MemberBean member) {
		// 수정
		return dao.update(member);
	}

	@Override
	public int remove(String id) {
		// 삭제
		return dao.delete(id);
		
		
		/*MemberBean member = map.remove(id);
		return member;*/
	}

	@Override
	public boolean isMember(String id) {
		return dao.isMember(id);
	}
}
