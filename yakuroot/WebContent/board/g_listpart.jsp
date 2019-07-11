<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
th {
	text-align: center;
}
.col{
margin : auto;
}
</style>

	<!-- 글 목록 테이블 -->
	<div>
		<div>
			<div style="width:1200px; margin:auto;">
				<table border="1" style="margin:auto; width:1100px">
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
						<c:forEach var="gdto" items="${p.getList()}">
							<tr>
								<td>${gdto.g_no}</td>
								<td>${gdto.g_head}</td>
								<td align="left">
									<a href="g_content.do?no=${gdto.g_no}">
										${gdto.g_title}
									</a>
								</td>
								<td>${gdto.g_writer}</td>
								<td>${gdto.date}</td>
								<td>${gdto.g_read}</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
						<c:if test="${login eq true}">
							<td colspan="6" align="right">
								<button>
									<a href="g_write.do">글쓰기</a>
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
				<a href="g_list.do?${p.getPrevBlcok()}">&lt;&lt;</a>
			</c:if>
			<c:if test="${not p.isFirstPage()}">
				<a href="g_list.do?${p.getPrevPage()}">&lt;</a>
			</c:if>
			<c:forEach var="i" begin="${p.getStartBlock()}"
				end="${p.getEndBlock()}">
				<c:choose>
					<c:when test="${p.isCurrentPage(i)}">
						<font color="red">${i}</font>
					</c:when>
					<c:otherwise>
						<a href="g_list.do?${p.getPage(i)}">${i}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${not p.isLastPage()}">
				<a href="g_list.do?${p.getNextPage()}">&gt;</a>
			</c:if>
			<c:if test="${not p.isLastBlock()}">
				<a href="g_list.do?${p.getNextBlock()}">&gt;&gt;</a>
			</c:if>
		</h4>
	</div>
	<!-- 글 검색 테이블 -->
	<div>
		<div>
			<div style="text-align: center;">
				<form action="g_list.do" method="get" align="center">
					<select name="type">
						<option value="g_title">제목</option>
						<option value="g_head">팀</option>
						<option value="g_writer">작성자</option>
					</select> <input type="text" name="keyword" placeholder="검색어"
						required="required">
					<button type="submit">검색</button>
				</form>
			</div>
		</div>
	</div>