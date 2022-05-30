<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Change Completed Page</title>
</head>
<body>
<br>
<h2 style ="text-align : center">変更しました</h2>
<table border ="1" align ="center">
<tr>
<td>会員名</td><td>住所</td><td>電話番号</td><td>Eメール</td><td>生年月日</td>
</tr>

<tr>
<td>${change.cName }</td><td>${change.cAddress }</td><td>${change.cTell }</td><td>${change.cMail }</td><td>${change.cBday }</td>
</tr>
</table>

<br><br>

<div class ="div" align ="center">
<table border ="0" style ="text-align : center">
<tr>
<td>
<form action ="/Bteam/customerChangedIDSearch.jsp"   method ="post">
<input type ="submit"value="変更TOPへ">
</form>
</td>
<td>
<form action ="/Bteam/TOP.jsp " method ="post">
<input type ="submit" value ="TOPへ">

</form>
</td>
</tr>
</table>


</div>

</body>
</html>