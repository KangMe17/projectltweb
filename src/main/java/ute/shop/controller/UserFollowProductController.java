package ute.shop.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ute.shop.entity.Product;
import ute.shop.entity.User;
import ute.shop.entity.UserFollowProduct;
import ute.shop.services.IUserFollowProductService;
import ute.shop.services.implement.UserFollowProductServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/user/followedProducts", "/user/follow", "/user/unfollow" })
public class UserFollowProductController extends HttpServlet {

	private IUserFollowProductService userFollowProductService = new UserFollowProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Lấy userId từ session
		User currentUser = (User) request.getSession().getAttribute("account");

		if (currentUser == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}

		try {
			int userId = currentUser.get_id(); // Lấy userId từ session
			List<UserFollowProduct> followedProducts = userFollowProductService.getFollowedProductsByUserId(userId);
			request.setAttribute("followedProducts", followedProducts);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/followedProducts.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to fetch followed products.");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userIdParam = request.getParameter("userId");
		String productIdParam = request.getParameter("productId");

		if (userIdParam == null || productIdParam == null || userIdParam.isEmpty() || productIdParam.isEmpty()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "userId and productId are required");
			return;
		}

		try {
			int userId = Integer.parseInt(userIdParam);
			int productId = Integer.parseInt(productIdParam);

			if (userFollowProductService.isProductFollowedByUser(userId, productId)) {
				response.sendRedirect("/user/followedProducts?userId=" + userId + "&error=already-followed");
				return;
			}

			UserFollowProduct userFollowProduct = new UserFollowProduct();
			userFollowProduct.setUser(new User(userId));
			userFollowProduct.setProduct(new Product(productId));

			userFollowProductService.followProduct(userFollowProduct);
			response.sendRedirect("/user/followedProducts?userId=" + userId + "&success=followed");
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid userId or productId");
		}
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userIdParam = request.getParameter("userId");
		String productIdParam = request.getParameter("productId");

		if (userIdParam == null || productIdParam == null || userIdParam.isEmpty() || productIdParam.isEmpty()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "userId and productId are required");
			return;
		}

		try {
			int userId = Integer.parseInt(userIdParam);
			int productId = Integer.parseInt(productIdParam);

			UserFollowProduct userFollowProduct = new UserFollowProduct();
			userFollowProduct.setUser(new User(userId));
			userFollowProduct.setProduct(new Product(productId));

			userFollowProductService.unfollowProduct(userFollowProduct);
			response.sendRedirect("/user/followedProducts?userId=" + userId + "&success=unfollowed");
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid userId or productId");
		}
	}
}
