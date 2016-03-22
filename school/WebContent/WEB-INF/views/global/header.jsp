<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<header style="width: 100%; margin: 0 auto"> <!-- 헤더 부분 설정, 보통 사이트 이미지로고와 login, mypage 등과 같은 것들이 작은 메뉴로 들어간다. -->
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<h3 style="color: white; text-align: center;">
				<a href="${context}/global/main.do">한빛 성적 관리</a>
			</h3>
		</div>
	</nav>
</header>
