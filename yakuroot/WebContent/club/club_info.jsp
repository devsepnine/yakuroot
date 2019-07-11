<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
<table border='1' style="width: 600px">
    <tbody>
        <tr>
            <td colspan="10"></td>
        </tr>
        
        
        <tr>
            <td rowspan="4" colspan="3"><img style="width: 300" alt="" src="<%=request.getContextPath() %>/img/emblem/${cdto.c_photo}.png"></td>
            <td colspan="7">빈칸</td>
            
        </tr>
        <tr>
            <td></td>
            <td>${cdto.c_name}</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            
        </tr>
        <tr>
            <td></td>
            <td>${cdto.c_year}</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td>${cdto.c_born}</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        
        
        
        <tr>
            <td colspan="10">${cdto.c_club}</td>
        </tr>
        
        
        <tr>
            <td colspan="10">[찾아오시는 길]</td>
        </tr>
        <tr>
            <td colspan="10">${cdto.c_map}</td>
        </tr>
        
        
        
        <tr>
            <td colspan="10">[구장 정보]</td>
        </tr>
        <tr>
            <td colspan="10">${cdto.c_stadium}</td>
        </tr>

    </tbody>
</table>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>