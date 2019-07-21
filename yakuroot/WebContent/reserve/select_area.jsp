<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/template/header.jsp"></jsp:include>

<div style="text-align: center; width: 1200px; margin: auto;">
	<h1>선택 가능한 구역</h1>
	<center>
	<table>
		<tbody>
		<tr>
			<c:forEach var="adto" items="${arealist}">
				<td><a class="cat_btn" href="../reserve/select_seat?s_no=${s_no}&match_no=${match_no}&area_no=${adto.a_no}">${adto.a_name}</a></td>
			</c:forEach>
		</tr>
		</tbody>
	</table>
	</center>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>