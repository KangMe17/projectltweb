package ute.shop.dao.implement;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import ute.shop.config.JPAConfig;
import ute.shop.dao.IProductDao;
import ute.shop.entity.Product;

public class ProductDaoImpl implements IProductDao {

	@Override
	public Product findById(int productId) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			return em.find(Product.class, productId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

	// find all product
	@Override
	public List<Product> findAll() {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
			return query.getResultList();
		} catch (Exception e) {
			throw new RuntimeException("Error finding all product", e);
		} finally {
			em.close();
		}
	}

	@Override
	public List<Product> findTopSelling() {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p ORDER BY p.sold DESC", Product.class);
			query.setMaxResults(7);
			return query.getResultList();
		} catch (Exception e) {
			throw new RuntimeException("Error finding top selling product", e);
		} finally {
			em.close();
		}
	}
}
