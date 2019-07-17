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
.ck-editor__editable {
	min-height: 480px;
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
					<form action="q_edit.do" method="post" enctype="multipart/form-data">
						<input type="hidden" name="q_no" value="${qdto.q_no}">
						<input type="hidden" name="q_savename" value="${qdto.q_savename}">
						<input type="hidden" name="q_uploadname" value="${qdto.q_uploadname}">
						<input type="hidden" name="q_len" value="${qdto.q_len}">
						<input type="hidden" name="q_type" value="${qdto.q_type}">
			<table>
				<tbody>
						<tr>
							<th width="20%">말머리</th>
							<td align="center"><select name="q_head">
									<option value="QnA">QnA</option>
							</select></td>
						</tr>
						<tr>
							<th width="20%">글 제목</th>
							<td>
								<div align="center">
									<input type="text" name="q_title" required
										value="${qdto.q_title}" style="width: 500px; height: 25px;">
								</div>
							</td>
						</tr>
						<tr>
							<th width="20%">내용</th>
							<td>
								<div style="width: 1000px;">
									<textarea name="q_content" required id="editor"
										value="${qdto.q_content}">${qdto.q_content}></textarea>
								</div>
							</td>
						</tr>
				</tbody>
			</table>
			<button type="submit"">수정하기</button>
			</form>
			<br>

		</div>
	</div>
</div>



<jsp:include page="/template/footer.jsp"></jsp:include>