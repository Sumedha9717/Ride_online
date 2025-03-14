package com.rideCompany.controller;

import com.rideCompany.dao.CustomerRegisterDao;
import com.rideCompany.model.User;
import com.rideCompany.service.RegisterService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Register") // ✅ Fix: Add servlet mapping
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegisterService registerService;

	public RegisterController() {
		super();
	}

	public void init() throws ServletException {
		try {
			registerService = RegisterService.getInstance(); // Ensure this method exists
		} catch (Exception e) {
			throw new ServletException("Failed to initialize RegisterService", e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("register".equals(action)) {
			showCusRegister(request, response);
		}
		response.getWriter().append("Invalid action! Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equals("enter")) {
			regUser(request, response);
		} else {
			// Show message and forward to Register
			request.setAttribute("errorMessage", "Invalid Information");
			request.getRequestDispatcher("/WEB-INF/view/customer_reg.jsp").forward(request, response);
		}
	}

	private void showCusRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/customer_reg.jsp").forward(request, response);
	}

	private void regUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("confirm_password");
		String role = request.getParameter("role");

		//------------------------------------- password length-------------------------------------------
		if (password.length() < 8) {
			request.setAttribute("errorMessage", "Password must be at least 8 characters long.");
			request.getRequestDispatcher("/WEB-INF/view/customer_reg.jsp").forward(request, response);
			return;
		}

		// ---------------------------------------password match---------------------------------------
		if (!password.equals(confirm_password)) {
			request.setAttribute("errorMessage", "Passwords do not match.");
			request.getRequestDispatcher("/WEB-INF/view/customer_reg.jsp").forward(request, response);
			return;
		}

		//------------------------------------------email format--------------------------------
		if (!email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
			request.setAttribute("errorMessage", "Please enter a valid email address.");
			request.getRequestDispatcher("/WEB-INF/view/customer_reg.jsp").forward(request, response);
			return;
		}

		// -----------------------------Check if username already exists-------------------------------------
		if (CustomerRegisterDao.isUsernameExists(name)) {
			request.setAttribute("errorMessage", "Username already exists. Please choose a different username.");
			request.getRequestDispatcher("/WEB-INF/view/customer_reg.jsp").forward(request, response);
			return;
		}

		// Check if email already exists
		if (CustomerRegisterDao.isEmailExists(email)) {
			request.setAttribute("errorMessage", "Email already exists. Please use a different email.");
			request.getRequestDispatcher("/WEB-INF/view/customer_reg.jsp").forward(request, response);
			return;
		}

		// Create user and add to database
		User user = new User(name, email, password, role);
		CustomerRegisterDao.addUser(user);

		// Redirect to success page or login page
		response.sendRedirect("/WEB-INF/view/login_page.jsp");

	}
}

