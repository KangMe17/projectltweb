<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<link href="${pageContext.request.contextPath}/css/box.css" rel="stylesheet">

<header id="header">
	<!--header-->
	<div class="header_top">
		<!--header_top-->
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="contactinfo">
						<ul class="nav nav-pills">
							<li><a href="#"><i class="fa fa-phone"></i> +2 95 01 88
									821</a></li>
							<li><a href="#"><i class="fa fa-envelope"></i>
									info@domain.com</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="social-icons pull-right">
						<ul class="nav navbar-nav">
							<li><a href="#"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
							<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
							<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/header_top-->

	<div class="header-middle">
		<!--header-middle-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<div class="logo pull-left">
						<a href="${pageContext.request.contextPath}/home"><img
							src="${URL}Eshopper/images/home/logo.png" alt="" /></a>
					</div>
					<div class="btn-group pull-right">
						<div class="btn-group">
							<button type="button" class="btn btn-default dropdown-toggle usa"
								data-toggle="dropdown">
								USA <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="#">Canada</a></li>
								<li><a href="#">UK</a></li>
							</ul>
						</div>

						<div class="btn-group">
							<button type="button" class="btn btn-default dropdown-toggle usa"
								data-toggle="dropdown">
								DOLLAR <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="#">Canadian Dollar</a></li>
								<li><a href="#">Pound</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-sm-8">
					<div class="shop-menu pull-right">
						<ul class="nav navbar-nav">
							<li><a href="/user/account"><i class="fa fa-user"></i>
									Account</a></li>
							<li><a href="#"><i class="fa fa-star"></i> Wishlist</a></li>
							<li><a href="/user/orders"><i class="fa fa-crosshairs"></i>
									Checkout</a></li>
							<li><a href="cart.html"><i class="fa fa-shopping-cart"></i>
									Cart</a></li>
							<li><c:choose>
									<c:when test="${not empty sessionScope.account}">
										<!-- Nếu người dùng đã đăng nhập, hiển thị Đăng xuất và tên người dùng -->
										<li><a href="${pageContext.request.contextPath}/logout">Đăng
												xuất</a></li>
										<li>Chào, ${sessionScope.account.firstname}!</li>
									</c:when>
									<c:otherwise>
										<!-- Nếu người dùng chưa đăng nhập, hiển thị Đăng nhập -->

										<li><a href="${pageContext.request.contextPath}/login"><i
												class="fa fa-lock"></i> Login</a></li>
										<li><a
											href="${pageContext.request.contextPath}/guest/register"><i
												class="fa fa-lock"></i> Register</a></li>
									</c:otherwise>
								</c:choose></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/header-middle-->

	<div class="header-bottom">
		<!--header-bottom-->
		<div class="container">
			<div class="row">
				<div class="col-sm-9">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<div class="mainmenu pull-left">
						<ul class="nav navbar-nav collapse navbar-collapse">
							<li><a href="index.html" class="active">Home</a></li>
							<li class="dropdown"><a href="#">Shop<i
									class="fa fa-angle-down"></i></a>
								<ul role="menu" class="sub-menu">
									<li><a href="shop.html">Products</a></li>
									<li><a href="product-details.html">Product Details</a></li>
									<li><a href="checkout.html">Checkout</a></li>
									<li><a href="cart.html">Cart</a></li>
									<li><a href="login.html">Login</a></li>
								</ul></li>
							<li class="dropdown"><a href="#">Blog<i
									class="fa fa-angle-down"></i></a>
								<ul role="menu" class="sub-menu">
									<li><a href="blog.html">Blog List</a></li>
									<li><a href="blog-single.html">Blog Single</a></li>
								</ul></li>
							<li><a href="404.html">404</a></li>
							<li><a href="contact-us.html">Contact</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="search_box pull-right">
						<form id="searchForm" method="get"
							onsubmit="return prepareSearchUrl()">
							<!-- Input từ khóa -->
							<input id="keywords" name="keywords" placeholder="Keywords?"
								required>

							<!-- Select tìm kiếm -->
							<select name="searchType" id="searchType" required>
								<option value="product">Tìm sản phẩm</option>
								<option value="store">Tìm cửa hàng</option>
								<option value="user">Tìm người dùng</option>
							</select>

							<!-- Nút tìm kiếm -->
							<button type="submit">
								<span class="box"> Search! </span>
							</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/header-bottom-->
</header>
<!--/header-->
<script>
    function prepareSearchUrl() {
        const searchType = document.getElementById("searchType").value;
        const keywords = document.getElementById("keywords").value.trim();

        // Kiểm tra nếu từ khóa trống
        if (!keywords) {
            alert("Vui lòng nhập từ khóa.");
            return false;
        }

        // Mã hóa từ khóa và thiết lập URL phù hợp
        const encodedKeywords = encodeURIComponent(keywords);
        const form = document.getElementById("searchForm");

        if (searchType === "product") {
            form.action = `/uteshop/home/searchProduct?keywords=${encodedKeywords}`;
        } else if (searchType === "store") {
            form.action = `/uteshop/home/searchStore?keywords=${encodedKeywords}`;
        } else if (searchType === "user") {
            form.action = `/uteshop/home/searchUser?keywords=${encodedKeywords}`;
        }

        // Tiếp tục gửi form
        return true;
    }
</script>
