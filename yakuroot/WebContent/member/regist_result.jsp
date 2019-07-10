<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <jsp:include page="/template/header.jsp"></jsp:include>
 <link rel="stylesheet" type="text/css" href="/yakuroot/css/common.css">
 
 
 
 <style>

	.form.form-label>fieldset {
		width: 300px;
		text-align: center;
		margin-top : 100px;
		margin-bottom : 100px;
	}
 </style>
 
 
 <div align="center">
	 <form class="form form-label">
			<fieldset>
				<legend>REGIST</legend>
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
									회원가입을 축하합니다!!
								</td>
							</tr>
							<tr height = "30">
								<td colspan ="2"></td>
							</tr>
							<tr>
								<td>
									<a href ="../"><input  type="button" value="MAIN" name="index"></a>
								</td>
								<td>
									<a href ="yakuroot/member/login.do"><input  type="button" value="LOGIN" name="index"></a>
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