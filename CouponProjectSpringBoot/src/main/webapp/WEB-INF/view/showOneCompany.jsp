<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form var="comp" items="${company}">
	<table>
		<tr>
			<td>${comp.id}</td>
			<td>${comp.comp_name}</td>
			<td>${comp.password}</td>
			<td>${company.email}</td>
		</tr>
	</table>	
</form:form>
</body>
</html>