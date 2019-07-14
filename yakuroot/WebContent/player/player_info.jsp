<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<form>
		<table border="1" style="">
			<tbody>
				<tr>
				<th rowspan="9" colspan="3"><img src="<%=request.getContextPath()%>/img/player/doosan/88Kim Tea Hyeong.png"></th><!-- 선수 프로필 사진 -->
<%-- 					<th rowspan="9" colspan="3"><img src="<%=request.getContextPath()%>/img/player/doosan/${pdto.p_photo}.png"></th><!-- 선수 프로필 사진 --> --%>
					<th rowspan="2">${pdto.p_bnum}</th><!-- 선수 등번호 -->
					<th rowspan="2" colspan="2">${pdto.p_name}</th><!-- 선수 이름 -->
				</tr>
				<tr>
				</tr>
				<tr>
					<td>선수명</td>
					<td colspan="2">${pdto.p_name }</td><!-- 선수 이름 -->
				</tr>
				<tr>
					<td>등번호</td>
					<td colspan="2">${pdto.p_bnum}</td><!-- 선수 등번호 -->
				</tr>
				<tr>
					<td>생년월일</td>
					<td colspan="2">${pdto.p_birth}</td><!-- 선수 생년월일 -->
				</tr>
				<tr>
					<td>포지션</td>
					<td colspan="2">${pdto.p_position}</td><!-- 선수 포지션 -->
				</tr>
				<tr>
					<td>키</td>
					<td colspan="2">${pdto.p_height}cm</td><!-- 선수 키 -->
				</tr>
				<tr>
					<td>몸무게</td>
					<td colspan="2">${pdto.p_weight}kg</td><!-- 선수 몸무게 -->
				</tr>
			</tbody>
		</table>
	</form>
</div>
<div>시즌 성적</div>
<div>최근 5경기 성적</div>

<jsp:include page="/template/footer.jsp"></jsp:include>