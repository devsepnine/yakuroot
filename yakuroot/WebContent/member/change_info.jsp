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
			padding-right: 80px;
		}
		
		.table input{
			width : 230px;
		}
		
		.table tr {
			text-align : center;
		}
		
		.table td input {
			padding-left: 20px;
		}
		
	</style>
   
   <div align = "center">
	   <form class="form form-label">
			<fieldset>
				<legend>[ ${mdto.m_id}님의 정보 ]</legend>
					<table border = 1 width = 80% align = "center" class="table table-noline">
						<tbody>
					   		<tr>
					   		<th>ID</th>
					   		<td><input type="text" value="${mdto.m_id}"  readonly></td>
					   		</tr>
					   		<tr>
					   		<th>NAME</th>
					   		<td><input type="text" value="${mdto.m_name}"  readonly></td>
					   		</tr>
					   		<tr>
					   		<th>BIRTH</th>
					   		<td><input type="text" value="${mdto.m_birth}" required></td>
					   		</tr>
					   		<tr>
					   		<th>PHONE</th>
					   		<td><input type="text" value="${mdto.m_phone}" pattern="^01[016-9]-[0-9]{3,4}-[0-9]{4}$" required></td>
					   		</tr>
					   		<tr>
					   		<th>EMAIL</th>  <%-- 이메일 한번에 받았는데 어떻게 어쩌고만 찍지...? --%>
					   		<td><input type="text" value="${mdto.m_email}"  pattern="^[a-z0-9]{8,15}$" required></td>
					   		</tr>
					   		<tr>
							<td><label for="m_addr">ADDRESS</label></td>
							<td>
								<input type="text" name="m_postcode" value="${mdto.m_postcode}"  required >
									<input type="button" value="우편번호 찾기" name="postcode_find"><br>
									<input type="text" name="m_addr1" value="${mdto.m_addr1}" required ><br>
									<input type="text" name="m_addr2" value="${mdto.m_addr2}"  >
							</td>
							</tr>
					   		<tr>
					   		<th>MY TEAM</th>
					   		<td><select name="m_fav">
									<option>선택 안함</option>
									<option>두산베어스</option>
									<option>SK와이번즈</option>
									<option>키움히어로즈</option>
									<option>LG트윈스</option>
									<option>NC다이노스</option>
									<option>KT위즈</option>
									<option>삼성라이온즈</option>
									<option>KIA타이거즈</option>
									<option>한화이글즈</option>
									<option>롯데자이언트</option>
									</select></td>
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
					   		<tr>
					   		<td><a href ="change_info.do"><input type="button" value="내 정보 수정" name="change_info"></a></td>
					   		<td><a href ="delete.do"><input type="button" value="회원 탈퇴" name="delete"></a></td>
					   		</tr>
						</tbody>
					</table>
			</fieldset>
		</form>
	</div>
   
  
   
   <jsp:include page="/template/footer.jsp"></jsp:include>
 