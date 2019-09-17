<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>REMOVED!</title>
</head>
<body>




coupon ${theCoupon.title} was removed!

<form:form action ="/company/read" method="GET">


<input type="submit" value="back"/>
</form:form>
</body>
</html>