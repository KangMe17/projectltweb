<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Giỏ hàng của bạn</h1>

<c:choose>
	<c:when
		test="${cart != null && cart.cartItems != null && !cart.cartItems.isEmpty()}">
		<table border="1" cellpadding="10" cellspacing="0">
			<thead>
				<tr>
					<th>Sản phẩm</th>
					<th>Giá</th>
					<th>Số lượng</th>
					<th>Tổng cộng</th>
					<th>Hành động</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${cart.cartItems}">
					<tr>
						<td>${item.product.name}</td>
						<td>${item.product.price}</td>
						<td>
							<form action="${pageContext.request.contextPath}/cart/update"
								method="post">
								<input type="hidden" name="productId"
									value="${item.product._id}"> <input type="number"
									name="count" value="${item.count}" min="1" required>
								<button type="submit">Cập nhật</button>
							</form>
						</td>
						<td>${item.product.price * item.count}</td>
						<td>
							<form action="${pageContext.request.contextPath}/cart/remove"
								method="post">
								<input type="hidden" name="productId"
									value="${item.product._id}">
								<button type="submit" class="btn-danger">Xóa</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="3"><strong>Tổng cộng:</strong></td>
					<td colspan="2">
						<!-- Calculate total sum of the cart items --> <c:set
							var="totalSum" value="0" /> <c:forEach var="item"
							items="${cart.cartItems}">
							<c:set var="totalSum"
								value="${totalSum + (item.product.price * item.count)}" />
						</c:forEach> ${totalSum}
					</td>
				</tr>
			</tfoot>
		</table>
		<button
			onclick="window.location.href='${pageContext.request.contextPath}/checkout'">Thanh
			toán</button>
	</c:when>
	<c:otherwise>
		<p>Giỏ hàng của bạn đang trống.</p>
		<a href="${pageContext.request.contextPath}/products">Tiếp tục mua
			sắm</a>
	</c:otherwise>
</c:choose>
