$(document).ready(function() {
	$('#prdSearchFrm1').on('submit', function(event) {
		event.preventDefault();
		
		// 폼에 있는 폼 data를 payload(파라미터)로 구성
		let formData = $(this).serialize();
		
		let keyword = $("#keyword").val();
		let type = $("#type").val();
		
		if(keyword == "" || type == "") {
			alert("검색조건과 검색어를 입력하세요");
			return false;
		} else {
			$.ajax({
				type: "post",
				url: "/mybatis/product/productSearch1",
				data: formData, 
				success: function(result) { // result에 검색 결과를 담은 html 코드가 반환
					$('#searchResultForm').html(result);
				
				},
				error: function() {
					alert("실패");
				}
			}); // ajax 끝
		}
	}); // on 끝	
}); // ready 끝