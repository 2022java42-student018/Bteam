<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>貸出中の資料一覧</h1>
<table border="1">
		<tr>
			<th>資料ID</th><th>タイトル</th><th>出版社</th><th>著者</th><th>貸出日</th><th>返却日</th>
		</tr>
		<c:forEach items="${item}" var="item">
			<tr>
				<td>${item.dID }</td><td>${item.cName }</td><td>${item.cMail }</td><td>${item.cBday }</td><td>${item.cJdate}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>