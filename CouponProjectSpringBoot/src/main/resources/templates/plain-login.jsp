
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>
</head>
<body>

<h3> My Custom Login Page</h3>

<form:form action="http://localhost:8080/authenticateTheUser" method="post">

<p> User name : <input type="text" name="username"/> </p>
<p> Password: <input type="password" name="password"/> </p>

<input type="submit" value="Login"/>

</form:form>
</body>
</html>