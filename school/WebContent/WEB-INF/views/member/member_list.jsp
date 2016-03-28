<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <table border="1" style="width: 90%; text-align: center">
      <tr>
         <td>scoreSeq</td>
         <td>아이디</td>
         <td>이름</td>
         <td>비밀번호</td>
         <td>주소</td>
         <td>생년월일</td>
         <td>자바</td>
         <td>SQL</td>
         <td>JSP</td>
         <td>스프링</td>
      </tr>
      <c:forEach var="list" items="${list}">
         <tr>
            <td>${list.score_seq}</td>
            <td>${list.id}</td>
            <td>${list.name}</td>
            <td>${list.password}</td>
            <td>${list.addr}</td>
            <td>${list.birth}</td>
            <td>${list.java}</td>
            <td>${list.sql}</td>
            <td>${list.jsp}</td>
            <td>${list.spring}</td>
         </tr>
      </c:forEach>
   </table>
   </center>