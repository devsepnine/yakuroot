<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>YAKUROOT</title>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script>
        $(function(){
            // $('.top_m').click(function(){
            //     $('.sub_menu').slideUp(200);
            //     $(this).nextAll().slideup(500);
            //     $(this)
            // })
            
            //a태그를 클릭하면 li에 active 클래스를 추가/제거
            //active 인 li 안에 있는 서브메뉴는 화면에 표시
            $('.top_m').click(function(){
                if($(this).hasClass("active")){
                    $('.top_m').removeClass("active");
                    $('.sub_menu').slideUp(100);
                }else{
                    $(this).addClass("active");
                    $('.sub_menu').slideUp(100);
                    $(this).next().slideDown(500);
                }
            })
        })
    </script>
    <style>
        body{
            margin: 0;
        }
        header{
            background-color: rgb(35,0,66);
            border-bottom: 3px solid red;
            height: 150px;
        }
        .menubox{
            list-style: none;
        }
        .menubox > li{
            display: inline-block;
            margin-block-start: 1em;
            margin-block-end: 1em;
            margin-inline-start: 0px;
            margin-inline-end: 0px;
            padding-inline-start: 40px;
        }
        .menubox a{
            text-decoration: none;
            color: white;
            font-size: 30px;  
        }
        .sub_menu{
            display: none;
            position: absolute;
            top: 153px;
            left: 0px;
            width: 100%;
            font-size: 20px;
            background-color: rgba(0,0,0,0.3)
        }
        .sub_menu ul{
            width: 1200px;
            margin: auto;
            padding-left: 300px;
        }
        .sub_menu li{
            padding: 0.5rem;
            padding-inline-start: 40px;
            display: inline-block;
        }
        .sub_menu a{
            color: black;
        }
        nav{
            width: 1200px;
            margin: auto;
        }
        .top_m{
            padding-bottom: 60px;
        }
    </style>
</head>
<body>
    <header>
        <nav>
            <table>
                <tbody>
                    <tr>
                        <td rowspan="2"><a class="" href="#"><img src="/img/baseball.png" width="200px" alt=""></a></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>
                            <ul class="menubox">
                                <li class="menu1">
                                    <a href="#" class="top_m" title="구단소개">구단소개</a>
                                    <div class="sub_menu">
                                        <ul>
                                            <li>구단메뉴1</li>
                                            <li>구단메뉴2</li>
                                            <li>구단메뉴3</li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="menu2">
                                    <a href="#" class="top_m" title="경기일정">경기일정</a>
                                    <div class="sub_menu">
                                        <ul>
                                            <li>경기메뉴1</li>
                                            <li>경기메뉴2</li>
                                            <li>경기메뉴3</li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="menu3">
                                    <a href="#" class="top_m" title="이벤트">이벤트</a>
                                    <div class="sub_menu">
                                        <ul>
                                            <li>이벤트메뉴1</li>
                                            <li>이벤트메뉴2</li>
                                            <li>이벤트메뉴3</li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="menu4">
                                    <a href="#" class="top_m" title="갤러리">갤러리</a>
                                    <div class="sub_menu">
                                        <ul>
                                            <li>갤메뉴1</li>
                                            <li>갤메뉴2</li>
                                            <li>갤메뉴3</li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="menu5">
                                    <a href="#" class="top_m" title="게시판">게시판</a>
                                    <div class="sub_menu">
                                        <ul>
                                            <li>게시판메뉴1</li>
                                            <li>게시판메뉴2</li>
                                            <li>게시판메뉴3</li>
                                        </ul>
                                    </div>
                                </li>
                            </ul>
                        </td>
                    </tr>
                </tbody>
            </table>
        </nav>
    </header>
    <h1>test1</h1>
</body>
</html>
