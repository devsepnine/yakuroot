<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/template/header.jsp"></jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center" text-align="center">
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
          
                <tr>
                    <td><img src="../img/club_logo/${cdto.c_photo}.png"></td>
                    <td>${cdto.c_name}</td>
                    <td>${cdto.c_year}</td>
                    <td>${cdto.c_born}</td>
                    <td>${cdto.c_club}</td>
                    <td><a href="club_list_edit.do?c_no=${cdto.c_no}"><button>수정 완료</button></td></a>
                </tr>
       
            </tbody>
        </table>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>