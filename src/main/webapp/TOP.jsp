<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者TOP</title>
</head>
<body>
	<table>
		<tr>
			<td></td>
			<td><jsp:include page="/Counter.jsp" /></td>
			<td></td>
			<td><jsp:include page="/CustomerManegement.jsp" /></td>
			<td></td>
			<td><jsp:include page="/DocumentManegement.jsp" /></td>
			<td></td>
		</tr>
	</table>
</body>
</html>