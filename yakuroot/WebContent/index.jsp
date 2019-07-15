<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/template/header.jsp"></jsp:include>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" type="text/css" href="css/swiper.css">
    
    <style>
    .swiper-container {
        width: 1190px;
        height: 275px;
    }
    </style>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="js/swiper.js"></script>
    <script>
        $(function(){

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
</head>
<body>
<div height = "100"></div>
	<div><img src="img/main/one.png" width="100%" height="290" margin = "150"></div>
    <!-- Slider main container -->
    <div class="swiper-container">
        <!-- Additional required wrapper -->
        <div class="swiper-wrapper">
            <!-- Slides -->
            <div class="swiper-slide">
                    <img src="img/main/two.png" width="1190" height="275">
            </div>
           <div class="swiper-slide">
                    <img src="img/main/three.png" width="1190" height="275">
            </div>
            <div class="swiper-slide">
                    <img src="img/main/four.png" width="1190" height="275">
            </div>
            ...
        </div>
        <!-- If we need pagination -->
        <div class="swiper-pagination"></div>
    
        <!-- If we need navigation buttons -->
        <div class="swiper-button-prev"></div>
        <div class="swiper-button-next"></div>
    
        <!-- If we need scrollbar -->
        <div class="swiper-scrollbar"></div>
    </div>
    
    
<jsp:include page="/template/footer.jsp"></jsp:include>