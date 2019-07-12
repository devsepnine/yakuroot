<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
<table border='1' style="width: 600px" class="table table-noline">
    <tbody>
        <tr>
            <td colspan="10"></td>
        </tr>
        
        
        <tr ><!-- 구단 로고 사진 -->
            <td style="width: 210px" rowspan="4"><img style="width: 200px" alt="" src="<%=request.getContextPath() %>/img/emblem/${cdto.c_photo}.png"></td>
            <td colspan="4"></td>
            
        </tr>
        <tr>
            <td></td><!-- 구단 이름 -->
            <td colspan="3">${cdto.c_name}</td>            
        </tr>
        <tr>
            <td></td><!-- 구단 창단 년도 -->
            <td colspan="3">${cdto.c_year}</td>
        </tr>
        <tr>
            <td></td><!-- 구단 연고지 -->
            <td colspan="3">${cdto.c_born}</td>
        </tr>
        
        
        
        <tr><!-- 구단 소개글 -->
            <td colspan="5">${cdto.c_club}</td>
        </tr>
        
        
        <tr>
            <td colspan="5">[찾아오시는 길]</td>
        </tr>
        <tr><!-- 홈 경기장 지도 -->
            <td colspan="5">${cdto.c_map}</td>
        </tr>
        
        
        
        <tr>
            <td colspan="5">[구장 정보]</td>
        </tr>
        <tr><!-- 홈 경기장 좌석표 -->
            <td colspan="5">
            <img style="with: 500px" alt="" src="<%=request.getContextPath() %>/img/stadium/${cdto.c_photo}.png">
        </tr>

    </tbody>
</table>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>