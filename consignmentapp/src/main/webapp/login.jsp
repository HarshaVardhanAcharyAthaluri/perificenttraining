<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
.formwrapper {
	display: flex;
	justify-content: center;
}
.loginerror{
text-align: center;
color: red;
}
.logout{
text-align: center;
color: teal;
}
</style>
</head>
<body>

<h1 style="text-align: center;">Login Details</h1>
<div class="loginerror">${loginfailed}</div>
<div class="logout">${logoutmsg}</div>
	<div class="formwrapper">
	
		<form action="/consignmentapp/login" method="post">
			<table>
				<tr>
					<td>USERNAME</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
				<td>PASSWORD</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
				<td></td>
				<td><input type="submit" name="LOGIN"></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>