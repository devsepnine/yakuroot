<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.reserve_btn{
		border: none;
		background-color: lightgrey;
		box-shadow: 1px 1px 1px black;
		color: black;
		font-size: 20px;
		width: 50px;
		height: 30px;
	}
	
</style>


<jsp:include page="/template/header.jsp"></jsp:include>
<c:set var="reserve" value="0" />
<div style="text-align:center; margin: auto; width: 1200px;">
	<h1>${adto.a_name}</h1>
	<table style="width: 700px; margin: auto; padding: 1.5rem;">
		<c:forEach var="i" begin="1" end="${adto.a_col}" step="1">
			<tr>
				<c:forEach var="j" begin="1" end="${adto.a_row}" step="1">
					<td style="text-align: center; padding: 0.6rem; width: 25px;"><button class="reserve_btn">
					
					<c:choose>
						<c:when test="${sdtolist[reserve].s_able eq 0}">
							${sdtolist[reserve].seat_name}
						</c:when>
						<c:otherwise>
							X
						</c:otherwise>
					</c:choose>
					</button></td>
					<c:set var="reserve" value="${reserve + 1 }"/>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	<a class="cat_btn">예매하기</a>
</div>


<jsp:include page="/template/footer.jsp"></jsp:include>