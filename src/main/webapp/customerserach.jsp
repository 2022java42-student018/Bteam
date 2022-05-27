<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員検索</title>
</head>
<body>

	<form action="/Bteam/CustomersearchServlet" method="post">	
		<h2>会員Eメール: 
		<input type="email" name="email" size="30" maxlength="40">
		<input type="submit" value="送信する">
		<input type="hidden" name="action" value="eMailSearch">
		</h2>
	</form>
</body>
</html>