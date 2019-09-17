<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
}

body {
	background-color: blue;
}

.logout {
	position: absolute;
	top: 0;
	right: 0;
}

.CouponsTable {
	position: fixed;
	margin-left: -150px; /* half of width */
	margin-top: -300px; /* half of height */
	top: 50%;
	left: 40%;
}
</style>
<title>LOGIN PAGE</title>
</head>
<body style="background-color: powderblue;">

	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />


	<div class="logout">
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">

			<input type="submit" value="Logout" />

		</form:form>
	</div>
	<security:authorize access="hasAnyRole('COMPANY')">

		<h1>Create Coupon</h1>


		<form:form action="company/create" method="POST"
			modelAttribute="theCoupon">

title <input name="title" />
			<br>
start date <input type="date" name="startd" />
			<br>
end date <input type="date" name="endd" />
			<br>
amount <input name="amount" />
			<br>
message <input name="message" />
			<br>
price <input name="price" />
			<br>
image <input name="image" />
			<br>
type <select name="type">
				<option>SPORTS</option>
				<option>GAMING</option>
				<option>BEAUTY</option>
				<option>TRAVEL</option>
			</select>
			<br>
			<input type="submit" value="submit">
		</form:form>

		<h1>all Coupons</h1>
		<form:form action="/company/read" method="GET">


			<input type="submit" value="Show All Coupons " />
		</form:form>
	</security:authorize>


	<security:authorize access="hasAnyRole('ADMIN')">


		<form:form action="/admin/getAllCustomers" method="GET">

			<h1>Show all customers</h1>

			<input type="submit" value="Show All Clients " />

		</form:form>

		<h1>Show Company by ID</h1>
		<form:form action="/admin/getCompanyById/{id}" method="GET"
			modelAttribute="company">
Id <input type="number" name="id">
			<input type="submit" value="show company">
		</form:form>

		<h1>Show customer by ID</h1>
		<form:form action="/admin/getCustomerById/{custid}" method="GET"
		modelAttribute="customer">
Id <input type="number" name="custid">
			<input type="submit" value="show customer">
		</form:form>


		<h1>Add Customer</h1>
		<form:form
			action="${pageContext.request.contextPath}/admin/createCustomer"
			method="POST" modelAttribute="customer">
Customer name<input type="text" name="cust_name">
Password <input type="text" name="password">

			<input type="submit" value="add">
		</form:form>

		<h1>Create a company</h1>

		<form:form
			action="${pageContext.request.contextPath}/admin/createCompany"
			method="POST" modelAttribute="company">
Company name <input type="text" name="comp_name">
Password <input type="text" name="password">
EMAIL <input type="text" name="email">
			<input type="submit" value="add">
		</form:form>


		<form:form action="/admin/getAllCompanies" method="GET">

			<h1>Show all companies</h1>

			<input type="submit" value="Show All" />

		</form:form>

		


	</security:authorize>


	<div class="customerLayout">
		<security:authorize access="hasAnyRole('CUSTOMER')">

			<a
				href="${pageContext.request.contextPath}/customer/getAllPurchasedCoupons">View
				All PURCHASED Coupons</a>

			<a href="${pageContext.request.contextPath}/customer/getAllCoupons">View
				All Coupons</a>

			<br>
			<br>
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

					<c:forEach var="tempCoupon" items="${theCoupon}">
						<tr>
							<td>${tempCoupon.coupid}</td>
							<td>${tempCoupon.title}</td>
							<td>${tempCoupon.startd}</td>
							<td>${tempCoupon.endd}</td>
							<td>${tempCoupon.amount}</td>
							<td>${tempCoupon.type}</td>
							<td>${tempCoupon.message}</td>
							<td>${tempCoupon.price}</td>
							<td>${tempCoupon.image}</td>
							<td><a
								href="${pageContext.request.contextPath}/customer/purchase/${tempCoupon.coupid}">Purchase</a></td>
						</tr>

					</c:forEach>
				</table>
			</div>
		</security:authorize>
	</div>

</body>
</html>