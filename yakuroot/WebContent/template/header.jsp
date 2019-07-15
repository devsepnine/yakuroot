<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="/yakuroot/css/common.css">
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
            margin-block-start: 0.5em;
            margin-block-end: 0.5em;
            margin-inline-start: 0px;
            margin-inline-end: 0px;
        }
/*******************************************************
				상단 메뉴 폰트 
********************************************************/
        .menubox a{
            text-decoration: none;
            color: white;
/*             font-weight:bold; */
            font-size: 36px; 
            margin-right: 2rem;
        }
        .menu_table{
        	width:1200px;
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
        .sub_menus a{
        	font-size: 20px;
        	font-weight: bold;
        }
        .sub_menus a:hover{
        	color: red;
        }
        
/*********************************************************
			헤드메뉴 호버 효과
*********************************************************/


.sm-link{
    --uismLinkDisplay: var(--smLinkDisplay, inline-flex);   
    --uismLinkTextColor: var(--smLinkTextColor);
    --uismLinkTextColorHover: var(--smLinkTextColorHover);  
    
    display: var(--uismLinkDisplay);
    color: var(--uismLinkTextColor);
    position: relative;
    overflow: hidden;
}

a.sm-link{
    text-decoration: none;
}

.sm-link__label{
  display: block;
}

/* sm-link_padding-all */ 

.sm-link_padding-all{
    --uismLinkLineWeight: var(--smLinkLineWeight, 2px);
    --uismLinkLineColor: var(--smLinkLineColor, #000);
    --uismLinkPadding: var(--smLinkPadding, 5px);
    
    padding: var(--uismLinkPadding);
}

.sm-link_padding-all::before, 
.sm-link_padding-all::after{
  width: 100%;
  height: var(--uismLinkLineWeight);
  left: 0;
}

.sm-link_padding-all::before{
  top: 0;
}

.sm-link_padding-all::after{
  bottom: 0;
}

.sm-link_padding-all .sm-link__label::before,
.sm-link_padding-all .sm-link__label::after{
  width: var(--uismLinkLineWeight);
  height: 100%;
  top: 0;
}

.sm-link_padding-all .sm-link__label::before{
  left: 0;
}

.sm-link_padding-all .sm-link__label::after{
  right: 0;
}

.sm-link_padding-all::before,
.sm-link_padding-all::after,
.sm-link_padding-all .sm-link__label::before,
.sm-link_padding-all .sm-link__label::after{
  content: "";     
    background-color: var(--uismLinkLineColor);
  position: absolute; 
    opacity: 0;
    
    will-change: transform, opacity;
    transition-property: transform, opacity;
}

.sm-link_padding-all:hover::before,
.sm-link_padding-all:hover::after,
.sm-link_padding-all:hover .sm-link__label::before,
.sm-link_padding-all:hover .sm-link__label::after{
    opacity: 1;
}

/* sm-link_padding-bottom */ 

.sm-link_padding-bottom{
    --uismLinkLineWeight: var(--smLinkLineWeight, 2px);
    --uismLinkLineColor: var(--smLinkLineColor, #000);  
    
    padding-bottom: var(--uismLinkLineWeight);  
    position: relative;
}

.sm-link_padding-bottom::after{
  content: "";
  width: 100%;
  height: var(--uismLinkLineWeight);
    background-color: var(--uismLinkLineColor);
    
  position: absolute;
  left: 0;
  bottom: 0;
}

/* sm-link_bg */ 

.sm-link_bg {
    --uismLinkLineColor: var(--smLinkLineColor, #000);  
    --uismLinkTextColorHover: var(--smLinkTextColorHover, #fff);    
    --uismLinkPadding: var(--smLinkPadding, 5px);
    
    padding: var(--uismLinkPadding);
    transition: color .3s ease-out;
}

.sm-link_bg::before, 
.sm-link_bg::after{
  content: "";
    background-color: var(--uismLinkLineColor); 
  opacity: 0;
  position: absolute;
    
    transition: transform .2s ease-out, opacity .2s ease-out .03s;
}

.sm-link_bg .sm-link__label{
  position: relative;
  z-index: 2;
}

.sm-link_bg:hover::before, 
.sm-link_bg:hover::after{
  opacity: 1;
    transition-duration: .35s, .35s;
    transition-delay: 0s, 0s;
}

.sm-link_bg:hover{
    color: var(--uismLinkTextColorHover);
}

/* sm-link_text */ 

.sm-link_text::before{
  content: attr(data-sm-link-text);
    color: var(--uismLinkTextColorHover);
  position: absolute;
}

.sm-link_text::before, 
.sm-link_text .sm-link__label{
  transition-property: transform;
    transition-timing-function: cubic-bezier(.86, .6, .08, 1.01); 
    transition-duration: .3s;
}

.sm-link_text:hover::before,
.sm-link_text:hover .sm-link__label{
    transition-duration: .4s;
}

/* effect 1 */
.sm-link__label:hover{
	text-shadow: 1px 1px 2px black, 0px 0px 8px white;
}
.sm-link1::before{
  transform: translate3d(-105%, 0, 0);
}

.sm-link1::after{
  transform: translate3d(105%, 0, 0);
}

.sm-link1 .sm-link__label::before{
  transform: translate3d(0%, -100%, 0);
}

.sm-link1 .sm-link__label::after{
  transform: translate3d(0%, 100%, 0);
}

.sm-link1::before,
.sm-link1::after,
.sm-link1 .sm-link__label::before,
.sm-link1 .sm-link__label::after{
    transition-timing-function: ease-out;
    transition-duration: .2s, .15s;
    transition-delay: 0s, .15s;
}

.sm-link1:hover::before,
.sm-link1:hover::after,
.sm-link1:hover .sm-link__label::before,
.sm-link1:hover .sm-link__label::after{
  transform: translate3d(0, 0, 0);
    opacity: 1;
    
    transition-duration: .25s;
    transition-delay: 0s;
}

/*
SETTINGS
*/

.sm-link{
    --smLinkPadding: 10px 15px;
    --smLinkLineWeight: 5px;
    --smLinkLineColor: #ffffff;
    --smLinkTextColor: #ffffff;
    --smLinkTextColorHover: #1b255a;
}

.sm-link_bg{
    --smLinkTextColorHover: #fff;
}

    </style>
</head>
<body>
    <header>
        <nav>
            <table class="menu_table">
                <tbody>
                    <tr>
                        <td rowspan="2" style="text-align: right; "><a class="" href="<%=request.getContextPath()%>"><img src="<%=request.getContextPath()%>/img/logo/baseball.png" width="200px" alt=""></a></td>
                        <c:choose>
                        	<c:when test="${empty login}">
                        <td style="text-align: right;padding-top:0.5rem;"><div class="nav_subs"><a href="<%=request.getContextPath()%>/member/login.do">로그인</a><a href = "<%=request.getContextPath()%>/member/agree.jsp">회원가입</a></div></td>
                        </c:when>
                        <c:otherwise>
                        <td style="text-align: right;padding-top:0.5rem;"><div class="nav_subs"><a href="<%=request.getContextPath()%>/member/logout.jsp">로그아웃</a><a href = "<%=request.getContextPath()%>/member/info.do">${login }</a>
                        <c:if test="${auth eq '관리자' }">
                        <a href = "<%=request.getContextPath()%>/admin/admin.do">관리자페이지</a>
                        </c:if>
                        </div></td>
                        </c:otherwise>
                        </c:choose>
                    </tr>
                    <tr>
                        <td>
                            <ul class="menubox">
                                <li class="menu1">
                                    <a class="top_m sm-link sm-link_padding-all sm-link1" title="구단소개"><span class="sm-link__label">K B O</span></a>
                                    <div class="sub_menus">
                                        <ul>
                                            <li><a href="<%=request.getContextPath()%>/club/select_club.jsp">구단 소개</a></li>
                                            <li><a href="<%=request.getContextPath()%>/player/player_select_club.jsp">선수 소개</a></li>
                                            <li><a>시즌 기록</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="menu2">
                                    <a class="sm-link sm-link_padding-all sm-link1" href="<%=request.getContextPath()%>/match/matchup" title="경기일정"><span class="sm-link__label">경기일정</span></a>
                                </li>
                                <li class="menu3">
                                    <a class="top_m sm-link sm-link_padding-all sm-link1" title="이벤트"><span class="sm-link__label">이벤트</span></a>
                                    <div class="sub_menus">
                                        <ul>
                                            <li>이벤트메뉴1</li>
                                            <li>이벤트메뉴2</li>
                                            <li>이벤트메뉴3</li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="menu4">
                                    <a href="<%=request.getContextPath()%>/board/g_list.do" class="top_m sm-link sm-link_padding-all sm-link1"  title="갤러리"><span class="sm-link__label">갤러리</span></a>
                                </li>
                                <li class="menu5">
                                    <a href="#" class="top_m sm-link sm-link_padding-all sm-link1" title="게시판"><span class="sm-link__label">게시판</span></a>
                                    <div class="sub_menus">
                                        <ul>
                                            <li><a href="<%=request.getContextPath()%>/board/notice_list.do">공지사항</a></li>
                                            <li><a href="<%=request.getContextPath()%>/board/f_list.do">자유게시판</a></li>
                                            <li><a href="<%=request.getContextPath()%>/board/q_list.do">Q&A 게시판</a></li>
                                        </ul>
                                    </div>
                                </li>
                                <c:if test="${auth eq '관리자'}">
                                <li class="menu6">
                                    <a href="#" class="top_m sm-link sm-link_padding-all sm-link1" title="관리자메뉴"><span class="sm-link__label">관리자메뉴</span></a>
                                    <div class="sub_menus">
                                        <ul>
                                            <li><a href="<%=request.getContextPath()%>/admin/search.do">회원 관리</a></li>
                                            <li><a href="<%=request.getContextPath()%>/club/club_list.do">팀리스트 관리</a></li>
                                            <li><a href="<%=request.getContextPath()%>/match/match_insert">경기일정 추가</a></li>
                                            <li><a href="<%=request.getContextPath()%>">관리자 메뉴4</a></li>
                                            <li><a href="<%=request.getContextPath()%>">관리자 메뉴5</a></li>
                                            <li><a href="<%=request.getContextPath()%>">관리자 메뉴6</a></li>
                                            <li><a href="<%=request.getContextPath()%>">관리자 메뉴7</a></li>
                                        </ul>
                                    </div>
                                </li>
                                </c:if>
                            </ul>
                        </td>
                    </tr>
                </tbody>
            </table>
        </nav>
    </header>
    <br><br>
