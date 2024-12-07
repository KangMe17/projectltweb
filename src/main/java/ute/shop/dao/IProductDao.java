package ute.shop.dao;

import java.util.List;
import ute.shop.entity.Product;

public interface IProductDao {
	Product findById(int productId);
	//@dmhisdmh admin
	List<Product> findAll();

	List<Product> findByStoreId(int storeId);
	
	//@dmhisdmh admin
	List<Product> findTopSelling();
}
