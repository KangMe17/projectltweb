package ute.shop.services;

import java.util.List;

import ute.shop.entity.Order;
import ute.shop.entity.OrderStatus;

public interface IOrderService {
	List<Order> getAllOrdersByUser(int userId);

	boolean updateOrderStatus(int orderId, OrderStatus status);

	boolean cancelOrder(int orderId);

	Order findById(int orderId);
}
