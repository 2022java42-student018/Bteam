<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>返却完了</title>
</head>
<body>
	<div style = "text-align: center">
		<div style="border: #00FFFF solid 1px; border-center: #808000 solid 8px; padding: 10px 20px;font-size: 100%;">${dName}</div><br>
		<h2>${message}</h2><br>
		<h3>${resmesage}</h3>
		<button onclick="location.href='TOP.jsp'">TOPへ</button><br>
		<button onclick="location.href='rentalform.html'">貸出・返却フォームへ</button>
	</div>	
</body>
</html>