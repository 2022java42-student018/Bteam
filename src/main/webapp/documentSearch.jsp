<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DocumentSerchStartPage</title>
</head>
<body>

<h1 align="center">検索</h1>


<form action ="" method ="post" align ="center">
 <h2>資料ID:
<input type ="text" name="dID" size="20" pattern="[0-9A-Za-z]*" title="英数字で入力してください" required>
<input type ="submit" value="検索">
<input type ="hidden" name="action" value="dIDSearch">
</h2>
</form>



<form action ="" method="post" align ="center">
<h2> 資料名:
<input type ="text" name="dName" size ="20" pattern="\S|\S.*?\S" required>
<input type ="submit" value="検索">
<input type ="hidden" name="action" value="dNameSearch">
</h2>
 </form>
 
 <form action ="" method ="post" align = "center" >
 <h2> 著者名:
 <input type ="text" name="aName" size="20" pattern="\S|\S.*?\S" required>
 <input type ="submit" value="検索">
 <input type ="hidden" name="action" value="aNameSearch">
 </h2>
 </form>


<button type="button"
onclick = "">
</button>

</body>
</html>