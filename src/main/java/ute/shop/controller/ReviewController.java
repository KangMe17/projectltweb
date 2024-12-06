package ute.shop.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ute.shop.entity.Order;
import ute.shop.entity.Product;
import ute.shop.entity.Review;
import ute.shop.entity.User;
import ute.shop.services.IReviewService;
import ute.shop.services.implement.OrderServiceImpl;
import ute.shop.services.implement.ReviewServiceImpl;
import ute.shop.services.*;

import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/review/add", "/review/delete" })
public class ReviewController extends HttpServlet {

	private final IReviewService reviewService = new ReviewServiceImpl();
	private final IOrderService orderService = new OrderServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int orderId = Integer.parseInt(req.getParameter("orderId"));
		Order order = orderService.findById(orderId);

		req.setAttribute("order", order);
		req.getRequestDispatcher("/views/addReview.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		switch (action) {
		case "/review/add":
			addReview(req, resp);
			break;
		case "/review/delete":
			deleteReview(req, resp);
			break;
		default:
			resp.sendRedirect(req.getContextPath() + "/home");
		}
	}

	private void addReview(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		User currentUser = (User) req.getSession().getAttribute("account");
		if (currentUser == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		int productId = Integer.parseInt(req.getParameter("productId"));
		int stars = Integer.parseInt(req.getParameter("stars"));
		String content = req.getParameter("content");

		Review review = new Review();
		review.setUser(currentUser);
		review.setProduct(new Product(productId)); // Tạo đối tượng product giả
		review.setStars(stars);
		review.setContent(content);

		reviewService.addReview(review);
		resp.sendRedirect(req.getContextPath() + "/product/detail?productId=" + productId);
	}

	private void deleteReview(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int reviewId = Integer.parseInt(req.getParameter("reviewId"));
		reviewService.deleteReview(reviewId);
		resp.sendRedirect(req.getContextPath() + "/home");
	}
}
