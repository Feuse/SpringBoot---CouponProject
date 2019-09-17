<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>

<title>Create Coupon</title>
</head>
<body style="background-color:powderblue;">



<h1> Create Coupon </h1>


<form:form action="company/create" method="POST" modelAttribute="theCoupon">

<input name="title"/>
<input name="start"/>
<input name="end"/>
<input name="amount"/>
<input name="message"/>
<input name="price"/>
<input name="image"/>
<select name="type">
<option>SPORTS</option>
<option>GAMING</option>
</select>

<input type="submit" value="submit">
</form:form>


</body>
</html>