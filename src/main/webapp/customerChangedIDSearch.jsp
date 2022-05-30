<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Customer Information Search Page</title>
</head>
<body>
<br>
<h2 style ="text-align : center">変更したいお客様の会員IDを入力してください</h2>
<br><br>

<div style ="text-align : center">
<form action ="/Bteam/CustomerChangeServlet" method ="post">


<lebel>
<input type ="text" name ="cID" size ="20" pattern ="[0-9]*" title="数字で入力してください" required>
<input type ="submit" value="検索" size="56">
<input type ="hidden" name ="action" value="cIDcheck">

</lebel>


</form>
<br>
<form action ="/Bteam/TOP.jsp" method ="post">

<input type ="submit" value="TOPへ">
</form>
</div>
</body>
</html>