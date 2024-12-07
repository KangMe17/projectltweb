<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<body>


	<section id="form">
		<!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form">
						<!--login form-->
						<h2>Login to your account</h2>
						<c:if test="${alert !=null}">
							<h3 class="alert alertdanger">${alert}</h3>
						</c:if>
						<form action="/UTEShop/login" method="post">
							<input type="email" name="email" placeholder="Email Address"
								required />
							<!-- Email input -->
							<input type="password" name="password" placeholder="Password"
								required />
							<!-- Password input -->
							<span> <input type="checkbox" class="checkbox"
								name="keepSignedIn"> Keep me signed in <!-- Optional remember me checkbox -->
							</span>
							<button type="submit" class="btn btn-default">Login</button>
						</form>
						<div class="mt-3">
							<a href="${pageContext.request.contextPath}/forgot-password">Forgot
								Password?</a>
						</div>
					</div>
					<!--/login form-->
				</div>
				<div class="col-sm-1">
					<h2 class="or">OR</h2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form">
						<!--sign up form-->
						<h2>New User Signup!</h2>
						<form action="#">
							<input type="text" placeholder="Name" /> <input type="email"
								placeholder="Email Address" /> <input type="password"
								placeholder="Password" />
							<button type="submit" class="btn btn-default">Signup</button>
						</form>
					</div>
					<!--/sign up form-->
				</div>
			</div>
		</div>
	</section>
	<!--/form-->




</body>


