<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>貸出履歴</h1>
<table border="1">
		<tr>
			<th>会員ID</th><th>タイトル</th><th>貸出日</th><th>返却日</th>
		</tr>
		<c:forEach items="${history}" var="item">
			<tr>
				<td>${item.cID }</td><td>${item.dName }</td><td>${item.renDate }</td><td>${item.retDate }</td><td>${item.cJdate}</td>
			</tr>
		</c:forEach>
	</table>

<a href="/Bteam/showcustomer.jsp">会員情報へ</a>
</body>
</html>