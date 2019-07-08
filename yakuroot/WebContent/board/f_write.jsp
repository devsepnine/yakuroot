<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<!-- 자유게시판 글 쓰기 jsp -->
<div align="center">
	<form action="f_write.do" method="post">

		<!-- 답글일 경우 parent값을 전달 -->
		<%-- 	<%if(request.getParameter("parent")!=null){%> --%>
		<%
			if (request.getParameterMap().containsKey("f_parent")) {
		%>
		<input type="hidden" name="f_parent"
			value="<%=request.getParameter("f_parent")%>">
		<%
			}
		%>
		말머리:<select name="f_head">
			<option value="잡담">잡담</option>
			<option value="한화">한화</option>
			<option value="sk">sk</option>
			<option value="kt">kt</option>
			<option value="삼성">삼성</option>
			<option value="두산">두산</option>
			<option value="키움">키움</option>
			<option value="lg">lg</option>
			<option value="nc">nc</option>
			<option value="롯데">롯데</option>
			<option value="kia">kia</option>
		</select> <br> <br> 글 제목: <input type="text" name="f_title" required
			placeholder="제목" size="60"> <input type="hidden"
			name="writer" required value="f_writer"> <br> <br>
		<textarea name="f_content" required
			style="width: 500px; height: 300px;"> </textarea>
		<br> <br>
		<button type="submit">글 쓰기</button>
	</form>
</div>
<jsp:include page="/template/footer.jsp"></jsp:include>