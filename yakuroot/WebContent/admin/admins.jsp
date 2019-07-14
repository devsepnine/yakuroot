<%@page import="member.beans.MemberDto"%>
<%@page import="member.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
   <jsp:include page="/template/header.jsp"></jsp:include>
   
   <style>

		.form.admin>fieldset {
			width: 1000px;
			text-align: center;
			margin-top : 100px;
			margin-bottom : 100px;
			padding : 20px;
		}
		
	</style>
   
   <div align = "center">
	   <form class="form admin">
			<fieldset>
				<legend>[ ADMIN PAGE ]</legend>
					<table width = 80% align = "center" class="table table-noline">
						<tbody>
							<tr>
					   		<th>NO</th>
					   		<td><input type="text" value="${mdto.m_no}"  readonly></td>
					   		</tr>
					   		<tr>
					   		<th>ID</th>
					   		<td><input type="text" value="${mdto.m_id}"  readonly></td>
					   		</tr>
					   		<tr>
					   		<th>PW</th>
					   		<td><a href ="edit_pw.do?m_id=${mdto.m_id}"><input type="button" value="임시 비밀번호 발급" name="eidt_pw"></a></td>
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
			</fieldset>
		</form>
	</div>
   
  
   
   <jsp:include page="/template/footer.jsp"></jsp:include>
 
 