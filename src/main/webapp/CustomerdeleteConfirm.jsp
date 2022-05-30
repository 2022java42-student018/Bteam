<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退会確認</title>
</head>
<body>
	<div style="text-align: center">
		<h3>以下の会員を退会させます</h3>
		<table border="1" align="center">
		<tr><td>会員ID</td><td>氏名</td><td>住所</td><td>電話番号</td><td>Eメール</td><td>生年月日</td><td>入会年月日</td></tr>
		<tr><td>${customer.cID}</td><td>${customer.cName}</td><td>${customer.cAddress}</td><td>${customer.cTell}</td><td>${customer.cEmail}</td><td>${customer.cBday}</td><td>${customer.cJdate}</td></tr>
		</table>
		<form action="/Bteam/CustomerdeleteServlet" method="post">
				<input type="submit"value="退会">
				<input type="hidden" name="dID" value="${customer.cID}">
				<input type="hidden" name="action" value="delete">
		</form>
	</div>
</body>
</html>