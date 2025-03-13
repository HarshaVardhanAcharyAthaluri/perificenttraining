<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table,tr,td,th{
border: solid 1px;
}
.formwrapper {
	display: flex;
	justify-content: center;
}
</style>
</head>
<body>
	<h1 style="text-align: center;">User Details</h1>
	<jsp:include page="/header.jsp"></jsp:include>
	<div class="formwrapper">

		<table>
			<tr>
				<th>UID</th>
				<th>USERNAME</th>
				<th>ADRESS</th>
				<th>ROLE</th>
				<th></th>
			</tr>
			<c:forEach var="user" items="${jspusers}">
			<tr>
				<td><c:out value="${user.uid}"></c:out> </td>
				<td><c:out value="${user.username}"></c:out> </td>
				<td><c:out value="${user.address}"></c:out> </td>
				<td><c:out value="${user.role}"></c:out> </td>
				<td><button><a href="/consignmentapp/delete?name=<c:out value='${user.username}'/>">DELETE</a></button> </td>
			</tr>
			</c:forEach>
			
		</table>

	</div>

</body>
</html>