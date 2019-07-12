<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<jsp:include page="/template/header.jsp"></jsp:include>
<!-- 공지사항 글 내용 jsp -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script>
	$(function() {
		$('.su').hide();

		$('.btn').click(function(e) {
			e.preventDefault();
			$(this).parent().prevAll('.content').toggle();
			$(this).parent().prevAll('.su').toggle();
			$(this).parent().prevAll('.btn').toggle();
			//			$('.btn').toggle();
			//			$('.su').toggle();
			if ($(this.text() == '수정'))
				$(this).text('취소');
			else
				$(this).text('수정');
		});
		$('.su-del').click(function(e) {
			//댓글 삭제를 누르면 정말 삭제할것인지 확인창 출력후 처리
			e.preventDefault();

			var choice = confirm('정말 삭제하시겠습니까');
			if (choice == true) {
				//원래 목적지(href 속성에 적혀있는 주소)로 이동
				//이동 명령 :location.href:"주소";
				//$(location).attr('href','주소');
				var url = $(this).attr('href');
				$(location).attr('href', url);
			}
		});
	});
</script>
<div align="center">
	<div>
		<div>
			<table border="1">
				<tbody>
					<tr>
						<div align="center">
							<h1>${ndto.n_title}</h1>
						</div>
					</tr>
					<tr>
						<th width="10%">작성자</th>
						<td>${ndto.n_writer}</td>
					</tr>
					<tr>
						<th width="30%">내용</th>
						<td style="width: 500px; height: 200px;">
						<img src="n_download.do?n_savename=${ndto.n_savename}">
						${ndto.n_content}</td>
					</tr>
					<tr>	
						<th width="20%">작성일</th>
						<td>${ndto.n_when}</td>
					</tr>
					<tr>
						<th colspan="2"><h4 align="left">댓글 ${list2.size()} // 조회수 ${ndto.n_read}</h4></th>
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
													test="${cdto.writer==ndto.n_writer}">
													<font color="red">(작성자)</font>
												</c:if> ${cdto.date} <br> ${cdto.content}
												<hr></td>
											<td width="80%" class="su">
												<form action="n_comment_su.do" method="post">
													<input type="hidden" name="no" value="${cdto.no}">
													<input type="hidden" name="origin" value="${ndto.n_no}">
													<textarea rows="4" cols="60" name="content">${cdto.content}</textarea>
													<input type="submit" value="수정">
												</form>
											</td>
											<!-- 본인 글이거나 관리자 일때만 표시 -->
											<td width="5%"><c:if test="${cdto.writer==login}">
													<a href="#" class="btn">수정</a></td>
											<td width="5%"><a href="nc_delete.do?no=${cdto.no}"
												class="su-del">삭제</a> </c:if></td>
										</tr>
										</c:forEach>
					<tr>
										<td colspan="2" align="center">
											<form action="n_comments.do" method="post">
												<input type="hidden" name="origin" value="${ndto.n_no}">
												<input type="hidden" name="writer" value="${login}">
												<textarea rows="4" cols="50" placeholder="댓글입력"
														name="content"></textarea>
												<button type="submit">등록</button>
											</form>
										</td>
									</tr>
									<%--댓글 1개 표시 영역 --%>
								
								</tbody>
							</table>
						</td>
					</tr>
					<%--댓글 입력 영역 --%>
					<tr>
						<td colspan="3" align="reft">
							<h4>
								<c:if test="${my eq true}">
									<button>
										<a href="notice_edit.do?n_no=${ndto.n_no}">글 수정</a>
									</button>
									<a href="n_delete.do?n_no=${ndto.n_no}"><button>글 삭제</button></a>
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
<jsp:include page="/template/footer.jsp"></jsp:include>