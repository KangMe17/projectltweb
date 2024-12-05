<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Home | E-Shopper</title>
<link href="${URL}Eshopper/css/bootstrap.min.css" rel="stylesheet">
<link href="${URL}Eshopper/css/font-awesome.min.css" rel="stylesheet">
<link href="${URL}Eshopper/css/prettyPhoto.css" rel="stylesheet">
<link href="${URL}Eshopper/css/price-range.css" rel="stylesheet">
<link href="${URL}Eshopper/css/animate.css" rel="stylesheet">
<link href="${URL}Eshopper/css/main.css" rel="stylesheet">
<link href="${URL}Eshopper/css/responsive.css" rel="stylesheet">
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon" href="images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="${URL}Eshopper/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="${URL}Eshopper/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="${URL}Eshopper/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="${URL}Eshopper/images/ico/apple-touch-icon-57-precomposed.png">
</head>
<!--/head-->

<body>
	
	<%@include file="/common/web/header.jsp" %>	

	<section>
		<div class="container">
			<sitemesh:write property="body" />
		</div>
	</section>

		<%@include file="/common/web/footer.jsp" %>	
	



	<script src="${URL}Eshopper/js/jquery.js"></script>
	<script src="${URL}Eshopper/js/bootstrap.min.js"></script>
	<script src="${URL}Eshopper/js/jquery.scrollUp.min.js"></script>
	<script src="${URL}Eshopper/js/price-range.js"></script>
	<script src="${URL}Eshopper/js/jquery.prettyPhoto.js"></script>
	<script src="${URL}Eshopper/js/main.js"></script>
	
</body>
</html>