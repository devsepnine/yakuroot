<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<div>
	<form>
		<table>
			<thead>
				<tr>
					<th>프로필 사진</th>
					<th>이름</th>
					<th>등번호</th>
					<th>소속 구단 로고</th>
					<th>생년월일</th>
					<th>포지션</th>
					<th>키</th>
					<th>몸무게</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pdto" items="${pdtolist}"><!-- 반복문 -->
					<tr>
						<td>프로필 사진</td><!-- //프로필 사진 -->
						<td>${pdto.p_name}</td><!-- 이름 -->
						<td>${pdto.p_bnum}</td><!-- 등번호 -->
						<td>${pdto.p_club}</td><!-- //소속 구단 로고 -->
						<td>${pdto.p_birth}</td><!-- 생년월일 -->
						<td>${pdto.p_position}</td><!-- 포지션 -->
						<td>${pdto.p_height}</td><!-- 키 -->
						<td>${pdto.p_weight}</td><!-- 몸무게 -->
						<td text-align="center"><a href=""><input type="button" id="edit" value="수정"></a></td><!-- 수정 버튼 -->
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</div>
    
<jsp:include page="/template/footer.jsp"></jsp:include>