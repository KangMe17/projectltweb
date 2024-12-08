<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h1 style="text-align: center; font-family: Arial, sans-serif;">Your
		Followed Products</h1>
	<c:if test="${not empty error}">
		<p style="color: red; font-weight: bold;">${error}</p>
	</c:if>
	<c:if test="${not empty success}">
		<p style="color: green; font-weight: bold;">${success}</p>
	</c:if>
	<div>
		<c:forEach var="followedProduct" items="${followedProducts}">
			<div
				style="border: 1px solid #ddd; padding: 10px; margin: 10px 0; display: flex; align-items: center; border-radius: 5px;">
				<img
					src="${not empty followedProduct.product.listImages ? followedProduct.product.listImages[0] : '/images/default-product.jpg'}"
					alt="${followedProduct.product.name}"
					style="width: 100px; height: 100px; object-fit: cover; margin-right: 15px; border-radius: 5px;">
				<div>
					<h3
						style="margin: 0; font-size: 1.2em; font-family: Arial, sans-serif;">${followedProduct.product.name}</h3>
					<p style="margin: 5px 0; color: #555;">
						Price: <strong>${followedProduct.product.price} USD</strong>
					</p>
					<p style="margin: 5px 0; color: #777;">Description:
						${followedProduct.product.description}</p>
					<p style="margin: 5px 0; color: #777;">Sold:
						${followedProduct.product.sold}</p>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>
