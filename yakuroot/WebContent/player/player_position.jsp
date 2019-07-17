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
	.cat_btn{
		display: inline-block;
		width: 80px;
		height: 30px;
		vertical-align: middle;
	}
</style>
<div style="height: 40px;"></div>
<div style="text-align: center; margin: auto; width: 1200px;">
		<!-- 버튼 디자인 -->
		<table style="width: 900px; margin: auto;">
			<tbody>
				<tr>
					<td><a  href="player_position.do?p_no="><span class="cat_btn">코치</span></a></td>
					<td><a  href="player_position_staff.do?p_no="><span class="cat_btn">스태프</span></a></td>
					<td><a  href="player_position_pitcher.do?p_no="><span class="cat_btn">투수</span></a></td>
					<td><a  href="player_position_catcher.do?p_no="><span class="cat_btn">포수</span></a></td>
					<td><a  href="player_position_in.do?p_no="><span class="cat_btn">내야</span></a></td>
					<td><a  href="player_position_out.do?p_no="><span class="cat_btn">외야</span></a></td>
				</tr>
			</tbody>
		</table>
</div>
<br>
<br>
<br>
<div>
	<form action="">
		<table align="center">
			<tbody>
				<c:if test="${tt%5==0 }">
					<tr>
				</c:if>
					<c:forEach var="pdto" items="${pdtolist}">
					<c:set var="tt" value="${tt + 1}"></c:set>
							<td>
							<img width="150px" height="157px" alt="" src="<%=request.getContextPath()%>/img/player/${pdto.p_club_no}/${pdto.p_bnum}${pdto.p_name}.png"><br>
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