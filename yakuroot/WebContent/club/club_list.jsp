<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 관리자메뉴에서 구단 리스트를 보는 페이지, 수정버튼을 누르면 수정페이지로 넘어갈 수 있는 페이지 -->

<style>
	.form #edit {
		width : 60px;
    	padding: 0.5rem 1rem;
	}
</style>


<div align="center" text-align="center">
<form class="form"><!-- 버튼 디자인 -->
		<table border="1" align="center" text-align="center">
			<thead>
				<tr>
                    <th colspan="2">팀명</th>
                    <th>창단년도</th>
                    <th>연고지</th>
                    <th>구단 소개글</th>
                    <th>비고</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cdto" items="${cdtolist}" ><!-- 반복문 -->
                <tr>
                    <td><img src="../img/club_logo/${cdto.c_photo}.png"></td><!-- 구단 로고 -->
                    <td>${cdto.c_name}</td><!-- 구단 이름 -->
                    <td>${cdto.c_year}</td><!-- 구단 창단년도 -->
                    <td>${cdto.c_born}</td><!-- 구단 연고지 -->
                    <td>${cdto.c_club}</td><!-- 구단 소개글 -->
                    <td text-align="center"><a href="club_list_edit.do?c_no=${cdto.c_no}"><input type="button"  id= "edit" value="수정"></a></td><!-- 수정 버튼 -->
                </tr>
                </c:forEach>
            </tbody>
        </table>
</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>