<%@page import="member.beans.MemberDto"%>
<%@page import="member.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
   <jsp:include page="/template/header.jsp"></jsp:include>
   
   <style>

		.form.admin>fieldset {
			width: 1100px;
			text-align: center;
			margin-top : 100px;
			margin-bottom : 100px;
			padding : 20px;
			height : 700px;
		}
		
		.form.admin > fieldset th {
			background-color: #FFF0F0;
			width : 150px;
			font-size : 25px;
		}
		
		.form.admin > fieldset td {
			width : 450px;
			font-size : 17px;
		}
		
		.form.admin table {
			border : 1px solid black;
		    display: table;
		    border-collapse: collapse;
		    border-color: grey;
		}
		
	</style>
   
   <div align = "center">
	   <form class="form admin">
			<fieldset>
				<legend>[ ADMIN PAGE ]</legend>
					<table width = 90%  height = 90% align = "center" border = 1 >
						<tbody>
							<tr>
								<th rowspan = "3" >회원<br><br>관리</th>
								<td>총 회원 수 : ${memberCount} 명 </td>
								<th rowspan = "3">게시판<br><br>관리</th>
								<td>최근 7일 갤러리 게시글/ 댓글 수  :  ${g_board}  /  ${g_comment} 개</td>
					   		</tr>
					   		<tr>
								<td>최근 7일 가입한 회원 수 : ${member} 명 </td>
								<td>최근 7일 자유게시판 게시글/ 댓글 수  :  ${f_board}  /  ${f_comment} 개</td>
					   		</tr>
					   		<tr>
								<td><input type="button" value= "전체 회원 관리"></td>
								<td><a href="../board/notice_write.do"><input type="button" value= "공지사항 작성"></a></td>
					   		</tr>
					   		<tr>
								<th rowspan = "3">구단<br><br>관리</th>
								<td>구단 리스트  <a href = "#"><input type="button" value= "추가"></a> <a href = "../club/club_list.do"><input type="button" value= "수정"></a></td>
								<th rowspan = "3">선수<br><br>관리</th>
								<td>선수 리스트   <a href = "#"><input type="button" value= "추가"></a>  <a href = "#"><input type="button" value= "수정"></a></td>
					   		</tr>
					   		<tr>
								<td>구단 프로필   <a href = "#"><input type="button" value= "추가"></a>  <a href = "#"><input type="button" value= "수정"></a></td>
								<td>선수 프로필   <a href = "#"><input type="button" value= "추가"></a>  <a href = "#"><input type="button" value= "수정"></a></td>
					   		</tr>
					   		<tr>
								<td>업데이트 대기중</td>
								<td>업데이트 대기중</td>
					   		</tr>
					   		<tr>
								<th rowspan = "3">경기<br><br>관리</th>
								<td>경기 일정   <a href = "../match/match_insert"><input type="button" value= "추가"></a>  <a href = "../match/matchup"><input type="button" value= "수정"></a></td>
								<th rowspan = "3">예매<br><br>관리</th>
								<td><input type="button" value= "예매 내역"></td>
					   		</tr>
					   		<tr>
								<td>경기 기록    <a href = "#"><input type="button" value= "추가"></a>  <a href = "#"><input type="button" value= "수정"></a></td>
								<td><input type="button" value= "결제 내역"></td>
					   		</tr>
					   		<tr>
								<td>업데이트 대기중</td>
								<td>업데이트 대기중</td>
					   		</tr>
						</tbody>
					</table>
			</fieldset>
		</form>
	</div>
   
  
   
   <jsp:include page="/template/footer.jsp"></jsp:include>
 
 