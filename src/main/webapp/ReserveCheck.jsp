<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ReserveCheck</title>
</head>
<body>

	<div style="text-align: center">
		<h1>会員名:${cName}</h1>
		<h1>資料予約</h1>
		<table align="center" border="1">
			<tr>
				<td>資料ID</td>
				<td>ISBN番号</td>
				<td>資料名</td>
				<td>分野コード</td>
				<td>著者名</td>
				<td>出版社</td>
				<td>出版日</td>
			</tr>
<c:forEach document="${r}" var="doc">
			<tr>
				<td>${doc.dID}</td>
				<td>${doc.isbn}</td>
				<td>${doc.dName}</td>
				<td>${doc.cCode}</td>
				<td>${doc.aName}</td>
				<td>${doc.pName}</td>
				<td>${doc.aDate}</td>
			</tr>
</c:forEach>

<c:forEach document="${a}" var="doc">
             <tr>
				<td>${doc.dID}</td>
				<td>${doc.isbn}</td>
				<td>${doc.dName}</td>
				<td>${doc.cCode}</td>
				<td>${doc.aName}</td>
				<td>${doc.pName}</td>
				<td>${doc.aDate}</td>
			</tr>
</c:forEach>
		</table>
		<form action="/Bteam/ReserveServlet" method="post">
		<input type="hidden" name="action" value="reserve" >
		<input type="submit" value="予約">
		</form>
	</div>
</body>
</html>