<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="/yakuroot/css/common.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>

.form.form-label>fieldset {
	width: 350px;
	text-align: left;
	margin-top : 100px;
	margin-bottom : 100px;
}

input[name=m_id], input[name=m_pw]{
	width : 200px;
}

.error {
	color : red;
	font-size : 15px;
	text-align : center;
}


</style>

<div align="center">
 
	<form action="${pageContext.request.contextPath}/member/login.do" method="post" class="form form-label">
		<fieldset>
			<legend>LOGIN</legend>
				<table border=1 width=300px class="table table-noline">
					<tbody>
						<tr>
						<td class="error" colspan="2" height="30">
						<%if(request.getParameterMap().containsKey("error")) { %>
							[ 로그인 정보가 일치하지 않습니다 ]
						<%} %>
						</td>
						</tr>
						<tr>
						<td><label for="m_id">ID</label></td>
						<td>
							<input type="text" name="m_id" id="m_id" placeholder="ID를 입력하세요" value="${cookie.saveID.value}" required>
						</td>
						</tr>
						<tr>
						<td><label for="m_pw">PASSWORD</label></td>
						<td>
							<input type="password" name="m_pw" id="m_pw" placeholder="PASSWORD를 입력하세요" required>
						</td>
						</tr>
						<tr align="right">
						<td colspan="2">
							<input type="checkbox" name="saveID" ${not empty cookie.saveID?"checked":""}>
							<label for="saveID" style="margin-right:20px">아이디 저장하기</label>
						</td>
						</tr>
						<tr align="center">
						<td colspan="2">
							<input style="padding:0.5rem 3rem;" type="submit" value="로그인">
						</td>
						</tr>
						<tr>
						<td colspan = "2" align = "center" >
						<input type="button" value="ID 찾기" name="find_id">
						<input type="button" value="PW 찾기" name="find_pw">
						</td>
						</tr>
					</tbody>
				</table>
		</fieldset>

	</form>

</div>

<jsp:include page="/template/footer.jsp"></jsp:include>