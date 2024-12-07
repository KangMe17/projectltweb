package ute.shop.services.implement;

import ute.shop.dao.IProductDao;
import ute.shop.dao.implement.ProductDaoImpl;
import ute.shop.entity.Product;
import ute.shop.services.IProductService;

public class ProductServiceImpl implements IProductService {

	private final IProductDao productDao = new ProductDaoImpl();

	@Override
	public Product findProductById(int productId) {
		// Lấy thông tin sản phẩm từ tầng DAO
		return productDao.findById(productId);
	}

	@Override
	public boolean isStockAvailable(int productId, int count) {
		// Kiểm tra tồn kho
		Product product = productDao.findById(productId);
		if (product == null) {
			return false;
		}
		return product.getQuantity() >= count;
	}

	@Override
	public Product findById(int productId) {
		return findProductById(productId);
	}
}
