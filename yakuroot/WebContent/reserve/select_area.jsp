<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/template/header.jsp"></jsp:include>

<div style="text-align: center;">
	<table style="width: 900px;">
		<tbody>
		<tr>
			<c:forEach var="adto" items="${arealist}">
				<td><a href="../reserve/select_seat?match_no=${match_no}&area_no=${adto.a_no}"><button>${adto.a_name}</button></a></td>
			</c:forEach>
		</tr>
		</tbody>
	</table>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>