<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
th {
	text-align: center;
}

.col {
	margin: auto;
}
</style>

<!-- 공지글 목록 테이블 -->
<div>
	<div>
		<div style="width: 1200px; margin: auto;">
			<table border="1" style="margin: auto; width: 1100px">
				<thead>
					<tr>
						<th width="100px">번호</th>
						<th width="150px">말머리</th>
						<th width="550px">제목</th>
						<th width="150px">작성자</th>
						<th width="150px">작성일</th>
						<th width="100px">조회</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${empty p.getList()}">
						<tr>
							<th colspan="6">글이 없습니다</th>
						</tr>
					</c:if>
					<c:forEach var="ndto" items="${p.getList()}">
						<tr>
							<td>${ndto.n_no}</td>
							<td>${ndto.n_head}</td>
							<td><a href="notice_content.do?no=${ndto.n_no}"> ${ndto.n_title}[${ndto.n_count}]</a></td>
							<td>${ndto.n_writer}</td>
							<td>${ndto.date}</td>
							<td>${ndto.n_read}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<c:if test="${auth eq '관리자'}">
						<td colspan="6" align="right">
							<button>
								<a href="notice_write.jsp">글쓰기</a>
							</button>
						</td>
						</c:if>
						
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
</div>
<div align="center">
	<h4>
		<c:if test="${not p.isFirstBlock()}">
			<a href="notice_list.do?${p.getPrevBlcok()}">&lt;&lt;</a>
		</c:if>
		<c:if test="${not p.isFirstPage()}">
			<a href="notice_list.do?${p.getPrevPage()}">&lt;</a>
		</c:if>
		<c:forEach var="i" begin="${p.getStartBlock()}"
			end="${p.getEndBlock()}">
			<c:choose>
				<c:when test="${p.isCurrentPage(i)}">
					<font color="red">${i}</font>
				</c:when>
				<c:otherwise>
					<a href="notice_list.do?${p.getPage(i)}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${not p.isLastPage()}">
			<a href="notice_list.do?${p.getNextPage()}">&gt;</a>
		</c:if>
		<c:if test="${not p.isLastBlock()}">
			<a href="notice_list.do?${p.getNextBlock()}">&gt;&gt;</a>
		</c:if>
	</h4>
</div>
<!-- 글 검색 테이블 -->
<div>
	<div>
		<div style="text-align: center;">
			<form action="notice_list.do" method="post" align="center">
				<select name="type">
					<option value="n_title">제목</option>
				</select> <input type="text" name="keyword" placeholder="검색어"
					required="required">
				<button type="submit">검색</button>
			</form>
		</div>
	</div>
</div>