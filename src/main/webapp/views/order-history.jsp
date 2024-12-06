<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Lịch sử mua hàng</h1>

<c:choose>
	<c:when test="${not empty orders}">
		<table border="1">
			<thead>
				<tr>
					<th>Mã đơn hàng</th>
					<th>Ngày đặt</th>
					<th>Trạng thái</th>
					<th>Tổng tiền</th>
					<th>Hành động</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="order" items="${orders}">
					<tr>
						<td>${order._id}</td>
						<td>${order.createdAt}</td>
						<td>${order.status}</td>
						<td>${order.amountFromUser}</td>
						<td><c:if test="${order.status == 'NOT_PROCESSED'}">
								<form action="${pageContext.request.contextPath}/orders/cancel"
									method="post" style="display: inline;">
									<input type="hidden" name="orderId" value="${order._id}" />
									<button type="submit">Hủy</button>
								</form>
							</c:if> <c:if test="${order.status == 'DELIVERED'}">
								<form action="${pageContext.request.contextPath}/review/add"
									method="get" style="display: inline;">
									<input type="hidden" name="orderId" value="${order._id}" />
									<button type="submit">Đánh giá</button>
								</form>
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
		<p>Bạn chưa có đơn hàng nào.</p>
	</c:otherwise>
</c:choose>
