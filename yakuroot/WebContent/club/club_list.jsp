<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="1">
			<thead>
				<tr>
                    <th colspan="2">팀명</th>
                    <th>창단년도</th>
                    <th>연고지</th>
                    <th>구단 소개글</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cdto" items="${cdtolist}" >
                <tr>
                    <td><img src="../img/club_logo/${cdto.c_photo}.png"></td>
                    <td>${cdto.c_name}</td>
                    <td>${cdto.c_year}</td>
                    <td>${cdto.c_born}</td>
                    <td>${cdto.c_club}</td>
                    <td><button>내용 수정</button></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

<jsp:include page="/template/footer.jsp"></jsp:include>