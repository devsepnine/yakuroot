<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      
<jsp:include page="/template/header.jsp"></jsp:include>

<style>
	.table {
		text-align : center;
	}
	
	.table input[name=details],
		input[name=eidt] {
		width : 100px;
		text-align : center;
	}
</style>

<script>

	$(function(){
		
		$("select[name=type]").val("${param.type}");
	});
	
</script>
<div align="center">
	<form action="search.do" method="get" >
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
</div>

<hr>

<c:choose>
	<c:when test="${empty list}">
		<div align = "center">
			<h2>[ 검색 결과가 존재하지 않습니다 ]</h2>
		</div>
	</c:when>

	<c:otherwise>
	<div align = "center">
		<form class="form form-label">
			<fieldset>
				<legend>SEARCH RESULT</legend>
					<table border="1" width="900" class="table table-noline">
						<thead>
							<tr>
								<th>NO</th>
								<th>ID</th>
								<th>NAME</th>
								<th>BIRTH</th>
								<th>EMAIL</th>
								<th>TEAM</th>
								<th>AUTH</th>
								<th width = "200px" colspan="2">FUNCTION</th>
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
								<td>${mdto.m_fav}</td>
								<td>${mdto.m_auth}</td>
								<td>
									<a href ="info.do?m_id=${mdto.m_id}"><input type="button" value="DETAILS" name="details"></a>
								</td>
								<td>
									<a href ="edit_info.do?m_id=${mdto.m_id}"><input type="button" value="EDIT" name="edit"></a>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
			</fieldset>
		</form>
	</div>
	
	</c:otherwise>
</c:choose>

<jsp:include page="/template/footer.jsp"></jsp:include>
