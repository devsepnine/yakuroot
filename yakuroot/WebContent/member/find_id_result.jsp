<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <jsp:include page="/template/header.jsp"></jsp:include>


    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 	
 	<style>
 	
    .form.form-label>fieldset {
		width: 330px;
		text-align: left;
		margin-top : 100px;
		margin-bottom : 100px;
		padding : 30px;
	}
	
 	</style>
 	   
   	<div align="center">
		<form class="form form-label">
			<fieldset>
				<legend>FIND ID RESULT</legend>
					<table class="table table-noline" style="width:100%">
						<tbody>
							<tr>
								<td colspan = "2">
								</td>
							</tr>
							<tr>
								<td colspan = "2">
								</td>
							</tr>
							<tr>
								<td colspan = "2" align = "center"> 
									아이디는[ ${m_id} ] 입니다							
								</td>
							</tr>
							<tr>
								<td colspan = "2">
								</td>
							</tr>
							<tr>
								<td colspan = "2">
								</td>
							</tr>
							<tr>
								<td align = "center">
									<a href ="../"><input  type="button" value="MAIN" name="index"></a>
								</td>
								<td align = "center">
									<a href ="yakuroot/member/login.do"><input type="button" value="LOGIN" name="login"></a>
								</td>
							</tr>
						</tbody>
					</table>
			</fieldset>
		</form>
	</div>
<jsp:include page="/template/footer.jsp"></jsp:include>