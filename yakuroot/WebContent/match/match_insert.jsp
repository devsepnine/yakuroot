<%@page import="club.beans.ClubDao"%>
<%@page import="club.beans.ClubDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	$(function () {
		document.getElementById('match_date').value = new Date().toISOString().substring(0, 10);
		  
		$(".match_add_btn").click(function(){
			var team1 = $("select[name=team1]").val();
			var team2 = $("select[name=team2]").val();
			console.log(team1, team2);
			if(team1 === team2){
				window.alert("팀 이름은 같을 수 없습니다");
				return false;
			}
			else{
				$("form[name=match]").submit();
			}
		});
		
	});
</script>

<style>

</style>


<div style="width: 1100px; margin: auto; text-align: center;">
<h1> 경기 일정 추가 하기</h1>
<form action="" method="post" name="match">
	<table style="width: 100%;" class= "table table-stripe table-hover">
		
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
				<td><input type="date" name="date" id="match_date"></td>
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
				<td><input type="number" value="0" name="team1point" readonly></td>
				<td><input type="number" value="0" name="team2point" readonly></td>
				<td>
				
					<select name = "team2">
						<c:forEach var="cdto" items="${cdtolist}">
							<option value="${cdto.c_no}">${cdto.c_name}</option>
						</c:forEach>
					</select></td>
					
				<td>
					<select name = "stadium">
						<c:forEach var="sdto" items="${sdtolist}">
							<option value="${sdto.s_no}">${sdto.s_name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</tbody>
		
	</table>
	<br><br>
	<a class="match_add_btn cat_btn ">경기 일정 추가</a>
	</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>