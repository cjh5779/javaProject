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
            <td>${prdNo}</td>
        </tr>
        <tr>
            <td>상품명</td>
            <td>${prdName}</td>
        </tr>
        <tr>
            <td>가격</td>
            <td>${prdPrice}원</td>
        </tr>
        <tr>
            <td>제조회사</td>
            <td>${prdCompany}</td>
        </tr>
        <tr>
            <td>제조일</td>
            <td>${prdDate}</td>
        </tr>
        <tr>
            <td>재고</td>
            <td>${prdStock}개</td>
        </tr>
    </table>
</body>
</html>