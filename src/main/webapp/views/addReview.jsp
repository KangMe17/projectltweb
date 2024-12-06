<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Thêm đánh giá</h1>

<form action="${pageContext.request.contextPath}/reviews/save"
	method="post">
	<input type="hidden" name="orderId" value="${order._id}" /> <label
		for="stars">Đánh giá (1-5 sao):</label> <select name="stars"
		id="stars" required>
		<option value="1">1 sao</option>
		<option value="2">2 sao</option>
		<option value="3">3 sao</option>
		<option value="4">4 sao</option>
		<option value="5">5 sao</option>
	</select> <label for="content">Nội dung:</label>
	<textarea name="content" id="content" required></textarea>

	<button type="submit">Gửi đánh giá</button>
</form>
