<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ReserveCheck</title>
</head>
<body>

	<div style="text-align: center">
		<h1>会員名:${cID}</h1>


		<h1>資料予約</h1>
		<table align="center" border="1">
			<tr>
				<td>資料ID</td>
				<td>資料名</td>
				<td>分野コード</td>
				<td>著者名</td>
				<td>出版社</td>
				<td>出版日</td>
			</tr>


			<tr>
				<td>${docment.dID}</td>
				<td>${docment.isbn}</td>
				<td>${docment.dName}</td>
				<td>${docment.cCode}</td>
				<td>${docment.aName}</td>
				<td>${docment.pName}</td>
				<td>${docment.aDate}</td>
			</tr>
		</table>
		<form action="/Bteam/ReserveServlet" method="post">
			<input type="hidden" name="action" value="decision">
			<input type="submit" value="予約">
		</form>
	</div>
</body>
</html>