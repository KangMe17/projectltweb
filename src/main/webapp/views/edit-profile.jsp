<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
    <h1>Sửa thông tin cá nhân</h1>

    <form action="${pageContext.request.contextPath}/edit-profile" method="post">
        <div>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${account.email}" required>
        </div>
        <div>
            <label for="phone">Số điện thoại:</label>
            <input type="text" id="phone" name="phone" value="${account.phone}" required>
        </div>
        <div>
            <label for="address">Địa chỉ:</label>
            <input type="text" id="address" name="address" value="${account.address}" required>
        </div>
        <button type="submit">Lưu thay đổi</button>
    </form>
</body>