<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
		<tr>
			<th>資料ID</th><th>タイトル</th><th>出版社</th><th>著者</th><th>貸出日</th><th>返却日</th>
		</tr>
		<c:forEach items="${document}" var="item">
			<tr>
				<td>${item.dID }</td><td>${item.dName }</td><td>${item.pName }</td><td>${item.aName }</td><td>${item.renCID }</td><td>${item.retCID }</td>
			</tr>
		</c:forEach>
	</table>
	
	<button type="button" onclick="history.back()">会員情報へ</button>
	
</body>
</html>