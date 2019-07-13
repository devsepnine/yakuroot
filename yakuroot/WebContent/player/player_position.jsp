<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<style>
	.form #edit {
		width : 60px;
		padding : 0.5rem 1rem;
	}
</style>

<div align="center">
	<form action="" class="position" text-align="center">
		<a href="#"><input type="button" value="코치"></a>
		<a href="#"><input type="button" value="스테프"></a>
		<a href="#"><input type="button" value="투수"></a>
		<a href="#"><input type="button" value="포수"></a>
		<a href="#"><input type="button" value="내야"></a>
		<a href="#"><input type="button" value="외야"></a>
	</form>
</div>
	<br><br><br>
<div>
	<form action="">
		<table>
			<c:forEach var="cdto" items="${cdtolist}" >
				
			</c:forEach>
		</table>
	</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>