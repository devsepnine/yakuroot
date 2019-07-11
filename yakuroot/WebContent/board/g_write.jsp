<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="../js/ckeditor.js"></script>
<script>
        $(function(){
            ClassicEditor
            .create( document.querySelector( '#editor' ) )
            .catch( error => {
                console.error( error );
            })
        });
     </script>
<style>
.ck-editor__editable {
	min-height: 480px;
}
</style>

<!-- 갤러리 글 쓰기 jsp -->
<div align="center">

	<form action="g_write.do" method="post">
		<%
			String login = (String) session.getAttribute("login");
		%>
		<%
			if (request.getParameterMap().containsKey("g_parent")) {
		%>
		<input type="hidden" name="g_parent"
			value="<%=request.getParameter("g_parent")%>">
		<%
			}
		%>
		말머리:<select name="g_head">
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
			</select> 
			<br> <br> 
			글 제목: <input type="text" name="g_title" required
			placeholder="제목" size="60"> <input type="hidden"
			name="g_writer" value="<%=login%>"> 
			<br> <br> 
			<input type="file" name="gf" multiple> 
			<br><br>
		<div style="width: 1000px;">
			<textarea name="g_content" required id="editor"> </textarea>
		</div>

		<br> <br>
		<button type="submit">글 쓰기</button>
	</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>