$(document).ready(function(){
	$('#frmLogin2').on('submit', function(event){
		event.preventDefault(); // submit 이벤트 중지
		
		let user_id = $('#user_id').val();
		let user_pw = $('#user_pw').val();
		
		$.ajax({
			type: "post", 
			url: "login", 
			data: {"user_id": user_id, "user_pw": user_pw}, 
			dataType: 'text', 
			success:function(result) {
				if(result == "success") {
					alert("로그인 성공\n상품 조회 화면으로 이동합니다");
					location.href = "/mybatis/product/listAllProduct";
				} else {
					alert("로그인 실패");
				}
			},
			error:function() {
				alert("전송 실패");
			}
		}); // ajax 끝
	}) // on 끝
}) // ready 끝