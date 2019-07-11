<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<style>

.form.form-label>fieldset {
	width: 330px;
	text-align: left;
	margin-top : 100px;
	margin-bottom : 100px;
	padding : 20px;
}

 input[name=m_id], input[name=m_name], input[name=m_phone]{
	width : 200px;
}

.error {
	color : red;
	font-size : 15px;
	text-align : center;
}

</style>

<div align="center">
	<form action="${pageContext.request.contextPath}/member/find_pw.do" method="post" class="form form-label">
	
		<fieldset>
			<legend>FIND PW</legend>
				<table  class="table table-noline">
					<tbody>
						<tr>
							<td class="error" colspan="2" height="30">
							<%if(request.getParameterMap().containsKey("error")) { %>
								[ 일치하는 정보가 없습니다 ]
							<%} %>
							</td>
						</tr>
						<tr>
						<tr>
							<td><label for="m_id">ID</label></td>
							<td>
								<input type="text" name="m_id" id="m_id" placeholder="ID를 입력하세요" required>
							</td>
						</tr>
							<td><label for="m_name">NAME</label></td>
							<td>
								<input type="text" name="m_name" id="m_name" placeholder="이름을 입력하세요" required>
							</td>
						</tr>
						<tr>
							<td><label for="m_phone">PHONE</label></td>
							<td>
								<input type="text" name="m_phone" id="m_phone" placeholder="핸드폰번호를 입력하세요" required>
							</td>
						</tr>
						<tr>
							<td colspan="2" align ="right">
					   			<input type="submit" value="PW 찾기">
					   		</td>
						</tr>
					</tbody>
				</table>
		</fieldset>
	</form>
</div>
<jsp:include page= "/template/footer.jsp"></jsp:include>