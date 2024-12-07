package ute.shop.dao.implement;
import jakarta.persistence.EntityManager;
import java.util.List;
import jakarta.persistence.TypedQuery;
import ute.shop.config.JPAConfig;
import ute.shop.dao.IStoreDao;
import ute.shop.entity.Store;

public class StoreDaoImpl implements IStoreDao {

	@Override
	public Store findById(int storeId) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			return em.find(Store.class, storeId);
		} catch (Exception e) {
			throw new RuntimeException("Error finding order by ID", e);
		} finally {
			em.close();
		}
	}

	//find all store
	@Override
	public List<Store> findAll() {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			TypedQuery<Store> query = em.createQuery("SELECT s FROM Store s", Store.class);
			return query.getResultList();
		} catch (Exception e) {
			throw new RuntimeException("Error finding all store", e);

		} finally {
			em.close();
		}
	}

	@Override
	public Store findByOrderId(int orderId) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			// Sử dụng JPQL với JOIN FETCH để tải luôn orderItems
			String jpql = "SELECT o.store FROM Order o JOIN FETCH o.orderItems WHERE o.id = :orderId";
			return em.createQuery(jpql, Store.class).setParameter("orderId", orderId).getSingleResult();
		} catch (Exception e) {
			throw new RuntimeException("Error finding store by order ID", e);

		} finally {
			em.close();
		}
	}

}
