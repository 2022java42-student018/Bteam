<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Addition Completed Page</title>
</head>
<body>

<h2 style ="text-align: center">登録しました</h2>
<br>
<table border ="1" align ="center">
<tr>
<td>資料ID</td><td>ISBN番号</td><td>分野コード</td><td>資料名</td><td>著者名</td><td>出版社名</td><td>出版日</td><td>入荷年月日</td>
</tr>

<tr>
<td>${AddDocument.dID}</td><td>${ AddDocument.isbn}</td><td>${AddDocument.cCode }</td><td>${AddDocument.dName }</td><td>${AddDocument.aName }</td><td>${AddDocument.pName }</td><td>${AddDocument.pDate }</td><td>${AddDocument.aDate }</td>
</tr>
</table>
<br>
<br>
<div class = "div"  align ="center">
<table border ="0" style ="text-align : center">
<tr>
<td>
<form action = "/Bteam/documentAddForm.jsp" method ="post">
<input type ="submit" value ="登録TOPへ">
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