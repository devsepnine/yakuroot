<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
									<option value='잡담'>잡담</option>
									<option value='한화'>한화</option>
									<option value='sk'>sk</option>
									<option value='kt'>kt</option>
									<option value='삼성'>삼성</option>
									<option value='두산'>두산</option>
									<option value='키움'>키움</option>
									<option value='lg'>lg</option>
									<option value='nc'>nc</option>
									<option value='롯데'>롯데</option>
									<option value='kia'>kia</option>
							</select></td>
						</tr>
						<tr>
							<th width="20%">글 제목</th>
							<td><input type="text" name="f_title" required
								value="${bdto.f_title}" style="width: 500px; height: 25px;">
							</td>
						</tr>
						<tr>
							<th width="20%">내용</th>
							<td><textarea name="f_content" required
									value="${bdto.f_content}" style="width: 500px; height: 250px;">${bdto.f_content}</textarea></td>
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