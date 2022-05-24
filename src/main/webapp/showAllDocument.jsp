<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>showAllDocument</title>

</head>
<body>
<jsp:include page="/documentSearchPart.jsp" />
<hr>

<table border="1">
<tr><td>資料ID</td><td>資料名</td><td>著者名</td><td>出版社名</td><td>貸出状況</td></tr>
<c:forEach items ="${items}" var="item">
<tr><td>${item.dID }</td><td>${item.dName }</td><td>${item.aName }</td><td>${item.pName }</td><td>${item.renCID }</td>
</tr>
</c:forEach>
</table>
</body>
</html>