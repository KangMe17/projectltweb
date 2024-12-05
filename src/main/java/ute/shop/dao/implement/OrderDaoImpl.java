package ute.shop.dao.implement;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import ute.shop.config.JPAConfig;
import ute.shop.dao.IOrderDao;
import ute.shop.entity.Order;
import ute.shop.entity.OrderStatus;

public class OrderDaoImpl implements IOrderDao {

	@Override
	public List<Order> getAllOrdersByUser(int userId) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o WHERE o.user._id = :userId", Order.class);
			query.setParameter("userId", userId);
			return query.getResultList();
		} catch (Exception e) {
			throw new RuntimeException("Error fetching orders by user", e);
		} finally {
			em.close();
		}
	}

	@Override
	public boolean updateOrderStatus(int orderId, OrderStatus status) {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			Order order = em.find(Order.class, orderId);
			if (order != null) {
				order.setStatus(status);
				trans.commit();
				return true;
			} else {
				trans.rollback();
				return false;
			}
		} catch (Exception e) {
			trans.rollback();
			throw new RuntimeException("Error updating order status", e);
		} finally {
			em.close();
		}
	}

	@Override
	public boolean cancelOrder(int orderId) {
		return updateOrderStatus(orderId, OrderStatus.CANCELLED);
	}

	@Override
	public Order findById(int orderId) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			return em.find(Order.class, orderId);
		} catch (Exception e) {
			throw new RuntimeException("Error finding order by ID", e);
		} finally {
			em.close();
		}
	}
}
