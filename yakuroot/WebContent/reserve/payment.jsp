<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>
<style>
<!--
	.pay_result{
		width: 800px;
		text-align: center;
		margin: auto;
		margin-top: 100px;
	}
	.pay_result span{
		font-size: 50px;
	}
-->
</style>
<section>
	<div class="pay_result">
		<span>${result == true ? '예매 완료' : '예매 실패'}</span><br>
		<a class="cat_btn" href="${pageContext.request.contextPath}"> 홈으로 </a>
	</div>
</section>
<jsp:include page="/template/footer.jsp"></jsp:include>