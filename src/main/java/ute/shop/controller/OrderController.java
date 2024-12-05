package ute.shop.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ute.shop.entity.Order;
import ute.shop.entity.OrderStatus;
import ute.shop.services.IOrderService;
import ute.shop.services.implement.OrderServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/orders", "/orders/cancel", "/orders/status" })
public class OrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final IOrderService orderService;

	public OrderController() {
		this.orderService = new OrderServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		switch (action) {
		case "/orders":
			showOrderHistory(req, resp);
			break;
		default:
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		switch (action) {
		case "/orders/cancel":
			cancelOrder(req, resp);
			break;
		case "/orders/status":
			updateOrderStatus(req, resp);
			break;
		default:
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	private void showOrderHistory(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Integer userId = (Integer) req.getSession().getAttribute("userId");

		if (userId == null) {
			req.setAttribute("error", "You must be logged in to view order history.");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}

		try {
			List<Order> orders = orderService.getAllOrdersByUser(userId);
			req.setAttribute("orders", orders);
			req.getRequestDispatcher("/views/order-history.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to fetch order history.");
		}
	}

	private void cancelOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			int orderId = Integer.parseInt(req.getParameter("orderId"));

			boolean isCanceled = orderService.cancelOrder(orderId);

			if (isCanceled) {
				resp.sendRedirect(req.getContextPath() + "/orders?success=cancel");
			} else {
				resp.sendRedirect(req.getContextPath() + "/orders?error=cancel");
			}
		} catch (NumberFormatException e) {
			resp.sendRedirect(req.getContextPath() + "/orders?error=invalid");
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect(req.getContextPath() + "/orders?error=cancel");
		}
	}

	private void updateOrderStatus(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			int orderId = Integer.parseInt(req.getParameter("orderId"));
			String status = req.getParameter("status");

			if (status == null || status.isEmpty()) {
				resp.sendRedirect(req.getContextPath() + "/orders?error=invalid-status");
				return;
			}

			boolean isUpdated = orderService.updateOrderStatus(orderId, OrderStatus.valueOf(status.toUpperCase()));

			if (isUpdated) {
				resp.sendRedirect(req.getContextPath() + "/orders?success=update");
			} else {
				resp.sendRedirect(req.getContextPath() + "/orders?error=update");
			}
		} catch (IllegalArgumentException e) {
			resp.sendRedirect(req.getContextPath() + "/orders?error=invalid");
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect(req.getContextPath() + "/orders?error=update");
		}
	}
}
