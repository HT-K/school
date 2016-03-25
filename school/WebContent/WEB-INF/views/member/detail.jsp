<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
<div id="detail">
		<div class="joinTop">
			<h2 class="text-center">회원상세정보</h2>
		</div>
		<div class="joinCenter row">
			<form>
				<fieldset class="joinField">
					<div class="form-group">
					 	<label for="input_id" class="col-sm-4 control-label">아이디</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id" value="${member.id}" readonly="readonly"/> <!-- input type으로 주면 그 값을 변경 시킬 수 있는데 지금 화면에서는 변경을 못하게 해야하므로 이렇게 적어준다. -->
						</div>
					</div>
					<div class="form-group">
						<label for="input_pw" class="col-sm-4 control-label">비밀번호</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id" value="${member.password}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">이름</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id" value="${member.name}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">주소</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id" value="${member.addr}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">생년월일</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id" value="${member.birth}" readonly="readonly"/>
						</div>
					</div>
				</fieldset>
			</form>
			<div class="input_button text-center">
				<button id="updateBtn">수정 폼으로 이동</button>
				<button id="delBtn">회원탈퇴</button>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$('form').addClass('form-horizontal'); // 이게 없으면 화면이 꺠진다.
		
		$('#updateBtn').addClass('btn btn-primary').click(function() { // 수정 폼 이동 클릭 시 URL에 id 값을 가지고 넘어간다.
			location.href = '${context}/member/update_form.do?id=${member.id}';
		});
		$('#delBtn').addClass('btn btn-primary').click(function() {
			location.href = '${context}/member/delete.do?id=${member.id}';
		});
	});
</script>
</html>