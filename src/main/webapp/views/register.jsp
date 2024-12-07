<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>V-shopper Register</title>
</head>
<body>
	<section id="form">
		<!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<div class="signup-form">
						<!--sign up form-->
						<h2>New User Register!</h2>
						<!-- Hiển thị thông báo -->
						<c:if test="${not empty message}">
							<h4 style="color: red;">${message}</h4>
						</c:if>

						<form method="post" action="${pageContext.request.contextPath}/guest/register" enctype="multipart/form-data">
							<input type="text" name="firstname" placeholder="Firstname" required /> 
							<input type="text" name="lastname" placeholder="Lastname" required /> 
							<input type="text" name="phone" placeholder="SDT" required /> 
							<input type="text" name="id_card" placeholder="CMND/CCCD" required /> 
							<input type="email" name="email" placeholder="Email Address" required /> 
							<input type="password" name="password" placeholder="Password" required /> 
							<input type="file" name="photo" accept="image/*" required>
							
							<!-- Hiển thị ảnh nếu user đã đăng ký -->
							<c:if test="${not empty user}">
								<h3>Xin chào, ${user.firstname}!</h3>
								<img src="${pageContext.request.contextPath}/uploads/${user.avatar}" alt="Avatar của bạn" />
							</c:if>

							<button type="submit" class="site-btn register-btn">REGISTER</button>
						</form>
					</div>
					<!--/sign up form-->
				</div>
			</div>
		</div>
	</section>
	<!--/form-->
</body>

<script>
	$(function() {
		$("#slider-range").slider({
			range : true,
			min : 0,
			max : 200,
			values : [ 0, 0 ],
			slide : function(event, ui) {
				$("#amount").val("$" + ui.values[0] + " - $" + ui.values[1]);
				$("#amount_start").val(ui.values[0]);
				$("#amount_end").val(ui.values[1]);
			}
		});
		/* $("#amount").val(
				"$" + $("#slider-range").slider("values", 0) + " - $"
						+ $("#slider-range").slider("values", 1)); */
	});

	function readURL(input) {
		if (input.files && input.files[0]) {

			var reader = new FileReader();

			reader.onload = function(e) {
				$('.image-upload-wrap').hide();

				$('.file-upload-image').attr('src', e.target.result);
				$('.file-upload-content').show();

				$('.image-title').html(input.files[0].name);
			};

			reader.readAsDataURL(input.files[0]);

		} else {
			removeUpload();
		}
	}

	function removeUpload() {
		$('.file-upload-input').replaceWith($('.file-upload-input').clone());
		$('.file-upload-content').hide();
		$('.image-upload-wrap').show();
	}
	$('.image-upload-wrap').bind('dragover', function() {
		$('.image-upload-wrap').addClass('image-dropping');
	});
	$('.image-upload-wrap').bind('dragleave', function() {
		$('.image-upload-wrap').removeClass('image-dropping');
	});
</script>
</html>