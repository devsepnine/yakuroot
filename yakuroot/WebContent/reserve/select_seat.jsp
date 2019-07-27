<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
	.dBtn{
		display : block;
		border: none;
		box-shadow: 1px 1px 1px black;
		color: black;
		font-size: 20px;
		width: 50px;
		height: 30px;
	}
	.reserve_btn{
		background-color: #CAFF9E;
	}
	.disabled_btn{
		background-color: darkgrey;
	}
	.resed_btn{
		background-color: red;
	}
	.hidebox{
		display: none;
	}
	.cat_btn{
		border: none;
	}
</style>
<script>
	$(function() {
		$(".hidebox").change(function() {
			if($(this).is(":checked")){
				$(".hidebox").prop('checked', false);
				$(".reserve_btn").css("background-color", "#CAFF9E");
				$(this).prev().css("background-color", "#97F072");
				$(this).prop('checked', true);
			}else{
				$(this).prop('checked', false);
				$(this).prev().css("background-color", "#CAFF9E");
			}
		})
		
	});
</script>

<jsp:include page="/template/header.jsp"></jsp:include>
<c:set var="reserve" value="0" />
<div style="text-align:center; margin: auto; width: 1200px;">
	<h1>${adto.a_name}</h1>
	<form action="result" method="post">
	<table style="width: 700px; margin: auto; padding: 1.5rem;">
		<c:forEach var="i" begin="1" end="${adto.a_col}" step="1">
			<tr>
				<c:forEach var="j" begin="1" end="${adto.a_row}" step="1">
					<td style="text-align: center; padding: 0.6rem; width: 25px;"><label class="dBtn ${rlist[reserve].s_able eq 0? (rlist[reserve].res_seat > 0 ? 'resed_btn' : 'reserve_btn') : 'disabled_btn'}" for="${rlist[reserve].seat_no}">
						${rlist[reserve].s_able eq 0? (rlist[reserve].res_seat > 0 ? '예약' : rlist[reserve].seat_name) : 'X'}
					<c:if test="${rlist[reserve].s_able eq 0 and rlist[reserve].res_seat eq 0}">
					</label><input class="hidebox" type="checkbox" name="seat_no" value="${rlist[reserve].seat_no}" id="${rlist[reserve].seat_no}">
					</c:if>
					</td>
					<c:set var="reserve" value="${reserve + 1 }"/>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	<input type="hidden" name ="s_no" value="${s_no}">
	<input type="hidden" name = "match_no" value="${match_no}">
	<input type="hidden" name = "area_no" value="${area_no}">
	<input type="submit" class="cat_btn" value="예매하기">
	</form>
</div>


<jsp:include page="/template/footer.jsp"></jsp:include>