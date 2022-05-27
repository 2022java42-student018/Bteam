<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delate Confirmation Page</title>
<style>


.div input:first-of-type{
margin-right : 20px;
/*
width:50px;
height:25px;
border-radus: 5px;
box-shadow: 1px 1px 1px;
border-style: solid;
*/
}


</style>
</head>
<body>

<br>
<div class = "div"  align ="center">

<h1>本当に削除しますか？</h1>
<br><br>

<table border ="0">
<tr>
<td>
<form action = "/Bteam/DocumentChangeDelateServlet" method ="post">
<input type = "submit" value ="削除" >
<input type ="hidden" name="action" value = "delate">
</form>
</td>

<td>
<form action = "/Bteam/showEachDocument.jsp">
<input type = "submit" value="戻る">
</form>
</td>
</tr>


</table>
</div>




</body>
</html>