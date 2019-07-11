<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
<table border='1' style="width: 600px">
    <tbody>
        <tr>
            <td colspan="10"></td>
        </tr>
        
        
        <tr >
            <td style="width: 210px" rowspan="4"><img style="width: 200px" alt="" src="<%=request.getContextPath() %>/img/emblem/${cdto.c_photo}.png"></td>
            <td colspan="4">빈칸</td>
            
        </tr>
        <tr>
            <td></td>
            <td colspan="3">${cdto.c_name}</td>            
        </tr>
        <tr>
            <td></td>
            <td colspan="3">${cdto.c_year}</td>
        </tr>
        <tr>
            <td></td>
            <td colspan="3">${cdto.c_born}</td>
        </tr>
        
        
        
        <tr>
            <td colspan="5">${cdto.c_club}</td>
        </tr>
        
        
        <tr>
            <td colspan="5">[찾아오시는 길]</td>
        </tr>
        <tr>
            <td colspan="5">${cdto.c_map}</td>
        </tr>
        
        
        
        <tr>
            <td colspan="5">[구장 정보]</td>
        </tr>
        <tr>
            <td colspan="5">${cdto.c_stadium}</td>
        </tr>

    </tbody>
</table>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>