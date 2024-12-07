package ute.shop.dao.implement;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import ute.shop.config.JPAConfig;
import ute.shop.dao.IStoreDao;
import ute.shop.entity.Store;

public class StoreDaoImpl implements IStoreDao {

	// find all store
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

}
