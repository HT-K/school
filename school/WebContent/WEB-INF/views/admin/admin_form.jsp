<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="admin_header.jsp"/>
<div class="container" style="width: 1000px; margin: 0 auto;"> <!-- container -> 부트스트랩에서 이미 선언되어있는 클래스  -->
	<div class="row display-table">
		<div class="col-xs-12 col-sm-4 display-cell"> <!-- 아래 리스트목록을 출력하기 위한 블록 크기 설정 클래스 -->
			<ul id="admin_sidebar" class="nav nav-pills nav-stacked"> <!-- 리스트 목록에 상자 효과를 주는 CSS 클래스다. -->
				<li><a onclick="admin.memberList()">전체학생 목록보기</a></li> <!-- 각 리스트에 파란색배경이 들어가게 해주는 CSS 클래스다. -->
				<li><a onclick="admin.gradeList()">전체학생 성적보기</a></li> <!-- 각 리스트에 파란색배경이 들어가게 해주는 CSS 클래스다. -->
				<li><a onclick="admin.searchById()">ID로 학생검색</a></li>
				<li><a onclick="admin.searchByName()">이름으로 학생검색(동명 허용)</a></li>
				<li><a onclick="admin.addScore()">학생 점수 입력</a></li>
			</ul>
		</div>
		<div class="col-xs-12 col-sm-8 display-cell" id="result" style="border: 1px solid black;height: 500px"> <!-- 결과창을 보여주기 위한 블록 크기를 설정하는 CSS 클래스다. -->
        	<jsp:include page="../member/member_list.jsp"/> <!-- 디폴트로 전체학생 목록을 보여줌!!!  -->
    	</div>
	</div>
</div>
<script src="${context}/resources/js/admin.js"></script>
<script type="text/javascript">
$(document).ready(function() { // 메인 메소드 같은 존재라고 생각하면 편하다.
	$('#admin_sidebar').children().first().addClass('dropdown active'); 
	$('#admin_sidebar').children().click(function() {
		$(this).addClass('dropdown active');
		$(this).siblings().removeClass('dropdown active');
	});
	
/* 	var admin = {
			memberList : function() {
				$('#result').load('')
				//$('#result').html($('<jsp:include/>',page="member_list.jsp"));
			}
	} */
});
</script>