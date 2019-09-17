<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>

<script>
function goBack() {
  window.history.back();
}
</script>
<meta charset="ISO-8859-1">
<style >
table, th, td {
  border: 1px solid black;

}

.CouponsTable{
	position: fixed;
	margin-left: -150px; /* half of width */
	margin-top: -300px; /* half of height */
	top: 50%;
	left: 40%;

}

</style>
<title>Insert title here</title>
</head>
<body>


<div class="CouponsTable">
<button onclick="goBack()">Go Back</button>
<h1>All Coupons List</h1>
<table class="i">
    <tr>
               <th>id</th>
               <th>title</th>
               <th>start</th>
               <th>end</th>
               <th>amount</th>
               <th>type</th>
               <th>message</th>
               <th>price</th>
               <th>image</th>
           </tr>
        
<c:forEach var="tempCoupon" items="${theCoupon}" >
<tr> 
<td> ${tempCoupon.coupid} </td>
<td> ${tempCoupon.title} </td>
<td> ${tempCoupon.startd} </td>
<td> ${tempCoupon.endd} </td>
<td> ${tempCoupon.amount} </td>
<td> ${tempCoupon.type} </td>
<td> ${tempCoupon.message} </td>
<td> ${tempCoupon.price} </td>
<td> ${tempCoupon.image} </td>

<td><a href="/company/delete/${tempCoupon.coupid}">remove </a>  </td>

</tr>
</c:forEach>

</table>
</div>
</body>
</html>