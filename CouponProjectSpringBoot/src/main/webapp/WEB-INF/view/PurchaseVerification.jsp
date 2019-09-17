<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>purchased!</title>
</head>
<body>


	<form:form var="error" items="${error}">
		<c:choose>
			<c:when test="${error==null}">

customer purchased ${coupon.title}!

</c:when>
			<c:otherwise>
        ${error} 
        <br />
			</c:otherwise>
		</c:choose>
	</form:form>
</body>
</html>