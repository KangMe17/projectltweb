package ute.shop.dao.implement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import ute.shop.config.JPAConfig;
import ute.shop.dao.ICartDao;
import ute.shop.entity.Cart;
import ute.shop.entity.User;

public class CartDaoImpl implements ICartDao {

	@Override
	public Cart findByUserId(int userId) {
		EntityManager em = JPAConfig.getEntityManager(); // Lấy EntityManager từ tiện ích
		try {
			return em.createQuery("SELECT c FROM Cart c WHERE c.user._id = :userId", Cart.class)
					.setParameter("userId", userId).getSingleResult();
		} catch (NoResultException e) {
			return null; // Nếu không tìm thấy, trả về null
		} finally {
			em.close();
		}
	}

	@Override
	public Cart getCartByUser(User user) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			return em.createQuery("SELECT c FROM Cart c LEFT JOIN FETCH c.cartItems WHERE c.user = :user", Cart.class)
					.setParameter("user", user).getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public Cart save(Cart cart) {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(cart);
			transaction.commit();
			return cart;
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public Cart update(Cart cart) {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			Cart updatedCart = em.merge(cart);
			transaction.commit();
			return updatedCart;
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public Cart findById(int cartId) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			Cart cart = em.find(Cart.class, cartId);
			return cart == null ? null : cart;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

}
