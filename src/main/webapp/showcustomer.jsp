<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>会員ID</th><th>氏名</th><th>電話番号</th><th>Eメール</th><th>生年月日</th><th>入会年月日</th>
		</tr>
		<c:forEach items="${customer}" var="cust">
			<tr>
				<td>${cust.cID }</td><td>${cust.cName }</td><td>${cust.cTell }</td><td>${cust.cMail }</td><td>${cust.cBday }</td><td>${cust.cJdate }</td>
			</tr>
		</c:forEach>
	</table>
	<!-- <a href="/Bteam/lend_doc.jsp">貸出中資料</a>
	<input type="hidden" name="action" value="${cust.cID }"> -->
	getparrmeter
	
	<form action="./CustomersearchServlet?" method="get">
				<a href="/CustomersearchServlet?action=lend_doc">貸出中資料</a>
				<!-- <input type="submit" value="rendoc"> -->
				<input type="hidden" name="action" value="${cust.cID }">
			</form>
	
	<a href="/Bteam/history_doc.jsp">貸出履歴</a> //historyテーブル
	<input type="hidden" name="action" value="${cust.cID }">
	
session.removeAttribute("Customerdata");
 
<a href ="/Bteam/documentSearch.jsp"><h2 align = "center">検索TOPへ</h2></a>


</body>
</html>