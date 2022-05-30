<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貸出履歴</title>
</head>
<body>
	<h1>貸出履歴</h1>
	<table border="1">
		<tr>
			<td>会員ID</td>
			<td>タイトル</td>
			<td>貸出日</td>
			<td>返却日</td>
		</tr>
		<c:forEach items="${document}" var="document">
			<tr>
				<td>${document.cID }</td>
				<td>${document.dName }</td>
				<td>${document.renDate }</td>
				<td>${document.retDate }</td>
				<td>${document.cJdate}</td>
			</tr>
		</c:forEach>
	</table>
	<form action="/Bteam/CustomersearchServlet" method="post">
		<input type="hidden" name="action" value="backinfo"> 
		<input type="submit" value="会員情報へ">
	</form>
</body>
</html>