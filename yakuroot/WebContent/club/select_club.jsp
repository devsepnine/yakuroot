<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<style>

.form.form-label>table {
	width: 1200px;
	text-align: center;
	margin-top : 100px;
	margin-bottom : 100px;
	background-color: none;
}


</style>
<div  align="center" text-align="center">
	<form class="form form-label">
	  
		<table  width = 100% class="table table-noline">
			<tbody>
				<tr height = 50><!-- 구단 로고 보여주는 첫번째 줄 -->
					<td>
						<a href="club_info.do?c_no=7"><img  src="../img/club_logo/lotte.png"></a><!-- 롯데 로고+프로필링크 -->
						<br>
						<br>
						<a href="club_info.do?c_no=7">롯데 자이언츠</a><!-- 롯데 글씨+프로필링크 -->
					</td>
					<td>
						<a href="club_info.do?c_no=6"><img src="../img/club_logo/samsung.png"></a><!-- 삼성 로고+프로필링크 -->
						<br>
						<br>
						<a href="club_info.do?c_no=6">삼성 라이온즈</a><!-- 삼성 글씨+프로필링크 -->
					</td>
					<td>
						<a href="club_info.do?c_no=1"><img src="../img/club_logo/doosan.png"></a><!-- 두산 로고+프로필링크 -->
						<br>
						<br>
						<a href="club_info.do?c_no=1">두산 베어스</a><!-- 두산 글씨+프로필링크 -->
					</td>
					<td>
						<a href="club_info.do?c_no=4"><img src="../img/club_logo/kiwoom.png"></a><!-- 키움 로고+프로필링크 -->
						<br>
						<br>
						<a href="club_info.do?c_no=4">키움 히어로즈</a><!-- 키움 글씨+프로필링크 -->
					</td>
					<td>
						<a href="club_info.do?c_no=3"><img src="../img/club_logo/hanwha.png"></a><!-- 한화 로고+프로필링크 -->
						<br>
						<br>
						<a href="club_info.do?c_no=3">한화 이글스</a><!-- 한화 글씨+프로필링크 -->
					</td>
				</tr>
				<tr height = 50><!-- 구단 로고 보여주는 두번째 줄  -->
					<td colspan = "5"></td>
				</tr>
				<tr>
					<td>
						<a href="club_info.do?c_no=10"><img src="../img/club_logo/nc.png"></a><!-- NC 로고+프로필링크 -->
						<br>
						<br>
						<a href="club_info.do?c_no=10">NC 다이노스</a><!-- NC 글씨+프로필링크 -->
					</td>
					<td>
						<a href="club_info.do?c_no=8"><img src="../img/club_logo/lg.png"></a><!-- LG 로고+프로필링크 -->
						<br>
						<br>
						<a href="club_info.do?c_no=8">LG 트윈즈</a><!-- LG 글씨+프로필링크 -->
					</td>
					<td>
						<a href="club_info.do?c_no=2"><img src="../img/club_logo/sk.png"></a><!-- SK 로고+프로필링크 -->
						<br>
						<br>
						<a href="club_info.do?c_no=2">SK 와이번스</a><!-- SK 글씨+프로필링크 -->
					</td>
					<td>
						<a href="club_info.do?c_no=9"><img src="../img/club_logo/kt.png"></a><!-- KT 로고+프로필링크 -->
						<br>
						<br>
						<a href="club_info.do?c_no=9">KT 위즈</a><!-- KT 글씨+프로필링크 -->
					</td>
					<td>
						<a href="club_info.do?c_no=5"><img src="../img/club_logo/kia.png"></a><!-- KIA 로고+프로필링크 -->
						<br>
						<br>
						<a href="club_info.do?c_no=5">KIA 타이거즈</a><!-- KIA 글씨+프로필링크 -->
					</td>
				</tr>
			</tbody>
		</table>

	</form>
</div>
<jsp:include page="/template/footer.jsp"></jsp:include>
