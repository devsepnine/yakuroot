<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/template/header.jsp"></jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 관리자메뉴에서 구단 프로필을 수정할 수 있는 페이지 -->

<style>
	.form #save{
		width : 60px;
		padding : 0.5rem 1rem;
	}
</style>

<div align = "center" text-align = "center">
	   <form action = "club_list_edit.do" method = "post" class="form"><!-- 버튼 디자인 -->
				<table border="1" align="center" text-align="center">
							<thead>
								<tr>
				                    <th colspan="2">팀명</th>
				                    <th>창단년도</th>
				                    <th>연고지</th>
				                    <th>구단 소개글</th>
				                    <th>구장 좌표</th>
				                    <th>비고</th>
				                </tr>
				            </thead>
				            <tbody>
				          
				                <tr>
				                    <td><img src="../img/club_logo/${cdto.c_photo}.png"></td><!-- 구단 로고 -->
				                    
				                    <input type="hidden" value="${cdto.c_no}"name="c_no"><!-- 구단 고유 번호. 정보들 불러오기 위해 필요하지만 hidden으로 보여주진 않는다 -->
				                    <td><input type="text" value="${cdto.c_name}" name="c_name"></td><!-- 구단 이름 -->
				                    <td><input type="text" value="${cdto.c_year}" name="c_year"></td><!-- 구단 창단 년도 -->
				                    <td><input type="text" value="${cdto.c_born}" name="c_born"></td><!-- 구단 연고지 -->
				                    <td><input type="text" value="${cdto.c_club}" name="c_club"></td><!-- 구단 소개글 -->
				                    <td><input type="text" value="${cdto.c_map}" name="c_map"></td><!-- 구장 좌표 -->
				                    <td text-align="center"><input type="submit" id="save" value="저장"></td><!-- 저장 버튼 -->
				                </tr>
				       
				            </tbody>
				        </table>
				        </form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>