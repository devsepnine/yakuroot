<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="/yakuroot/css/common.css">


<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    $(function(){
        $("input[name=postcode_find]").click(findAddress);
    });

    function findAddress() {
        new daum.Postcode({
            oncomplete: function(data) {
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
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
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
</script>
<script>
	$(function() {

		// m_id 입력창에  blur 이벤트가 발생하면 ajax 통신으로 중복검사 수행
		// 요청 url : /member/id_check.do

		$("input[name=id_check_btn]").click(function() {
			$.ajax({
				url : "id_check.do",
				data : {
					m_id : $("input[name=m_id]").val()
				},
				dataType : "text",
				success : function(resp) {
					if (resp == "N") {
						window.alert("이미 사용중인 아이디입니다");
						$("input[name=m_id]").select();
					} else {
						window.alert("사용 가능한 아이디입니다")
					}
				}
			});
		});
		
		//이메일주소 옵션에서 선택했을때 왼쪽 입력창에 value 표시
		$("#email_address").change(function(){
			$("#m_email_address").val($(this).val())
			
			console.log($(this).val())
			
			 //if($(this).val() == ""){
			if(!$(this).val()){
                 $(this).prev().prop("disabled", false);
             }
             else{
            	 $(this).prev().prop("disabled", true);
             }
		});
	});
</script>
<style>

.form.form-label>fieldset {
	width: 650px;
	text-align: left;
	margin-top : 100px;
	margin-bottom : 100px;
}


.form.form-label .form-group > input {
	width : auto;
}
.table input{
	width : 190px;
}
.table input[name=postcode_find], input[name=registbtn]{
	width : 130px;
	margin-left : 20px;
}
.table input[name=id_check_btn]{
	width : 110px;
	margin-left : 20px;
	text-align : center;
}
</style>
<script>
        function checkId(){
            var m_id = document.querySelector("#m_id").value;
            var regex = /^[a-z0-9]{8,15}$/;
            
            var result = regex.test(m_id);
//             console.log(m_id);
//             console.log(result, typeof result);
            
            var div = document.querySelector(".m_idD");

            if(result) {
                div.innerHTML = ""
                $("input[name=id_check_btn]").prop("disabled", false)
                								.css("background-color", "#1E3269");
            }
            else {
                div.innerHTML = "<font color = 'gray' size = '2'>8~15자의 영문 소문자, 숫자로 입력해주세요</font>"
                $("input[name=id_check_btn]").prop("disabled", true)
                								.css("background-color", "lightgray");
            }
        }
</script>
<script>
        function checkPw(){
            var m_pw = document.querySelector("#m_pw").value;
            var regex = /^[a-zA-Z0-9!@#$\-_]{8,15}$/;
            
            var result = regex.test(m_pw);
//             console.log(result, typeof result);
            
            var div = document.querySelector(".m_pwD");

            if(result) {
                div.innerHTML = ""
            }
            else {
                div.innerHTML = "<font color = 'gray' size = '2'>8~15자의 영문 대소문자, 숫자, 특수문자(!@#$-_)로 입력해주세요</font>"
                
            }
        }
</script>
<script>
        function checkName(){
            var m_name = document.querySelector("#m_name").value;
            var regex = /^[가-힣]{2,7}$/;
            
            var result = regex.test(m_name);
//             console.log(result, typeof result);
            
            var div = document.querySelector(".m_nameD");

            if(result) {
                div.innerHTML = ""
            }
            else {
                div.innerHTML = "<font color = 'gray' size = '2'>2~7자의 한글로 입력해주세요</font>"
                
            }
        }
</script>
<script>
        function checkPhone(){
            var m_phone = document.querySelector("#m_phone").value;
            var regex = /^01[016-9]-[0-9]{3,4}-[0-9]{4}$/;
            
            var result = regex.test(m_phone);
//             console.log(result, typeof result);
            
            var div = document.querySelector(".m_phoneD");

            if(result) {
                div.innerHTML = ""
            }
            else {
                div.innerHTML = "<font color = 'gray' size = '2'> -포함 숫자로 입력해주세요</font>"
                
            }
        }
</script>
<script>
        function checkEmail(){
            var m_email = document.querySelector("#m_email").value;
            var regex = /^[a-z0-9]{8,15}$/;
            
            var result = regex.test(m_email);
            
            var div = document.querySelector(".m_emailD");

            if(result) {
                div.innerHTML = ""
            }
            else {
                div.innerHTML = "<font color = 'gray' size = '2'>8~15자의 영문 소문자, 숫자로 입력해주세요</font>"
            }
        }
</script>
<div align="center">
   

	<form action="regist.do" method="post" class="form form-label">
		<fieldset>
			<legend>REGIST</legend>
				<table class="table table-noline">
					<tbody>
						<tr>
							<td><label for="m_id">ID</label></td>
							<td>
								<input onblur="checkId();" type="text" name="m_id" id="m_id" required>
								<input type="button" value="중복확인" name="id_check_btn">
								<div class="m_idD"></div>
							</td>
							
						</tr>
						
						<tr>
							<td><label for="m_pw">PASSWORD</label></td>
							<td>
								<input onblur="checkPw();" type="password" name="m_pw" id="m_pw" required>
								<div class="m_pwD"></div>
							</td>
						</tr>
						
						<tr>
							<td><label for="m_name">NAME</label></td>
							<td>
								<input onblur="checkName();" type="text" name="m_name" id="m_name"  required>
								<div class="m_nameD"></div>
							</td>
						</tr>
						
						<tr>
							<td><label for="m_birth">BIRTH</label></td>
							<td>
								<input type="date" name="m_birth" id="m_birth" value="2019-07-08" required>
							</td>
						</tr>
						
						<tr>
							<td><label for="m_phone">PHONE</label></td>
							<td>
								<input onblur="checkPhone();" type="tel" name="m_phone" id="m_phone" >
								<div class="m_phoneD"></div>
							</td>
						</tr>
						
						<tr>
							<td><label for="m_email">EMAIL</label></td>
							<td>
								<input onblur="checkEmail();" type="text" name="m_email" id="m_email" pattern="^[a-z0-9]{8,15]$">
									<span>@</span>
									<input type="text" name="m_email_address" id="m_email_address" pattern="^.*?\..*?$">
									<select id="email_address">
										<option value="">직접입력</option>
										<option value="naver.com">naver.com</option>
										<option value="daum.net">daum.net</option>
										<option value="gmail.com">gmail.com</option>
									</select>
								<div class="m_emailD"></div>
							</td>
						</tr>
						
						<tr>
							<td><label for="m_addr">ADDRESS</label></td>
							<td>
								<input type="text" name="m_postcode" placeholder="우편번호" >
									<input type="button" value="우편번호 찾기" name="postcode_find"><br>
									<input type="text" name="m_addr1" placeholder="주소"><br>
									<input type="text" name="m_addr2" placeholder="상세주소">
							</td>
						</tr>
						
						<tr>
							<td><label for="m_fav">MY TEAM</label></td>
							<td>
								<select name="m_fav">
									<option value="none">선택 안함</option>
									<option value="doosan">두산베어스</option>
									<option value="sk">SK와이번즈</option>
									<option value="kiwoom">키움히어로즈</option>
									<option value="lg">LG트윈스</option>
									<option value="nc">NC다이노스</option>
									<option value="kt">KT위즈</option>
									<option value="samsung">삼성라이온즈</option>
									<option value="kia">KIA타이거즈</option>
									<option value="hanhwa">한화이글즈</option>
									<option value="lotte">롯데자이언트</option>
									</select>
							</td>
						</tr>
						<tr>
							<td colspan = 2 style="text-align:right">
								<input type="submit" value="가입하기" name = "registbtn">
							</td>
						</tr>
					</tbody>
				</table>
			


		</fieldset>


	</form>

</div>

<jsp:include page="/template/footer.jsp"></jsp:include>

