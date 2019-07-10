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

<div align="center" class="container">
	<div class="row">
		<div class="co-md-6">
			<table class="table">
				<tbody>
					<form action="f_edit.do" method="post">
						<input type="hidden" name="f_no" value="${bdto.f_no}">
						<tr>
							<th width="20%">말머리</th>
							<td align="center"><select name="f_head">
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
							</select></td>
						</tr>
						<tr>
							<th width="20%">글 제목</th>
							<td>
							<div align="center">
							<input type="text" name="f_title" required
								value="${bdto.f_title}" style="width: 500px; height: 25px;">
							</div>
							</td>
						</tr>
						<tr>
							<th width="20%">내용</th>
							<td>
							<div style="width: 1000px;">
								<textarea name="f_content" required id="editor" value="${bdto.f_content}">${bdto.f_content}></textarea>
							</div>
							</td>
						</tr>
				</tbody>
			</table>
			<br>
			<button type="submit" class="btn btn-outline-primary">수정하기</button>
			</form>

		</div>
	</div>
</div>



<jsp:include page="/template/footer.jsp"></jsp:include>