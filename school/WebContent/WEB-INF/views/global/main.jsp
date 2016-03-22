<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<div class = "mg_auto" style="width: 1000px;">
	메인 홈 <br />
	<a href="${context}/member/login_form.do"> 로그인 화면 이동</a>
	<div><h4>아이디가 없으면, 계정을 생성하시오</h4>
		<a href="${context}/member/join_form.do">회원가입</a>
	</div>
</div>
<jsp:include page="footer.jsp" />
