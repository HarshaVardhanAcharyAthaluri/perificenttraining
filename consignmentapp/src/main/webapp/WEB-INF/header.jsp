<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.navbar {
	display: flex;
	justify-content: space-evenly;
	padding: 15px 0px;
}

.navbar a {
	text-decoration: none;
	color: white;
	font-size: large;
}

.navbar li {
	text-decoration: none;
	list-style-type: none;
}

.logoutbttn {
	float: right;
	margin-right: 50px;
}

.navwarapper {
	background-color: #127a76;
	height: 100px;
}
</style>

</head>
<header>
	<nav class="navwarapper">
		<ul class="navbar">
			<li><a href="/consignmentapp/index">HOME</a></li>
			<li><a
				href="/consignmentapp/consignmentservlet?path=consignmentlist">CONSIGNMENTS</a></li>
			<li><a href="/consignmentapp/userservlet?path=list">USERS</a></li>
		</ul>
		<div class="logoutbttn">
			<button><a href="/consignmentapp/logout">LOGOUT</a></button>
		</div>
	</nav>
</header>
<body>

</body>
</html>