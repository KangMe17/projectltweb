package ute.shop.services.implement;

import java.util.List;

import ute.shop.dao.IOrderDao;
import ute.shop.dao.implement.OrderDaoImpl;
import ute.shop.entity.Cart;
import ute.shop.entity.CartItem;
import ute.shop.entity.Order;
import ute.shop.entity.OrderItem;
import ute.shop.entity.OrderStatus;
import ute.shop.entity.User;
import ute.shop.services.IOrderService;
import ute.shop.services.*;

public class OrderServiceImpl implements IOrderService {
	private IOrderDao orderDao = new OrderDaoImpl();
	private ICartService cartService = new CartServiceImpl();

	@Override
	public List<Order> getAllOrdersByUser(int userId) {
		try {
			return orderDao.getAllOrdersByUser(userId);
		} catch (Exception e) {
			throw new RuntimeException("Error fetching orders for user ID: " + userId, e);
		}
	}

	@Override
	public boolean updateOrderStatus(int orderId, OrderStatus status) {
		try {
			return orderDao.updateOrderStatus(orderId, status);
		} catch (Exception e) {
			throw new RuntimeException("Error updating order status for order ID: " + orderId, e);
		}
	}

	@Override
	public boolean cancelOrder(int orderId) {
		try {
			return orderDao.cancelOrder(orderId);
		} catch (Exception e) {
			throw new RuntimeException("Error cancelling order with ID: " + orderId, e);
		}
	}

	@Override
	public Order findById(int orderId) {
		try {
			return orderDao.findById(orderId);
		} catch (Exception e) {
			throw new RuntimeException("Error finding order by ID: " + orderId, e);
		}
	}

	@Override
	public Order placeOrder(int userId, String address, String phone, String paymentMethod) throws Exception {
		// Lấy giỏ hàng của người dùng
		Cart cart = cartService.findCartByUserId(userId);
		if (cart == null || cart.getCartItems().isEmpty()) {
			throw new Exception("Giỏ hàng rỗng.");
		}

		// Tạo đối tượng Order
		Order order = new Order();
		order.setUser(new User(userId));
		order.setAddress(address);
		order.setPhone(phone);
		order.setStatus(OrderStatus.NOT_PROCESSED);
		order.setIsPaidBefore(false);
		order.setAmountFromUser(cart.getTotalAmount()); // Tổng tiền từ giỏ hàng

		// Lưu đơn hàng
		order = orderDao.save(order);

		// Lưu từng OrderItem
		for (CartItem item : cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);
			orderItem.setProduct(item.getProduct());
			orderItem.setCount(item.getCount());
			orderDao.saveOrderItem(orderItem);
		}

		// Xóa giỏ hàng sau khi đặt hàng
		cartService.clearCart(userId);

		return order;
	}

	@Override
	public boolean makePayment(int orderId) {
		Order order = orderDao.findById(orderId);
		if (order == null) {
			throw new IllegalArgumentException("Order not found.");
		}
		order.setIsPaidBefore(true);
		order.setStatus(OrderStatus.PROCESSED);
		return orderDao.save(order) != null;
	}

}
