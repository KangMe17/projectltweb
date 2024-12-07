package ute.shop.services.guest.implement;

import java.util.List;

import ute.shop.dao.guest.implement.CategoryDAO;
import ute.shop.dao.guest.implement.ProductDAO;
import ute.shop.entity.Category;
import ute.shop.entity.Product;

public class ProductService {
    private final ProductDAO productDAO;
    private final CategoryDAO categoryDAO;

    // Constructor duy nhất với cả ProductDAO và CategoryDAO
    public ProductService(ProductDAO productDAO, CategoryDAO categoryDAO) {
        this.productDAO = productDAO;
        this.categoryDAO = categoryDAO;
    }

    // Tìm sản phẩm theo ID
    public Product getProductById(int id) {
        return productDAO.findById(id);
    }

    // Tìm kiếm sản phẩm theo tiêu chí
    public List<Product> searchProducts(String keywords, Integer categoryId, Double minPrice, Double maxPrice, int page, int pageSize) {
        return productDAO.searchProducts(keywords, categoryId, minPrice, maxPrice, page, pageSize);
    }

    // Đếm số lượng kết quả tìm kiếm
    public int countSearchResults(String keywords, Integer categoryId, Double minPrice, Double maxPrice) {
        return productDAO.countSearchResults(keywords, categoryId, minPrice, maxPrice);
    }

    // Lấy danh sách tất cả danh mục
    public List<Category> getAllCategories() {
        return categoryDAO.findAll();
    }
}