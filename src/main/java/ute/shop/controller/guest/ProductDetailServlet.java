package ute.shop.controller.guest;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ute.shop.config.JPAConfig;
import ute.shop.dao.guest.implement.CategoryDAO;
import ute.shop.dao.guest.implement.ProductDAO;
import ute.shop.entity.Product;
import ute.shop.services.guest.implement.ProductService;

import java.io.IOException;

@WebServlet(urlPatterns = {"/home/productDetail" })
public class ProductDetailServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductService productService;

    @Override
    public void init() throws ServletException {
        EntityManager em = JPAConfig.getEntityManager();
        productService = new ProductService(new ProductDAO(em), new CategoryDAO(em));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productIdParam = request.getParameter("id");

        if (productIdParam == null || productIdParam.isEmpty()) {
            response.sendRedirect("/home/searchProduct");
            return;
        }

        int productId;
        try {
            productId = Integer.parseInt(productIdParam);
        } catch (NumberFormatException e) {
            response.sendRedirect("/home/searchProduct");
            return;
        }

        // Lấy thông tin sản phẩm
        Product product = productService.getProductById(productId);
        if (product == null) {
            response.sendRedirect("/home/searchProduct");
            return;
        }

        // Gửi thông tin sản phẩm tới JSP
        request.setAttribute("product", product);
        request.getRequestDispatcher("/views/guest/productDetail.jsp").forward(request, response);
    }
}
