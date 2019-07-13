<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<jsp:include page="/template/header.jsp"></jsp:include>
	
	<%
	session.removeAttribute("login");
	%>
	
	
	<style>
		p {
			font-size: 50px;
			text-align : center;
			padding-top: 50px;
		}
	</style>
	
	
	<p>[ 그동안 이용해주셔서 감사합니다 ]<p>
	
	

	<jsp:include page= "/template/footer.jsp"></jsp:include>
