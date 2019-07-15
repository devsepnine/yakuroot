<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
<jsp:include page="/template/header.jsp"></jsp:include>

<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=68ddd144598c5b4deebea5bf8841415f"></script>
 <script>
        $(function(){
            var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
            var options = { //지도를 생성할 때 필요한 기본 옵션
                center: new kakao.maps.LatLng(${cdto.c_map}), //지도의 중심좌표.
                level: 3 //지도의 레벨(확대, 축소 정도)
            };

            var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
        
            // 마커가 표시될 위치입니다 
            var markerPosition = new kakao.maps.LatLng(${cdto.c_map});

            // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
                position: markerPosition
            });

            // 마커가 지도 위에 표시되도록 설정합니다
            marker.setMap(map);
        });
        
        
    </script>

<div align="center" text-align="center">
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
	            <td colspan="5">
	            	<div id="map" style="width:700px;height:300px;"></div>
	            </td>
	        </tr>
	        
	        
	        
	        <tr>
	            <td colspan="5">[구장 정보]</td>
	        </tr>
	        <tr><!-- 홈 경기장 좌석표 -->
	            <td colspan="5">
	            <img width= "700px" height="auto" alt="" src="<%=request.getContextPath() %>/img/stadium/${cdto.c_photo}.png">
	        </tr>
	
	    </tbody>
	</table>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>