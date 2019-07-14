<%@page import="member.beans.MemberDto"%>
<%@page import="member.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>
<% 
	String m_id = request.getParameter("m_id");
	MemberDao mdao = new MemberDao();
	MemberDto mdto = mdao.get(m_id);
%>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	$(function() {
		$("input[name=postcode_find]").click(findAddress);
	});

	function findAddress() {
		new daum.Postcode({
			oncomplete : function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
				// 각 주소의 노출 규칙에 따라 주소를 조합한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var addr = ''; // 주소 변수
				var extraAddr = ''; // 참고항목 변수

				//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
					addr = data.roadAddress;
				} else { // 사용자가 지번 주소를 선택했을 경우(J)
					addr = data.jibunAddress;
				}

				// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
				if (data.userSelectedType === 'R') {
					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraAddr += (extraAddr !== '' ? ', '
								+ data.buildingName : data.buildingName);
					}
					// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if (extraAddr !== '') {
						extraAddr = ' (' + extraAddr + ')';
					}
					// 조합된 참고항목을 해당 필드에 넣는다.

				}

				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				// document.querySelector('input[name=postcode]').value = data.zonecode;
				// document.querySelector("input[name=basicaddr]").value = addr;
				// 커서를 상세주소 필드로 이동한다.
				// document.querySelector("input[name=detailaddr]").focus();

				// 이 코드는 jquery.js 를 먼저 불러온 경우만 사용 가능
				$("input[name=m_postcode]").val(data.zonecode);
				$("input[name=m_addr1]").val(addr);
				$("input[name=m_addr2]").focus();
			}
		}).open();
	}

	//이메일 검사 후 형식에 안맞을시 보조메세지 출력
	function checkEmail() {
		var m_email = document.querySelector("#m_email").value;
		var regex = /^[a-z0-9]{8,15}$/;

		//정규표현식으로 m_email값 검사
		var result = regex.test(m_email);

		var div = document.querySelector(".m_emailD");

		if (result) {
			div.innerHTML = ""
		}
		
		//m_email이 형식에 맞지 않으면 메세지 춮력
		else {
			div.innerHTML = "<font color = 'gray' size = '2'>8~15자의 영문 소문자, 숫자로 입력해주세요</font>"
		}
	}

	//핸드폰 번호 검사 후 형식에 안맞을시 보조메세지 출력
	function checkPhone() {
		var m_phone = document.querySelector("#m_phone").value;
		var regex = /^01[016-9]-[0-9]{3,4}-[0-9]{4}$/;

		//정규표현식으로 m_phone값 검사
		var result = regex.test(m_phone);

		var div = document.querySelector(".m_phoneD");

		if (result) {
			div.innerHTML = ""
		}
		
		//m_phone이 형식에 맞지 않으면 메세지 춮력
		else {
			div.innerHTML = "<font color = 'gray' size = '2'> -포함 숫자로 입력해주세요</font>"
		}
	}

	//이메일 @뒷부분 옵션으로 선택시 입력창 비활성화, 옵션 선택시 입력창에 옵션 value 값 찍어주기
		$("#email_address").change(function() {
			$("#m_email_address").val($(this).val())

			if (!$(this).val()) {
				$(this).prev().prop("readonly", false);
			}
			else {
				$(this).prev().prop("readonly", true);
			}
		});

		//select 옵션값 선택되서 나오게 하는거
		$("select[name=m_fav]").val("${mdto.m_fav}");
</script>
<style>
.form.form-label>fieldset {
	width: 750px;
	text-align: left;
	margin-top: 100px;
	margin-bottom: 100px;
	padding: 20px;
}

.change_info td input {
	width: 180px;
}

.change_info th {
	width: 150px;
	text-align: center;
}

.change_info td input {
	padding-left: 20px;
}
</style>

<div align="center">
	<form action="${pageContext.request.contextPath}/member/change_info.do" method="post" class="form form-label">
		<fieldset>
			<legend>[ ${mdto.m_id}님의 정보 수정 ]</legend>
			<table width=100% align="center" class="change_info"
				class="table table-noline">
				<tbody>
					<tr>
						<th>ID</th>
						<td colspan="2"><input type="text" value="${mdto.m_id}"
							name="m_id" readonly></td>
					</tr>
					<tr>
						<th>NAME</th>
						<td colspan="2"><input type="text" value="${mdto.m_name}"
							name="m_name" readonly></td>
					</tr>
					<tr>
						<th>BIRTH</th>
						<td colspan="2"><input type="date" value="${mdto.m_birth}"
							name="m_birth" required></td>
					</tr>
					<tr>
						<th>PHONE</th>
						<td colspan="2"><input type="text" value="${mdto.m_phone}"
							id="m_phone" name="m_phone" onblur="checkPhone();"
							pattern="^01[016-9]-[0-9]{3,4}-[0-9]{4}$" required>
							<div class="m_phoneD"></div></td>
					</tr>
					<tr>
						<th>EMAIL</th>
						<%-- 이메일 한번에 받은거 @ 앞에서 끊어서 그것만 넣어주기 --%>
						<td colspan="2"><input onblur="checkEmail();" type="text"
							name="m_email" id="m_email" value="${mdto.m_email_first}"
							pattern="^[a-z0-9]{8,15}$" required> <span>@</span> <input
							type="text" name="m_email_address" id="m_email_address"
							pattern="^.*?\..*?$" value="${mdto.m_email_last}" required>
							<select id="email_address">
								<option value="">직접입력</option>
								<option>naver.com</option>
								<option>daum.net</option>
								<option>gmail.com</option>
						</select>
							<div class="m_emailD"></div></td>
					</tr>
					<tr>
						<th>ADDRESS</th>
						<td colspan="2"><input type="text" name="m_postcode"
							value="${mdto.m_postcode}" required readonly> <input
							type="button" value="우편번호 찾기" name="postcode_find"
							style="margin-left: 40px; width: 130px;"><br> <input
							type="text" name="m_addr1" value="${mdto.m_addr1}" required
							readonly><br> <input type="text" name="m_addr2"
							value="${mdto.m_addr2}"></td>
					</tr>
					<tr>
						<th>MY TEAM</th>
						<td colspan="2"><select name="m_fav">
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

					<td colspan="3" height="50px"></td>
					</tr>
					</tr>
					<tr>
						<td colspan="3" align="right"><input type="submit"
							value="정보 저장" name="change_info_btn"
							style="margin-right: 50px; width: 130px;"></td>
					</tr>

				</tbody>
			</table>
		</fieldset>
	</form>
</div>



<jsp:include page="/template/footer.jsp"></jsp:include>
