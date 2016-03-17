package com.movie.web.grade;

import java.util.Vector;

public class GradeServiceImpl implements GradeService{
	// 멤버 필드 (속성을 모아놓은 부분)
	Vector<GradeBean> gradeList; // 메소드들이 공유를 해야해서 멤버 필드 영역에 선언해야 한다. (인스턴스 변수라 한다) , 인스턴스 변수 멤버 필드 영역에서 초기화를 하지 않는다. 따라서 아래 생성자와 같이 메소드에서 초기화해주는게 좋다!
	GradeBean grade;
	public GradeServiceImpl() {
		gradeList = new Vector<GradeBean>(); // 초기화
	}
	
	// 멤버 메소드 에어리어
	@Override
	public void input(GradeBean gradeBean) { // gradeBean -> 지역변수의 일종으로 매개변수 혹은 파라미터라고 부름
		// C 성적표 등록
		gradeList.add(gradeBean);
	}

	@Override
	public Vector<GradeBean> getList() { // 서비스에서 syso를 하는게 아니라 Controller로 gradeList를 던져주면 된다!
		// R 성적표 리스트 출력
		return gradeList;
	}

	@Override
	public GradeBean getGradeByHak(int hak) {
		// R 성적표 조회(학번)
		for (GradeBean temp : gradeList) {
			if (temp.getHak() == hak) {
				return temp;
			}
		}
		return null;
	}

	@Override
	public Vector<GradeBean> getGradesByName(String name) {
		// R 성적표 조회(이름)
		Vector<GradeBean> tmpVec = new Vector<GradeBean>();
		
		for (GradeBean temp : gradeList) {
			if (temp.getName().equals(name)) {
				tmpVec.add(temp); // 매개변수로 넘어온 name 값을 가진 GradeBean객체를 tmpVec벡터에 저장한다.
			}
		}
		return tmpVec;
	}

	@Override
	public int getCount() {
		// R 카운트 조회
		return gradeList.size();
	}

	@Override
	public String update(GradeBean grade) {
		// U 성적표 수정
		/*for (int i = 0; i < gradeList.size(); i++) {
			if (gradeList.get(i).getHak() == grade.getHak()) {
				gradeList.get(i).setJava(grade.getJava());
				gradeList.get(i).setSql(grade.getSql());
				gradeList.get(i).setJsp(grade.getJsp());
				gradeList.get(i).setSpring(grade.getSpring());
				return "수정성공";
			}
		}
		return "수정하려는 학번이 존재하지 않습니다.";*/
		
		
		/*//for - each 문을 이용한 수정
		for (GradeBean temp : gradeList) {
			if (temp.getHak() == grade.getHak()) {
				gradeList.remove(temp);
				gradeList.add(grade);
				return "수정성공";
			}
		}
		return "수정실패";*/
		
		//for - each 방법2
		for (GradeBean temp : gradeList) {
			if (temp.getHak() == grade.getHak()) {
				int index = gradeList.indexOf(temp); // 매개변수로 받아온 grade의 학번과 같은 학번을 가진 객체를 찾으면 그 객체의 index번호를 찾아낸다. 그 후 그 객체의 성적을 수정!
				gradeList.get(index).setJava(grade.getJava());
				gradeList.get(index).setSql(grade.getSql());
				gradeList.get(index).setJsp(grade.getJsp());
				gradeList.get(index).setSpring(grade.getSpring());
				return "수정성공";
			}
		}
		return "수정실패";
	}

	@Override
	public String delete(int hak) {
		// D 성적표 삭제
		for (GradeBean temp : gradeList) {
			if (temp.getHak() == hak) {
				gradeList.remove(temp);
				return "삭제성공";
			}
		}
		return "삭제실패";
	}

}