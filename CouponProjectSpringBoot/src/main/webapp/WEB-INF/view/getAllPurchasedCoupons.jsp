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
<style type="text/css">
.CouponsTable {
	position: fixed;
	margin-left: -150px; /* half of width */
	margin-top: -300px; /* half of height */
	top: 50%;
	left: 40%;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>All Coupons List</h1>
<button onclick="goBack()">Go Back</button>

<div class="CouponsTable">
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


</tr>

</c:forEach>

</table>
</div>
</div>
</body>
</html>