<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document Change Form Page</title>

<style>
lebel{
 display : inline-block;
 text-align : right;
 width: 150px;
 }
 
 .div input:firsr-of-type{
margin-right : 20px;
}

</style>
</head>
<body>

<br>
<h2 style ="text-align: center">変更フォーム</h2>
<br><br>

<div style = "text-align : center" align = "center">

<form action ="/Bteam/DocumentChangeDelateServlet" method = "post">

<p>
<lebel>
 ISBN番号:
</lebel>
<input type = "text" name ="isbn" value="${targetbook.isbn }" size="20" pattern ="[0-9]*" title="数字で入力してください" required>
</p>

<p>
<lebel>
分野コード:
</lebel>
<input type = "text" name="cCode" value ="${targetbook.cCode }" size="20" pattern="[0-9]*" title="英数字で入力してください" required >
</p>

<p>
<lebel>
   資料名:
</lebel>
<input type = "text" name="dName" value ="${targetbook.dName }" size ="20" pattern ="\S|\S.*?\S" required >
</p>



<p>
<lebel>
   著者名:
</lebel>
<input type ="text" name="aName" value ="${targetbook.aName }" size ="20" pattern ="\S|\S.*?\S" required >
</p>

<p>
<lebel>
  出版社名:
</lebel>
<input type ="text" name="pName" value ="${targetbook.pName }" size ="20" pattern ="\S|\S.*?\S" required >
</p>

<p>
<lebel>
   出版日:
</lebel>
<input type ="text" name ="pDate" value ="${targetbook.pDate }" size="20" pattern ="^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$"title="決まった形式で入力してください(例 : 2022-05-26)" required>


<p>

<br>
<div align ="center">
<table >
<tr>
<td>
<input type ="submit"  value="変更" size ="56"  style ="text-align: center">
<input type ="hidden" name="action" value="change">

</td>

</form>
<td>
<form action = "/Bteam/showEachDocument.jsp" method ="post"  style ="text-align: center">
<input type ="submit" value ="戻る">
</form>
</td>
</tr>
</table>
</div>


</div>

</body>
</html>