<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<!-- 자유게시판 글 내용 jsp -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script>

</script>
<div align="center">
	<h1>${bdto.f_title}</h1>
</div>

<div class="container">
	<div class="row">
		<div class="col-md-6 offset-md-3">
			<table class="table">
				<tbody>
					<tr>
						<th width="10%">작성자</th>
						<td>${bdto.f_writer}</td>
					</tr>
					<tr>
						<th width="30%">내용</th>
						<td style="width: 500px; height: 200px;">${bdto.f_content}</td>
					</tr>
					<tr>
						<th width="20%">작성일</th>
						<td>${bdto.f_when}</td>
					</tr>
					<tr>
						<th width="20%">조회수</th>
						<td>${bdto.f_read}</td>
					</tr>
					<tr>
						<th>댓글 ${list2.size()}</th>
					</tr>
					<tr>
						<td colspan="2">
							<form action="f_comments.do" method="post">
								<input type="hidden" name="f_origin" value="${bdto.f_no}">
								<textarea rows="4" cols="100" placeholder="댓글입력"
									name="f_content"></textarea>
								<button class="btn btn-outline-primary" type="submit">등록</button>
							</form>
						</td>
					</tr>
					<%--댓글 목록 표시 --%>
					<tr>
						<td colspan="2">
							<table width="100%">
								<tbody>
									<%--댓글 1개 표시 영역 --%>
									<c:forEach var="cdto" items="${list2}">
										<tr>
											<td width="90%" class="content"><font color="blue"
												size="5">${cdto.f_writer}</font> <c:if
													test="${cdto.f_writer==bdto.f_writer}">
													<font color="red">(작성자)</font>
												</c:if> ${cdto.f_date} <br> ${cdto.f_content}
												<hr></td>
											<td width="80%" class="su">
												<form action="comments_su.do" method="post">
													<input type="hidden" name="no" value="${cdto.f_no}">
													<input type="hidden" name="origin" value="${bdto.f_no}">
													<textarea rows="4" cols="95" name="content">${cdto.f_content}</textarea>
													<input type="submit" value="수정">
												</form>
											</td>
											<!-- 본인 글일때만 표시 -->
											<td width="5%"><c:if test="${cdto.f_writer==ok}">
													<a href="#" class="btn">수정</a>
												</c:if></td>
											<td width="5%"><c:if test="${cdto.f_writer==ok}">
													<a href="c_delete.do?no=${cdto.f_no}" class="su-del">삭제</a>
												</c:if></td>
										</tr>
									</c:forEach>
									<%--댓글 1개 표시 영역 --%>
								</tbody>
							</table>
						</td>
					</tr>
					<%--댓글 입력 영역 --%>
					<tr>
						<td colspan="3" align="right">
						<button class="btn btn-outline-primary"><a href="f_write.jsp">글쓰기</a></button>
						<button class="btn btn-outline-primary"><a href="f_write.jsp?parent=${bdto.f_no}">답글쓰기</a></button></td>
					</tr>
					<tr>
						<td colspan="3" align="reft">
							<h4>
								<%-- <c:if test="${my}"> --%>
								<button class="btn btn-outline-primary"><a href="f_edit.jsp?f_no=${bdto.f_no}">글 수정</a></button>
								<a href="f_delete.do?no=${bdto.f_no}"><button class="btn btn-outline-primary">글 삭제</button></a>
								<%-- </c:if> --%>
							</h4>

						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<hr>
<%-- <c:if test="${my}"> --%>

<%-- </c:if> --%>
<br>

<jsp:include page="/template/footer.jsp"></jsp:include>