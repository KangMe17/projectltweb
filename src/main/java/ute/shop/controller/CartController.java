package ute.shop.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ute.shop.entity.Cart;
import ute.shop.entity.CartItem;
import ute.shop.entity.Order;
import ute.shop.entity.OrderItem;
import ute.shop.entity.User;
import ute.shop.services.ICartService;
import ute.shop.services.IProductService;
import ute.shop.services.implement.CartServiceImpl;
import ute.shop.services.implement.ProductServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = { "/cart", "/cart/add", "/cart/update", "/cart/remove", "/cart/view"	 })
public class CartController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final ICartService cartService = new CartServiceImpl();
	private final IProductService productService = new ProductServiceImpl();

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
		case "/cart/remove":
			removeFromCart(req, resp);
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
		req.getSession().setAttribute("cart", cart);
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

			if (count <= 0) {
				throw new IllegalArgumentException("Số lượng phải lớn hơn 0.");
			}

			Cart updatedCart = cartService.addOrUpdateCartItem(currentUser.get_id(), productId, count);
			req.getSession().setAttribute("cart", updatedCart);
			resp.sendRedirect(req.getContextPath() + "/cart/view");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			resp.sendRedirect(req.getContextPath() + "/error?message=InvalidInput");
		} catch (IllegalArgumentException e) {
			resp.sendRedirect(req.getContextPath() + "/error?message=" + e.getMessage());
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

			if (newCount <= 0) {
				throw new IllegalArgumentException("Số lượng phải lớn hơn 0.");
			}

			Cart updatedCart = cartService.addOrUpdateCartItem(currentUser.get_id(), productId, newCount);
			req.getSession().setAttribute("cart", updatedCart);
			resp.sendRedirect(req.getContextPath() + "/cart/view");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			resp.sendRedirect(req.getContextPath() + "/error?message=InvalidInput");
		} catch (IllegalArgumentException e) {
			resp.sendRedirect(req.getContextPath() + "/error?message=" + e.getMessage());
		}
	}

	private void removeFromCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		User currentUser = (User) req.getSession().getAttribute("account");

		if (currentUser == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		try {
			int productId = Integer.parseInt(req.getParameter("productId"));

			cartService.removeCartItem(currentUser.get_id(), productId);
			Cart updatedCart = cartService.getCartByUser(currentUser);
			req.getSession().setAttribute("cart", updatedCart);
			resp.sendRedirect(req.getContextPath() + "/cart/view");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			resp.sendRedirect(req.getContextPath() + "/error?message=InvalidInput");
		} catch (IllegalArgumentException e) {
			resp.sendRedirect(req.getContextPath() + "/error?message=" + e.getMessage());
		}
	}


}
