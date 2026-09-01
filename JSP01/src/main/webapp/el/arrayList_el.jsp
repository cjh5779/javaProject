<%-- 
	isElIgnored=false EL 표현 사용 가능
	true면 일반 text로 처리됨
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.MemberBean" %>
<%@ page import="java.util.ArrayList" %> <%-- 수정 1: ArrayList 임포트 추가 --%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%-- 현재 코드에서 mB는 사용되지 않으므로 주석 처리하거나 지워도 무방합니다 --%>
<%-- <jsp:useBean id="mB" class="bean.MemberBean"/> --%> 
<jsp:useBean id="memberList" class="java.util.ArrayList"/>

<%
	MemberBean m1 = new MemberBean("son", "1234", "손흥민", "son@test.com");
	MemberBean m2 = new MemberBean("park", "1234", "박지성", "park@test.com");
	
	// jsp:useBean으로 만든 memberList에 데이터 추가
	memberList.add(m1);
	memberList.add(m2);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">	
		<title>ArrayList EL 표현</title>
	</head>
	<body>
		<table border=1 align="center">
			<tr align="center" bgcolor="#99ccff">
				<td width="20%"><b>아이디</b></td>
				<td width="20%"><b>비밀번호</b></td>
				<td width="20%"><b>이름</b></td>
				<td width="20%"><b>이메일</b></td>
			</tr>
			<tr align="center">
				<td>${memberList[0].memId}</td>
				<td>${memberList[0].memPwd}</td>
				<td>${memberList[0].memName}</td>
				<td>${memberList[0].memEmail}</td>
			</tr>
			
			<tr align="center">
				<td>${memberList[1].memId}</td>
				<td>${memberList[1].memPwd}</td>
				<td>${memberList[1].memName}</td>
				<td>${memberList[1].memEmail}</td>
			</tr>
		</table>
	</body>
</html>