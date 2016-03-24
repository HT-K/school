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
		<h3 style="color: white; text-align: center;">
			<a href="${context}/global/main.do">한빛 성적 관리</a>
		</h3>
		<ul class="nav nav-pills">
			<li role="presentation" class="dropdown" style="margin-left: 100px">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"> 
					자바스크립트<span class="caret"></span>
				</a>
				<ul class="dropdown-menu"> <!-- 리스트 목록을 만들기 위한 ul과 li, ul에 부트스트랩에 이미 들어있는 클래스를 사용해서 이쁘게 나오게 효과를 준다. -->
					<li><a href="${context}/js/hello.do">자바스크립트 소개</a></li>
					<li><a href="${context}/js/var.do">변수</a></li>
					<li><a href="${context}/js/operator.do">연산자</a></li>
					<li><a href="${context}/js/function.do">함수</a></li>
					<li><a href="${context}/js/object.do">객체</a></li>
					<li><a href="${context}/js/bom.do">BOM</a></li>
					<li><a href="${context}/js/dom.do">DOM</a></li>
					<li><a href="${context}/js/form.do">form 태그</a></li>
					<li><a href="${context}/js/closure.do">클로저</a></li>
					<li><a href="${context}/js/pattern.do">패턴</a></li>
				</ul>
			</li>
		</ul>
	</header>
