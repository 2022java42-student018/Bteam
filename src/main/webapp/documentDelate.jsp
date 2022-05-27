<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deletion Completed Page</title>
<style>
.div input:firsr-of-type{
margin-right : 20px;
}

</style>
</head>
<body>

<br>
<div align ="center">
<h1>削除しました</h1>
<br><br>

<table border ="0">
<tr>
<td>
<form action = "/Bteam/documentSearch.jsp" method ="post">
<input type = "submit" value ="検索TOPへ" >
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