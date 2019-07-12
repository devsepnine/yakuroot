<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<jsp:include page="/template/header.jsp"></jsp:include>


<form action="search.do" method="get">
	<select name="type">
		<option value="m_id">ID</option>
		<option value="m_name">NAME</option>
		<option value="m_birth">BIRTH</option>
		<option value="m_fav">TEAM</option>
		<option value="m_auth">AUTH</option>
	</select>
	
	<input type="search" name="keyword" placeholder="검색어" required value="${keyword}">
	
	<input type="submit" value="검색">
</form>

<hr>

<c:choose>

	<c:when test="${empty list}">
		<h3>검색 결과가 존재하지 않습니다</h3>
	</c:when>
	
	<c:otherwise>
		<table border="1" width="900">
		<thead>
			<tr>
				<th>NO</th>
				<th>ID</th>
				<th>NAME</th>
				<th>BIRTH</th>
				<th>EMAIL</th>
				<th>TEAM</th>
				<th>AUTH</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="mdto" items="${list}">
			<tr>
				<td>${mdto.m_no}</td>
				<td>${mdto.m_id}</td>
				<td>${mdto.m_name}</td>
				<td>${mdto.m_birth}</td>
				<td>${mdto.m_email}</td>
				<td>${mdto.m_team}</td>
				<td>${mdto.m_auth}</td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
	</c:otherwise>
</c:choose>

<jsp:include page="/template/footer.jsp"></jsp:include>
