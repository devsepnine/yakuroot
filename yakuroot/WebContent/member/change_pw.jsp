<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   

   
<jsp:include page="/template/header.jsp"></jsp:include>

 <script>
 	// 비밀번호 확인창, 변경하기 버튼 비활성화
	$(function(){
		$("input[name=m_pw2]").prop("readonly", true)
									.css("background-color", "lightgray");
		$("input[name=change_pw_btn]").prop("disabled", true)
										.css("background-color", "lightgray");
	});
	
	//비밀번호 검사 후 형식에 안맞을시 보조메세지 출력	
	function checkPw(){
    	var m_pw1 = document.querySelector("#m_pw").value;
        var m_pw2 = document.querySelector("#m_pw2").value;
        var regex = /^[a-zA-Z0-9!@#$\-_]{8,15}$/;
        
        //정규표현식으로 m_pw1값 검사
        var result = regex.test(m_pw1);

        var div = document.querySelector(".m_pwD");
		
        //m_pw1이랑 m_pw2가 일치하지 않으면 메세지 출력, 버튼 비활성화
        if (m_pw1 != m_pw2) {
        	div.innerHTML = "<font color = 'gray' size = '2'>비밀번호가 일치하지 않습니다</font>"
           	$("input[name=change_pw_btn]").prop("disabled", true)
												.css("background-color", "lightgray");
        }
        
		//m_pw1이랑 m_pw2가 일치하면 버튼 활성화
        if(m_pw1 == m_pw2) {
//      	div.innerHTML = "<font color = 'gray' size = '2'>비밀번호가 일치합니다</font>"
			div.innerHTML = ""
            $("input[name=change_pw_btn]").prop("disabled", false)
         									.css("background-color", "#1E3269");
         	}
            
        //m_pw1이 형식에 맞으면 비밀번호 확인창 활성화
        if(result) {
        	div.innerHTML = ""
            $("input[name=m_pw2]").prop("readonly", false)
									.css("background-color", "#DCEBFF");
        }
        //m_pw1이 형식에 맞지 않으면 메세지 춮력
        else {
         	div.innerHTML = "<font color = 'gray' size = '2'>8~15자의 영문 대소문자, 숫자, 특수문자(!@#$-_)로 입력해주세요</font>"    
            }
        }
    
	//비밀번호 검사 후 형식에 안맞을시 보조메세지 출력
	function checkPw2(){
	    var m_pw1 = document.querySelector("#m_pw").value;
	    var m_pw2 = document.querySelector("#m_pw2").value;
	    
	    //m_pw1이랑 m_pw2가 일치하는지 검사
	    var result = m_pw1 == m_pw2;
	            
	    var div = document.querySelector(".m_pwD2");
		
	    //m_pw1이랑 m_pw2가 일치하지 않으면 변경버튼 비활성화
	    if (m_pw1 != m_pw2) {
	    	$("input[name=change_pw_btn]").prop("disabled", true)
											.css("background-color", "lightgray");
    	}
	    
	    //m_pw1이랑 m_pw2가 일치하면 버튼 활성화
	    if(result) {
	//  div.innerHTML = "<font color = 'gray' size = '2'>비밀번호가 일치합니다</font>"
	    	div.innerHTML = ""
	    	$("input[name=change_pw_btn]").prop("disabled", false)
	            							.css("background-color", "#1E3269");
	    }
	    //m_pw1이랑 m_pw2가 일치하지 않으면 메세지 출력
	    else {
	    div.innerHTML = "<font color = 'gray' size = '2'>비밀번호가 일치하지 않습니다</font>"
	    }
	}
</script>
 	
 <style>

	.form.form-label>fieldset {
		width: 550px;
		text-align: center;
		margin-top : 100px;
		margin-bottom : 100px;
		padding : 20px;
	}
	
	 input[name=m_pw], input[name=m_pw2]{
		width : 300px;
	}

</style>

 	
 	<div align="center">
	<form action="${pageContext.request.contextPath}/member/change_pw.do" method="post" class="form form-label">
		<fieldset>
			<legend>CHANGE PW</legend>
				<table  class="table table-noline">
					<tbody>
						<tr>
							<td><label for="m_pw">PASSWORD</label></td>
							<td>
								<input onblur="checkPw();" type="password" name="m_pw" id="m_pw" pattern="^[a-zA-Z0-9!@#$\-_]{8,15}$" required>
								<div class="m_pwD"></div>
							</td>
						</tr>
						<tr>
							<td><label for="m_pw2">PASSWORD CHECK</label></td>
							<td>
								<input onblur="checkPw2();" type="password" name="m_pw2" id="m_pw2" required>
								<div class="m_pwD2"></div>
							</td>
						</tr>
						<tr>
							<td colspan="2" align ="right">
					   			<input type="submit" value="PW 변경하기" name="change_pw_btn">
					   		</td>
						</tr>
					</tbody>
				</table>
		</fieldset>
	</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>