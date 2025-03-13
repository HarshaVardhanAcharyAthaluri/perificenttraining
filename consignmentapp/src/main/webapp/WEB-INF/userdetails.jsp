<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserDetails</title>
<style>
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
	
		<form action="/consignmentapp/userservlet" method="post">
			<table>
				<tr>
					<td>USERNAME</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>ADDRESS</td>
					<td><input type="text" name="addr"></td>
				</tr>
				<tr>
				<td>ROLE</td>
					<td><input type="text" name="role"></td>
				</tr>
				<tr>
				<td>PASSWORD</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
				<td></td>
				<td><input type="submit" name="SAVE"></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>