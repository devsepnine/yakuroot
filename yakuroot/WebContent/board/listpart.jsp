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
						<c:forEach var="bdto" items="${p.getList()}">
							<tr>
								<td>${bdto.f_no}</td>
								<td>${bdto.f_head}</td>
								<td align="left"><c:forEach var="i" begin="1"
										end="${bdto.f_depth}">
										<font color="black">☞</font>
									</c:forEach>
									<c:if test="${bdto.f_depth > 0}">
										<img src="/study/image/다운로드.jpg" width="30" height="20">
									</c:if><a href="f_content.do?no=${bdto.f_no}">
										${bdto.f_title}</a></td>
								<td>${bdto.f_writer}</td>
								<td>${bdto.date}</td>
								<td>${bdto.f_read}</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="6" align="right">
								<button class="btn btn-outline-primary">
									<a href="f_write.do">글쓰기</a>
								</button>
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
	<div align="center">
		<h4>
			<c:if test="${not p.isFirstBlock()}">
				<a href="f_list.do?${p.getPrevBlcok()}">&lt;&lt;</a>
			</c:if>
			<c:if test="${not p.isFirstPage()}">
				<a href="f_list.do?${p.getPrevPage()}">&lt;</a>
			</c:if>
			<c:forEach var="i" begin="${p.getStartBlock()}"
				end="${p.getEndBlock()}">
				<c:choose>
					<c:when test="${p.isCurrentPage(i)}">
						<font color="red">${i}</font>
					</c:when>
					<c:otherwise>
						<a href="f_list.do?${p.getPage(i)}">${i}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${not p.isLastPage()}">
				<a href="f_list.do?${p.getNextPage()}">&gt;</a>
			</c:if>
			<c:if test="${not p.isLastBlock()}">
				<a href="f_list.do?${p.getNextBlock()}">&gt;&gt;</a>
			</c:if>
		</h4>
	</div>
	<!-- 글 검색 테이블 -->
	<div>
		<div>
			<div style="text-align: center;">
				<form action="f_list.do" method="get" align="center">
					<select name="type">
						<option value="f_title">제목</option>
						<option value="f_head">팀</option>
						<option value="f_writer">작성자</option>
					</select> <input type="text" name="keyword" placeholder="검색어"
						required="required">
					<button type="submit" class="btn btn-outline-primary">검색</button>
				</form>
			</div>
		</div>
	</div>