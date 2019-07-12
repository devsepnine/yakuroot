<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/template/header.jsp"></jsp:include>
<style>
	.match_div{
		width:900px;
		margin:auto;
	}
</style>

<div class="match_div">
	<table border="1" style="width:900px;">
		<thead>
			<tr>
				<th width="20%">날짜</th>
				<th width="20%">시간</th>
				<th colspan="4">경기</th>
				<th width="20%">구장</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty matlist}">
					<tr>
						<th colspan="7"> 경기 일정이 없습니다.</th>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="matdto" items="${matlist}">
						<tr>
							<td>${matdto.m_date}</td>
							<td>${matdto.m_date}</td>
							<td>${matdto.m_team1}</td>
							<td>${matdto.m_point1}</td>
							<td>${matdto.m_point2}</td>
							<td>${matdto.m_team2}</td>
							<td>${matdto.m_stadium}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	<c:if test="${auth eq '관리자'}">
		<a href="match_insert"><button>경기일정 추가하기</button></a>
	</c:if>
</div>


<jsp:include page="/template/footer.jsp"></jsp:include>