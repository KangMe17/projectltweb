package ute.shop.controller.admin;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ute.shop.entity.Category;
import ute.shop.entity.Product;
import ute.shop.entity.Store;
import ute.shop.entity.User;
import ute.shop.services.ICategoryService;
import ute.shop.services.IProductService;
import ute.shop.services.IStoreService;
import ute.shop.services.IUserService;
import ute.shop.services.implement.CategoryServiceImpl;
import ute.shop.services.implement.ProductServiceImpl;
import ute.shop.services.implement.StoreServiceImpl;
import ute.shop.services.implement.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin/userDetails", "/admin/updateUser", "/admin/addUser", "/admin/deleteUser" })
public class UserController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		IUserService uservice = new UserServiceImpl();
		if (url.contains("Details")) {
			int user_id = Integer.parseInt(req.getParameter("id"));
			User user = uservice.findById(user_id);
			req.setAttribute("user", user);

			req.getRequestDispatcher("/views/admin/user.jsp").forward(req, resp);
		}
		else if (url.contains("add"))
		{
			req.getRequestDispatcher("/views/admin/user-add.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		if (url.contains("add")) {
			//int id = Integer.parseInt(req.getParameter("_id"));
			String name = req.getParameter("name");
			boolean isEmailActive = Boolean.parseBoolean(req.getParameter("isEmailActive"));
			boolean isPhoneActive = Boolean.parseBoolean(req.getParameter("isPhoneActive"));
			int rating = Integer.parseInt(req.getParameter("rating"));
			Date date = new Date(System.currentTimeMillis());
			
			


			// Gọi service để thêm sản phẩm
			IUserService userService = new UserServiceImpl();
			User user = new User();
			//newProduct.set_id(id);
					
			//userService.addUser(user);

			// Điều hướng về trang quản lý sản phẩm
			resp.sendRedirect(req.getContextPath() + "/admin/manager");
		} else
			resp.sendRedirect(req.getContextPath() + "/admin/manager");
	
	}
}
