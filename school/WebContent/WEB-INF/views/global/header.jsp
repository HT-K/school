<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.Calendar, java.util.Date" %>
<c:set var="now" value="<%= new java.util.Date() %>"></c:set>
<% // 이렇게 쓰는 방식은 모델1 방식이다. , 스크립트 릿은 맨 위 상단에 디렉토리 에서만 써야 모델2 방식이다.
	Calendar cal = Calendar.getInstance();
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH) + 1;
	int date = cal.get(Calendar.DATE);
%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>성적관리</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script> <!-- 부트스트랩 홈페이지에서 CDN으로 가져온다. -->
</head>

<body>
<c:choose>
	<c:when test="${user.level = 'admin'}">
		<jsp:include page="../admin/admin_header.jsp"/>
	</c:when>
	<c:otherwise>
		<jsp:include page="../member/member_header.jsp"/>
	</c:otherwise>
</c:choose>

<%-- <c:choose>
	<c:when test="empty sessionScope.user"> <!-- 세션 객체를 검사해서 값이 있으면 when 실행, 없으면 otherwise 실행 -->
		<jsp:include page="../global/default_header.jsp" />
	</c:when>
	<c:otherwise>
		<c:choose> <!-- if - else 문을 쓰기 위한 태그  -->
			<c:when test="${user.level eq 'admin'}"> <!-- user.level이 admin이면~  -->
				<jsp:include page="../admin/admin_header.jsp" /> <!-- 관리자 헤더페이지를 띄워주고 -->
			</c:when>
			<c:otherwise>
				<jsp:include page="../member/member_header.jsp" /> <!-- 유저 레벨이 admin이 아니면 멤버 헤더 페이지를 띄워준다. -->
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose> --%>
