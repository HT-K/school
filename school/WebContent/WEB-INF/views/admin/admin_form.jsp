<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="admin_header.jsp"/>
<div class="container" style="width: 1000px; margin: 0 auto;"> <!-- container -> 부트스트랩에서 이미 선언되어있는 클래스  -->
	<div class="row display-table">
		<div class="col-xs-12 col-sm-4 display-cell"> <!-- 아래 리스트목록을 출력하기 위한 블록 크기 설정 클래스 -->
			<ul class="nav nav-pills nav-stacked"> <!-- 리스트 목록에 상자 효과를 주는 CSS 클래스다. -->
				<li class="dropdown active"><a onclick="adm.allList()">전체회원 목록보기</a></li> <!-- 각 리스트에 파란색배경이 들어가게 해주는 CSS 클래스다. -->
				<li class="dropdown active"><a onclick="adm.idSearch()">ID로 회원검색</a></li>
				<li class="dropdown active"><a onclick="adm.nameSearch()">이름으로 회원검색(동명 허용)</a></li>
				<li class="dropdown active"><a onclick="adm.insertScore()">학생 점수 입력</a></li>

				<!-- <button onclick="opr.sysout()">배열출력</button> <input type="button" value="배열출력" /> 이것도 왼쪽과 같지만 html5에서는 이 방식을 추천하지 않는다.
				<button onclick="opr.score()">점수출력</button>
				<button onclick="opr.grade()">성적출력</button>
				<button onclick="opr.grade()">성적출력</button>
				<button onclick="opr.grade()">성적출력</button>
				<button onclick="opr.grade()">성적출력</button> -->
			</ul>
		</div>
		<div class="col-xs-12 col-sm-8 display-cell" id="result" style="border: 1px solid black;height: 500px"> <!-- 결과창을 보여주기 위한 블록 크기를 설정하는 CSS 클래스다. -->
        text
    	</div>
	</div>
</div>
<script type="text/javascript">
	var adm = {
		allList : function() {	
			
		}
	}
</script>
