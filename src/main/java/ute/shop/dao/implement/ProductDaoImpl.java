package ute.shop.dao.implement;

import jakarta.persistence.EntityManager;
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
}
