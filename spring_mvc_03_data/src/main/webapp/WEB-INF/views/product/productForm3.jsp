<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 등록</title>
</head>
<body>
    <h2>상품 등록</h2>
    <form method="post" action="<c:url value='/product/newProduct4' />">
        <table border="1">
            <tr>
                <td>상품번호</td>
                <td><input type="text" name="prdNo" required></td>
            </tr>
            <tr>
                <td>상품명</td>
                <td><input type="text" name="prdName" required></td>
            </tr>
            <tr>
                <td>가격</td>
                <td><input type="number" name="prdPrice" required></td>
            </tr>
            <tr>
                <td>제조회사</td>
                <td><input type="text" name="prdCompany" required></td>
            </tr>
            <tr>
                <td>제조일</td>
                <td><input type="date" name="prdDate" required></td>
            </tr>
            <tr>
                <td>재고</td>
                <td><input type="number" name="prdStock" required></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="등록">
                    <input type="reset" value="다시작성">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>