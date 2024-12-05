<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<body>
	<div class="container">
		<h2 class="my-4">Khôi phục mật khẩu</h2>

		<!-- Hiển thị thông báo nếu có lỗi -->
		<c:if test="${alert != null}">
			<div class="alert alert-danger" role="alert">${alert}</div>
		</c:if>

		<!-- Form nhập email để lấy mật khẩu mới -->
		<form action="${pageContext.request.contextPath}/forgot-password"
			method="post">
			<div class="form-group">
				<label for="email">Nhập email của bạn để nhận mật khẩu mới:</label>
				<input type="email" id="email" name="email" class="form-control"
					required>
			</div>
			<button type="submit" class="btn btn-primary">Gửi liên kết
				tạo mật khẩu mới</button>
		</form>

		<!-- Liên kết quay lại trang đăng nhập nếu người dùng đã có tài khoản -->
		<div class="mt-3">
			<a href="${pageContext.request.contextPath}/login">Quay lại trang
				đăng nhập</a>
		</div>
	</div>
</body>

