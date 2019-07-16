<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 선수 포지션 선택(코치) -->


<style>
.form {
	width: 60px;
	padding: 0.5rem 1rem;
}
</style>

<div align="center">
	<form class="form" text-align="center">
		<!-- 버튼 디자인 -->
		<table>
			<tbody>
				<tr>
					<td><a href="player_position.do?p_no="><input type="button" value="코치"></a></td>
					<td><a href="player_position_staff.do?p_no="><input type="button" value="스테프"></a></td>
					<td><a href="player_position_pitcher.do?p_no="><input type="button" value="투수"></a></td>
					<td><a href="player_position_catcher.do?p_no="><input type="button" value="포수"></a></td>
					<td><a href="player_position_in.do?p_no="><input type="button" value="내야"></a></td>
					<td><a href="player_position_out.do?p_no="><input type="button" value="외야"></a></td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
<br>
<br>
<br>
<div>
	<form action="">
		<table align="center">
			<tbody>
			
				<!-- 5개씩 끊어서 반복하고 싶은데 어떻게 해야할 지 나는 모르겠다 -->
				<c:if test="${tt%5==0 }">
					<tr>
				</c:if>
					<c:forEach var="pdto" items="${pdtolist}">
					<c:set var="tt" value="${tt + 1}"></c:set>
							<td>
							<img width="150px" alt="" src="<%=request.getContextPath()%>/img/player/${pdto.p_club_no}/${pdto.p_bnum}${pdto.p_name}.png"><br>
							<a href="#">${pdto.p_name}</a>
							</td>
				<c:if test="${tt%5==0}">
					</tr>
				</c:if>
					</c:forEach>
			</tbody>
		</table>
	</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>