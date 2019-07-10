<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="/yakuroot/css/common.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
   
    <%
//		로그아웃
//			세션삭제, 홈으로 이동
// 		session.removeAttribute("login");  // ->항목삭제
		session.invalidate(); // ->전체삭제
    
		response.sendRedirect(request.getContextPath()); 
    %>
    
<jsp:include page="/template/footer.jsp"></jsp:include>