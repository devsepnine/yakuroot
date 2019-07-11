<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


   <jsp:include page="/template/header.jsp"></jsp:include>
   
   <style>
	
		.form.form-label>fieldset {
			width: 650px;
			text-align: left;
			margin-top : 100px;
			margin-bottom : 100px;
			padding : 20px;
		}
		
		
		.table input{
			width : 190px;
		}
		
		.table input[name=btn]{
			width : 100px;
			align : center;
			margin-left: 120px;
		}
		
		
	</style>
	
	  <div align = "center">
		<form action="check.do" method="post" class="form form-label">
			<input type="hidden" name="pass" value="<%=request.getParameter("pass")%>">
			<fieldset>
				<legend>CHECK PASSWORD</legend>
					<table border=1 class="table table-noline">
						<tbody>
							<tr>
								<td class="error" colspan="2" height="30" style="padding-left: 90px; color:red;">
									<%if(request.getParameterMap().containsKey("error")) { %>
										[ 비밀번호가 일치하지 않습니다 ]
									<%} %>
								</td>
							</tr>
							<tr>
								<td><label for="m_pw">PASSWORD</label></td>
								<td>
									<input type="password" name="m_pw" id="m_pw" required>
								</td>
							</tr>
							<tr>
								<td colspan ="2"></td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="submit" value="확인" name="btn">
								</td>
							</tr>
						</tbody>
					</table>
			</fieldset>
		</form>
	</div>

	
	
</form>   
 

   <jsp:include page= "/template/footer.jsp"></jsp:include>