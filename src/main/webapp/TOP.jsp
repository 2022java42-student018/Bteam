<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者TOP</title>
</head>
<body>
	<table align="center"  cellspacing="30">
		<tr>
			<td width="300" class="left" ><jsp:include page="/Counter.jsp" /></td>
			<td width="300" class="center" ><jsp:include page="/CustomerManegement.jsp" /></td>
			<td width="300" class="right"><jsp:include page="/DocumentManegement.jsp" /></td>
		</tr>
	</table>
</body>
</html>