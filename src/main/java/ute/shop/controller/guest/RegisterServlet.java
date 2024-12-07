package ute.shop.controller.guest;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import ute.shop.config.JPAConfig;
import ute.shop.dao.guest.implement.UserDAO;
import ute.shop.entity.User;
import ute.shop.services.guest.implement.UserService;

import java.io.File;
import java.io.IOException;

@WebServlet(urlPatterns = { "/guest/register" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;

	@Override
	public void init() throws ServletException {
		EntityManager em = JPAConfig.getEntityManager();

		userService = new UserService(new UserDAO(em));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getServletPath();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		request.getRequestDispatcher("/views/register.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getServletPath();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String phone = request.getParameter("phone");
		String id_card = request.getParameter("id_card");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// Lấy file từ input name="photo"
		Part filePart = request.getPart("photo"); // <input type="file" name="photo">
		String fileName = extractFileName(filePart);
		String uploadDir  = "C:/uploads/" + fileName; // Thay đổi thư mục lưu trữ theo môi trường của bạn.

		// Tạo thư mục nếu chưa tồn tại
	    File uploadDirFile = new File(uploadDir);
	    if (!uploadDirFile.exists()) {
	        uploadDirFile.mkdirs();
	    }

	    // Lưu file vào thư mục động
	    String savePath = uploadDir + File.separator + fileName;
	    filePart.write(savePath);

		// Tạo User và lưu đường dẫn ảnh
		User newUser = new User();
		newUser.setFirstname(firstname);
		newUser.setLastname(lastname);
		newUser.setPhone(phone);
		newUser.setId_card(id_card);
		newUser.setEmail(email);
		newUser.setPassword(password);;
//		newUser.setHashed_password(password);
		newUser.setAvatar(fileName); // Lưu tên file vào avatar của user.

		try {
			userService.registerUser(newUser);
			request.setAttribute("message", "Đăng ký thành công!");
			request.setAttribute("user", newUser);
			// request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			request.getRequestDispatcher("/views/register.jsp").forward(request, response);

		} catch (IllegalArgumentException e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("/views/register.jsp").forward(request, response);
		}
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		for (String content : contentDisp.split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
			}
		}
		return "default.jpg"; // Tên file mặc định nếu không có tên file.
	}

}
