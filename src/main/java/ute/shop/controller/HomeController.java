package ute.shop.controller;

import java.io.IOException;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ute.shop.config.JPAConfig;
import ute.shop.dao.guest.implement.CategoryDAO;
import ute.shop.dao.guest.implement.ProductDAO;
import ute.shop.entity.Category;
import ute.shop.entity.Product;
import ute.shop.entity.User;
import ute.shop.services.guest.implement.CategoryService;
import ute.shop.services.guest.implement.ProductService;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/home"})
public class HomeController extends HttpServlet {
    private ProductService productService;
    private CategoryService categoryService;

    @Override
    public void init() throws ServletException {
        EntityManager em = JPAConfig.getEntityManager();
        productService = new ProductService(new ProductDAO(em), new CategoryDAO(em));
        categoryService = new CategoryService(new CategoryDAO(em));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sort = req.getParameter("sort");
        String minPriceStr = req.getParameter("minPrice");
        String maxPriceStr = req.getParameter("maxPrice");

        List<Product> products;

        if (sort != null) {
            // Sắp xếp sản phẩm theo giá
            switch (sort) {
                case "priceAsc":
                    products = productService.getProductsSortedByPrice(true); // Giá từ thấp đến cao
                    break;
                case "priceDesc":
                    products = productService.getProductsSortedByPrice(false); // Giá từ cao đến thấp
                    break;
                case "sales":
                    products = productService.getProductsBySales(10); // 10 sản phẩm bán chạy nhất
                    break;
                default:
                    products = productService.getProductsBySales(10); // Mặc định
            }
        } else if (minPriceStr != null && maxPriceStr != null) {
            // Lọc sản phẩm theo khoảng giá
            try {
                double minPrice = Double.parseDouble(minPriceStr);
                double maxPrice = Double.parseDouble(maxPriceStr);
                products = productService.getProductsByPriceRange(minPrice, maxPrice);
            } catch (NumberFormatException e) {
                products = productService.getProductsBySales(10); // Trường hợp không hợp lệ
            }
        } else {
            products = productService.getProductsBySales(10); // Mặc định: sản phẩm bán chạy nhất
        }

        // Gửi danh sách sản phẩm đến giao diện
        req.setAttribute("products", products);
        
        List<Category> randomCategories = categoryService.getRandomCategories(5);
        req.setAttribute("randomcategories", randomCategories);
        List<Product> productsCate = productService.getProductsByCategory(randomCategories.get(0).get_id());
        req.setAttribute("productsCate", productsCate);

        // Lấy danh mục
        List<Category> categories = categoryService.getAllCategoriesWithProducts();
        req.setAttribute("categories", categories);

        // Xử lý người dùng đăng nhập (không thay đổi)
        HttpSession session = req.getSession(false);
        User user = session != null ? (User) session.getAttribute("account") : null;
        req.setAttribute("user", user);

        // Forward đến home.jsp
        req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
    }

}