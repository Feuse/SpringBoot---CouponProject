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

<h1>All Customers List</h1>

<c:forEach var="tempCustomer" items="${customers}">
<table class="i">
<tr>
<td> ${tempCustomer.cust_id} </td>
<td> ${tempCustomer.cust_name} </td>
<td> ${tempCustomer.password} </td>

</tr>
</table>
</c:forEach>

</body>
</html>