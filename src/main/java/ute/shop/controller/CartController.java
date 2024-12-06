package ute.shop.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ute.shop.entity.Cart;
import ute.shop.entity.User;
import ute.shop.services.ICartService;
import ute.shop.services.IProductService;
import ute.shop.services.implement.CartServiceImpl;
import ute.shop.services.implement.ProductServiceImpl;

import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/cart", "/cart/add", "/cart/update", "/cart/view" })
public class CartController extends HttpServlet {

	ICartService cartService = new CartServiceImpl();
	IProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		switch (action) {
		case "/cart":
		case "/cart/view":
			viewCart(req, resp);
			break;
		default:
			resp.sendRedirect(req.getContextPath() + "/home");
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		switch (action) {
		case "/cart/add":
			addToCart(req, resp);
			break;
		case "/cart/update":
			updateCart(req, resp);
			break;
		default:
			resp.sendRedirect(req.getContextPath() + "/home");
			break;
		}
	}

	private void viewCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User currentUser = (User) req.getSession().getAttribute("account");

		if (currentUser == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		Cart cart = cartService.getCartByUser(currentUser);
		req.setAttribute("cart", cart);
		req.getRequestDispatcher("/views/cart.jsp").forward(req, resp);
	}

	private void addToCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		User currentUser = (User) req.getSession().getAttribute("account");

		if (currentUser == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		try {
			int productId = Integer.parseInt(req.getParameter("productId"));
			int count = Integer.parseInt(req.getParameter("count"));

			// Kiểm tra số lượng phải lớn hơn 0
			if (count <= 0) {
				resp.sendRedirect(req.getContextPath() + "/error?message=InvalidQuantity");
				return;
			}

			// Gọi hàm service để thêm hoặc cập nhật sản phẩm
			Cart updatedCart = cartService.addOrUpdateCartItem(currentUser.get_id(), productId, count);

			if (updatedCart != null) {
				// Nếu cập nhật thành công, chuyển hướng đến trang xem giỏ hàng
				resp.sendRedirect(req.getContextPath() + "/cart/view");
			} else {
				// Nếu không tìm thấy cart hoặc sản phẩm, trả về lỗi
				resp.sendRedirect(req.getContextPath() + "/error?message=CartUpdateFailed");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			resp.sendRedirect(req.getContextPath() + "/error?message=InvalidInput");
		}
	}

	private void updateCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		User currentUser = (User) req.getSession().getAttribute("account");

		if (currentUser == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		try {
			int productId = Integer.parseInt(req.getParameter("productId"));
			int newCount = Integer.parseInt(req.getParameter("count"));

			// Kiểm tra số lượng phải lớn hơn 0
			if (newCount <= 0) {
				resp.sendRedirect(req.getContextPath() + "/error?message=InvalidQuantity");
				return;
			}

			// Gọi hàm service để cập nhật sản phẩm trong giỏ hàng
			Cart updatedCart = cartService.addOrUpdateCartItem(currentUser.get_id(), productId, newCount);

			if (updatedCart != null) {
				// Nếu cập nhật thành công, chuyển hướng đến trang xem giỏ hàng
				resp.sendRedirect(req.getContextPath() + "/cart/view");
			} else {
				// Nếu không tìm thấy cart hoặc sản phẩm, trả về lỗi
				resp.sendRedirect(req.getContextPath() + "/error?message=CartUpdateFailed");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			resp.sendRedirect(req.getContextPath() + "/error?message=InvalidInput");
		}
	}

}
