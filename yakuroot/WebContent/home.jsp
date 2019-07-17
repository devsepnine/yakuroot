<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/template/header.jsp"></jsp:include>
	

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" type="text/css" href="css/swiper.css">
    
    <style>
    .swiper-container {
        width: 620px;
        height: 450px;
    }
    .match4_table{
    	background-color: white;
    	margin-right: 15px;
    }
    .match4_table td{
    	font-size: 20px;
    	padding: 0.2rem;
    }
    </style>
    
<!--     배트애니메이션 -->
    <style>
        .baseball-bat, .baseball-ball{
            position:fixed;
        }
        .baseball-bat{
            top:50%;
            left:50%;
            margin-top:-150px;
            width:200px;
            height:200px;
            animation-name:bat2;
            animation-duration: 0.1s
        }
        .baseball-ball{
            top:50%;
            left:50%;
            margin-left:-40px;
            margin-top: -60px;
            width:50px;
            height:36px;
            animation-name: hit;
            animation-duration: 3s;
        }
        @keyframes bat2{
            from{
                transform:rotate(0deg);
            }
            to{
                transform:rotate(-45deg);
            }
        }
        @keyframes hit{
            0%{
                transform:scale(2);
            }
            100%{
                transform:scale(300);
            }
        }
    </style>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.cookie.js"></script>
    <script src="js/swiper.js"></script>
    <script>
        $(function(){
			$(".open_ani").hide();
			
			if(!($.cookie('open_ani'))){
				$(".swiper-container").css("z-index", "1");
				$(".open_ani").show();
				$.cookie('open_ani', 'yes', {expires : 1});
				setTimeout(function() {
					  $(".open_ani").remove();
					}, 1500);
			}

		
			
            var mySwiper = new Swiper ('.swiper-container', {
            // Optional parameters
            
            direction: 'horizontal',
            loop: true,

            // If we need pagination
            pagination: {
            el: '.swiper-pagination',
            type:'bullets',
            clickable:true,
            },

            // Navigation arrows
            navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
            // hideOnClick:true,//안되는듯...
            },

            // And if we need scrollbar
            // scrollbar: {
            // el: '.swiper-scrollbar',
            // },

            // effect 설정
            effect:'coverflow',

            // coverflow 상세설정
            coverflowEffect: {
                rotate: 0,
                slideShadows: false,
                modifier:1,
            },
        })

        });
    </script>

	<div><img src="img/main/one.png" width="100%" height="290" margin = "150"></div>
	<div style="height:30px;"></div>
	<div style="width:  1200px; margin:auto; text-align: center;">
		<c:forEach var="matdto" items="${matlist}">
		<table class="match4_table" style="text-align: center; display: inline-block;">
			<thead>
				<td colspan="3" style="background-color: #5D5D5D;color: white; font-size: 22px;">${matdto.m_stadium}</td>
			</thead>
			<tbody>
				<tr>
					<td>${matdto.m_team1}</td>
					<td>VS</td>
					<td>${matdto.m_team2}</td>
				</tr>
				<tr>
					<td colspan="3">${matdto.m_date.substring(0,10)}</td>
				</tr>
				<tr>
					<td colspan="3">${matdto.m_date.substring(11,16)}</td>
				</tr>
				<tr>
					<td colspan="3" style="padding-bottom: 1rem;"><a class="cat_btn" href="<%=request.getContextPath() %>/reserve/reserve_area?match_no=${matdto.match_no}&s_no=${matdto.s_no}">예매하기</a></td>
				</tr>
			</tbody>
		</table>
		</c:forEach>
	
	</div>
	<div style="height:40px;"></div>
    <!-- Slider main container -->
    <div class="swiper-container">
        <!-- Additional required wrapper -->
        <div class="swiper-wrapper">
            <!-- Slides -->
            <div class="swiper-slide">
                    <img src="img/main/A.png" width="620" height="450">
            </div>
           <div class="swiper-slide">
                    <img src="img/main/B.png" width="620" height="450">
            </div>
        </div>
        <!-- If we need pagination -->
        <div class="swiper-pagination"></div>
    
        <!-- If we need navigation buttons -->
        <div class="swiper-button-prev"></div>
        <div class="swiper-button-next"></div>
    
        <!-- If we need scrollbar -->
        <div class="swiper-scrollbar"></div>
    </div>
    
    <div class="open_ani" style="z-index: 99999;">
    <img class="baseball-bat" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkns5sWyRU8ipFrgcg6tdVnp-td1SkYwoYUJi6ABGkb9BmNKgDDQ">
    <img class="baseball-ball" src="<%=request.getContextPath() %>/img/baseball.png">
	</div>
<jsp:include page="/template/footer.jsp"></jsp:include>