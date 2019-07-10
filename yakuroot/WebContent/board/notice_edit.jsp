<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<style>
div {
	margin: auto;
}
</style>

<div align="center">
	<div>
		<div>
			<table border ="1">
				<tbody>
					<form action="notice_edit.do" method="post">
						<input type="hidden" name="n_no" value="${ndto.n_no}">
						<tr>
							<th width="20%">말머리</th>
							<td align="center"><select name="n_head">
									<option value="공지사항">공지</option>
							</select></td>
						</tr>
						<tr>
							<th width="20%">글 제목</th>
							<td>
							<div align="center">
							<input type="text" name="n_title" required
								value="${ndto.n_title}" style="width: 500px; height: 25px;">
							</div>
							</td>
						</tr>
						<tr>
							<th width="20%">내용</th>
							<td>
							<div style="width: 1000px;">
								<textarea name="n_content" required id="editor" value="${ndto.n_content}">${ndto.n_content}></textarea>
							</div>
							</td>
						</tr>
				</tbody>
			</table>
			<br>
			<button type="submit">수정하기</button>
			</form>

		</div>
	</div>
</div>



<jsp:include page="/template/footer.jsp"></jsp:include>