/* 
      전체선택과 삭제요청 처리할 자바스크립트 
*/

$(document).ready(function() {
    //[전체선택] 체크박스 체크한경우
    $("#allCheck").on('click', function() {
        let chk = $("#allCheck").prop("checked");

        if (chk) { //전체 선택이 체크된 경우
            $(".chkDelete").prop("checked", true);

        } else {//전체 선택 체크가 풀린 경우
            $(".chkDelete").prop("checked", false);
        }

    });//on 끝

    //개별 체크박스 해제할 경우 [전체선택] 체크박스 해제
    //개별 체크박스 모두 체크되었을대 [전체 선택] 체크박스 체크
    $('.chkDelete').on('click', function() {
        //어떤 개별 체크박스에서던 click이벤트가 발생하면 아래 절차를 수행
        //클래스 선택자 .은 객체참조를 요소로 갖고있는 배열 반환
        let total = $('.chkDelete').length;//개별체크박스의 전체 개수
        let checked = $('.chkDelete:checked').length; //.클래스 선택자를 우선 진행하고 그 결과에 : 속성선택자를 연결해서 진행, 배열을 반환

        if (total != checked) {
            $("#allCheck").prop("checked", false);
        } else {
            $("#allCheck").prop("checked", true);
        }

    });//on 끝
	
	//삭제 버튼 클릭 이벤트 처리 함수 연결(목록 체크된 내용에 따라 삭제 요청(비동기방식))
	$("#deleteCartBtn").on('click', function(){
		let chk = $('.chkDelete').is(':checked'); //checked 속성값이 true인 요소가 하나라도 있으면 true를 반환
		
		if(chk) { //하나 이상 선택된 경우
			let answer = confirm("선택된 상품을 삭제하시겠습니까?");
			
			if(answer) { //비동기방식으로 삭제 요청(ajax)
				let checkArr = new Array();
				$(".chkDelete:checked").each(function(){
					console.log($(this).val());
					checkArr.push($(this).val()); //서버로 전송되는 파라미터는 cartNo가 전송
				}); //each 끝
				
				//서버에 비동기 요청
				$.ajax({
					url:"/product/deleteCart",
					type:"post",
					data:{"delPrd":checkArr},
					success:function(result){
						if(result){
							location.href="/product/cartList"; //delete된 결과 반영하는 페이지를 요청
						}
					},
					error:function(){
						alert("오류발생");
					}
				});
			}
		} else { //하나도 선택되지 않은 경우
			alert("선택된 상품이 없습니다");
		}
	}); //on 끝

});