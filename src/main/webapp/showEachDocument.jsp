<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Each Document Page</title>
<style type = "text/css">
box  { display:inline; 
       align:center; }

</style>
</head>
<body>

<h1 style = "text-align: center">本の情報</h1>
<div style ="text-align: center">
<h3><a href ="/Bteam/showAllDocument.jsp">前のページに戻る</a></h3>
</div>

<br><hr><br>


<table border = "1" align = "center" >

<tr><th>資料ID</th><td>${targetbook.dID }</td></tr>

<tr><th>ISBN番号</th><td>${targetbook.isbn }</td></tr>

<tr><th>分野コード</th><td>${targetbook.cCode }</td></tr>

<tr><th>資料名</th><td>${targetbook.dName }</td></tr>

<tr><th>著者名</th><td>${targetbook.aName }</td></tr>

<tr><th>出版社名</th><td>${targetbook.pName }</td></tr>

<tr><th>出版日</th><td>${targetbook.pDate }</td></tr>

<tr><th>入荷年月日</th><td>${targetbook.aDate }</td></tr>

<tr><th>貸出状況</th><td>${targetbook.renCID }</td></tr>

<tr><th>予約状況</th><td>${targetbook.resCID }</td></tr>

</table>
<br>
<br>

<div align = "center">
<table border="0">
<tr>
<td>
<form action="/Bteam/ReserveServlet" method ="post">
<input type = "submit" value="予約">
<input type ="hidden" name = "action" value ="reserve">
</form>
</td>


<td>
<form action="/Bteam/documentChangeForm.jsp">
<input type = "submit" value = "変更">
<input type = "hidden" name = "action" value = "change">

</form>
</td>


<td>
<form action ="/Bteam/DocumentChangeDelateServlet" method = "post">
<input type = "submit" value = "削除">
<input type = "hidden" name="action" value = "preDelate">
</form>
</td>
<td>
<form action = "/Bteam/documentSearch.jsp">
<input type = "submit" value="検索TOPへ">
</form>
</td>
</tr>
</table>
</div>



</body>
</html>