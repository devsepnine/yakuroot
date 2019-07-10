<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>YAKUROOT</title>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script>
        $(function(){
            // $('.top_m').click(function(){
            //     $('.sub_menus').slideUp(200);
            //     $(this).nextAll().slideup(500);
            //     $(this)
            // })
            
            //a태그를 클릭하면 li에 active 클래스를 추가/제거
            //active 인 li 안에 있는 서브메뉴는 화면에 표시
            $('.top_m').click(function(){
                if($(this).hasClass("active")){
                    $('.top_m').removeClass("active");
                    $('.sub_menus').slideUp(100);
                }else{
                    $(this).addClass("active");
                    $('.sub_menus').slideUp(100);
                    $(this).next().slideDown(500);
                }
            })
        })
    </script>
    
    <style>
        body{
            margin: 0;
        }
        a{
        	text-decoration: none;
        }
/*************************************************
         				헤더
**************************************************/
        header{
            background-color: rgb(16,17,47);
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
/*******************************************************
				상단 메뉴 폰트 
********************************************************/
        .menubox a{
            text-decoration: none;
            color: white;
            font-weight:bold;
            font-size: 30px;  
        }
/*******************************************************
         			서브메뉴 
*******************************************************/
        .sub_menus{
            display: none;
            position: absolute;
            top: 152px;
            left: 0px;
            width: 100%;
            font-size: 20px;
            background-color: rgb(255,255,255) !important;
        }
        .sub_menus ul{
            width: 1200px;
            margin: auto;
            padding-left: 300px;
        }
        .sub_menus li{
            padding: 0.5rem;
            padding-inline-start: 40px;
            display: inline-block;
        }
/********************************************************
        			 서브메뉴 폰트
********************************************************/
        .sub_menus a{
            color: black;
        }
        nav{
            width: 1200px;
            margin: auto;
        }
        .top_m{
            padding-bottom: 60px;
        }
/*******************************************************
					서브메뉴 디자인
********************************************************/
        .nav_subs > a{
        	color:white;
        	background-color: red;
        	margin-left: 0.5rem;
        	border-radius: 20px;
        	padding: 0.2rem;
        	padding-left: 0.5rem;
        	padding-right: 0.5rem;
        }
    </style>
</head>
<body>
    <header>
        <nav>
            <table class="menu_table">
                <tbody>
                    <tr>
                        <td rowspan="2"><a class="" href="<%=request.getContextPath()%>"><img src="<%=request.getContextPath()%>/img/logo/baseball.png" width="200px" alt=""></a></td>
                        <c:choose>
                        	<c:when test="${empty login}">
                        <td style="text-align: right;padding-top:0.2rem;"><div class="nav_subs"><a href="<%=request.getContextPath()%>/member/login.do">로그인</a><a href = "<%=request.getContextPath()%>/member/regist.do">회원가입</a><a href = "#">고객센터</a></div></td>
                        </c:when>
                        <c:otherwise>
                        <td style="text-align: right;padding-top:0.2rem;"><div class="nav_subs"><a href="<%=request.getContextPath()%>/member/logout.jsp">로그아웃</a><a href = "#">회원정보</a><a href = "#">고객센터</a></div></td>
                        </c:otherwise>
                        </c:choose>
                    </tr>
                    <tr>
                        <td>
                            <ul class="menubox">
                                <li class="menu1">
                                    <a href="#" class="top_m" title="구단소개">K B O</a>
                                    <div class="sub_menus">
                                        <ul>
                                            <li><a href="<%=request.getContextPath()%>/club/select_club.jsp">구단 소개</a></li>
                                            <li>구장 소개</li>
                                            <li>선수 소개</li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="menu2">
                                    <a href="#" class="top_m" title="경기일정">경기일정</a>
                                    <div class="sub_menus">
                                        <ul>
                                            <li>경기메뉴1</li>
                                            <li>경기메뉴2</li>
                                            <li>경기메뉴3</li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="menu3">
                                    <a href="#" class="top_m" title="이벤트">이벤트</a>
                                    <div class="sub_menus">
                                        <ul>
                                            <li>이벤트메뉴1</li>
                                            <li>이벤트메뉴2</li>
                                            <li>이벤트메뉴3</li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="menu4">
                                    <a href="#" class="top_m" title="갤러리">갤러리</a>
                                    <div class="sub_menus">
                                        <ul>
                                            <li>갤메뉴1</li>
                                            <li>갤메뉴2</li>
                                            <li>갤메뉴3</li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="menu5">
                                    <a href="#" class="top_m" title="게시판">게시판</a>
                                    <div class="sub_menus">
                                        <ul>
                                            <li><a href="<%=request.getContextPath()%>/board/f_list.do">자유게시판</a></li>
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
    <br><br>
