<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	$(function () {
		var hour = parseInt(${matdto.m_date.substring(11,13)});
		var min = parseInt(${matdto.m_date.substring(14,16)});
		
		$("select[name=hour]").val(hour);
		$("select[name=min]").val(min);
		$("select[name=team1]").val("${matdto.m_team1}");
		$("select[name=team2]").val("${matdto.m_team2}");
		$("select[name=stadium]").val("${matdto.m_stadium}");
		
		
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
	.fix_btn{
		background-color: #6B66FF;
		color: white;
		font-weight: bold;
		padding: 0.3rem;
		box-shadow: 1px 1px 1px black;
		margin-right: 20px;
		border-radius: 5px;
		font-size: 15px;
	}
</style>
<div style="width: 1100px; margin: auto;">
<form action="" method="post" name="match">
	<table style="width: 100%;" class="table table-stripe table-hover">
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
				<td><input type="date" name="date" id="match_date" value="${matdto.m_date.substring(0,10)}"></td>
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
				<td><input type="number" value="${matdto.m_point1 }" name="team1point" ></td>
				<td><input type="number" value="${matdto.m_point1 }" name="team2point" ></td>
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
	<input type="hidden" name="match_no" value="${match_no}">
	<div style="text-align: center; padding: 0.5rem;">
	<a class="match_fix_btn fix_btn match_add_btn">경기 일정 수정</a>
	<a href="<%=request.getContextPath()%>/match/match_delete?match_no=${match_no }" class="match_del_btn fix_btn">경기 일정 제거</a>
	</div>
	</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>