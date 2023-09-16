<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../layouts/header.jsp"%>

<script>
$(document).ready(function() {

	$('.remove').click(function(){
		if(!confirm('정말 삭제할까요?')) return;
		
		// form을 열어서 submit()호출
		console.log(documnt.forms);
		document.forms.removeForm.submit();
	});	
}); 

</script>

<br>

<h1 class="page-header">
	<i class="far fa-file-alt"></i> ${travel.title}
</h1>

<br>

<div class="d-flex justify-content-between">
	
	<div>
		<i class="fas fa-user"></i> ${travel.region}
	</div>
	
	<div>
		<i class="fa-solid fa-location-dot"></i> ${travel.address}
	</div>
	
	<div>
		<i class="fa-solid fa-phone"></i> ${travel.phone}
	</div>
	
</div>

<hr>

<div>${travel.description}</div>

<c:if test="${result=='success'}">
	<script>
		alert("수정이 완료되었습니다!");
	</script>
</c:if> 

<br>

<div class="mt-4">
	<a href="${cri.getLink('list')}" class="btn btn-primary list"><i class="fas fa-list"></i> 목록</a>
	<a href="${cri.getLink('modify')}&no=${travel.no}" class="btn btn-primary modify"> <i class="far fa-edit"></i> 수정</a>
	<a href="#" class="btn btn-danger remove"> <i class="far fa-trash-alt"></i> 삭제</a>
</div>

<form action="remove" method="post" name="removeForm">
	<input type="hidden" name="no" value="${travel.no}" />
	<input type="hidden" name="pageNum" value="${cri.pageNum}"/>
	<input type="hidden" name="amount" value="${cri.amount}"/>
	<input type="hidden" name="type" value="${cri.type}" />
	<input type="hidden" name="keyword" value="${cri.keyword}" />
</form>

<%@ include file="../layouts/footer.jsp"%>