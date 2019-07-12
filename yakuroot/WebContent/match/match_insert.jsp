<%@page import="club.beans.ClubDao"%>
<%@page import="club.beans.ClubDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	
<div style="width: 1100px; margin: auto;">
	<table style="width: 100%" border=1;>
		<form action="" method="get">
		<thead>
			<tr>
				<th width="20%">날짜</th>
				<th width="40%">시간</th>
				<th>구단1</th>
				<th>구단1 점수</th>
				<th>구단2 점수</th>
				<th>구단2</th>
				<th width="20%">구장</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="date"></td>
				<td>
					<select name ="hour">
						<c:forEach var="i" begin="1" end="24" step="1">
						<option value="${i}">${i}</option>
						</c:forEach>
					</select>
					:
					<select name ="min">
						<c:forEach var="i" begin="0" end="60" step="1">
						<option value="${i}">${i}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select name = "team1">
						<c:forEach var="cdto" items="${cdtolist}">
							<option value="${cdto.c_no}">${cdto.c_name}</option>
					</c:forEach>
					</select>
				</td>
				<td><input type="text"></td>
				<td><input type="text"></td>
				<td>
				
					<select name = "team1">
						<c:forEach var="cdto" items="${cdtolist}">
							<option value="${cdto.c_no}">${cdto.c_name}</option>
						</c:forEach>
					</select></td>
					
				<td><input type="text"></td>
			</tr>
		</tbody>
		</form>
	</table>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>