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
@WebServlet(urlPatterns = { "/home" })
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
        // Lấy sản phẩm bán từ 10 trở lên, sắp xếp theo số lượng bán
        List<Product> topProducts = productService.getProductsBySales(10);
        List<Category> categories = categoryService.getAllCategoriesWithProducts();
        List<Category> randomCategories = categoryService.getRandomCategories(5);
        List<Product> products = productService.getProductsByCategory(randomCategories.get(0).get_id());
        req.setAttribute("randomcategories", randomCategories);
        req.setAttribute("products", products);
        req.setAttribute("categories", categories);
        // Gửi danh sách sản phẩm đến giao diện
        req.setAttribute("topProducts", topProducts);

        // Xử lý người dùng đăng nhập (nếu có)
        HttpSession session = req.getSession(false);
        User user = null;
        if (session != null) {
            user = (User) session.getAttribute("account");
        }
        if (user != null) {
            req.setAttribute("user", user);
        }

        // Forward đến giao diện home.jsp
        req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
    }
}

