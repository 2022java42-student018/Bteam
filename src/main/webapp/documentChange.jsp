<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Completed Page</title>
<style>
.div input:first-of-type{
margin-right : 20px;
</style>
</head>
<body>

<h2 style ="text-align: center">変更しました</h2>
<table border ="1" align ="center">
<tr>
<td>ISBN番号</td><td>分野コード</td><td>資料名</td><td>著者名</td><td>出版社名</td><td>出版日</td>
</tr>

<tr>
<td>${ change.isbn}</td><td>${change.cCode }</td><td>${change.dName }</td><td>${change.aName }</td><td>${change.pName }</td><td>${change.pDate }</td>

</table>

<br><br>
<div class = "div"  align ="center">
<table border ="0" style ="text-align : center">
<tr>
<td>
<form action = "/Bteam/documentSearch.jsp">
<input type ="submit" value ="検索TOPへ">
</form>
</td>
<td>
<form action ="/Bteam/TOP.jsp" method ="post">
<input type ="submit" value ="TOPへ">
</form>
</td>
</tr>
</table>
</div>





</body>
</html>