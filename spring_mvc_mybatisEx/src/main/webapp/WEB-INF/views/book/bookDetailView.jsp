<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 상세 정보</title>
</head>
<body>
    <h3>도서 상세 정보</h3>
    <table border="1">
        <tr><td>도서 번호</td><td>${book.bookNo}</td></tr>
        <tr><td>도서명</td><td>${book.bookName}</td></tr>
        <tr><td>저자</td><td>${book.bookAuthor}</td></tr>
        <tr><td>가격</td><td>${book.bookPrice}</td></tr>
        <tr><td>출판일</td><td><fmt:formatDate value="${book.bookDate}" pattern="yyyy-MM-dd"/></td></tr>
        <tr><td>재고</td><td>${book.bookStock}</td></tr>
        <tr><td>출판사 번호</td><td>${book.pubNo}</td></tr>
    </table>
    <br>
    
    <!-- 기능 버튼(링크) -->
    <a href="<c:url value='/book/updateBookForm/${book.bookNo}'/>">[수정]</a>
    <a href="<c:url value='/book/deleteBook/${book.bookNo}'/>">[삭제]</a>
    <a href="<c:url value='/book/listAllBook'/>">[목록]</a>
</body>
</html>