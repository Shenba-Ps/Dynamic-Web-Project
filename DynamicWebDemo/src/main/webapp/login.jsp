<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
		<h1 class="label">User Login</h1>
		
		<form class="login_form" action="<%= request.getContextPath() %>/LoginServlet" method="post"  onsubmit="return validated()">
			<div class="font">username</div>
			<input autocomplete="off" type="text" name="username">
			<div id="email_error">Please fill up your Email or Phone</div>
			<div class="font font2">Password</div>
			<input type="password" name="password">
			<div id="pass_error">Please fill up your Password</div>
			<button type="submit">Login</button>
		</form>
	</div>	

</body>
</html>