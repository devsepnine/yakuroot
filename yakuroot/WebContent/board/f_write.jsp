<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<!-- 자유게시판 글 쓰기 jsp -->
<div align="center">
	<form action="f_write.do" method="post">

		<!-- 답글일 경우 parent값을 전달 -->
		<%-- 	<%if(request.getParameter("parent")!=null){%> --%>
		<%
			String login = (String) session.getAttribute("login");
		%>
		<%
			if (request.getParameterMap().containsKey("f_parent")) {
		%>
		<input type="hidden" name="f_parent"
			value="<%=request.getParameter("f_parent")%>">
		<%
			}
		%>
		말머리:<select name="f_head">
			<option value="talk">잡담</option>
			<option value="hanhwa">한화이글즈</option>
			<option value="sk">SK와이번즈</option>
			<option value="kt">KT위즈</option>
			<option value="samsung">삼성라이온즈</option>
			<option value="doosan">두산베어스</option>
			<option value="kiwoom">키움히어로즈</option>
			<option value="lg">LG트윈스</option>
			<option value="nc">NC다이노스</option>
			<option value="lotte">롯데자이언트</option>
			<option value="kia">KIA타이거즈</option>
		</select> <br> <br> 글 제목: <input type="text" name="f_title" required
			placeholder="제목" size="60"> <input type="hidden"
			name="f_writer" value="<%=login%>"> <br> <br>
		<textarea name="f_content" required
			style="width: 500px; height: 300px;"> </textarea>
		<br> <br>
		<button type="submit">글 쓰기</button>
	</form>
</div>
<jsp:include page="/template/footer.jsp"></jsp:include>