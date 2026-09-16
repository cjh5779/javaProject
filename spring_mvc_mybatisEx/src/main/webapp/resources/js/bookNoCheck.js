$(document).ready(function() {
    function getBookNo() {
        let bookNo = $('#bookNo').val();
        if(bookNo === "") {
            alert("도서번호를 입력하세요");
            return null;
        }
        return bookNo;
    }

    $('#btnAjax').on('click', function(event) {
        event.preventDefault();
        let bookNo = getBookNo();
        if(!bookNo) return;

        $.ajax({
            type: "post",
            url: "/mybatisEx/book/bookNoCheck1",
            data: {"bookNo": bookNo},
            dataType: "text",
            success: function(result) {
                if(result === "available") alert("[Ajax] 사용 가능한 번호입니다.");
                else alert("[Ajax] 사용 불가능한 번호입니다.");
            },
            error: function() {
                alert("Ajax 전송 실패");
            }
        });
    });

    $('#btnFetch').on('click', function(event) {
        event.preventDefault();
        let bookNo = getBookNo();
        if(!bookNo) return;

        fetch("/mybatisEx/book/bookNoCheck2/" + bookNo)
            .then(response => response.text())
            .then(result => {
                if(result === "available") alert("[Fetch] 사용 가능한 번호입니다.");
                else alert("[Fetch] 사용 불가능한 번호입니다.");
            })
            .catch(error => {
                console.log(error);
                alert("Fetch 전송 실패");
            });
    });

    $('#btnAxios').on('click', function(event) {
        event.preventDefault();
        let bookNo = getBookNo();
        if(!bookNo) return;

        axios.post("/mybatisEx/book/bookNoCheck3", { "bookNo": bookNo })
            .then(response => {
                if(response.data === "available") alert("[Axios] 사용 가능한 번호입니다.");
                else alert("[Axios] 사용 불가능한 번호입니다.");
            })
            .catch(error => {
                console.log(error);
                alert("Axios 전송 실패");
            });
    });
});