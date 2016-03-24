<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div class="container" style="width: 1000px; margin: 0 auto;"> <!-- container -> 부트스트랩에서 이미 선언되어있는 클래스  -->
	<div class="row display-table">
		<div class="col-xs-12 col-sm-4 display-cell">
			<ul class="nav nav-pills nav-stacked">
				<li class="dropdown active"><a onclick="opr.sysout()">배열출력</a></li>
				<li class="dropdown active"><a onclick="opr.sysout()">점수출력</a></li>
				<li class="dropdown active"><a onclick="opr.sysout()">성적출력</a></li>
				<li class="dropdown active"><a onclick="opr.sysout()">성별출력</a></li>
				<li class="dropdown active"><a onclick="opr.sysout()">가장 큰 수 출력</a></li>
				<li class="dropdown active"><a onclick="opr.sysout()">구구단 출력</a></li>
				<li class="dropdown active"><a onclick="opr.sysout()">홀수 합 출력</a></li>

				<button onclick="opr.sysout()">배열출력</button> <!-- <input type="button" value="배열출력" /> 이것도 왼쪽과 같지만 html5에서는 이 방식을 추천하지 않는다. -->
				<button onclick="opr.score()">점수출력</button>
				<button onclick="opr.grade()">성적출력</button>
				<button onclick="opr.grade()">성적출력</button>
				<button onclick="opr.grade()">성적출력</button>
				<button onclick="opr.grade()">성적출력</button>
			</ul>
		</div>
	</div>
</div>
<script type="text/javascript">
var opr = {
	sysout : function() {
		var arr = ['사과', '배', '감', '귤'];
		for ( var i in arr) {
			console.log(arr[i] + '\t');
		}
	},
	score : function() {
		var result = ''; // 초기화 시키기
		var avengers = [];
		avengers.push({name : '아이언', kor : 90, eng : 90, math : 90});
		avengers.push({name : '헐크', kor : 80, eng : 80, math : 80});
		avengers.push({name : '캡아', kor : 70, eng : 70, math : 70});
		
		for ( var i in avengers) {
			avengers[i].getSum = function() {
				return this.kor + this.eng + this.math;
			}
			avengers[i].getAvg = function() {
				return avengers[i].getSum() / 3; // this.getSum() / 3; 도 된다.
			}
			console.log("이름 : " +avengers[i].name + " 합계 =" + avengers[i].getSum() + " 평균 = " + avengers[i].getAvg() + "<br/>");
		}
		result = '========== 어벤져스 성적표 ===========\n';
		result += '이름\t국어\t영어\t수학\t총점\t평균\n';
		result += '--------------------------------\n';
		for ( var i in avengers) {
			{
				with(avengers[i]){
					result += name + ':\t' + kor + ':\t' + eng + ':\t' + math + ':\t' + getSum() + ':\t' + getAvg() + '\n';
				}
			}
		}
		console.log(result);
		/* 
		with 키워드는 배열에 담긴 하나의 객체를 의미한다. 예를 들어 var iron = {name : '아이언', kor : 90, eng : 90, math : 90}
		이렇게 선언되 하나의 객체를 avengers.push(iron) 이라고 줄 경우
		출력문에서 with를 사용하지 않는다면 iron.name 이런식으로 하나씩 명시해야 하기 떄문에 with를 사용한다.
		*/
	},
	grade : function() {
		/*
			평균
			90이상 A
			80 B
			70 C
			60 D
			미만 F
		*/
		var kor = prompt('국어점수'),eng = prompt('국어점수'), math = prompt('국어점수');
		var avg = (kor + eng + math) / 3;
		if (avg >= 90) {
			console.log("성적 = A");
		} else if (avg >= 80) {
			console.log("성적 = B");
		} else if (avg >= 70) {
			console.log("성적 = C");
		} else if (avg >= 60) {
			console.log("성적 = D");
		} else {
			console.log("성적 = F");
		}
	},
	gender : function() {
		/* 
		800101-1234567 일 경우 flag 값은 1 이다라고 정의함
		*/
		var flag = 4; // 라면 성별을 판별하는 로직을 switch - case 로 완성하시오
		// 자바의 switch case 와 동일
		
		var result = '';
		
		switch (flag) {
		case 1 :
			result = '남자';
			break;
		case 2 :
			result = '여자';
			break;
		case 3 :
			result = '남자';
			break;
		case 4 :
			result = '여자';
			break;
		default:
			console.log("잘못입력했어");
			return;
		}
		console.log('주민등록번호 판별 결과 = ' + result);
	},
	bigNum : function() {
		/* 80, 70, 60 일 경우 if 문으로 최대값 을 구하는 로직을 완성하시오 */ 	
		var a = 80, b = 70, c = 60;
		var bigNum = 0;
		
		if (a > b && a > c) {
			bigNum = a;
		} else if (b > a && b > c) {
			bigNum = b;
		} else {
			bigNum = c;
		}
		
		console.log("가장 큰 수 = " + bigNum);
	},
	gugudan : function() {
		var i=1,j=7;
		for (var int = i; int < 10; i++) {
			// 7단 구구단을 출력하시오
			console.log(j + "*" + i + " = " + i*j + "\n");
		}
	},
	sum1to100 : function() {
		var sum=0,i=0;
		while (i <= 100) {
			/* 1부터 100까지의 합을 출력하시오*/
			sum += i;
			i++;
		}
		console.log("1부터 100까지의 합 = " + sum);
	},
	oddSum : function() {
		var oddSum=0,evenSum=0, limit=prompt('홀수 짝수의 합을 구하기 위한 한계 값 입력');
		for (var int = 0; int < 100; int++) {
			// 1부터 100 까지 수 중에서 홀수의 합 oddSum 과 
			// 짝수들의 합 evenSum 을 구하시오
		}
	}
}
</script>