package ute.shop.dao.implement;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import ute.shop.config.JPAConfig;
import ute.shop.dao.IProductDao;
import ute.shop.entity.Product;

public class ProductDaoImpl implements IProductDao{

	
	//find all product
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

}
