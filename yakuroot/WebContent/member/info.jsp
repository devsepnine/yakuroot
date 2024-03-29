<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
   <jsp:include page="/template/header.jsp"></jsp:include>
   
   <style>

		.form.form-label>fieldset {
			width: 550px;
			text-align: left;
			margin-top : 100px;
			margin-bottom : 100px;
			padding : 30px;
			padding-right: 20px;
		}
		
		.table input{
			width : 70%;
		}
		
		.table tr {
			text-align : center;
		}
		
		.table th {
			width : 120px;
		}
		
		.table td input {
			padding-left: 20px;
		}
		
		.table input[name=change_info], input[name=delete] {
			width : 230px;
		}
		
	</style>
   
   <div align = "center">
	   <form class="form form-label">
			<fieldset>
				<legend>[ ${mdto.m_id}님의 정보 ]</legend>
					<table border = 1 width = 90% align = "center" class="table table-noline">
						<tbody>
					   		<tr>
						   		<th>ID</th>
						   		<td><input type="text" value="${mdto.m_id}"  readonly></td>
					   		</tr>
					   		<tr>
						   		<th>PW</th>
						   		<td><a href ="check.do?go=change_pw.do"><input type="button" value="CHANGE PW" name="change_pw"></a></td>
					   		</tr>
					   		<tr>
						   		<th>NAME</th>
						   		<td><input type="text" value="${mdto.m_name}"  readonly></td>
					   		</tr>
					   		<tr>
						   		<th>BIRTH</th>
						   		<td><input type="text" value="${mdto.m_birth}"  readonly></td>
					   		</tr>
					   		<tr>
						   		<th>PHONE</th>
						   		<td><input type="text" value="${mdto.m_phone}"  readonly></td>
					   		</tr>
					   		<tr>
						   		<th>EMAIL</th>
						   		<td><input type="text" value="${mdto.m_email}"  readonly></td>
					   		</tr>
					   		<tr>
						   		<th>POST CODE</th>
						   		<td><input type="text" value="${mdto.m_postcode}"  readonly></td>
					   		</tr>
					   		<tr>
						   		<th> MAIN ADDRESS</th>
						   		<td><input type="text" value="${mdto.m_addr1}"  readonly></td>
					   		</tr>
					   		<tr>
						   		<th>ADDRESS</th>
						   		<td><input type="text" value="${mdto.m_addr2}"  readonly></td>
					   		</tr>
					   		<tr>
						   		<th>MY TEAM</th>
						   		<td><input type="text" value="${mdto.m_fav}"  readonly></td>
					   		</tr>
					   		<tr>
						   		<th>AUTH</th>
						   		<td><input type="text" value="${mdto.m_auth}"  readonly></td>
					   		</tr>
					   		<tr>
						   		<th>REGIST DATE</th>
						   		<td><input type="text" value="${mdto.m_regist}"  readonly></td>
					   		</tr>
					   		<tr>
						   		<th>LAST TIME</th>
						   		<td><input type="text" value="${mdto.m_lasttime}"  readonly></td>
					   		</tr>
					   		<tr>
					   			<td colspan="2" height="50px"></td>
					   		</tr>
						</tbody>
					</table>
					<table class = "table table-noline">
						<tr>
							<td><a href ="check.do?go=change_info.do"><input type="button" name="change_info" value="내 정보 수정" name="change_info"></a></td>
						   	<td><a href ="check.do?go=delete.do"><input type="button"  name = "delete" value="회원 탈퇴" name="delete"></a></td>
						</tr>
					</table>
			</fieldset>
		</form>
	</div>
 
   <jsp:include page="/template/footer.jsp"></jsp:include>
 