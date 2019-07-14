<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
//		로그아웃
//			세션삭제, 홈으로 이동
// 		session.removeAttribute("login");  // ->로그인 항목삭제
		session.invalidate(); // ->전체삭제
    
		response.sendRedirect(request.getContextPath()); 
    %>
