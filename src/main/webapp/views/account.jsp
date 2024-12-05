<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
	<h1>Thông tin tài khoản</h1>

	<c:choose>
		<c:when test="${not empty account}">
			<p>
				<strong>Avatar:</strong>
			</p>
			<p>
				<c:choose>
					<c:when test="${not empty account.avatar}">
						<img
							src="${pageContext.request.contextPath}/images/${account.avatar}"
							alt="Avatar" width="150" height="150">
					</c:when>
					<c:otherwise>
						<img
							src="${pageContext.request.contextPath}/images/default-avatar.jpg"
							alt="Default Avatar" width="150" height="150">
					</c:otherwise>
				</c:choose>
			</p>
			<form action="${pageContext.request.contextPath}/upload-avatar"
				method="post" enctype="multipart/form-data">
				<input type="file" name="avatar" accept="image/*" required>
				<button type="submit">Upload</button>
			</form>
			<p>
				<strong>Email:</strong> ${account.email}
			</p>
			<p>
				<strong>Số điện thoại:</strong> ${account.phone}
			</p>
			<p>
				<strong>Họ và tên:</strong> ${account.firstname} ${account.lastname}
			</p>
			<p>
				<strong>Chứng minh nhân dân:</strong> ${account.id_card}
			</p>
			<p>
				<strong>Kích hoạt email:</strong> ${account.isEmailActive ? "Đã kích hoạt" : "Chưa kích hoạt"}
			</p>
			<p>
				<strong>Kích hoạt số điện thoại:</strong> ${account.isPhoneActive ? "Đã kích hoạt" : "Chưa kích hoạt"}
			</p>
			<p>
				<strong>Vai trò:</strong> ${account.role == 'ADMIN' ? "Admin" : "Người dùng"}
			</p>
			<p>
				<strong>Địa chỉ:</strong> ${account.address != null ? account.address : "Chưa cập nhật"}
			</p>
			<p>
				<strong>Số dư ví điện tử:</strong> ${account.e_wallet} USD
			</p>
			<p>
				<strong>Ngày tạo:</strong> ${account.createdAt}
			</p>
			<p>
				<strong>Ngày cập nhật:</strong> ${account.updatedAt}
			</p>
			<!-- Nút sửa thông tin -->
			<button
				onclick="window.location.href='${pageContext.request.contextPath}/edit-profile'">Sửa
				thông tin</button>

			<button onclick="showChangePasswordForm()">Thay đổi mật khẩu</button>

			<!-- Form thay đổi mật khẩu (ẩn mặc định) -->
			<div id="changePasswordForm" style="display: none;">
				<h3>Thay đổi mật khẩu</h3>
				<form action="${pageContext.request.contextPath}/change-password"
					method="post">
					<div>
						<label for="oldPassword">Mật khẩu cũ:</label> <input
							type="password" id="oldPassword" name="oldPassword" required>
					</div>
					<div>
						<label for="newPassword">Mật khẩu mới:</label> <input
							type="password" id="newPassword" name="newPassword" required>
					</div>
					<div>
						<label for="confirmPassword">Xác nhận mật khẩu mới:</label> <input
							type="password" id="confirmPassword" name="confirmPassword"
							required>
					</div>
					<button type="submit">Thay đổi mật khẩu</button>
				</form>
			</div>
		</c:when>
		<c:otherwise>
			<p>
				Bạn chưa đăng nhập. Vui lòng <a
					href="${pageContext.request.contextPath}/login">đăng nhập</a>.
			</p>
		</c:otherwise>
	</c:choose>
	<script>
		function showChangePasswordForm() {
			var form = document.getElementById("changePasswordForm");
			form.style.display = form.style.display === "none" ? "block"
					: "none";
		}
	</script>
</body>
