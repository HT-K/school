<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="admin_header.jsp"/>

<form style="margin-left: 40%">
	<input type="text" id="id" name="id"/>
	<input type="text" id="password" name="password"/>
	<button id="admin_login_btn" >관리자 로그인</button>
</form>

<script>
	$(function() {
		$('#admin_login_btn').click(function() {
			$('form').attr('action','${context}/admin/admin_login.do').submit();
		});
	});
</script>