<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <jsp:include page="/template/header.jsp"></jsp:include>
 
 <style>

	.form.form-label>fieldset {
		width: 500px;
		text-align: center;
		margin-top : 100px;
		margin-bottom : 100px;
		padding : 20px;
	}
	
 </style>
 
 <div align="center">
	 <form class="form form-label">
			<fieldset>
				<legend>CHANGE PW RESULT</legend>
					<table width = 100% class="table table-noline">
						<tbody>
							<tr>
								<td colspan ="2"></td>
							</tr>
							<tr>
								<td colspan ="2"></td>
							</tr>
							<tr>
								<td colspan = "2">
									비밀번호가 변경되었습니다.
								</td>
							</tr>
							<tr height = "30">
								<td colspan ="2"></td>
							</tr>
							<tr>
								<td colspan = "2">
									<a href ="../"><input  type="button" value="MAIN" name="index"></a>
								</td>
								
							</tr>
							<tr>
								<td colspan ="2"></td>
							</tr>
							<tr>
								<td colspan ="2"></td>
							</tr>
						</tbody>
					</table>
	 		</fieldset>
	 </form>
</div> 
<jsp:include page="/template/footer.jsp"></jsp:include>