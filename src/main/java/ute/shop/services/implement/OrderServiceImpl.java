package ute.shop.services.implement;

import java.util.List;

import ute.shop.dao.IOrderDao;
import ute.shop.dao.implement.OrderDaoImpl;
import ute.shop.entity.Order;
import ute.shop.entity.OrderStatus;
import ute.shop.services.IOrderService;

public class OrderServiceImpl implements IOrderService {
	private IOrderDao orderDao = new OrderDaoImpl();

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
}
