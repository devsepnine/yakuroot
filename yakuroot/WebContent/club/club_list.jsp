<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<table border="1">
            <tbody>
                <tr>
                    <th colspan="2">팀명</th>
                    <th>창단년도</th>
                    <th>연고지</th>
                    <th>구단 소개글</th>
                </tr>
                <tr>
                    <td><img src="../img/club_logo/doosan.png"></td>
                    <td>두산${cdto.c_name}</td>
                    <td>1982${cdto.c_year}</td>
                    <td>서울${cdto.c_born}</td>
                    <td>구단 소개글${cdto.c_club}</td>
                    <td><button>내용 수정</button></td>
                </tr>
                <tr>
                    <td><img src="../img/club_logo/sk.png"></td>
                    <td>SK${cdto.c_name}</td>
                    <td>2000${cdto.c_year}</td>
                    <td>인천${cdto.c_born}</td>
                    <td>구단 소개글${cdto.c_club}</td>
                    <td><button>내용 수정</button></td>
                </tr>
                <tr>
                    <td><img src="../img/club_logo/hanwha.png"></td>
                    <td>한화${cdto.c_name}</td>
                    <td>1986${cdto.c_year}</td>
                    <td>대전${cdto.c_born}</td>
                    <td>구단 소개글${cdto.c_club}</td>
                    <td><button>내용 수정</button></td>
                </tr>
                <tr>
                    <td><img src="../img/club_logo/kiwoom.png"></td>
                    <td>키움${cdto.c_name}</td>
                    <td>2008${cdto.c_year}</td>
                    <td>서울${cdto.c_born}</td>
                    <td>구단 소개글${cdto.c_club}</td>
                    <td><button>내용 수정</button></td>
                </tr>
                <tr>
                    <td><img src="../img/club_logo/kia.png"></td>
                    <td>KIA${cdto.c_name}</td>
                    <td>2001${cdto.c_year}</td>
                    <td>광주${cdto.c_born}</td>
                    <td>구단 소개글${cdto.c_club}</td>
                    <td><button>내용 수정</button></td>
                </tr>
                <tr>
                    <td><img src="../img/club_logo/samsung.png"></td>
                    <td>삼성${cdto.c_name}</td>
                    <td>1982${cdto.c_year}</td>
                    <td>대구${cdto.c_born}</td>
                    <td>구단 소개글${cdto.c_club}</td>
                    <td><button>내용 수정</button></td>
                </tr>
                <tr>
                    <td><img  src="../img/club_logo/lotte.png"></td>
                    <td>롯데${cdto.c_name}</td>
                    <td>1982${cdto.c_year}</td>
                    <td>부산${cdto.c_born}</td>
                    <td>구단 소개글${cdto.c_club}</td>
                    <td><button>내용 수정</button></td>
                </tr>
                <tr>
                    <td><img src="../img/club_logo/lg.png"></td>
                    <td>LG${cdto.c_name}</td>
                    <td>1990${cdto.c_year}</td>
                    <td>서울${cdto.c_born}</td>
                    <td>구단 소개글${cdto.c_club}</td>
                    <td><button>내용 수정</button></td>
                </tr>
                <tr>
                    <td><img src="../img/club_logo/kt.png"></td>
                    <td>KT${cdto.c_name}</td>
                    <td>2013${cdto.c_year}</td>
                    <td>수원${cdto.c_born}</td>
                    <td>구단 소개글${cdto.c_club}</td>
                    <td><button>내용 수정</button></td>
                </tr>
                <tr>
                    <td><img src="../img/club_logo/nc.png"></td>
                    <td>NC${cdto.c_name}</td>
                    <td>2011${cdto.c_year}</td>
                    <td>창원${cdto.c_born}</td>
                    <td>구단 소개글${cdto.c_club}</td>
                    <td><button>내용 수정</button></td>
                </tr>
            </tbody>
        </table>

<jsp:include page="/template/footer.jsp"></jsp:include>