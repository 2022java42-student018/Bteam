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

<div style ="text-align: center">
<h1>検索結果</h1>
</div>
<jsp:include page="/documentSearchPart.jsp" />
<br><br>

<div style ="text-align: center">
<a href="/Bteam/DocumentServlet?action=AscSort">昇順</a>

 / 
<a href="/Bteam/DocumentServlet?action=DscSort" >降順</a>

</div>
<br>
<hr>
<br>


<table border="1" align ="center">
<tr><td>資料ID</td><td>資料名</td><td>著者名</td><td>出版社名</td><td>貸出状況</td></tr>


<c:forEach items ="${items}" var="item">


<tr><td><a href="/Bteam/DocumentInfoServlet?action=showInfo&key=${item.dID}"> ${item.dID } </a>
</td><td>${item.dName }</td><td>${item.aName }</td><td>${item.pName }</td><td>${item.renCID }</td>
</tr>
</c:forEach>
</table>
<br>

<a href ="/Bteam/documentSearch.jsp"><h2 align = "center">検索TOPへ</h2></a>
</body>
</html>