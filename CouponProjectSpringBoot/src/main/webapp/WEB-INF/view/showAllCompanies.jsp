<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style >
table, th, td {
  border: 1px solid black;

}
</style>
<title>Insert title here</title>
</head>
<body>

<h1>All Companies List</h1>

<c:forEach var="tempCompany" items="${companies}">
<table class="i">
<tr>
<td > ${tempCompany.id} </td>
<td> ${tempCompany.comp_name} </td>
<td> ${tempCompany.password} </td>
<td> ${tempCompany.email} </td>
	<td><a
							href="${pageContext.request.contextPath}/admin/RemoveCompanyById/${tempCompany.id}">Delete</a></td>
</tr>
</table>

</c:forEach>

</body>
</html>