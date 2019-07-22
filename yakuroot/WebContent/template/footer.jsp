<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<br><br><br><br>
   	<div class="footer" align="center" style="background-color: #1E2129; padding-bottom: 20px;padding-top: 20px">
		<span style="color: #474747">
			<font> copyright &copy;</font><br>
			<font> 세션ID : <%=session.getId() %></font><br>
			<font> 신규세션 ? : <%=session.isNew() %></font><br>
			<font> 로그인 상태 : ${sessionScope.login != null } , ${not empty login}, <%=session.getAttribute("login") != null %></font><br>
			<font> 로그인한 사용자 아이디 : ${sessionScope.login} 권한 : ${sessionScope.auth}</font> <br>
			<font> 관리자 입니까 ? ${sessionScope.auth eq "관리자"}</font>
		</span>
	</div>
</body>
</html>
