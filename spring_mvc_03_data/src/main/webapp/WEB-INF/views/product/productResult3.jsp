<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 등록 결과</title>
</head>
<body>
    <h2>상품 등록 결과</h2>
    <table border="1">
        <tr>
            <th>항목</th>
            <th>내용</th>
        </tr>
        <tr>
            <td>상품번호</td>
            <td>${product.prdNo}</td>
        </tr>
        <tr>
            <td>상품명</td>
            <td>${product.prdName}</td>
        </tr>
        <tr>
            <td>가격</td>
            <td>${product.prdPrice}원</td>
        </tr>
        <tr>
            <td>제조회사</td>
            <td>${product.prdCompany}</td>
        </tr>
        <tr>
            <td>제조일</td>
            <td>${product.prdDate}</td>
        </tr>
        <tr>
            <td>재고</td>
            <td>${product.prdStock}개</td>
        </tr>
    </table>
</body>
</html>