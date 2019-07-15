<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/template/header.jsp"></jsp:include>

<div>
	<table border="1" align="center">
		<thead>
			<tr>
				<th>구단 로고</th>
				<th>경기수</th>
				<th>승</th>
				<th>패</th>
				<th>무승부</th>
				<th>승률</th>
				<th>게임차</th>
				<th>최근 10경기</th>
				<th>연속</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach>
				<tr>
					<td><img src="../img/club_logo/${cdto.c_photo}.png"></td>
					<td>${cssdto.c_game}</td>
					<td>${cssdto.c_win}</td>
					<td>${cssdto.c_loss}</td>
					<td>${cssdto.c_draw}</td>
					<td>${cssdto.c_victory}</td>
					<td>${cssdto.c_gap}</td>
					<td>${cssdto.c_last_ten}</td>
					<td>${cssdto.c_continue}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>