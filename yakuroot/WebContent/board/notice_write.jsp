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
     .ck-editor__editable{
     min-height:480px;
     }
     </style>
		<%
			String login = (String) session.getAttribute("login");
		%>

<!-- 공지게시판 글 쓰기 jsp -->
<div align="center">
	<form action="notice_write.do" method="post" enctype="multipart/form-data">
		말머리:<select name="n_head">
					<option value="공지사항">공지사항</option>
				</select> 
			<br> 
			<br> 
			글 제목: <input type="text" name="n_title" required
			placeholder="제목" size="60"> 
			<input type="hidden"
			name="n_writer" value="${login}">
			<br>
			<br>
			<input type="file" name="nf" multiple> 
			<div style="width: 1000px;">
			<textarea name="n_content" required id="editor"> </textarea>
			</div>
			
			<br> 
			<br>
			<button type="submit">글 쓰기</button>
	</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>