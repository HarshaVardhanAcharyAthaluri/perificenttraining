<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, tr, td, th {
	border: solid 1px;
}

.formwrapper {
	display: flex;
	justify-content: center;
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<h1 style="text-align: center;">Consignment Details</h1>
	<jsp:include page="/header.jsp"></jsp:include>
	<div class="formwrapper">
		<button>
			<a href="/consignmentapp/consignmentservlet?path=addconsignment">ADD
				CONSIGNMENT</a>
		</button>
	</div>
	<div class="formwrapper">

		<table>
			<tr>
				<th>CID</th>
				<th>CONSIGNMEN_NAME</th>
				<th>QUANTITY</th>
				<th>STATUS</th>
				<th></th>
			</tr>
			<c:forEach var="consignment" items="${jspconsognments}">
				<tr>
					<td><c:out value="${consignment.cid}"></c:out></td>
					<td><c:out value="${consignment.cname}"></c:out></td>
					<td><c:out value="${consignment.quantity}"></c:out></td>
					<td><c:out value="${consignment.status}"></c:out></td>
					<td><button>
							<a
								href="/consignmentapp/consignmentservlet?path=consignmentdelete&cid=<c:out value='${consignment.cid}'/>">DELETE</a>
						</button></td>
				</tr>
			</c:forEach>

		</table>

	</div>

</body>
</html>