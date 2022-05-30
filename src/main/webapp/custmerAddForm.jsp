<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Information Add Page </title>
<style>
.div input:firsr-of-type{
margin-right : 20px;
}

lebel{
 display : inline-block;
 text-align : right;
 width: 150px;
 
 }
</style>
</head>
<body>


<h2 style = "text-align : center">お客様情報登録フォーム</h2>
<div style = "text-align : center">

<form action = "Bteam/CustomerAddServlet" method = "post">

<p>
<lebel>
氏名:
</lebel>
<input type = "text" name = "cName" size = "40" pattern = "\S|\S.*?\S"  required>
</p>

<p>
<lebel>
住所:
</lebel>
<input type = "text" name ="cAddress" size = "40" pattern = "\S|\S.*?\S"  required>
</p>

<p>
<lebel>
電話番号:
</lebel>
<input type = "text" name = "cTell" size ="40" pattern = "^[0-9a-zA-Z]+$" title="英数字で入力してください" required>
</p>

<p>
<lebel>
Eメール:
</lebel>
<input type = "email" name="cMail" size ="40" pattern= "^[0-9a-zA-Z]+$" title="英数字で入力してください" required>
</p>

<p>
<lebel>
生年月日:
</lebel>
<input type = "text" name ="cBday"  size="40" pattern ="^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$"title="YYYY-MM-DDの形式で入力してください" required>
</p>

<br>
<input type = "submit" value ="登録" size ="56">
<input type ="hidden" name="action" value ="add">
</form>
</div>
<br>

<div align ="center">
<form action ="Bteam/TOP.jsp" method = "post">
<input type ="submit" value ="TOPへ">
</form>
</div>

 


</body>
</html>