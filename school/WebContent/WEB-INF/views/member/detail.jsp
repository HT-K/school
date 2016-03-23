<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
<div id="detail">
		<div class="joinTop">
			<h2 class="text-center">회원상세정보</h2>
		</div>
		<div class="joinCenter row">
			<form action="${context}/member/update_form.do" name="updateForm" class="form-horizontal">
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
					<div class="input_button text-center">
						<input type="submit" id="updateButton" class="btn btn-primary" value ="수정 폼으로 이동"/>
<%-- 						<input type="hidden" id="id" name="id" class="btn btn-primary" value="${member.id}" /> --%>
						<input type="submit" formaction="${context}/member/delete.do" id="deleteform" class="btn btn-primary" value ="회원탈퇴"/>
						
					</div>
				</fieldset>
			</form>
		</div>
	</div>