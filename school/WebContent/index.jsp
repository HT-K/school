<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="context" value="<%=request.getContextPath() %>"></c:set>

<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>메인 화면</title>
</head>
<body>
	<body>
	<a href="${context}/member/Login_form.do">로그인 화면 이동</a> <!-- 이 전체를 url이라고 하고 /member/Login_form.do는 uri라고 한다.  -->
</body>
</body>
</html>
