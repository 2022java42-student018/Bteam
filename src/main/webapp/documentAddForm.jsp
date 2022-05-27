<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Documet Add Form Page</title>
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

<h2 style ="text-align : center">登録フォーム</h2>
<div style = "text-align : center">

<form action ="/Bteam/DocumentAddServlet" method = "post">

<p>
<lebel>
 ISBN番号:
</lebel>
<input type = "text" name ="isbn"  size="20" pattern ="[0-9]*" title="数字で入力してください" required>
</p>

<p>
<lebel>
分野コード:
</lebel>
<input type = "text" name="cCode"  size="20" pattern="[0-9]*" title="英数字で入力してください" required >
</p>

<p>
<lebel>
   資料名:
</lebel>
<input type = "text" name="dName" size ="20" pattern ="\S|\S.*?\S"  required>
</p>



<p>
<lebel>
   著者名:
</lebel>
<input type ="text" name="aName" size ="20" pattern ="\S|\S.*?\S" required>
</p>

<p>
<lebel>
  出版社名:
</lebel>
<input type ="text" name="pName"  size ="20" pattern ="\S|\S.*?\S" required>
</p>

<p>
<lebel>
   出版日:
</lebel>
<input type ="text" name ="pDate"  size="20" pattern ="^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$"title="YYYY-MM-DDの形式で入力してください" required>


</p>

<br>

<input type ="submit"  value="登録" size ="56">
<input type ="hidden" name="action" value="add">

</form>
</div>
<br>

<div align = "center">

<form action ="/Bteam/TOP.jsp" method ="post">
<input type ="submit" value ="TOPへ">
</form>

</div>
</body>
</html>