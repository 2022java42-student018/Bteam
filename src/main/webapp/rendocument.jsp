<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貸出中資料</title>
</head>
<body>
<div style="text-align: center">
		<h3>貸出中資料</h3>
		<table border="1" align="center">
		<c:forEach items="${document}" var="document">
		<tr><td>資料ID</td><td></td><td>タイトル</td><td>出版社</td><td>著者</td><td>貸出日</td><td>返却日</td></tr>
		<tr><td>${document.dID}</td><td>${document.dName}</td><td>${document.aName}</td><td>${document.pName}</td><td>${document.renDay}</td><td>${document.resDay}</td></tr>
		</c:forEach>
		</table>
		<form action="/Bteam/CustomersearchServlet" method="post">
				<input type="hidden" name="action" value="backinfo">
				<input type="submit"value="会員情報へ">
		</form>
	</div>
</body>
</html>