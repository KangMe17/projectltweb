<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">
<title><sitemesh:write property="title" /></title>
<%@ include file="/common/css-link.jsp"%>
<style>
    .store-title {
        font-size: 2em;
        text-align: center;
        color: #333;
        margin: 20px 0;
    }

    .store-avatar {
        width: 120px;
        height: 120px;
        border-radius: 50%;
        border: 3px solid #4CAF50;
        display: block;
        margin: 0 auto;
    }

    .store-bio {
        text-align: center;
        color: #666;
        margin: 10px 0;
    }

    .staff-title, .slider-title, .review-title, .product-title {
        text-align: center;
        color: #555;
        margin: 20px 0 10px;
    }

    .staff-list, .product-list {
        list-style-type: none;
        padding: 0;
        text-align: center;
    }

    .staff-item, .product-item {
        background-color: #e7f3fe;
        margin: 5px 0;
        padding: 10px;
        border-radius: 5px;
    }

    .image-slider {
        display: flex;
        overflow-x: auto;
        padding: 10px;
        justify-content: center;
    }

    .slider-image {
        width: 300px;
        height: auto;
        border-radius: 8px;
        margin: 0 10px;
        transition: transform 0.2s;
    }

    .slider-image:hover {
        transform: scale(1.05);
    }

    .review-container {
        text-align: center;
    }

    .review-item {
        border: 1px solid #ddd;
        border-radius: 8px;
        margin: 10px 0;
        padding: 15px;
        background-color: #fff;
        box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
    }

    .review-content {
        margin: 5px 0;
        color: #444;
    }

    .review-user {
        font-size: 0.9em;
        color: #777;
    }

    .product-link {
        text-decoration: none;
        color: #007BFF;
    }

    .product-link:hover {
        text-decoration: underline;
    }
    
    .search-title {
        font-size: 2.5em;
        text-align: center;
        color: #333;
        margin: 20px 0;
    }

    .search-results {
        text-align: center;
        color: #666;
        margin-bottom: 30px;
        font-size: 1.2em;
    }

    .store-list-container {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        gap: 20px;
        margin: 0 auto;
        max-width: 1200px;
    }

    .store-card-item {
        border: 1px solid #ddd;
        border-radius: 8px;
        width: 280px;
        text-align: center;
        background-color: #fff;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        transition: transform 0.2s;
    }

    .store-card-item:hover {
        transform: scale(1.05);
    }

    .store-avatar-image {
        width: 100px;
        height: 100px;
        border-radius: 50%;
        margin-top: 15px;
        border: 3px solid #4CAF50;
    }

    .store-name {
        font-size: 1.5em;
        color: #333;
        margin: 10px 0;
    }

    .store-bio {
        color: #666;
        margin: 10px 15px;
        font-size: 0.9em;
    }

    .store-detail-link {
        display: inline-block;
        margin: 15px 0;
        padding: 10px 15px;
        background-color: #4CAF50;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s;
    }

    .store-detail-link:hover {
        background-color: #45a049;
    }

    .pagination-container {
        text-align: center;
        margin: 20px 0;
    }

    .pagination-link, .pagination-number {
        margin: 0 5px;
        padding: 10px;
        background-color: #f1f1f1;
        color: #333;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s;
    }

    .pagination-link:hover, .pagination-number:hover {
        background-color: #ddd;
    }

    .pagination-number.active {
        background-color: #4CAF50;
        color: white;
    }
    
</style>
<%@ include file="/common/web/header.jsp"%>

</head>

<body class="my-body">
	<sitemesh:write property="body" />
</body>

<footer>
	<%@ include file="/common/web/footer.jsp"%>
</footer>