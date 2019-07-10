<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<jsp:include page="/template/header.jsp"></jsp:include>

<!-- 자유게시판 글 내용 jsp -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script>	
</script>
<div align="center">
	<h1>${bdto.f_title}</h1>
</div>

<div align="center">
	<div>
		<div>
			<table>
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
						<td>
						</td>
						<td>
							<form action="f_comments.do" method="post">
								<input type="hidden" name="origin" value="${bdto.f_no}">
								<input type="hidden" name="writer" value="${bdto.f_writer}">
								<textarea rows="4" cols="50" placeholder="댓글입력"
									name="content"></textarea>
								<button type="submit">등록</button>
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
												size="5">${cdto.writer}</font> <c:if
													test="${cdto.writer==bdto.f_writer}">
													<font color="red">(작성자)</font>
												</c:if> ${cdto.date} <br> ${cdto.content}
												<hr></td>
											<td width="80%">
												<form action="comment_su.do" method="post">
													<input type="hidden" name="no" value="${cdto.no}">
													<input type="hidden" name="origin" value="${bdto.f_no}">
													<textarea rows="4" cols="60" name="content">${cdto.content}</textarea>
													<input type="submit" value="수정">
												</form>
											</td>
											<!-- 본인 글이거나 관리자 일때만 표시 -->	
											<td width="10%"><c:if test="${cdto.writer==login||mdto.m_auth==admin}">
													<a href="c_delete.do?no=${cdto.no}" class="su-del">삭제</a>
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
						<button><a href="f_write.do">글쓰기</a></button>
						<button><a href="f_write.do?f_parent=${bdto.f_no}">답글쓰기</a></button></td>
					</tr>
					<tr>
						<td colspan="3" align="reft">
							<h4>
								<c:if test="${bdto.f_writer==login||mdto.m_auth==admin}">
								<button><a href="f_edit.do?f_no=${bdto.f_no}">글 수정</a></button>
								<a href="f_delete.do?no=${bdto.f_no}"><button>글 삭제</button></a>
								</c:if>
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