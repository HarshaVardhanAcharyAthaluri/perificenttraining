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
<h1 style="text-align: center;">CONSIGNMENT DETAILS</h1>

	<div class="formwrapper">
		<form action="/consignmentapp/consignmentservlet?path=consignmentsave" method="post">
			<table>
				<tr>
					<td>CNAME</td>
					<td><input type="text" name="cname"></td>
				</tr>
				<tr>
					<td>QUANTITY</td>
					<td><input type="text" name="qunatity"></td>
				</tr>
				<tr>
				<td>STATUS</td>
					<td><input type="text" name="status"></td>
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