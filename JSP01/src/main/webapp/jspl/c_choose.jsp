<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 영역이 page이므로 변수처럼 사용 가능 value에 el 표현 사용가능 -->
<c:set var="id" value="hong" scope="page"/>
<c:set var="pwd" value="1234" scope="page"/>
<c:set var="name" value="${'홍길동'}" scope="page"/>
<c:set var="age" value="${20}" scope="page"/>
<c:set var="height" value="${177}" scope="page"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>c:set 활용 예시</title>
	</head>
	<body>
		<table border=1 align="center">
			<tr align="center" bgcolor="#99ccff">
				<td width="20%"><b>아이디</b></td>
				<td width="20%"><b>비밀번호</b></td>
				<td width="20%"><b>이름</b></td>
				<td width="20%"><b>이메일</b></td>
				<td width="20%"><b>키</b></td>
			</tr>
			<c:choose>
				<c:when test="${id==null}">
					<tr align="center"><td colspan="5">아이디가 없습니다</td></tr>
				</c:when>
				<c:when test="${pwd==null}">
					<tr align="center"><td colspan="5">비밀번호가 없습니다</td></tr>
				</c:when>
				<c:when test="${name==null}">
					<tr align="center"><td colspan="5">이름이 없습니다</td></tr>
				</c:when>
				<c:when test="${empty age}">
					<tr align="center"><td colspan="5">나이가 없습니다</td></tr>
				</c:when>
				<c:when test="${height==''}">
					<tr align="center"><td colspan="5">값이 비었습니다</td></tr>
				</c:when>
				<c:otherwise>
					<tr align="center">
						<td>${id}</td>
						<!-- 여기에 html 태그 포함 html 영역으로 전환됨 -->
						<td>${pwd}</td>
						<td>${name}</td>
						<td>${age}</td>
						<td>${height}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
	</body>
</html>