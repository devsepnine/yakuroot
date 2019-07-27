<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<form>
		<table border="1" style="width: 700px; margin-top: 30px" class="table table-stripe">
			<tbody>
				<tr>
					<th style="width: 150px; height: 200px" rowspan="6"><img height="200px" alt="" src="<%=request.getContextPath()%>/img/player/${pdto.p_club_no}/${pdto.p_bnum}${pdto.p_name}.png"></th><!-- 선수 프로필 사진 -->
					<th style="font-size: 50px">${pdto.p_bnum}</th><!-- 선수 등번호 -->
					<th style="font-size: 50px">${pdto.p_name}</th><!-- 선수 이름 -->
				</tr>
				<tr>
					<td>등번호</td>
					<td>${pdto.p_bnum}번</td><!-- 선수 등번호 -->
				</tr>
				<tr>
					<td>생년월일</td>
					<td>${pdto.p_birth}</td><!-- 선수 생년월일 -->
				</tr>
				<tr>
					<td>포지션</td>
					<td>${pdto.p_position}</td><!-- 선수 포지션 -->
				</tr>
				<tr>
					<td>키</td>
					<td>${pdto.p_height}cm</td><!-- 선수 키 -->
				</tr>
				<tr>
					<td>몸무게</td>
					<td>${pdto.p_weight}kg</td><!-- 선수 몸무게 -->
				</tr>
			</tbody>
		</table>
	</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>