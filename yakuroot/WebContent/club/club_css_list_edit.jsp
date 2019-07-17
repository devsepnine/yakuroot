
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/template/header.jsp"></jsp:include>

<style>
	.form.admin #save{
		width : 60px;
		padding : 0.5rem 1rem;
		align : center;
		margin-left: 0px;
		color : white;
	}
	
</style>

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
				<td>비고</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cssdto" items="${cssdtolist}">
				<tr>
					<td><img src="../img/club_logo/${cdto.c_photo}.png"></td>
					<input type="hidden" value="${cdto.c_no}"name="c_no">
					<td>${cssdto.c_game}</td>
					<td>${cssdto.c_win}</td>
					<td>${cssdto.c_loss}</td>
					<td>${cssdto.c_draw}</td>
					<td>${cssdto.c_victory}</td>
					<td>${cssdto.c_gap}</td>
					<td>${cssdto.c_last_ten}</td>
					<td>${cssdto.c_continue}</td>
					<td text-align="center"><input type="submit" id="save" value="저장"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>