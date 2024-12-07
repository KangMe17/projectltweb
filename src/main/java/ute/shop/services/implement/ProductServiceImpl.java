package ute.shop.services.implement;

import java.util.List;

import ute.shop.dao.IProductDao;
import ute.shop.dao.implement.ProductDaoImpl;
import ute.shop.entity.Product;
import ute.shop.services.IProductService;

public class ProductServiceImpl implements IProductService{

	IProductDao productDao = new ProductDaoImpl();
	
	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	
	
}
