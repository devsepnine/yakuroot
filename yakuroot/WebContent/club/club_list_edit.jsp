<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/template/header.jsp"></jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
	.form #save{
		width : 60px;
		padding : 0.5rem 1rem;
	}
</style>

<div align = "center" text-align = "center">
	   <form action = "club_list_edit.do" method = "post" class="form">
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
				                    
				                    <td><input type="text" value="${cdto.c_name}" name="c_name"></td>
				                    <td><input type="text" value="${cdto.c_year}" name="c_year"></td>
				                    <td><input type="text" value="${cdto.c_born}" name="c_born"></td>
				                    <td><input type="text" value="${cdto.c_club}" name="c_club"></td>
				                    <input type="hidden" value="${cdto.c_no}"name="c_no">
				                  
				                    <td text-align="center"><input type="submit" id="save" value="저장"></td>
				                </tr>
				       
				            </tbody>
				        </table>
				        </form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>