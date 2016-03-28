<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table border="1" style="width: 90%; text-align: center">
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<!-- <th>전공</th>
		<th>수강과목</th> -->
		<th>주소</th>
		<th>생년월일</th>
	</tr>
	<c:forEach var="member" items="${list}"> <!-- 컨트롤러에서 보내온 list를 member에 담는다 -->
		<tr>
			<td>${member.id}</td>
			<td>${member.name}</td>
			<%-- <td>${member.major}</td>
			<td>${member.subjects}</td> --%>
			<td>${member.addr}</td>
			<td>${member.birth}</td>
		</tr>
	</c:forEach>
</table>