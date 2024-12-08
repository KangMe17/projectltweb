<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Place Order</title>
</head>
<body>
	<h1>Place Your Order</h1>
	<form action="${pageContext.request.contextPath}/orders/place"
		method="post">
		<div>
			<label for="address">Address:</label> <input type="text" id="address"
				name="address" required />
		</div>
		<div>
			<label for="phone">Phone:</label> <input type="text" id="phone"
				name="phone" required />
		</div>
		<div>
			<label for="paymentMethod">Payment Method:</label> <select
				id="paymentMethod" name="paymentMethod" required>
				<option value="credit_card">Credit Card</option>
				<option value="paypal">PayPal</option>
				<option value="cash_on_delivery">Cash on Delivery</option>
			</select>
		</div>
		<div>
			<button type="submit">Place Order</button>
		</div>
	</form>
</body>
</html>
