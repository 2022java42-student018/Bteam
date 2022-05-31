<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報</title>
</head>
<body>
	<div style="text-align: center">
		<h3>会員情報</h3>
		<table border="1" align="center">
			<tr>
				<td>会員ID</td>
				<td>氏名</td>
				<td>住所</td>
				<td>電話番号</td>
				<td>Eメール</td>
				<td>生年月日</td>
				<td>入会年月日</td>
			</tr>
			<tr>
				<td>${customer.cID}</td>
				<td>${customer.cName}</td>
				<td>${customer.cAddress}</td>
				<td>${customer.cTell}</td>
				<td>${customer.cMail}</td>
				<td>${customer.cBday}</td>
				<td>${customer.cJdate}</td>
			</tr>
		</table>
		<br>
		<table align="center" cellspacing="30">
			<tr>
				<td align="right"><a
					href="/Bteam/CustomersearchServlet?action=rental&cID=${customer.cID}">貸出中資料</a></td>
				<td align="left"><a
					href="/Bteam/CustomersearchServlet?action=history&cID=${customer.cID}">貸出履歴</a></td>
			</tr>
		</table>
		<form action="/Bteam/CustomersearchServlet" method="post">
			<input type="hidden" name="action" value="gotoTOP">
			<input type="submit"value="TOPへ">
		</form>
	</div>
</body>
</html>