<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보 등록</title>
<script type="text/javascript" src="<c:url value='/js/jquery-3.7.1.min.js'/>"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="<c:url value='/js/bookNoCheck.js'/>"></script>
</head>
<body>
    <h3>도서 정보 등록</h3>
    <form id="newBookForm" method="post" action="<c:url value='/book/insertBook'/>">
        <!-- 중복 확인 완료 여부를 체크하기 위한 플래그 (선택 사항) -->
        <input type="hidden" id="checkYn" value="N">

        <table border="1">
            <tr>
                <td>도서 번호</td>
                <td>
                    <input type="text" name="bookNo" id="bookNo">
                    <button type="button" id="btnAjax">Ajax 확인</button>
                    <button type="button" id="btnFetch">Fetch 확인</button>
                    <button type="button" id="btnAxios">Axios 확인</button>
                    <span id="checkMsg"></span>
                </td>
            </tr>
            <tr>
                <td>도서명</td>
                <td><input type="text" name="bookName" id="bookName"></td>
            </tr>
            <tr>
                <td>저자</td>
                <td><input type="text" name="bookAuthor" id="bookAuthor"></td>
            </tr>
            <tr>
                <td>가격</td>
                <td><input type="number" name="bookPrice" id="bookPrice"></td>
            </tr>
            <tr>
                <td>출판일</td>
                <td><input type="date" name="bookDate" id="bookDate"></td>
            </tr>
            <tr>
                <td>재고</td>
                <td><input type="number" name="bookStock" id="bookStock"></td>
            </tr>
            <tr>
                <td>출판사 번호</td>
                <td><input type="text" name="pubNo" id="pubNo"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="등록">
                    <input type="reset" value="취소">
                </td>
            </tr>
        </table>
    </form>
    <br>
    <a href="<c:url value='/book/listAllBook'/>">[목록으로]</a>
</body>
</html>