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

import org.hibernate.Hibernate;

public class CartServiceImpl implements ICartService {

	private final ICartDao cartDao = new CartDaoImpl();
	private final IProductDao productDao = new ProductDaoImpl();

	@Override
	public Cart findCartByUserId(int userId) {
		return cartDao.findByUserId(userId);
	}

	@Override
	public Cart getCartByUser(User user) {
		// Tải giỏ hàng và các item của nó
		Cart cart = cartDao.getCartByUser(user);
		Hibernate.initialize(cart.getCartItems()); // Khởi tạo các cartItems để tránh LazyInitializationException
		return cart;
	}

	@Override
	public Cart createCart(User user) {
		Cart cart = new Cart();
		cart.setUser(user);
		cart.setCreatedAt(new Date());
		cart.setUpdatedAt(new Date());
		cart.setCartItems(List.of()); // Tạo giỏ hàng rỗng ban đầu
		return cartDao.save(cart); // Cần implement phương thức `save` trong `CartDaoImpl`
	}

	@Override
	public Cart addOrUpdateCartItem(int cartId, int productId, int quantity) {
		Cart cart = cartDao.findById(cartId); // Tìm giỏ hàng theo ID
		if (cart == null) {
			throw new IllegalArgumentException("Cart không tồn tại.");
		}

		Product product = productDao.findById(productId); // Tìm sản phẩm
		if (product == null) {
			throw new IllegalArgumentException("Sản phẩm không tồn tại.");
		}

		// Kiểm tra nếu sản phẩm đã tồn tại trong giỏ hàng
		CartItem existingItem = cart.getCartItems().stream().filter(item -> item.getProduct().get_id() == productId)
				.findFirst().orElse(null);

		if (existingItem != null) {
			// Cập nhật số lượng
			existingItem.setCount(existingItem.getCount() + quantity);
			existingItem.setUpdatedAt(new Date());
		} else {
			// Thêm sản phẩm mới vào giỏ hàng
			CartItem newItem = new CartItem();
			newItem.setCart(cart);
			newItem.setProduct(product);
			newItem.setCount(quantity);
			newItem.setCreatedAt(new Date());
			newItem.setUpdatedAt(new Date());
			cart.getCartItems().add(newItem);
		}

		cart.setUpdatedAt(new Date());
		return cartDao.update(cart); // Cần implement phương thức `update` trong `CartDaoImpl`
	}

	@Override
	public void removeCartItem(int cartId, int productId) {
		Cart cart = cartDao.findById(cartId);
		if (cart == null) {
			throw new IllegalArgumentException("Cart không tồn tại.");
		}

		// Lọc và loại bỏ sản phẩm khỏi giỏ hàng
		List<CartItem> updatedItems = cart.getCartItems().stream()
				.filter(item -> item.getProduct().get_id() != productId).toList();

		cart.setCartItems(updatedItems);
		cart.setUpdatedAt(new Date());
		cartDao.update(cart); // Lưu cập nhật vào DB
	}
}
