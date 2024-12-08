package ute.shop.services.implement;

import ute.shop.dao.ICartDao;
import ute.shop.dao.IProductDao;
import ute.shop.dao.implement.CartDaoImpl;
import ute.shop.dao.implement.ProductDaoImpl;
import ute.shop.entity.Cart;
import ute.shop.entity.CartItem;
import ute.shop.entity.Product;
import ute.shop.entity.User;
import ute.shop.services.ICartService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CartServiceImpl implements ICartService {

	private final ICartDao cartDao = new CartDaoImpl();
	private final IProductDao productDao = new ProductDaoImpl();

	@Override
	public Cart findCartByUserId(int userId) {
		return cartDao.findByUserId(userId);
	}

	@Override
	public Cart getCartByUser(User user) {
		Cart cart = cartDao.getCartByUser(user);
		if (cart == null) {
			throw new IllegalArgumentException("Không tìm thấy giỏ hàng cho người dùng này.");
		}
		return cart;
	}

	@Override
	public Cart createCart(User user) {
		if (user == null) {
			throw new IllegalArgumentException("Người dùng không hợp lệ.");
		}
		Cart cart = new Cart();
		cart.setUser(user);
		cart.setCreatedAt(new Date());
		cart.setUpdatedAt(new Date());
		cart.setCartItems(List.of()); // Giỏ hàng trống
		return cartDao.save(cart);
	}

	@Override
	public Cart addOrUpdateCartItem(int userId, int productId, int quantity) {
		Cart cart = findCartByUserId(userId);
		if (cart == null) {
			throw new IllegalArgumentException("Giỏ hàng không tồn tại.");
		}

		Product product = productDao.findById(productId);
		if (product == null) {
			throw new IllegalArgumentException("Sản phẩm không tồn tại.");
		}

		CartItem existingItem = cart.getCartItems().stream().filter(item -> item.getProduct().get_id() == productId)
				.findFirst().orElse(null);

		if (existingItem != null) {
			existingItem.setCount(quantity); // Cập nhật trực tiếp số lượng
			existingItem.setUpdatedAt(new Date());
		} else {
			CartItem newItem = new CartItem();
			newItem.setCart(cart);
			newItem.setProduct(product);
			newItem.setCount(quantity);
			newItem.setCreatedAt(new Date());
			newItem.setUpdatedAt(new Date());
			cart.getCartItems().add(newItem);
		}

		cart.setUpdatedAt(new Date());
		return cartDao.update(cart);
	}

	@Override
	public void removeCartItem(int userId, int productId) {
		// Tìm giỏ hàng theo userId
		Cart cart = cartDao.findByUserId(userId);
		if (cart == null) {
			throw new IllegalArgumentException("Giỏ hàng không tồn tại.");
		}

		// Xóa sản phẩm khỏi danh sách các item
		List<CartItem> updatedItems = cart.getCartItems().stream()
				.filter(item -> item.getProduct().get_id() != productId).toList();

		if (updatedItems.size() == cart.getCartItems().size()) {
			throw new IllegalArgumentException("Sản phẩm không tồn tại trong giỏ hàng.");
		}

		cart.setCartItems(updatedItems);
		cart.setUpdatedAt(new Date());
		cartDao.update(cart);
	}

	@Override
	public void clearCart(int userId) {
		Cart cart = cartDao.findByUserId(userId);
		if (cart == null) {
			throw new IllegalArgumentException("Giỏ hàng không tồn tại.");
		}

		cart.getCartItems().clear(); // Xóa danh sách item
		cart.setUpdatedAt(new Date());
		cartDao.update(cart); // Cập nhật giỏ hàng
	}
}
