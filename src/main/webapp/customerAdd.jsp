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

<h2 style ="text-align : center">登録しました</h2>
<br>
<table border ="1" align ="center">
<tr>
<td>氏名</td><td>住所</td><td>電話番号</td><td>Eメール</td><td>生年月日</td><td>入会年月日</td>
</tr>

<tr>
<td>${AddCustomer.cName }</td><td>${AddCustomer.cAddress }</td><td>${AddCustomer.cTell }</td><td>${AddCustomer.cMail }</td><td>${AddCustomer.cBday }</td><td>${AddCustomer.cJdate }
</tr>
</table>
<br><br>

<div class ="div" align ="center">
<table border ="0" style ="text-align : center">
<tr>
<td>
<form action = "/Bteam/customerAddForm.jsp" method ="post">
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