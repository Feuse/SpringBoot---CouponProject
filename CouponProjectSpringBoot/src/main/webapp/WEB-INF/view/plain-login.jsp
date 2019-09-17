<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>

<style>
body {
background-color:powderblue;
}
.failed{
color: red;
}

.logout{
color: green;
border : solid 1px;
background: coral;
font-size: 20px;
}
</style>
</head>
<body>

<h3> My Custom Login Page</h3>

<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
<c:if test="${param.error != null}">
<i class="failed"> Sorry! you entered invalid username/password.</i>
</c:if>

<p> User name : <input type="text" name="username"/> </p>
<p> Password: <input type="password" name="password"/> </p>

<input type="submit" value="Login"/>

<c:if test="${param.logout != null}">
<i class="logout"> You have been logged out!</i>
</c:if>

</form:form>
</body>
</html>