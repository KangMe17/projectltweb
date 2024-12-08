package ute.shop.services;

import java.util.List;

import ute.shop.entity.Order;
import ute.shop.entity.OrderStatus;

public interface IOrderService {
	List<Order> getAllOrdersByUser(int userId);

	boolean updateOrderStatus(int orderId, OrderStatus status);

	boolean cancelOrder(int orderId);

	Order findById(int orderId);

	Order placeOrder(int userId, String address, String phone, String paymentMethod) throws Exception;

	boolean makePayment(int orderId);
	
	
	//@admin tinh tong so order cua he thong
	long countTotalOrders();
	
	//@admin 
	List<Order> findLatestOrders();

}
