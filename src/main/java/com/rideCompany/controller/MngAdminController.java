package com.rideCompany.controller;

import com.rideCompany.dao.CustomerRegisterDao;
import com.rideCompany.service.AdminRegisterService;
import com.rideCompany.model.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/MngAdmin")
public class MngAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminRegisterService adminRegisterService;
       

    public MngAdminController() {
        super();
    }

	public void init() throws ServletException {
		try {
			adminRegisterService = AdminRegisterService.getInstance();
		} catch (Exception e) {
			throw new ServletException("Failed to initialize RegisterService", e);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("go_manage".equals(action)) {
			showAdminMng(request, response);
		}else if ("adminSpace".equals(action)) {
			AdminSpace(request, response);
		}
		else if ("showAdmin".equals(action)) {
			listAdmin(request, response);
		}
		else {
		response.getWriter().append("Invalid action! Served at: ").append(request.getContextPath());
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equals("addAdmin")) {
			regAdmin(request, response);
		} else {
			// Show message and forward to Register
			request.setAttribute("errorMessage", "Invalid Information");
			request.getRequestDispatcher("/WEB-INF/view/admin/mngAdmin.jsp").forward(request, response);
		}
	}

	private void showAdminMng(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/admin/mngAdmin.jsp").forward(request, response);
	}

	private void AdminSpace(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/admin/adminspace.jsp").forward(request, response);
	}

	private void regAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("confirm_password");
		String role = "admin";

		//------------------------------------- password length-------------------------------------------
		if (password.length() < 8) {
			request.setAttribute("errorMessage", "Password must be at least 8 characters long.");
			request.getRequestDispatcher("/WEB-INF/view/admin/mngAdmin.jsp").forward(request, response);
			return;
		}

		// ---------------------------------------password match---------------------------------------
		if (!password.equals(confirm_password)) {
			request.setAttribute("errorMessage", "Passwords do not match.");
			request.getRequestDispatcher("/WEB-INF/view/admin/mngAdmin.jsp").forward(request, response);
			return;
		}

		//------------------------------------------email format--------------------------------
		if (!email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
			request.setAttribute("errorMessage", "Please enter a valid email address.");
			request.getRequestDispatcher("/WEB-INF/view/admin/mngAdmin.jsp").forward(request, response);
			return;
		}

		// -----------------------------Check if username already exists-------------------------------------
		if (CustomerRegisterDao.isUsernameExists(name)) {
			request.setAttribute("errorMessage", "Username already exists. Please choose a different username.");
			request.getRequestDispatcher("/WEB-INF/view/admin/mngAdmin.jsp").forward(request, response);
			return;
		}

		// Check if email already exists
		if (CustomerRegisterDao.isEmailExists(email)) {
			request.setAttribute("errorMessage", "Email already exists. Please use a different email.");
			request.getRequestDispatcher("/WEB-INF/view/admin/mngAdmin.jsp").forward(request, response);
			return;
		}

		// Create user and add to database
		User user = new User(name, email, password, role);
		CustomerRegisterDao.addUser(user);

		// Set success message
		request.setAttribute("successMessage", "Admin added successfully!");

		// Forward to the same page (or a success page)
		request.getRequestDispatcher("/WEB-INF/view/admin/mngAdmin.jsp").forward(request, response);

	}

	private void listAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<User> adminList = new ArrayList<User>();
		try {
			// Retrieve the list of admins from the service layer
			adminList = AdminRegisterService.getInstance().getAllAdmin();

			// Set the "admins" attribute in the request
			request.setAttribute("admins", adminList);
		} catch (SQLException e) {
			// Handle SQL exceptions
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/view/admin/error.jsp").forward(request, response);
			return; // Stop further execution if there's an error
		}

		// Forward the request to the JSP page
		request.getRequestDispatcher("/WEB-INF/view/admin/listAdmin.jsp").forward(request, response);
	}

}
