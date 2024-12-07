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

@WebServlet(urlPatterns = { "/orders", "/orders/cancel", "/orders/status", "/orders/place", "/orders/payment" })
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
		case "/orders/place":
			showPlaceOrderForm(req, resp);
			break;
		case "/orders/payment":
			showPaymentForm(req, resp);
			break;
		default:
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	private void showPlaceOrderForm(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Kiểm tra xem người dùng có đăng nhập hay không
		Integer userId = (Integer) req.getSession().getAttribute("userId");

		if (userId == null) {
			// Nếu người dùng chưa đăng nhập, chuyển đến trang đăng nhập
			resp.sendRedirect(req.getContextPath() + "/login.jsp");
			return;
		}

		// Hiển thị trang đặt hàng
		req.getRequestDispatcher("/views/placeOrder.jsp").forward(req, resp);
	}

	private void showPaymentForm(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Kiểm tra xem người dùng có đăng nhập hay không
		Integer userId = (Integer) req.getSession().getAttribute("userId");

		if (userId == null) {
			// Nếu người dùng chưa đăng nhập, chuyển đến trang đăng nhập
			resp.sendRedirect(req.getContextPath() + "/login.jsp");
			return;
		}

		// Lấy thông tin đơn hàng từ service (giả sử đơn hàng của người dùng đã có)
		try {
			List<Order> orders = orderService.getAllOrdersByUser(userId);
			req.setAttribute("orders", orders);
			req.getRequestDispatcher("/views/payment.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to fetch order details.");
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
		case "/orders/payment":
			makePayment(req, resp);
			break;
		case "/orders/place":
			placeOrder(req, resp); // Thêm xử lý đặt hàng
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

	private void placeOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			Integer userId = (Integer) req.getSession().getAttribute("userId");

			if (userId == null) {
				resp.sendRedirect(req.getContextPath() + "/login.jsp");
				return;
			}

			// Lấy thông tin từ form
			String address = req.getParameter("address");
			String phone = req.getParameter("phone");
			String paymentMethod = req.getParameter("paymentMethod");

			// Gọi service để đặt hàng
			Order order = orderService.placeOrder(userId, address, phone, paymentMethod);

			if (order != null) {
				resp.sendRedirect(req.getContextPath() + "/orders?success=place");
			} else {
				resp.sendRedirect(req.getContextPath() + "/cart?error=place");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect(req.getContextPath() + "/cart?error=place");
		}
	}

	private void makePayment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			int orderId = Integer.parseInt(req.getParameter("orderId"));

			// Gọi service để thực hiện thanh toán
			boolean isPaid = orderService.makePayment(orderId);

			if (isPaid) {
				resp.sendRedirect(req.getContextPath() + "/orders?success=payment");
			} else {
				resp.sendRedirect(req.getContextPath() + "/orders?error=payment");
			}
		} catch (NumberFormatException e) {
			resp.sendRedirect(req.getContextPath() + "/orders?error=invalid-order-id");
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect(req.getContextPath() + "/orders?error=payment");
		}
	}
}
