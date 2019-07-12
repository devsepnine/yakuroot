<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/template/header.jsp"></jsp:include>

<%
	String sample_pw = request.getParameter("m_pw");
%>

<style>

.form.form-label>fieldset {
	width: 550px;
	text-align: left;
	margin-top : 100px;
	margin-bottom : 100px;
	padding : 20px;
}



.table input{
	width : 250px;
}

</style>

<div align="center">
	<form class="form form-label">
			<fieldset>
				<legend>SAMPLE PW</legend>
					<table border=1 width=450px class="table table-noline">
						<tbody>
							<tr>
								<td>
									임시 비밀번호
								</td>
								<td>
									<input type="text" name="m_pw" id="m_pw"  value="<%=sample_pw%>" readonly >
								</td>
							</tr>
						</tbody>
					</table>
			</fieldset>
	</form>
</div>


<jsp:include page="/template/footer.jsp"></jsp:include>