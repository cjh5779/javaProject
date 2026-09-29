/*

*/

$(document).ready(function(){
	$('#imageFileForm').on('submit', function(event){ // 1. event 파라미터 추가
		event.preventDefault();

		let formData = new FormData($('#imageFileForm')[0]);
		
		let fileName = $('#uploadFile').val().split('\\').pop(); // 파일명만 추출
		// C:\\hy9\\springBootWorkspace\\1001.jpg
		
		$.ajax({
			type: "post",
			url: "imageFileUpload",
			enctype: "multipart/form-data",
			processData:false, // multipart/form-data 이므로 임의변경(문자열로) 하지 않도록
			contentType:false, // contentType은 자체처리에 의존
			data: formData,
			success: function(result){
				if(result=='success') {
					$('#imageBox').html('<img src="/images/' + fileName + '" width="400" height="300">');
					// images: url 매핑이름
					// 개발자가 직접 url 매핑을 진행해 줘야 함 -> WebConfig.java에서 진행
				}
			},
			error: function(){alert("실패")}
		});
	}); // on 끝
}); // ready 끝