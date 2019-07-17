<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/template/header.jsp"></jsp:include>
<style>
	.match_div{
		width:1200px;
		margin:auto;
		text-align: center;
	}
	.match_table th{
		font-size: 30px;
		border-bottom: 3px solid black;
	}
	.match_table td{
		font-size: 20px;
	}
	.a_btn{
		background-color: #6B66FF;
		color: white;
		font-weight: bold;
		padding: 0.3rem;
		box-shadow: 1px 1px 1px black;
		margin-right: 20px;
		font-size: 20px;
		border-radius: 5px;
	}
	.b_btn{
		background-color: #6B66FF;
		color: white;
		padding: 2px;
		box-shadow: 1px 1px 1px black;
		border-radius: 5px;
	}
	.b_btn:hover{
		background-color: #F58282;
	}
	.a_btn:hover{
		background-color: #F58282;
	}
</style>

<div class="match_div" >
	<h1>경기 일정</h1>
	<table class="match_table table table-stripe table-hover" style="width:1100px;">
		<thead>
			<tr>
				<th width="20%">날짜</th>
				<th width="20%">시간</th>
				<th colspan="4">경기</th>
				<th width="20%">구장</th>
				<c:if test="${auth eq '관리자'}">
					<th>수정</th>
				</c:if>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty matlist}">
					<tr>
						<th colspan="8"> 경기 일정이 없습니다.</th>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="matdto" items="${matlist}">
						<tr>
							<td>${matdto.m_date.substring(0,10)}</td>
							<td>${matdto.m_date.substring(11,19)}</td>
							<td>${matdto.m_team1}</td>
							<td>${matdto.m_point1}</td>
							<td>${matdto.m_point2}</td>
							<td>${matdto.m_team2}</td>
							<td>${matdto.m_stadium}</td>
							<c:if test="${auth eq '관리자'}">
								<td><a class="b_btn" href="match_fix?match_no=${matdto.match_no}">수정하기</a></td>
							</c:if>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>