$(document).ready(function() {
    $('#bookSearchFrm').on('submit', function(e) {
        e.preventDefault(); // 기본 폼 submit(페이지 새로고침) 방지
        
        let type = $('#type').val();
        let keyword = $('#keyword').val().trim();

        if (type === '') {
            alert('검색 조건을 선택하세요.');
            $('#type').focus();
            return;
        }

        if (keyword === '') {
            alert('검색어를 입력하세요.');
            $('#keyword').focus();
            return;
        }

        $.ajax({
            type: 'post',
            url: '/mybatisEx/book/bookSearch',
            data: $(this).serialize(),
            success: function(result) {
                // 반환받은 JSP 결과 조각을 영역에 삽입
                $('#searchResultBox').html(result);
            },
            error: function() {
                alert('도서 검색 중 오류가 발생했습니다.');
            }
        });
    });
});