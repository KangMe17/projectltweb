package ute.shop.services;

import ute.shop.entity.Product;

public interface IProductService {

	// Tìm sản phẩm theo ID
	Product findProductById(int productId);

	// Kiểm tra xem sản phẩm có đủ tồn kho không
	boolean isStockAvailable(int productId, int count);

}
